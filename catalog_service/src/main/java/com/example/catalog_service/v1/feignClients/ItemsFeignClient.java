package com.example.catalog_service.v1.feignClients;

import com.example.catalog_service.v1.ItemV1;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Component;
import org.springframework.web.bind.annotation.GetMapping;

import java.util.List;

@FeignClient(value = "itemsFeignClient",url = "http://localhost:8080/items")
public interface ItemsFeignClient {
    @GetMapping
    ResponseEntity<List<ItemV1>> getAll();
}
