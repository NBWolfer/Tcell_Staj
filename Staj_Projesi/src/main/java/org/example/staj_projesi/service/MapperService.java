package org.example.staj_projesi.service;

import org.example.staj_projesi.domain.model.entity.Client;
import reactor.core.publisher.Mono;

public interface MapperService {
    Mono<Client> mapToEntity(String clientName);
}
