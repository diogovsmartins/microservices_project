package com.example.catalog_service;

import com.example.catalog_service.toggles.ToggleHandlerService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.openfeign.EnableFeignClients;

import javax.annotation.PostConstruct;

@SpringBootApplication
@EnableFeignClients
public class CatalogServiceApplication {

    @Autowired
    private ToggleHandlerService toggleHandlerService;

    public static void main(String[] args) {
        SpringApplication.run(CatalogServiceApplication.class, args);
    }

    @PostConstruct
    private void postInit() {
        System.out.println(toggleHandlerService.toString());
    }

}
