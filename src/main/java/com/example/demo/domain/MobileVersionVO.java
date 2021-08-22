package com.example.demo.domain;

import lombok.Data;

import java.util.List;

@Data
public class MobileVersionVO {
    private String appId;
    private List<String> appVersion;
}
