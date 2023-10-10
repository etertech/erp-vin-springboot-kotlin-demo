package com.erpvin.entity

import com.fasterxml.jackson.annotation.JsonBackReference
import com.fasterxml.jackson.annotation.JsonManagedReference
import jakarta.persistence.*
import jakarta.validation.constraints.Size

@Entity
@Table(name="products")
data class Product(
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    val id: Long? = null,

    var productName: String,
    var price: Double,

    @JsonBackReference("unit-products")
    @ManyToOne(fetch = FetchType.EAGER)
    @JoinColumn(name="unit_id")
    val productUnit: ProductUnit?,
    val soldQuantity: Int,
    @Column(length = 2000)
    @Size(max = 2000)
    val description: String,
    val stock: Int,
    val year: Int,

    @JsonBackReference
    @ManyToOne(fetch= FetchType.EAGER)
    @JoinColumn(name="warehouse_id")
    var warehouse: Warehouse?,

    @JsonBackReference("category-products")
    @ManyToOne(fetch= FetchType.EAGER)
    @JoinColumn(name="category_id")
    var category: Category?,

    @JsonManagedReference
    @OneToMany(mappedBy ="product", fetch = FetchType.EAGER, cascade = [CascadeType.ALL])
    val productPhotos: MutableList<ProductPhoto> = mutableListOf()

) {
    override fun toString(): String {
        return "Product(id=$id, productName='$productName', price=$price, productUnit='$productUnit', " +
                "soldQuantity=$soldQuantity, description='$description', stock=$stock)"
    }

}