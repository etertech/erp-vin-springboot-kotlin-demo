package com.erpvin.dto

import com.erpvin.entity.Address

data class WarehousesTableDto(

    val id:Long?= null,
    val name: String,


    val address: Address,

    )
