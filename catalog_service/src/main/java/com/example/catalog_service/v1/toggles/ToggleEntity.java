package com.example.catalog_service.v1.toggles;

import lombok.Getter;
import lombok.Setter;
import lombok.ToString;


@Getter
@Setter
@ToString
public class ToggleEntity {
    private String ActivatedCountries;
    private Boolean activated;

}
