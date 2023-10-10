package com.erpvin.service

import com.erpvin.dto.WarehousesTableDto
import com.erpvin.entity.Warehouse

interface WarehouseService {
    fun addWarehouse(warehouse: Warehouse): Warehouse
    fun getWarehouses(): List<WarehousesTableDto>?
}