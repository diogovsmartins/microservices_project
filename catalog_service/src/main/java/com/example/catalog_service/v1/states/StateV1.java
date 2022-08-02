package com.example.catalog_service.v1.states;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class StateV1 implements IStateV1 {
    private String country;
    private Boolean inStock;
}
