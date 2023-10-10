package com.erpvin.controller

import com.erpvin.dto.ClientDto
import com.erpvin.entity.Address
import com.erpvin.entity.Client
import com.erpvin.service.ClientService
import io.github.oshai.kotlinlogging.KotlinLogging
import org.springframework.http.HttpStatus
import org.springframework.http.HttpStatusCode
import org.springframework.http.ResponseEntity
import org.springframework.web.bind.annotation.CrossOrigin
import org.springframework.web.bind.annotation.PostMapping
import org.springframework.web.bind.annotation.RequestBody
import org.springframework.web.bind.annotation.RequestMapping
import org.springframework.web.bind.annotation.RestController

@RestController
@RequestMapping("api")
@CrossOrigin("\${front.url}")
class ClientController (val clientService: ClientService){

    private val logger = KotlinLogging.logger {}
    @PostMapping("/client/addClient")
    fun addClient(@RequestBody clientDto: ClientDto) : ResponseEntity<Client> {

        logger.info { clientDto.addedDate }

        val savedClient = clientService.addClient(clientDto)
        return ResponseEntity(savedClient, HttpStatus.CREATED)
    }
}