package com.erpvin.service.impl

import com.erpvin.dto.CategoryDto
import com.erpvin.dto.UsersTableDto
import com.erpvin.entity.Category
import com.erpvin.repository.CategoryDao
import com.erpvin.service.CategoryService
import org.springframework.stereotype.Service

@Service
class CategoryServiceImpl(private val categoryDao: CategoryDao) :CategoryService{
    override fun addCategory(category: Category): Category {
        return categoryDao.save(category)
    }

    override fun getCategories(): List<CategoryDto>? {
        return categoryDao.findAll().map{
            CategoryDto(
                id = it?.id!! ,
                name= it.categoryName
            )
        }
    }

}