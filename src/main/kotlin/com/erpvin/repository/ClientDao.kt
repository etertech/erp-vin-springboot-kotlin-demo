package com.erpvin.repository

import com.erpvin.entity.Client
import org.springframework.data.jpa.repository.JpaRepository

interface ClientDao:JpaRepository<Client, Long> {
}