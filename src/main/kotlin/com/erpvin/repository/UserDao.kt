package com.erpvin.repository

import com.erpvin.entity.UserBean
import org.springframework.data.jpa.repository.JpaRepository
import java.util.*

interface UserDao : JpaRepository<UserBean?, Long?>{
    override fun findById(id: Long): Optional<UserBean?>
    fun findByUsername(username: String?): UserBean?
//
//    @Query("SELECT o FROM User o WHERE o.id != :id AND size(o.pets) > 0")
//    fun findAllButSelf(@Param("id") id: Long): List<User?>?

}


