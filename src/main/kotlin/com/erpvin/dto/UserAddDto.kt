package com.erpvin.dto

import com.erpvin.entity.Role
import java.time.LocalDate

class UserAddDto(
    val username: String,
    val password: String,
    val email: String,
    val firstName: String,
    val lastName: String,
    val telephone: String,
    val birthday: LocalDate,
    var roles: MutableSet<Role> = HashSet(),
    var enabled: Boolean = true,
) {
}