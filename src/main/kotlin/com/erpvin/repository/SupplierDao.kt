package com.erpvin.repository

import com.erpvin.entity.Supplier
import org.springframework.data.jpa.repository.JpaRepository

interface SupplierDao :JpaRepository<Supplier,Long>{

}