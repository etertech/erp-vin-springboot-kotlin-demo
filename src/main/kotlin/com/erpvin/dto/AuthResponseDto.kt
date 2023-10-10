package com.erpvin.dto

import com.erpvin.entity.Role


class AuthResponseDto(
     val token: String,
     val id: Long,
     val username : String,
     val firstName : String,
     val lastName : String,
     var roles: List<Role>,
     val enabled: Boolean
) {
     val tokenType = "Bearer "


}

