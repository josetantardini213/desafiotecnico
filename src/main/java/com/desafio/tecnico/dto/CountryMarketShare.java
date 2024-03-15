package com.desafio.tecnico.dto;

import lombok.Data;

import java.util.List;

@Data
public class CountryMarketShare {
    private String country;
    private List<MarketShare> market;
}
