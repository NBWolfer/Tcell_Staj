package org.example.staj_projesi.controller;

import org.example.staj_projesi.domain.model.dto.ClientResponseDTO;
import org.example.staj_projesi.domain.repository.ClientRepository;
import org.example.staj_projesi.service.CurrencyService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;
import reactor.core.publisher.Mono;

import java.util.HashMap;


@RestController
public class ClientAPIController {

    private final CurrencyService currencyService;
    private ClientRepository clientRepository;

    public ClientAPIController(ClientRepository clientRepository, CurrencyService currencyService) {
        this.clientRepository = clientRepository;
        this.currencyService = currencyService;
    }


    @GetMapping("/fetchClients")
    public Mono<ResponseEntity<HashMap<String, ClientResponseDTO>>> getExchangeRates() {
        return currencyService.convertToHashMapAndSaveAsync()
                .map(ResponseEntity::ok);
    }
}
