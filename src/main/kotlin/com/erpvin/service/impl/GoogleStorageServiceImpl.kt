package com.erpvin.service.impl


import com.erpvin.service.GoogleStorageService
import com.google.auth.oauth2.ServiceAccountCredentials
import com.google.cloud.storage.Bucket
import com.google.cloud.storage.Storage
import com.google.cloud.storage.StorageOptions
import org.springframework.beans.factory.annotation.Value
import org.springframework.core.io.Resource
import org.springframework.stereotype.Service
import org.springframework.web.multipart.MultipartFile


@Service
class GoogleStorageServiceImpl(
    @Value("\${google.cloud.storage.credentials.location}") private val credentialsLocation: Resource,
    @Value("\${google.cloud.storage.bucket-name}") private val bucketName: String
) : GoogleStorageService {

    private val storage: Storage = StorageOptions.newBuilder()
        .setCredentials(ServiceAccountCredentials.fromStream(credentialsLocation.inputStream))
        .build()
        .service
    private val bucket: Bucket = storage.get(bucketName)

    override fun uploadImage(file: MultipartFile): String {
        val blob = bucket.create(file.originalFilename, file.bytes, file.contentType)

//        return blob.mediaLink
        return convertUrl(blob.selfLink)
    }

    fun convertUrl(url: String): String {
        val bucket = "erpvin"
        val regex = "https://www.googleapis.com/storage/v1/b/$bucket/o/(.*)".toRegex()
        val matchResult = regex.find(url)
        val fileName = matchResult?.groups?.get(1)?.value ?: return ""
        return "https://storage.googleapis.com/$bucket/$fileName"
    }

}