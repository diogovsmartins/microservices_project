package com.example.catalog_service.v1.toggles;

import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.stereotype.Component;

@ConfigurationProperties(prefix = "toggles")
@Component
public class ToggleHandlerService {

    private  ToggleEntity v1CountryToggle;
    public ToggleEntity getV1CountryToggle() {
        return v1CountryToggle;
    }

    public void setV1CountryToggle(ToggleEntity v1CountryToggle) {
        this.v1CountryToggle = v1CountryToggle;
    }

    @Override
    public String toString() {
        return "ToggleHandlerService{" +
                "v1CountryToggle=" + v1CountryToggle +
                '}';
    }
}
