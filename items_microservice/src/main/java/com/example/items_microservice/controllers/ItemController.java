package com.example.items_microservice.controllers;

import com.example.items_microservice.domain.Item;
import com.example.items_microservice.domain.dto.ItemDto;
import com.example.items_microservice.services.ItemService;
import org.springframework.beans.factory.annotation.Autowired;
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
    public ResponseEntity<Optional<ItemDto>> getById(@PathVariable Long id) {
        return ResponseEntity.ok(itemService.getById(id));
    }

    @GetMapping()
    public ResponseEntity<List<Item>> getAll() {
        return ResponseEntity.ok(itemService.getAll());
    }

    @PostMapping(value = "/insert")
    public ResponseEntity<Optional<Item>> insert(@RequestBody ItemDto itemDto){
        return ResponseEntity.ok(itemService.insertItem(itemDto));
    }

    @PutMapping(value = "/update")
    public ResponseEntity<String> update(@RequestBody ItemDto item){
        itemService.update(item);
        return ResponseEntity.ok().body("Item updated.");
    }

    @DeleteMapping(value = "/delete/{id}")
    public ResponseEntity<String> delete(@PathVariable Long id){
        itemService.delete(id);
        return ResponseEntity.ok().body("Item deleted.");
    }
}
