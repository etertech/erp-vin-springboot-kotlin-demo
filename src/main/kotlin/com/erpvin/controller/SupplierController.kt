package com.erpvin.controller

import com.erpvin.dto.ClientDto
import com.erpvin.dto.SupplierDto
import com.erpvin.entity.Client
import com.erpvin.entity.Supplier
import com.erpvin.service.SupplierService
import io.github.oshai.kotlinlogging.KotlinLogging
import org.springframework.http.HttpStatus
import org.springframework.http.ResponseEntity
import org.springframework.web.bind.annotation.*

@RestController
@RequestMapping("api")
@CrossOrigin("\${front.url}")
class SupplierController(val supplierService: SupplierService) {
    private val logger = KotlinLogging.logger {}
    @PostMapping("/supplier/addSupplier")
    fun addClient(@RequestBody supplierDto: SupplierDto) : ResponseEntity<Supplier> {

        logger.info { supplierDto.addedDate }

        val savedSupplier = supplierService.addSupplier(supplierDto)
        return ResponseEntity(savedSupplier, HttpStatus.CREATED)
    }
}