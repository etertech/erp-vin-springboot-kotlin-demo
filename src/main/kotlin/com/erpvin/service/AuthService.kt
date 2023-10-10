package com.erpvin.service
import com.erpvin.dto.UserAddDto
import com.erpvin.dto.UsersTableDto
import com.erpvin.entity.Role
import com.erpvin.entity.UserBean
import com.erpvin.exception.AccountExistsException

interface AuthService  {

    @Throws(AccountExistsException::class)
    fun save(userAddDto: UserAddDto): UserBean

    fun createRole(roleName: String): Role

    fun getUserByUserName(username: String?) : UserBean?

    fun getUsers(): List<UsersTableDto>?

}