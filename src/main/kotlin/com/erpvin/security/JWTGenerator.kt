package com.erpvin.security

import io.github.oshai.kotlinlogging.KotlinLogging
import io.jsonwebtoken.Claims
import io.jsonwebtoken.Jwts
import io.jsonwebtoken.SignatureAlgorithm
import io.jsonwebtoken.security.Keys
import org.springframework.security.authentication.AuthenticationCredentialsNotFoundException
import org.springframework.security.core.Authentication
import org.springframework.stereotype.Component
import java.security.Key
import java.util.*




@Component
class JWTGenerator {
    private val logger = KotlinLogging.logger {}
    private val key: Key = Keys.secretKeyFor(SignatureAlgorithm.HS512)
// ça génère la clé, le dev ne choisit pas
// algo recommandé : au moins 512 bytes.

    // ça génère la clé, le dev ne choisit pas
    // algo recommandé : au moins 512 bytes.
    fun generateToken(authentication: Authentication): String {
        // on récupère le nom du user
        val username = authentication.name
        // on prend la date
        val currentDate = Date()

        //on prépare la date d'expiration du token
        val expireDate: Date = Date(currentDate.time + SecurityConstants.JWT_EXPIRATION)
        val token: String = Jwts.builder()
            .setSubject(username)
            .setIssuedAt(currentDate)
            .setExpiration(expireDate)
            .signWith(key, SignatureAlgorithm.HS512)
            .compact()
        logger.info("New token {}", token)
        return token
    }

    fun getUsernameFromJWT(token: String?): String {
        val claims: Claims = Jwts.parserBuilder() // un parser parcourt une suite de choses
            .setSigningKey(key)
            .build()
            .parseClaimsJws(token)
            .getBody() // récupère le body json
        return claims.getSubject() // récupère le subject enregistré plus haut dans le token
    }

    fun validateToken(token: String?): Boolean {
        return try {
            Jwts.parserBuilder()
                .setSigningKey(key)
                .build()
                .parseClaimsJws(token)
            true
        } catch (e: Exception) {
            throw AuthenticationCredentialsNotFoundException("JWT was incorrect", e.fillInStackTrace())
        }
    }
}
