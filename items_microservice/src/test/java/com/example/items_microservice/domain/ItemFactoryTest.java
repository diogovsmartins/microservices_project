package com.example.items_microservice.domain;

import com.example.items_microservice.domain.Item;
import com.example.items_microservice.domain.factory.ItemFactory;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.junit.jupiter.MockitoExtension;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertInstanceOf;

@ExtendWith(MockitoExtension.class)
class ItemFactoryTest {
    @InjectMocks
    ItemFactory itemFactory;

    @Test
    void shouldReturnAnInstanceOfChicken() {
        assertInstanceOf(Item.class, itemFactory.createItem());
    }

}
