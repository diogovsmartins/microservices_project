package com.example.catalog_service.v1;


import lombok.Getter;
import lombok.Setter;

import java.math.BigDecimal;
import java.math.BigInteger;

@Getter
@Setter
public class ItemV1 {
    private Long id;
    private String name;
    private String description;
    private BigInteger inventoryCount;
    private BigDecimal price;
    private Boolean inStock;
}
