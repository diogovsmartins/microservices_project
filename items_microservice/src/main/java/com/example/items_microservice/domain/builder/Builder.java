package com.example.items_microservice.domain.builder;

import java.math.BigDecimal;
import java.math.BigInteger;

public interface Builder {
    Builder setName(String name);
    Builder setDescription(String description);
    Builder setInventoryCount(BigInteger inventoryCount);
    Builder setPrice(BigDecimal price);
    Builder setInStock(Boolean inStock);

}
