package com.example.demo.config;

import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
@ConfigurationProperties(prefix = "flag")
public class Flag {
    private List<String> cz4;
    private List<String> suitability;
    private List<String> risk;
    private List<String> domiant;

    public Flag() {
    }

    public List<String> getCz4() {
        return cz4;
    }

    public void setCz4(List<String> cz4) {
        this.cz4 = cz4;
    }

    public List<String> getSuitability() {
        return suitability;
    }

    public void setSuitability(List<String> suitability) {
        this.suitability = suitability;
    }

    public List<String> getRisk() {
        return risk;
    }

    public void setRisk(List<String> risk) {
        this.risk = risk;
    }

    public List<String> getDomiant() {
        return domiant;
    }

    public void setDomiant(List<String> domiant) {
        this.domiant = domiant;
    }
}
