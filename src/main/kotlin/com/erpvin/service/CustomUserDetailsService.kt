package com.erpvin.service

import org.springframework.security.core.userdetails.UserDetails
import org.springframework.security.core.userdetails.UserDetailsService
import org.springframework.security.core.userdetails.UsernameNotFoundException

interface CustomUserDetailsService : UserDetailsService{
    @Throws(UsernameNotFoundException::class)
    override fun loadUserByUsername(username: String?): UserDetails
}