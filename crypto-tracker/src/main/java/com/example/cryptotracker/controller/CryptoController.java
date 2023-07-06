package com.example.cryptotracker.controller;

import com.example.cryptotracker.model.CryptoResponse;
import com.example.cryptotracker.service.CryptoService;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;
import reactor.core.publisher.Mono;

@RestController
@CrossOrigin
public class CryptoController {

    private final CryptoService cryptoService;

    public CryptoController(CryptoService cryptoService) {
        this.cryptoService = cryptoService;
    }

    @GetMapping("/crypto/{name}")
    public Mono<CryptoResponse> getCryptoData(@PathVariable String name) {
        return cryptoService.getCryptoData(name);
    }


}
