package com.erpvin.service.impl

import com.erpvin.dto.ClientDto
import com.erpvin.entity.Address
import com.erpvin.entity.Client
import com.erpvin.repository.ClientDao
import com.erpvin.service.ClientService
import org.springframework.stereotype.Service


@Service
class ClientServiceImpl(val clientDao: ClientDao) :ClientService{
    override fun addClient(clientDto: ClientDto): Client {
        val address = Address(
            street = clientDto.address.street,
            city = clientDto.address.city,
            state = clientDto.address.state,
            postalCode = clientDto.address.postalCode,
            country = clientDto.address.country
        )

        val client = Client(
            firstName = clientDto.firstName,
            lastName =  clientDto.lastName,
            companyName = clientDto.companyName,
            email = clientDto.email,
            telephone = clientDto.telephone,
            address = address,
            addedDate = clientDto.addedDate
        )
        return clientDao.save(client)
    }
}