package org.example.staj_projesi.service;

import org.example.staj_projesi.domain.model.dto.ClientResponseDTO;
import reactor.core.publisher.Mono;

public interface CurrencyRateAdapter {
    Mono<ClientResponseDTO> getDTO();
}
