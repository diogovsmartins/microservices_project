package com.example.items_microservice.domain;

import org.springframework.lang.NonNull;

import javax.persistence.*;
import java.math.BigDecimal;
import java.math.BigInteger;

@Entity
@Table(name = "items")
public class  Item {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    @NonNull
    @Column(columnDefinition = "varchar(200)", nullable = false)
    private String name;
    @Column(columnDefinition = "varchar(300)")
    private String description;
    @NonNull
    @Column(name = "inventory_count", columnDefinition = "long")
    private BigInteger inventoryCount;
    @NonNull
    @Column(columnDefinition = "decimal(12,2)")
    private BigDecimal price;
    @Column(name = "in_stock")
    private Boolean inStock;

    public Item(@NonNull String name, String description, @NonNull BigInteger inventoryCount, @NonNull BigDecimal price, Boolean inStock) {
        this.name = name;
        this.description = description;
        this.inventoryCount = inventoryCount;
        this.price = price;
        this.inStock = inStock;
    }
    public Item(){}

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    @NonNull
    public String getName() {
        return name;
    }

    public void setName(@NonNull String name) {
        this.name = name;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    @NonNull
    public BigInteger getInventoryCount() {
        return inventoryCount;
    }

    public void setInventoryCount(@NonNull BigInteger inventoryCount) {
        this.inventoryCount = inventoryCount;
    }

    @NonNull
    public BigDecimal getPrice() {
        return price;
    }

    public void setPrice(@NonNull BigDecimal price) {
        this.price = price;
    }

    public Boolean getInStock() {
        return inStock;
    }

    public void setInStock(Boolean inStock) {
        this.inStock = inStock;
    }
}
