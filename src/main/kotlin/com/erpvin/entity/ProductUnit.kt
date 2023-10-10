package com.erpvin.entity

import com.fasterxml.jackson.annotation.JsonManagedReference
import jakarta.persistence.CascadeType
import jakarta.persistence.Entity
import jakarta.persistence.FetchType
import jakarta.persistence.GeneratedValue
import jakarta.persistence.GenerationType
import jakarta.persistence.Id
import jakarta.persistence.OneToMany
import jakarta.persistence.Table

@Entity
@Table(name = "unit_product")
data class ProductUnit(
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    val id: Long? = null,
    val name: String,

    @JsonManagedReference
    @OneToMany(mappedBy = "productUnit", fetch = FetchType.LAZY, cascade = [CascadeType.ALL])
    val products: MutableList<Product> = mutableListOf()
) {
}