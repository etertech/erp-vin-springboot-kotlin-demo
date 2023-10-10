package com.erpvin.controller

import com.erpvin.dto.CategoryDto
import com.erpvin.dto.WarehouseDto
import com.erpvin.dto.WarehousesTableDto
import com.erpvin.entity.Address
import com.erpvin.entity.Warehouse
import com.erpvin.service.WarehouseService
import org.springframework.http.HttpStatus
import org.springframework.http.ResponseEntity
import org.springframework.web.bind.annotation.*


@RestController
@RequestMapping("api")
@CrossOrigin("\${front.url}")
class WarehouseController(private val warehouseService: WarehouseService) {


    @PostMapping("/warehouse/addWarehouse")
    fun addWarehouse(@RequestBody warehouseDto: WarehouseDto): ResponseEntity<Warehouse> {
        val address = Address(
            street = warehouseDto.address.street,
            city = warehouseDto.address.city,
            state = warehouseDto.address.state,
            postalCode = warehouseDto.address.postalCode,
            country = warehouseDto.address.country
        )

        val warehouse = Warehouse(
            name = warehouseDto.name,
            address = address
        )
        val savedWarehouse = warehouseService.addWarehouse(warehouse)
        return ResponseEntity(savedWarehouse, HttpStatus.CREATED)
    }

    @GetMapping("warehouse/getWarehouses")
    fun getWarehouses(): ResponseEntity<List<WarehousesTableDto>> {
        val categories = warehouseService.getWarehouses()
        return ResponseEntity.ok(categories)
    }



}
