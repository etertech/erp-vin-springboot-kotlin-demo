package com.erpvin.entity

import jakarta.persistence.Entity
import jakarta.persistence.GeneratedValue
import jakarta.persistence.GenerationType
import jakarta.persistence.Id
import jakarta.persistence.Table

@Entity
@Table(name="address")
data class Address(

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    val id:Long?=null,
    val street: String,
    val city: String,
    val state: String?,
    val postalCode: String,
    val country: String
)
