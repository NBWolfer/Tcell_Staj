package org.example.staj_projesi.service;

import org.example.staj_projesi.domain.model.dto.ClientResponseDTO;
import reactor.core.publisher.Mono;

import java.util.HashMap;

public interface ClientService {
    Mono<HashMap<String, ClientResponseDTO>> convertToHashMapAndSaveAsync();
}
