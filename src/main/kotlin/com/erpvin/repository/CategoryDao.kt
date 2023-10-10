package com.erpvin.repository

import com.erpvin.entity.Category
import org.springframework.data.jpa.repository.JpaRepository

interface CategoryDao:JpaRepository<Category, Long> {
}