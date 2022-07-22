package com.example.items_microservice;

import com.example.items_microservice.domain.Item;
import com.example.items_microservice.domain.builder.ItemBuilder;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.junit.jupiter.MockitoExtension;

import java.math.BigDecimal;
import java.math.BigInteger;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertInstanceOf;


@ExtendWith(MockitoExtension.class)
class ItemBuilderTest {

    @Test
    void shouldReturnAnInstanceOfItem() {
        Item item = new ItemBuilder()
                .setName("Vassoura")
                .setDescription("Vassoura de palha")
                .setInventoryCount(BigInteger.valueOf(30))
                .setPrice(BigDecimal.valueOf(15.25))
                .setInStock(Boolean.TRUE).build();
        assertInstanceOf(Item.class, item);
        assertEquals("Vassoura", item.getName());
        assertEquals("Vassoura de palha", item.getDescription());
        assertEquals(BigInteger.valueOf(30), item.getInventoryCount());
        assertEquals(BigDecimal.valueOf(15.25), item.getPrice());
        assertEquals(Boolean.TRUE, item.getInStock());
    }
}
