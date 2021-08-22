package com.example.demo.domain;

import lombok.Data;

@Data
public class ProfileWithSettlementOption {
    private boolean cz4Flag;
    private boolean suitabilityFlag;
    private boolean riskFlag;
    private boolean dominantFlag;
}
