package com.example.demo.config;

import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.stereotype.Component;

@Component
@ConfigurationProperties(prefix = "flags")
public class Flags {
    private boolean cz4;
    private boolean suitability;
    private boolean risk;
    private boolean domiant;

    public Flags() {
    }

    public boolean isCz4() {
        return cz4;
    }

    public void setCz4(boolean cz4) {
        this.cz4 = cz4;
    }

    public boolean isSuitability() {
        return suitability;
    }

    public void setSuitability(boolean suitability) {
        this.suitability = suitability;
    }

    public boolean isRisk() {
        return risk;
    }

    public void setRisk(boolean risk) {
        this.risk = risk;
    }

    public boolean isDomiant() {
        return domiant;
    }

    public void setDomiant(boolean domiant) {
        this.domiant = domiant;
    }
}
