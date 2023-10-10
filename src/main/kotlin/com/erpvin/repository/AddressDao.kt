package com.erpvin.repository

import com.erpvin.entity.Address
import org.springframework.data.jpa.repository.JpaRepository

interface AddressDao :JpaRepository<Address,Long>{
}