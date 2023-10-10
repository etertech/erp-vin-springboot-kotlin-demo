package com.erpvin.dto
import com.erpvin.entity.Role
import java.time.LocalDate

data class UsersTableDto(
    val id: Long? = null,
    var username: String,
    val password: String,
    val email: String,
    val firstName: String = "",
    val lastName: String = "",
    val telephone: String = "",
    val birthday: LocalDate,
    var roles: List<Role>,
    val enabled: Boolean

)