package com.example.items_microservice.controllers;

import com.example.items_microservice.domain.Item;
import com.example.items_microservice.domain.dto.ItemDto;
import com.example.items_microservice.services.ItemService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping(value = "/items")
public class ItemController {
    private final ItemService itemService;

    @Autowired
    public ItemController(ItemService itemService) {
        this.itemService = itemService;
    }

    @GetMapping(value = "/{id}")
    public ResponseEntity<Optional<Item>> getById(@PathVariable Long id) {
        return ResponseEntity.ok(itemService.getById(id));
    }

    @GetMapping()
    public ResponseEntity<List<Item>> getAll() {
        return ResponseEntity.ok(itemService.getAll());
    }

    @PostMapping(value = "/insert")
    public ResponseEntity insert(@RequestBody ItemDto itemDto){
        if (itemDto == null || itemDto.getName().isEmpty() || itemDto.getPrice() == null){
            return ResponseEntity.badRequest().body("Invalid item, check if this object is null or has no name or price.");
        }
        return new ResponseEntity(HttpStatus.CREATED);
    }

    @PutMapping(value = "/update")
    public ResponseEntity update(@RequestBody ItemDto item){
        itemService.update(item);
        return new ResponseEntity(HttpStatus.ACCEPTED);
    }

    @DeleteMapping(value = "/delete/{id}")
    public ResponseEntity delete(@PathVariable Long id){
        itemService.delete(id);
        return new ResponseEntity(HttpStatus.ACCEPTED);
    }
}
