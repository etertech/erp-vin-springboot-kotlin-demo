package com.erpvin.service.impl

import com.erpvin.entity.Role
import com.erpvin.repository.UserDao
import com.erpvin.service.CustomUserDetailsService
import org.springframework.security.core.GrantedAuthority
import org.springframework.security.core.authority.SimpleGrantedAuthority
import org.springframework.security.core.userdetails.User
import org.springframework.security.core.userdetails.UserDetails
import org.springframework.security.core.userdetails.UsernameNotFoundException
import org.springframework.stereotype.Service

@Service
class CustomUserDetailsServiceImpl(
    private val userDao: UserDao


): CustomUserDetailsService {



    override fun loadUserByUsername(username: String?): UserDetails {
        val user = userDao.findByUsername(username)
            ?: throw  UsernameNotFoundException("Username not found")

        return User(user.username, user.password, mapRolesToAuthorities(user.roles))
    }

    private fun mapRolesToAuthorities(roles: List<Role>): List<GrantedAuthority> {
        return roles.map { role ->
            SimpleGrantedAuthority(role.name)
        }
    }
}