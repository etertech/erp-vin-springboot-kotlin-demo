package com.erpvin.repository

import com.erpvin.entity.Warehouse
import org.springframework.data.jpa.repository.JpaRepository

interface WarehouseDao: JpaRepository<Warehouse, Long> {
}
