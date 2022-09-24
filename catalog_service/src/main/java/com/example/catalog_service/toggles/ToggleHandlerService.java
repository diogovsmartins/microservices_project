package com.example.catalog_service.toggles;

import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.stereotype.Component;

@ConfigurationProperties(prefix = "toggles")
@Component
public class ToggleHandlerService {

    private  ToggleEntity countryToggle;
    public ToggleEntity getCountryToggle() {
        return countryToggle;
    }

    public void setCountryToggle(ToggleEntity countryToggle) {
        this.countryToggle = countryToggle;
    }

    @Override
    public String toString() {
        return "ToggleHandlerService{" +
                "countryToggle=" + countryToggle +
                '}';
    }
}
