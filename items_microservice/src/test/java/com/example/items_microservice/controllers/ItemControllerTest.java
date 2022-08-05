package com.example.items_microservice.controllers;

import com.example.items_microservice.domain.dto.ItemDto;
import com.example.items_microservice.repositories.ItemRepositorie;
import com.example.items_microservice.services.ItemService;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Spy;
import org.mockito.junit.jupiter.MockitoExtension;

import java.util.Optional;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.when;

@ExtendWith(MockitoExtension.class)
class ItemControllerTest {

    @InjectMocks
    private ItemController itemController;
    @Mock
    private ItemService itemService;
    @Spy
    ItemRepositorie itemRepositorie;

    @Test
    void testeGetById(){

    }


}