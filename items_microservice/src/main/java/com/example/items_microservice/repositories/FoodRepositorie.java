package com.example.items_microservice.repositories;

import com.example.items_microservice.domain.Food;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface FoodRepositorie extends JpaRepository<Food, Long> {
}
