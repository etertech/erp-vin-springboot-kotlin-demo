package com.erpvin.service

import com.erpvin.dto.ClientDto
import com.erpvin.entity.Client

interface ClientService {
    fun addClient(clientDto: ClientDto): Client
}