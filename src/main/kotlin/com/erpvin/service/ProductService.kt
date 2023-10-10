package com.erpvin.service

import com.erpvin.dto.*
import com.erpvin.entity.Product
import org.springframework.web.multipart.MultipartFile

interface ProductService {
    fun addProduct(productAddDto: ProductAddDto, productPhotos: Array<MultipartFile>?): Product
    fun getCategories(): List<CategoryDto>?
    fun getWarehouses(): List<WarehouseWithIdDto>?
    fun getProductUnits(): List<ProductUnitDto>?
    fun getProducts(): List<ProductsTableDto>?
    fun updateProduct(id: Long, productUpdateDto: ProductUpdateDto)
}