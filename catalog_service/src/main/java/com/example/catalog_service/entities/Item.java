package com.example.catalog_service.entities;


import lombok.Getter;
import lombok.Setter;

import java.math.BigDecimal;
import java.math.BigInteger;

@Getter
@Setter
public class Item {
    private Long id;
    private String name;
    private String description;
    private BigInteger inventoryCount;
    private BigDecimal price;
    private Boolean inStock;
}
