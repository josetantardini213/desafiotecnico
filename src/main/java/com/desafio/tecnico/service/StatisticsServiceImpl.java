package com.desafio.tecnico.service;

import com.desafio.tecnico.dto.CountryMarketShare;
import com.desafio.tecnico.dto.MarketShare;
import com.desafio.tecnico.repository.ComitenteRepository;
import com.desafio.tecnico.repository.MercadoRepository;
import com.desafio.tecnico.repository.PaisRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class StatisticsServiceImpl implements StatisticsService {

    @Autowired
    private PaisRepository paisRepository;

    @Autowired
    private MercadoRepository mercadoRepository;

    @Autowired
    private ComitenteRepository comitenteRepository;

    @Override
    public List<CountryMarketShare> calculateMarketShare() {
        try{
        List<CountryMarketShare> stats = new ArrayList<>();
        var allCountries = paisRepository.findAll();

        for (var country : allCountries) {
            CountryMarketShare cms = new CountryMarketShare();
            cms.setCountry(country.getNombre());
            List<MarketShare> marketShares = new ArrayList<>();

            var markets = mercadoRepository.findByPais(country);
            if (markets.isEmpty()) {
                continue;
            }

            long totalComitentesInCountry = comitenteRepository.countByMercadoPais(country); // Actualizado
            for (var market : markets) {
                long comitentesInMarket = comitenteRepository.countByMercados(market);
                if (totalComitentesInCountry > 0) {
                    double percentage = (double) comitentesInMarket / totalComitentesInCountry * 100;
                    MarketShare ms = new MarketShare(market.getCodigo(), String.format("%.2f", percentage));
                    marketShares.add(ms);
                }
            }

            cms.setMarket(marketShares);
            stats.add(cms);
        }
        return stats;
        } catch (Exception e) {
            return null;
        }
    }
}
