package com.example.items_microservice.domain.dto;

import com.example.items_microservice.domain.Item;
import org.springframework.lang.NonNull;

import java.math.BigDecimal;
import java.math.BigInteger;

public class ItemDto {
    private Long id;
    @NonNull
    private String name;
    @NonNull
    private String description;
    @NonNull
    private BigInteger inventoryCount;
    @NonNull
    private BigDecimal price;

    public ItemDto(String name, String description, BigInteger inventoryCount, BigDecimal price) {
        this.name = name;
        this.description = description;
        this.inventoryCount = inventoryCount;
        this.price = price;
    }
    public ItemDto(Item item){
        this.id=item.getId();
        this.name=item.getName();
        this.description=item.getDescription();
        this.inventoryCount=item.getInventoryCount();
        this.price=item.getPrice();
    }

    public ItemDto() {
    }

    @NonNull
    public String getName() {
        return name;
    }

    public void setName(@NonNull String name) {
        this.name = name;
    }

    @NonNull
    public String getDescription() {
        return description;
    }

    public void setDescription(@NonNull String description) {
        this.description = description;
    }

    @NonNull
    public BigInteger getInventoryCount() {
        return inventoryCount;
    }

    public void setInventoryCount(@NonNull BigInteger quantity) {
        this.inventoryCount = quantity;
    }

    @NonNull
    public BigDecimal getPrice() {
        return price;
    }

    public void setPrice(@NonNull BigDecimal price) {
        this.price = price;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }
}
