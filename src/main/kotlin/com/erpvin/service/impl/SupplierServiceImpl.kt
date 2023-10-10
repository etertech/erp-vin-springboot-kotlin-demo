package com.erpvin.service.impl

import com.erpvin.dto.SupplierDto
import com.erpvin.entity.Address
import com.erpvin.entity.Supplier
import com.erpvin.repository.SupplierDao
import com.erpvin.service.SupplierService
import org.springframework.stereotype.Service

@Service
class SupplierServiceImpl (val supplierDao: SupplierDao):SupplierService{
    override fun addSupplier(supplierDto: SupplierDto): Supplier {
        val address = Address(
            street = supplierDto.address.street,
            city = supplierDto.address.city,
            state = supplierDto.address.state,
            postalCode = supplierDto.address.postalCode,
            country = supplierDto.address.country
        )

        val supplier = Supplier(
            firstName = supplierDto.firstName,
            lastName =  supplierDto.lastName,
            companyName = supplierDto.companyName,
            email = supplierDto.email,
            telephone = supplierDto.telephone,
            address = address,
            addedDate = supplierDto.addedDate
        )
        return supplierDao.save(supplier)

    }

}