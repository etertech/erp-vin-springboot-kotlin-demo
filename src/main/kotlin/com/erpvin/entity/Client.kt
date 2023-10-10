package com.erpvin.entity

import jakarta.persistence.*
import java.time.LocalDate
import java.time.LocalDateTime
import java.time.ZonedDateTime

@Entity
@Table(name="clients")
data class Client (
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    val id:Long? = null,
    val firstName:String ="",
    val lastName: String = "",
    val companyName: String = "",
    val email: String="",
    val telephone: String = "",

    @OneToOne(cascade = [CascadeType.ALL])
    @JoinColumn(name = "address_id")
    val address: Address,

    val addedDate: ZonedDateTime

)

