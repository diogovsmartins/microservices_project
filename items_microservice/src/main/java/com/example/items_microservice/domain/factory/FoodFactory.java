package com.example.items_microservice.domain.factory;


import com.example.items_microservice.domain.Food;
import org.springframework.stereotype.Component;

@Component
public class FoodFactory implements AbstractFactory {

    @Override
    public Food createFood() {
        return new Food();
    }
}
