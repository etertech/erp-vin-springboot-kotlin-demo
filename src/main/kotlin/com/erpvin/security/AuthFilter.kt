package com.erpvin.security

import com.erpvin.service.CustomUserDetailsService
import io.github.oshai.kotlinlogging.KotlinLogging
import jakarta.servlet.FilterChain
import jakarta.servlet.ServletException
import jakarta.servlet.http.HttpServletRequest
import jakarta.servlet.http.HttpServletResponse
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken
import org.springframework.security.core.context.SecurityContextHolder
import org.springframework.security.core.userdetails.UserDetails
import org.springframework.security.core.userdetails.UsernameNotFoundException
import org.springframework.security.web.authentication.WebAuthenticationDetailsSource
import org.springframework.stereotype.Component
import org.springframework.util.StringUtils
import org.springframework.web.filter.OncePerRequestFilter
import java.io.IOException
@Component
class AuthFilter(private val jwtGenerator: JWTGenerator, private val customUserDetailsService: CustomUserDetailsService) : OncePerRequestFilter() {
    private val logger = KotlinLogging.logger {}

    @Throws(ServletException::class, IOException::class)
    override fun doFilterInternal(
        request: HttpServletRequest,
        response: HttpServletResponse,
        filterChain: FilterChain
    ) {
        val token = getJWTFromRequest(request)
        if (StringUtils.hasText(token) && jwtGenerator.validateToken(token)) {
            // j'ai un token valide
            val username: String = jwtGenerator.getUsernameFromJWT(token)
            val userDetails: UserDetails = customUserDetailsService.loadUserByUsername(username)
            val authenticationToken = UsernamePasswordAuthenticationToken(userDetails, null, userDetails.authorities)
            authenticationToken.details = WebAuthenticationDetailsSource().buildDetails(request)
            SecurityContextHolder.getContext().authentication = authenticationToken
        }
        filterChain.doFilter(request, response) // si tout est ok, le processus continue
    }

    private fun getJWTFromRequest(request: HttpServletRequest): String? {
        val bearerToken: String? = request.getHeader("Authorization")
        return if (bearerToken?.startsWith("Bearer ") == true) {
            bearerToken.substring(7)
        } else null
    }


}