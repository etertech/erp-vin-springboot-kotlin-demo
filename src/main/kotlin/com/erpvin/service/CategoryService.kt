package com.erpvin.service

import com.erpvin.dto.CategoryDto
import com.erpvin.dto.UsersTableDto
import com.erpvin.entity.Category

interface CategoryService {
    fun addCategory(category: Category): Category
    fun getCategories(): List<CategoryDto>?
}