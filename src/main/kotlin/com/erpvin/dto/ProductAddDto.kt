package com.erpvin.dto

import org.springframework.web.multipart.MultipartFile

class ProductAddDto (
    val productName: String,
    val price: Double,
    val productUnitId: Long,
    val soldQuantity: Int,
    val description: String,
    val stock: Int,
    val year: Int,
    val categoryId: Long,
    val warehouseId: Long,
    //val productPhotos: List<MultipartFile>



){
}