package com.erpvin.controller

import com.erpvin.dto.AuthResponseDto
import com.erpvin.dto.LoginDto
import com.erpvin.dto.UserAddDto
import com.erpvin.dto.UsersTableDto
import com.erpvin.entity.UserBean
import com.erpvin.exception.UnauthorizedException
import com.erpvin.security.JWTGenerator
import com.erpvin.service.AuthService
import com.erpvin.service.CustomUserDetailsService
import io.github.oshai.kotlinlogging.KotlinLogging
import org.springframework.http.HttpStatus
import org.springframework.http.ResponseEntity
import org.springframework.security.authentication.AuthenticationManager
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken
import org.springframework.security.core.Authentication
import org.springframework.security.core.context.SecurityContextHolder
import org.springframework.web.bind.annotation.*


@RestController
@RequestMapping("api")
@CrossOrigin("\${front.url}")
class AuthController(
    val authService: AuthService,
    private var authenticationManager: AuthenticationManager,
    private var jwtGenerator: JWTGenerator,
    private var customUserDetailsService: CustomUserDetailsService
) {
    private val logger = KotlinLogging.logger {}

    @PostMapping("auth/login")
    @Throws(UnauthorizedException::class)
    fun login(@RequestBody loginDto: LoginDto): ResponseEntity<AuthResponseDto> {
        val authentication: Authentication = authenticationManager.authenticate(
            UsernamePasswordAuthenticationToken(loginDto.username, loginDto.password)
        )
        SecurityContextHolder.getContext().authentication = authentication
        // stocke l'objet authentification dans le contexte de l'app
        val token: String = jwtGenerator.generateToken(authentication)
        val userBean = authService.getUserByUserName(loginDto.username)
        if (userBean != null) {
            logger.info { "Utilisateur est connecté." }
        } else {
            logger.info { "null null null" }
        }
        //userDetails.authorities
        return if (userBean?.id != null) {
            ResponseEntity(
                AuthResponseDto(
                    token, userBean.id, userBean.username, userBean.firstName,
                    userBean.lastName, userBean.roles, userBean.enabled
                ),
                HttpStatus.OK
            )
        } else {
            throw UnauthorizedException()
        }
    }


    @PostMapping("user/addUser")
    fun addUser(@RequestBody userAddDto: UserAddDto): ResponseEntity<String> {
        val userBean: UserBean = authService.save(userAddDto)
        //val token: String = authService.generateUserJWT(userBean)
        return ResponseEntity("Username registered success", HttpStatus.OK)
    }

    @GetMapping("/{name}")
    fun retrieveGreeting(@PathVariable("name") name: String): String {
        //return "Hello $name"
        //logger.info("Name is $name")
        return "Hello World $name"
    }

    @GetMapping("user/getUsers")
    fun getUsers(): ResponseEntity<List<UsersTableDto>> {
        val users = authService.getUsers()
        return ResponseEntity.ok(users)
    }

}