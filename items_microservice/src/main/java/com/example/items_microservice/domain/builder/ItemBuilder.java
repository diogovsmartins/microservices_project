package com.example.items_microservice.domain.builder;

import com.example.items_microservice.domain.Item;

import java.math.BigDecimal;
import java.math.BigInteger;

public class ItemBuilder implements Builder{
    private String name;
    private String description;
    private BigInteger inventoryCount;
    private BigDecimal price;
    private Boolean inStock;

    @Override
    public ItemBuilder setName(String name) {
        this.name=name;
        return this;
    }

    @Override
    public ItemBuilder setDescription(String description) {
        this.description=description;
        return this;
    }

    @Override
    public ItemBuilder setInventoryCount(BigInteger inventoryCount) {
        this.inventoryCount=inventoryCount;
        return this;
    }

    @Override
    public ItemBuilder setPrice(BigDecimal price) {
        this.price=price;
        return this;
    }

    @Override
    public ItemBuilder setInStock(Boolean inStock) {
        this.inStock=inStock;
        return this;
    }

    public Item build(){
        return new Item(
                name,
                description,
                inventoryCount,
                price,
                inStock);
    }
}
