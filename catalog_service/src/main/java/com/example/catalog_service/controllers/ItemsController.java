package com.example.catalog_service.controllers;

import com.example.catalog_service.entities.Item;
import com.example.catalog_service.services.ItemsService;
import com.example.catalog_service.toggles.ToggleHandlerService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping(value = "/catalog")
public class ItemsController {
    private final ItemsService itemsService;

    @Autowired
    public ItemsController(
            final ItemsService itemsService,
            final ToggleHandlerService toggleHandlerService) {
        this.itemsService = itemsService;
    }

    @GetMapping(value = "/items")
    public ResponseEntity<List<Item>> getItems(
            @RequestHeader Boolean inStock) {
        return ResponseEntity.ok(itemsService.getItems(inStock));
    }

    @GetMapping(value = "/items/{id}")
    @ResponseBody
    public ResponseEntity<Optional<Item>> getItemById(@PathVariable Long id) {
        return ResponseEntity.ok(itemsService.getItemById(id));
    }
}
