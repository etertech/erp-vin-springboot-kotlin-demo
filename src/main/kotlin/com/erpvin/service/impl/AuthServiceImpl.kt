package com.erpvin.service.impl
import com.erpvin.dto.UserAddDto
import com.erpvin.dto.UsersTableDto
import com.erpvin.entity.Role
import com.erpvin.entity.RoleEnum
import com.erpvin.entity.UserBean
import com.erpvin.exception.AccountExistsException
import com.erpvin.repository.RoleDao
import com.erpvin.repository.UserDao
import com.erpvin.service.AuthService
import io.github.oshai.kotlinlogging.KotlinLogging
import org.springframework.security.crypto.password.PasswordEncoder
import org.springframework.stereotype.Service
import java.lang.IllegalArgumentException

@Service
class AuthServiceImpl (val userDao:UserDao,
                       val passwordEncoder: PasswordEncoder,
                        val roleDao: RoleDao,
) : AuthService{
    private val logger = KotlinLogging.logger {}


    override fun save(userAddDto: UserAddDto): UserBean {
        if(userDao.findByUsername(userAddDto.username) != null) {
            logger.info { "User exists" }
            throw AccountExistsException()
        }

        val roles = userAddDto.roles.map { role ->
            createRole(role.name) // Utilisation de la fonction createRole pour réutiliser ou créer chaque rôle
        }.toList()

        val userBean = userAddDto.let {
            UserBean(null ,
                it.username,
                passwordEncoder.encode(it.password),
                it.email,
                it.firstName,
                it.lastName,
                it.telephone,
                it.birthday,
                roles,
                it.enabled

                )
        }
        userDao.save(userBean)
        return userBean
    }



    override fun createRole(roleName: String): Role {

        // Vérifier si le roleName est une valeur valide de RoleEnum
        if(!RoleEnum.values().any{it.name == roleName}) {
            logger.error { "Invalid role name: $roleName" }
            throw IllegalArgumentException("Invalid role name: $roleName")
        }

        // Rechercher le rôle par son nom
        val existingRole = roleDao.findByName(roleName)

        // Si le rôle existe déjà, le retourner. Sinon, créer un nouveau rôle.
        return existingRole ?: roleDao.save(Role(name = roleName))
    }

    override fun getUserByUserName(username: String?): UserBean? {
        return userDao.findByUsername(username)
    }

    override fun getUsers(): List<UsersTableDto>? {
        return userDao.findAll().map{
            UsersTableDto(
                id = it?.id!! ,
                username= it.username,
                password = it.password,
                email=it.email,
                firstName=it.firstName,
                lastName=it.lastName,
                telephone=it.telephone,
                birthday=it.birthday,
                roles = it.roles,
                enabled= it.enabled
            )
        }
    }
}