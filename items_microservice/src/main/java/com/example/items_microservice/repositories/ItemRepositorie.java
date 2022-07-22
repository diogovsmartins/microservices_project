package com.example.items_microservice.repositories;

import com.example.items_microservice.domain.Item;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ItemRepositorie extends JpaRepository<Item, Long> {
}
