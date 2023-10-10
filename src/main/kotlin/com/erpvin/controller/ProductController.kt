package com.erpvin.controller

import com.erpvin.dto.*
import com.erpvin.entity.Product
import com.erpvin.service.ProductService
import org.springframework.http.ResponseEntity
import org.springframework.web.bind.annotation.*
import org.springframework.web.multipart.MultipartFile

@RestController
@RequestMapping("api")
@CrossOrigin("\${front.url}")
class ProductController (
    val productService: ProductService

){
    @PostMapping("product/addProduct")
    fun addProduct(
        @RequestParam("productName") productName: String,
        @RequestParam("price") price: Double,
        @RequestParam("productUnitId") productUnitId: Long,
        @RequestParam("soldQuantity") soldQuantity: Int,
        @RequestParam("description") description: String,
        @RequestParam("stock") stock: Int,
        @RequestParam("year") year: Int,
        @RequestParam("categoryId") categoryId: Long,
        @RequestParam("warehouseId") warehouseId: Long,
        @RequestParam("productPhotos", required = false) productPhotos: Array<MultipartFile>?

    ): ResponseEntity<Product>
     {
         val productDto = ProductAddDto(productName, price, productUnitId, soldQuantity, description, stock , year,
             categoryId, warehouseId)
         return ResponseEntity.ok(productService.addProduct(productDto, productPhotos))

    }

    @GetMapping("product/getCategories")
    fun getCategories(): ResponseEntity<List<CategoryDto>> {
        val categories = productService.getCategories()
        return ResponseEntity.ok(categories)
    }

    @GetMapping("product/getWarehouses")
    fun getWarehouses(): ResponseEntity<List<WarehouseWithIdDto>> {
        val warehouses = productService.getWarehouses()
        return ResponseEntity.ok(warehouses)
    }

    @GetMapping("product/getProductUnits")
    fun getProductUnit(): ResponseEntity<List<ProductUnitDto>> {
        val productUnits = productService.getProductUnits()
        return ResponseEntity.ok(productUnits)
    }

    @GetMapping("product/getProducts")
    fun getProducts(): ResponseEntity<List<ProductsTableDto>> {
        val products = productService.getProducts()
        return ResponseEntity.ok(products)
    }

    @PutMapping("product/{id}")
    fun updateProduct(@PathVariable id: Long, @RequestBody productUpdateDto: ProductUpdateDto): ResponseEntity<Any> {
        return try {
            productService.updateProduct(id, productUpdateDto)
            ResponseEntity.ok().body(mapOf("success" to true))
        } catch (e: Exception) {
            ResponseEntity.badRequest().body(mapOf("success" to false, "message" to e.message))
        }
    }


}