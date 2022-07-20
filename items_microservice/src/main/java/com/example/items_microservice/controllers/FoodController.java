package com.example.items_microservice.controllers;

import com.example.items_microservice.domain.Food;
import com.example.items_microservice.services.FoodService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping(value = "/food")
public class FoodController {
    private final FoodService foodService;

    @Autowired
    public FoodController(FoodService foodService) {
        this.foodService = foodService;
    }

    @GetMapping(value = "/{id}")
    public ResponseEntity<Optional<Food>> getById(@PathVariable Long id) {
        return ResponseEntity.ok(foodService.getById(id));
    }

    @GetMapping()
    public ResponseEntity<List<Food>> getAll() {
        return ResponseEntity.ok(foodService.getAll());
    }

    @PostMapping(value = "/insert")
    public ResponseEntity<Optional<Food>> insert(
            @RequestHeader String name,
            @RequestHeader String description){
        return ResponseEntity.ok(foodService.insertFood(name, description));
    }

    @PutMapping(value = "/update")
    public ResponseEntity update(@RequestBody Food food){
        foodService.update(food);
        return ResponseEntity.ok().body("Item updated.");
    }

    @DeleteMapping(value = "/delete/{id}")
    public ResponseEntity delete(@PathVariable Long id){
        foodService.delete(id);
        return ResponseEntity.ok().body("Item deleted.");
    }
}
