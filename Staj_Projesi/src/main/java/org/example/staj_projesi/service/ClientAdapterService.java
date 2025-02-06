package org.example.staj_projesi.service;

import org.example.staj_projesi.domain.model.dto.ClientResponseDTO;
import reactor.core.publisher.Mono;

public interface ClientAdapterService {
    Mono<ClientResponseDTO> getDTO();
    String getClientName();
}
