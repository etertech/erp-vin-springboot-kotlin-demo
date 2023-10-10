package com.erpvin.entity

import com.fasterxml.jackson.annotation.JsonManagedReference
import jakarta.persistence.*

@Entity
@Table(name="warehouses")
data class Warehouse(
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    val id:Long?= null,
    val name: String,

    @OneToOne(cascade = [CascadeType.ALL])
    @JoinColumn(name = "address_id")
    val address: Address,

    @JsonManagedReference
    @OneToMany(mappedBy ="warehouse", fetch = FetchType.LAZY, cascade = [CascadeType.ALL])
    val products: MutableList<Product> = mutableListOf()
)

{
    override fun toString(): String {
        return "Warehouse(id=$id, name='$name', address='$address')"
    }
}