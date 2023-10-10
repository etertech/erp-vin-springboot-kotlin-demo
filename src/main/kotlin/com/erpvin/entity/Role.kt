package com.erpvin.entity

import com.fasterxml.jackson.annotation.JsonBackReference
import jakarta.persistence.*

@Entity
@Table(name="roles")
data class Role (
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    val id: Long? = null,
    @Column(unique = true, nullable = false)
    val name: String,
    @JsonBackReference
    @ManyToMany(mappedBy = "roles", fetch = FetchType.EAGER)
    val users: MutableSet<UserBean> = HashSet()
){
    override fun toString(): String {
        return "Role(id=$id, name='$name')"
    }
}