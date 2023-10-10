package com.erpvin.controller

import com.erpvin.dto.CategoryDto
import com.erpvin.dto.UsersTableDto
import com.erpvin.entity.Category
import com.erpvin.service.CategoryService
import org.springframework.http.HttpStatus
import org.springframework.http.ResponseEntity
import org.springframework.web.bind.annotation.*

@RestController
@RequestMapping("api")
@CrossOrigin("\${front.url}")
class CategoryController(private val categoryService: CategoryService) {

    @PostMapping("/category/addCategory")
    fun addCategory(@RequestBody category: Category): ResponseEntity<Category> {
        val createCategory = categoryService.addCategory(category)
        return ResponseEntity(createCategory, HttpStatus.CREATED)
    }

    @GetMapping("category/getCategories")
    fun getCategories(): ResponseEntity<List<CategoryDto>> {
        val categories = categoryService.getCategories()
        return ResponseEntity.ok(categories)
    }
}