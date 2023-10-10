package com.erpvin.security

import com.erpvin.service.CustomUserDetailsService
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.context.annotation.Bean
import org.springframework.context.annotation.Configuration
import org.springframework.context.annotation.Lazy
import org.springframework.security.authentication.AuthenticationManager
import org.springframework.security.config.annotation.authentication.configuration.AuthenticationConfiguration
import org.springframework.security.config.annotation.web.builders.HttpSecurity
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity
import org.springframework.security.config.http.SessionCreationPolicy
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder
import org.springframework.security.crypto.password.PasswordEncoder
import org.springframework.security.web.SecurityFilterChain
import org.springframework.security.web.authentication.UsernamePasswordAuthenticationFilter



@Configuration
@EnableWebSecurity
class SecurityConfig (private val userDetailsService: CustomUserDetailsService,
                      private val authEntryPoint: AuthEntryPoint){

    @Autowired
    @Lazy
    private lateinit var authFilter: AuthFilter



    @Bean
    fun filterChain(http: HttpSecurity): SecurityFilterChain {
        http.csrf().disable()
            .exceptionHandling()
            .authenticationEntryPoint(authEntryPoint)
            .and()
            .sessionManagement()
            .sessionCreationPolicy(SessionCreationPolicy.STATELESS)
            .and()
            .authorizeRequests()
            .requestMatchers("/api/auth/**").permitAll()
            .requestMatchers("/api/public/**").permitAll()
            //.requestMatchers("/api/user/addUser").hasAnyAuthority("ADMIN", "MANAGER")
            .requestMatchers("/api/user/**").permitAll()
            .requestMatchers("/api/category/**").permitAll()
            .requestMatchers("/api/warehouse/**").permitAll()
            .requestMatchers("/api/product/**").permitAll()
            .requestMatchers("/api/client/**").permitAll()
            .requestMatchers("/api/supplier/**").permitAll()
            .anyRequest().authenticated()
            .and()
            .httpBasic()

        http
            .addFilterBefore(authFilter, UsernamePasswordAuthenticationFilter::class.java)
        return http.build()
    }

    @Bean
    fun jwtAuthenticationFilter(jwtGenerator: JWTGenerator, customUserDetailsService: CustomUserDetailsService): AuthFilter {
        return AuthFilter(jwtGenerator, customUserDetailsService)
    }

    @Bean
    fun authenticationManager(authenticationConfiguration: AuthenticationConfiguration): AuthenticationManager {
        return authenticationConfiguration.getAuthenticationManager()
    }

    @Bean
    fun passwordEncoder(): PasswordEncoder {
        return BCryptPasswordEncoder()
    }
}