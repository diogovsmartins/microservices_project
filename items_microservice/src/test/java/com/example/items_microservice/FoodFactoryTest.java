package com.example.items_microservice;

import com.example.items_microservice.domain.Food;
import com.example.items_microservice.domain.factory.FoodFactory;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.junit.jupiter.MockitoExtension;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertInstanceOf;

@ExtendWith(MockitoExtension.class)
class FoodFactoryTest {
    @InjectMocks
    FoodFactory foodFactory;

    @Test
    void shouldReturnAnInstanceOfChicken() {
        assertInstanceOf(Food.class, foodFactory.createFood());
    }

}
