package com.erpvin.repository

import com.erpvin.entity.ProductUnit
import org.springframework.data.jpa.repository.JpaRepository

interface ProductUnitDao :JpaRepository<ProductUnit, Long>{
}