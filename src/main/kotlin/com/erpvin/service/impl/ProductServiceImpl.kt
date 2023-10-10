package com.erpvin.service.impl

import com.erpvin.dto.*
import com.erpvin.entity.Product
import com.erpvin.entity.ProductPhoto
import com.erpvin.entity.ProductUnit
import com.erpvin.repository.CategoryDao
import com.erpvin.repository.ProductDao
import com.erpvin.repository.ProductUnitDao
import com.erpvin.repository.WarehouseDao
import com.erpvin.service.GoogleStorageService
import com.erpvin.service.ProductService
import org.hibernate.Hibernate
import org.springframework.stereotype.Service
import org.springframework.web.multipart.MultipartFile


@Service
class ProductServiceImpl(
    private val googleStorageService: GoogleStorageService,
    private val productDao: ProductDao,

    private val categoryDao: CategoryDao,
    private val warehouseDao: WarehouseDao,
    private val productUnitDao: ProductUnitDao,
    // ... other dependencies
) : ProductService {

    override fun addProduct(productAddDto: ProductAddDto, productPhotos: Array<MultipartFile>?): Product {

        val category = categoryDao.findById(productAddDto.categoryId)
            .orElseThrow { IllegalArgumentException("Category not found") }

        val warehouse = warehouseDao.findById(productAddDto.warehouseId)
            .orElseThrow { IllegalArgumentException("Warehouse not found") }

        val productUnit = productUnitDao.findById(productAddDto.productUnitId)
            .orElseThrow {IllegalArgumentException("Product Unit not found")}

        val product = Product(
            productName = productAddDto.productName,
            price = productAddDto.price,
            productUnit = productUnit,
            soldQuantity = productAddDto.soldQuantity,
            description = productAddDto.description,
            stock = productAddDto.stock,
            year = productAddDto.year,
            category = category,
            warehouse = warehouse
        )

        // Save product to DB
        // ...

//        val productPhotoEntities = productAddDto.productPhotos
//            .map { photo -> googleStorageService.uploadImage(photo) }
//            .map { imageUrl -> ProductPhoto(photoLink = imageUrl, product = product) }
//
//        product.productPhotos.addAll(productPhotoEntities)

        // Save product photos to DB
        // ...

        if (productPhotos.isNullOrEmpty()) {
            val defaultUrl = "https://storage.googleapis.com/erpvin/placeholder.png"
            val defaultProductPhoto = ProductPhoto(photoLink = defaultUrl, product = product)
            product.productPhotos.add(defaultProductPhoto)
        } else {



            productPhotos.forEach { file ->
            val url = googleStorageService.uploadImage(file)
            val productPhoto = ProductPhoto(photoLink = url, product = product)
            product.productPhotos.add(productPhoto)
            }
        }

        return productDao.save(product)
    }

    override fun getCategories(): List<CategoryDto>? {
        return categoryDao.findAll().map {
            CategoryDto(id = it.id!!, name = it.categoryName)
        }
    }

    override fun getWarehouses(): List<WarehouseWithIdDto>? {
        return warehouseDao.findAll().map {
            WarehouseWithIdDto(id = it.id!!, name = it.name)
        }
    }

    override fun getProductUnits(): List<ProductUnitDto>? {
        return productUnitDao.findAll().map{
            ProductUnitDto(id= it.id!!, name = it.name)
        }
    }

    override fun getProducts(): List<ProductsTableDto>? {
       return productDao.findAll().map{
           ProductsTableDto(
               id = it.id!! ,
               productName= it.productName,
               price = it.price,
               soldQuantity=it.soldQuantity,
               description=it.description,
               stock=it.stock,
               year=it.year,
               productPhotos = it.productPhotos.map { photo -> ProductPhotoDto(id = photo.id ?: 0, photoLink = photo.photoLink) },
               warehouseName= it.warehouse!!.name,
               categoryName = it.category!!.categoryName,
               productUnitName = it.productUnit!!.name,
           )
       }
    }

    override fun updateProduct(id: Long, productUpdateDto: ProductUpdateDto) {
        var product = productDao.findById(id)
            .orElseThrow { IllegalArgumentException("Product with ID $id not found") }

        product.productName = productUpdateDto.productName
        product.price = productUpdateDto.price

        productDao.save(product)
    }

}