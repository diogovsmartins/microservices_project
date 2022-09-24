package com.example.catalog_service.services;

import com.example.catalog_service.entities.Item;
import com.example.catalog_service.feignClients.ItemsFeignClient;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Service
public class ItemsService {
    private final ItemsFeignClient itemsFeignClient;

    @Autowired
    public ItemsService(final ItemsFeignClient itemsFeignClient) {
        this.itemsFeignClient = itemsFeignClient;
    }

    public List<Item> getItems(Boolean inStock) {
        if (Boolean.FALSE.equals(inStock)) {
            return Optional.ofNullable(
                            itemsFeignClient
                                    .getAll()
                                    .getBody())
                    .get()
                    .stream()
                    .filter(item -> Boolean.FALSE.equals(item.getInStock()))
                    .collect(Collectors.toList());
        }
        return Optional.ofNullable(itemsFeignClient
                .getAll()
                .getBody())
                .get()
                .stream()
                .filter(item->Boolean.TRUE.equals(item.getInStock()))
                .collect(Collectors.toList());
    }

    public Optional<Item> getItemById(Long id) {
        return Optional.ofNullable(itemsFeignClient.getById(id).getBody());
    }
}
