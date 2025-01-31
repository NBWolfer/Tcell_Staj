package org.example.staj_projesi.service;

import reactor.core.publisher.Mono;

public interface ClientService<T> {
    Mono<T> getDTO();
}
