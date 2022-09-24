package com.example.catalog_service.v1.toggles;

import org.junit.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.junit.jupiter.MockitoExtension;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.junit4.SpringRunner;

import static org.junit.jupiter.api.Assertions.assertEquals;


@RunWith(SpringRunner.class)
@ExtendWith(MockitoExtension.class)
class ToggleHandlerServiceTest {

    @Autowired
    @InjectMocks
    ToggleHandlerService toggleHandlerService;

    @Test
    void teste1(){
        var var=toggleHandlerService.getV1CountryToggle();
        assertEquals("a",var);
    }

}