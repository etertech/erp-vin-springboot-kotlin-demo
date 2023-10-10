package com.erpvin.service

import org.springframework.web.multipart.MultipartFile

interface GoogleStorageService {
    fun uploadImage(file: MultipartFile): String
}