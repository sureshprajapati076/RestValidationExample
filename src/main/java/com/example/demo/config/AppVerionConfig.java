package com.example.demo.config;

import com.example.demo.domain.MobileVersionVO;
import lombok.Data;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.stereotype.Component;

import java.util.List;
import java.util.Map;

@Component
@ConfigurationProperties(prefix = "version")
@Data
public class AppVerionConfig {
    private List<MobileVersionVO> allowed;
}
