package com.erpvin.dto

import com.erpvin.entity.Address
import jakarta.persistence.CascadeType
import jakarta.persistence.JoinColumn
import jakarta.persistence.OneToOne
import java.time.LocalDate
import java.time.LocalDateTime
import java.time.ZonedDateTime

class SupplierDto (
    val firstName:String,
    val lastName: String,
    val companyName: String,
    val email: String,
    val telephone: String,
    val address: Address,
    val addedDate: ZonedDateTime
){

}