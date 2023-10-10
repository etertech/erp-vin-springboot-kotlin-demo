package com.erpvin.service

import com.erpvin.dto.ClientDto
import com.erpvin.dto.SupplierDto
import com.erpvin.entity.Client
import com.erpvin.entity.Supplier

interface SupplierService {
    fun addSupplier(supplierDto: SupplierDto): Supplier
}