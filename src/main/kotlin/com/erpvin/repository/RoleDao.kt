package com.erpvin.repository

import com.erpvin.entity.Role
import org.springframework.data.jpa.repository.JpaRepository

interface RoleDao: JpaRepository<Role?, Long?> {
    fun findByName(name: String): Role?
}