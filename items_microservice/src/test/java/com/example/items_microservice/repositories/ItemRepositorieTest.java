package com.example.items_microservice.repositories;


import com.example.items_microservice.domain.Item;
import com.example.items_microservice.domain.builder.ItemBuilder;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.junit.runner.RunWith;
import org.mockito.junit.jupiter.MockitoExtension;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import org.springframework.boot.test.autoconfigure.orm.jpa.TestEntityManager;
import org.springframework.test.context.junit4.SpringRunner;


import java.math.BigDecimal;
import java.math.BigInteger;
import java.util.NoSuchElementException;
import java.util.stream.Collectors;

import static org.junit.jupiter.api.Assertions.*;

@RunWith(SpringRunner.class)
@DataJpaTest
@ExtendWith(MockitoExtension.class)
class ItemRepositorieTest {

    @Autowired
    TestEntityManager entityManager;
    @Autowired
    ItemRepositorie itemRepositorie;

    @Test
    void findById(){
        Item item=itemRepositorie.findById(1L).get();
        assertNotNull(item);
        assertEquals("Cadeira",item.getName());
        assertEquals("Cadeira de madeira",item.getDescription());
        assertEquals(BigInteger.TEN,item.getInventoryCount());
        assertEquals(BigDecimal.valueOf(49.99),item.getPrice());
        assertEquals(Boolean.TRUE,item.getInStock());
    }

    @Test
    void findAll(){
        var item=itemRepositorie.findAll();
        assertNotNull(item);
    }

    @Test
    void insertItem(){
        Item item= new ItemBuilder()
                .setName("TEST_ITEM")
                .setDescription("TEST DESCRIPTION")
                .setInventoryCount(BigInteger.ONE)
                .setPrice(BigDecimal.TEN)
                .setInStock(true).build();
        itemRepositorie.save(item);
       var listOfItems= itemRepositorie
               .findAll()
               .stream()
               .filter(object ->object.getName().equals("TEST_ITEM")).collect(Collectors.toList());
        assertNotNull(listOfItems);
    }

    @Test
    void removeItem(){
        Item item= new ItemBuilder()
                .setName("Cadeira")
                .setDescription("Cadeira de madeira")
                .setInventoryCount(BigInteger.TEN)
                .setPrice(BigDecimal.valueOf(49.99))
                .setInStock(true).build();
        item.setId(1L);
        int itemSizeBeforeDeletion=itemRepositorie.findAll().size();
        itemRepositorie.delete(item);
        assertTrue(itemRepositorie.findAll().size()<itemSizeBeforeDeletion);
    }
    @Test
    void updateItem(){
        Item item= new ItemBuilder()
                .setName("Cadeira UPDATED")
                .setPrice(BigDecimal.valueOf(100))
                .setInStock(true).build();
        item.setId(1L);
        var itemNameBeforeUpdate=itemRepositorie.findById(1L).get().getName();
        var itemPriceBeforeUpdate=itemRepositorie.findById(1L).get().getPrice();
        itemRepositorie.save(item);
        var itemAfterUpdate=itemRepositorie.findById(1L);
        assertFalse(itemAfterUpdate.get().getName().equals(itemNameBeforeUpdate));
        assertTrue(itemAfterUpdate.get().getPrice().compareTo(itemPriceBeforeUpdate)>0);
    }

}