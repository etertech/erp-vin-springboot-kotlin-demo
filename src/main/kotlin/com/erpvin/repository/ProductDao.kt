package com.erpvin.repository

import com.erpvin.entity.Product
import org.springframework.data.jpa.repository.JpaRepository

interface ProductDao :JpaRepository<Product,Long>{
}