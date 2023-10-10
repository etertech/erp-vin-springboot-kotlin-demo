package com.erpvin.entity

import com.fasterxml.jackson.annotation.JsonManagedReference
import jakarta.persistence.*

@Entity
@Table(name="categories")
data class Category (
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    val id:Long?= null,
    val categoryName: String,
    @JsonManagedReference("category-products")
    @OneToMany(mappedBy ="category", fetch = FetchType.LAZY, cascade = [CascadeType.ALL])
    val products: MutableList<Product> = mutableListOf()

){

}