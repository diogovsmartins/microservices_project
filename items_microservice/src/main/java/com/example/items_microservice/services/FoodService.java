package com.example.items_microservice.services;

import com.example.items_microservice.domain.Food;
import com.example.items_microservice.domain.factory.FoodFactory;
import com.example.items_microservice.repositories.FoodRepositorie;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class FoodService {
    private final FoodRepositorie foodRepositorie;
    private final FoodFactory foodFactory;

    @Autowired
    public FoodService(FoodRepositorie foodRepositorie,FoodFactory foodFactory) {
        this.foodRepositorie = foodRepositorie;
        this.foodFactory = foodFactory;
    }

    public Optional<Food> getById(Long id) {
        return foodRepositorie.findById(id);
    }

    public List<Food> getAll() {
        return foodRepositorie.findAll();
    }

    public Optional<Food> insertFood(String name, String description) {
        Food food = foodFactory.createFood();
        food.setName(name);
        food.setDescription(description);
        foodRepositorie.save(food);
        return Optional.ofNullable(food);
    }

    public void delete(Long id) {
        Food food = getById(id).orElse(foodFactory.createFood());
        foodRepositorie.delete(food);
    }

    public void update(Food food) {
        Food foodToUpdate = getById(food.getId()).orElse(foodFactory.createFood());
        foodToUpdate.setName(food.getName());
        foodToUpdate.setDescription(food.getDescription());
        foodRepositorie.saveAndFlush(foodToUpdate);
    }
}
