package com.example.cryptotracker.service;

import com.example.cryptotracker.model.CryptoResponse;
import org.springframework.stereotype.Service;
import org.springframework.web.reactive.function.client.WebClient;
import reactor.core.publisher.Mono;

@Service
public class CryptoService {

    private final WebClient webClient;

    public CryptoService(WebClient.Builder webClientBuilder) {
        this.webClient = webClientBuilder.baseUrl("https://api.coingecko.com/api/v3/").build();
    }

    public Mono<CryptoResponse> getCryptoData(String cryptoName) {
        return this.webClient.get()
                .uri(uriBuilder -> uriBuilder
                        .path("/coins/markets")
                        .queryParam("vs_currency", "usd")
                        .queryParam("ids", cryptoName)
                        .build())
                .retrieve()
                .bodyToFlux(CryptoResponse.class)
                .next();
    }
}
