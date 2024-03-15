package com.desafio.tecnico.controller;

import com.desafio.tecnico.dto.CountryMarketShare;
import com.desafio.tecnico.service.ComitenteService;
import com.desafio.tecnico.service.StatisticsService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/api")
public class StatisticsController {

    @Autowired
    private StatisticsService statisticsService;

    @GetMapping("/stats")
    public List<CountryMarketShare> getStats() {
        return statisticsService.calculateMarketShare();
    }
}