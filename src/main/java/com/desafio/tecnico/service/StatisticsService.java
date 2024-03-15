package com.desafio.tecnico.service;

import com.desafio.tecnico.dto.CountryMarketShare;

import java.util.List;

public interface StatisticsService {
    List<CountryMarketShare> calculateMarketShare();
}
