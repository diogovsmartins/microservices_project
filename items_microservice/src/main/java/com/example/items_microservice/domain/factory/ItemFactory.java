package com.example.items_microservice.domain.factory;


import com.example.items_microservice.domain.Item;
import org.springframework.stereotype.Component;

@Component
public class ItemFactory implements AbstractFactory {

    @Override
    public Item createItem() {
        return new Item();
    }
}
