package org.example.staj_projesi.controller;

import lombok.RequiredArgsConstructor;
import org.example.staj_projesi.domain.model.dto.ClientResponseDTO;
import org.example.staj_projesi.domain.repository.ClientRepository;
import org.example.staj_projesi.service.impl.ClientServiceImpl;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;
import reactor.core.publisher.Mono;

import java.util.HashMap;


@RestController
@RequiredArgsConstructor
public class ClientAPIController {

    private final ClientServiceImpl currencyService;
    private ClientRepository clientRepository;

    @GetMapping("/fetchClients")
    public Mono<ResponseEntity<HashMap<String, ClientResponseDTO>>> getExchangeRates() {
        return currencyService.convertToHashMapAndSaveAsync()
                .map(ResponseEntity::ok);
    }
}
