package com.example.catalog_service.v1.controllers;

import com.example.catalog_service.v1.ItemV1;
import com.example.catalog_service.v1.services.ItemsService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping(value = "/v1")
public class V1ItemsController {
    private final ItemsService itemsService;

    @Autowired
    public V1ItemsController(final ItemsService itemsService){
        this.itemsService=itemsService;
    }

    @GetMapping(value = "/items")
    public ResponseEntity<List<ItemV1>> getItems(
            @RequestHeader Boolean inStock){
        return ResponseEntity.ok(itemsService.getItems(inStock));
    }

    @GetMapping(value = "/items/{id}")
    @ResponseBody
    public ResponseEntity<Optional<ItemV1>> getItemById(@PathVariable Long id){
       return ResponseEntity.ok(itemsService.getItemById(id));
    }
}
