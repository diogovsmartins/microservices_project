package com.example.catalog_service.v1.services;

import com.example.catalog_service.v1.ItemV1;
import com.example.catalog_service.v1.feignClients.ItemsFeignClient;
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

    public List<ItemV1> getItems(Boolean inStock) {
        if (Boolean.FALSE.equals(inStock)) {
            return Optional.ofNullable(
                            itemsFeignClient
                                    .getAll()
                                    .getBody())
                    .get()
                    .stream()
                    .filter(itemV1 -> itemV1.getInStock().equals(Boolean.FALSE))
                    .collect(Collectors.toList());
        }
        return itemsFeignClient.getAll().getBody();
    }

    public Optional<ItemV1> getItemById(Long id) {
        return Optional.ofNullable(itemsFeignClient.getById(id).getBody());
    }
}
