package com.example.catalog_service.v1.controllers;

import com.example.catalog_service.v1.ItemV1;
import com.example.catalog_service.v1.services.ItemsService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping(value = "/v1")
public class V1ItemsController {
    private final ItemsService itemsService;

    @Autowired
    public V1ItemsController(final ItemsService itemsService){
        this.itemsService=itemsService;
    }

    @GetMapping(value = "/items")
    public ResponseEntity<List<ItemV1>> getItems(){
        return ResponseEntity.ok(itemsService.getItems());
    }
}
