package com.example.demo.config;

import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
@ConfigurationProperties(prefix = "pershing")
public class PershingConfig {
    private List<String> whitelisted;
    private String nonwhitelisted;

    public PershingConfig() {
    }

    public List<String> getWhitelisted() {
        return whitelisted;
    }

    public void setWhitelisted(List<String> whitelisted) {
        this.whitelisted = whitelisted;
    }

    public String getNonwhitelisted() {
        return nonwhitelisted;
    }

    public void setNonwhitelisted(String nonwhitelisted) {
        this.nonwhitelisted = nonwhitelisted;
    }
}
