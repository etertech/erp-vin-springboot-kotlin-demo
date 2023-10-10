package com.erpvin.dto

import com.erpvin.entity.ProductUnit

data class ProductsTableDto(
    val id: Long,
    val productName: String,
    val price: Double,
    val soldQuantity: Int,
    val description: String,
    val stock: Int,
    val year: Int,
    val productPhotos: List<ProductPhotoDto>,
    val warehouseName: String,
    var categoryName: String,
    var productUnitName: String
    //val firstPhoto: String

)