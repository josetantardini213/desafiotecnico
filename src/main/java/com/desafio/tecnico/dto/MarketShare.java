package com.desafio.tecnico.dto;

import lombok.Data;

@Data
public class MarketShare {
    private String name;
    private String percentage;

    public MarketShare(String name, String percentage) {
        this.name = name;
        this.percentage = percentage;
    }
}
