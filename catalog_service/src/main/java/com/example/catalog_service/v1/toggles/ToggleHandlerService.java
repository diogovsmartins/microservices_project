package com.example.catalog_service.v1.toggles;

import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.boot.context.properties.ConstructorBinding;

@ConfigurationProperties(prefix = "toggles")
@ConstructorBinding
public class ToggleHandlerService {

    private final ToggleEntity v1ActivatedCountries;

    public ToggleHandlerService(ToggleEntity v1ActivatedCountries) {
        this.v1ActivatedCountries = v1ActivatedCountries;
    }

    public ToggleEntity getV1ActivatedCountries() {
        return v1ActivatedCountries;
    }


    @Override
    public String toString() {
        return "ToggleHandlerService{" +
                "v1ActivatedCountries=" + v1ActivatedCountries +
                '}';
    }
}
