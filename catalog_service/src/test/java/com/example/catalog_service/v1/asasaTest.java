package com.example.catalog_service.v1;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.junit.jupiter.MockitoExtension;

import static org.junit.jupiter.api.Assertions.assertEquals;


@ExtendWith(MockitoExtension.class)
class asasaTest {

    @InjectMocks
    Asasa teste=new Asasa();

    @Test
    void testYamlValue() {
      assertEquals("http://localhost:8080",teste.getItemHost());
    }
}