package com.example.catalog_service.feignClients;

import com.example.catalog_service.entities.Item;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

import java.util.List;

@FeignClient(value = "itemsFeignClient", url = "http://localhost:8080/items")
public interface ItemsFeignClient {
    @GetMapping
    ResponseEntity<List<Item>> getAll();

    @GetMapping(value = "/{id}")
    ResponseEntity<Item> getById(@PathVariable Long id);
}
