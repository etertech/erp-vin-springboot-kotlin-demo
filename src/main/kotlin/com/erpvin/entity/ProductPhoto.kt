package com.erpvin.entity

import com.fasterxml.jackson.annotation.JsonBackReference
import jakarta.persistence.*

@Entity
@Table(name= "product_photos")
data class ProductPhoto (
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    val id: Long?=null,
    val photoLink: String,

    @JsonBackReference
    @ManyToOne(fetch= FetchType.EAGER)
    @JoinColumn(name="product_id")
    var product: Product
){

}