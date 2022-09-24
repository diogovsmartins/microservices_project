package com.example.items_microservice.services;

import com.example.items_microservice.domain.Item;
import com.example.items_microservice.domain.builder.ItemBuilder;
import com.example.items_microservice.domain.dto.ItemDto;
import com.example.items_microservice.domain.factory.ItemFactory;
import com.example.items_microservice.repositories.ItemRepositorie;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class ItemService {
    private final ItemRepositorie itemRepositorie;
    private final ItemFactory itemFactory;

    @Autowired
    public ItemService(ItemRepositorie itemRepositorie, ItemFactory itemFactory) {
        this.itemRepositorie = itemRepositorie;
        this.itemFactory = itemFactory;
    }

    public Optional<Item> getById(Long id) {
        Item item = itemRepositorie.findById(id).orElse(itemFactory.createItem());
        return Optional.of(item);
    }

    public List<Item> getAll() {
        return itemRepositorie.findAll();
    }

    public void insertItem(ItemDto itemDTO) {
        Item item = new ItemBuilder()
                .setName(itemDTO.getName())
                .setDescription(itemDTO.getDescription())
                .setInventoryCount(itemDTO.getInventoryCount())
                .setPrice(itemDTO.getPrice())
                .setInStock(Boolean.TRUE)
                .build();
        itemRepositorie.save(item);
    }

    public void delete(Long id) {
        Item item = itemRepositorie.findById(id).orElse(itemFactory.createItem());
        itemRepositorie.delete(item);
    }

    public void update(ItemDto item) {
        Item itemToUpdate = itemRepositorie.findById(item.getId()).orElse(itemFactory.createItem());
        itemToUpdate.setName(item.getName());
        itemToUpdate.setDescription(item.getDescription());
        itemToUpdate.setInventoryCount(item.getInventoryCount());
        itemToUpdate.setPrice(item.getPrice());
        itemRepositorie.saveAndFlush(itemToUpdate);
    }
}
