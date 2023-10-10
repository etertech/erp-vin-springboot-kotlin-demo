package com.erpvin.entity

import com.fasterxml.jackson.annotation.JsonManagedReference
import jakarta.persistence.*
import java.time.LocalDate

@Entity
@Table(name="users")
data class UserBean(
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    val id: Long? = null,


    var username: String,
    val password: String,
    val email: String,
    val firstName: String = "",
    val lastName: String = "",
    val telephone: String = "",
    val birthday: LocalDate,
    //var roles: List<Role> = mutableListOf(),
    @JsonManagedReference
    @ManyToMany(fetch = FetchType.EAGER)
    @JoinTable(
        name = "users_roles",
        joinColumns = [JoinColumn(name = "user_id")],
        inverseJoinColumns = [JoinColumn(name = "role_id")]
    )
    var roles: List<Role> ,
    val enabled: Boolean

)  {







}