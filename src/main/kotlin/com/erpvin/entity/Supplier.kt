package com.erpvin.entity

import jakarta.persistence.*
import java.time.ZonedDateTime

@Entity
@Table(name="suppliers")
class Supplier (
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
