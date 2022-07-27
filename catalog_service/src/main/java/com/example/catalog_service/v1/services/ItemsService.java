package com.example.catalog_service.v1.services;

import com.example.catalog_service.v1.ItemV1;
import com.example.catalog_service.v1.feignClients.ItemsFeignClient;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ItemsService {
    private final ItemsFeignClient itemsFeignClient;

    @Autowired
    public ItemsService(final ItemsFeignClient itemsFeignClient){
        this.itemsFeignClient=itemsFeignClient;
    }

    public List<ItemV1> getItems(){
        return  itemsFeignClient.getAll().getBody();
    }
}
