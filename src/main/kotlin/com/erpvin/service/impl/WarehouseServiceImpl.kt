package com.erpvin.service.impl

import com.erpvin.dto.CategoryDto
import com.erpvin.dto.WarehousesTableDto
import com.erpvin.entity.Warehouse
import com.erpvin.repository.AddressDao
import com.erpvin.repository.WarehouseDao
import com.erpvin.service.WarehouseService
import org.springframework.stereotype.Service

@Service
class WarehouseServiceImpl(
    val warehouseDao: WarehouseDao,
    val addressDao: AddressDao


) : WarehouseService {
    override fun addWarehouse(warehouse: Warehouse): Warehouse {
        return warehouseDao.save(warehouse)
    }

    override fun getWarehouses(): List<WarehousesTableDto>? {
        return warehouseDao.findAll().map{
            WarehousesTableDto(
                id = it?.id!! ,
                name= it.name,
                address = it.address
            )
        }
    }
}