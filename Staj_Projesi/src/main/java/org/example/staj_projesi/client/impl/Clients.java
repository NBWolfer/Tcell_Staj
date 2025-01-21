package org.example.staj_projesi.client.impl;

import org.example.staj_projesi.dtos.Client1DTO;
import reactor.core.publisher.Mono;

// The data coming from clients differs one to one. So, we need to declare different DTOs for them and declare this interface generic.
public interface Clients<T> {
    Mono<T> getDTO();
}
