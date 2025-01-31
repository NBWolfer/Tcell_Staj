package org.example.staj_projesi.service;

import org.example.staj_projesi.domain.model.dto.ClientResponseDTO;
import org.example.staj_projesi.domain.model.entity.Client;
import org.example.staj_projesi.domain.repository.ClientRepository;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;
import reactor.core.scheduler.Schedulers;

import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

@Service
public class CurrencyService {
    private final Map<String, CurrencyRateAdapter> clients;
    private final ClientRepository clientRepository;

    public CurrencyService(@Qualifier("client1AdapterImpl") CurrencyRateAdapter client1, @Qualifier("client2AdapterImpl") CurrencyRateAdapter client2, ClientRepository clientRepository) {
        this.clients = Map.of(
                "client1", client1,
                "client2", client2
        );
        this.clientRepository = clientRepository;
    }

    public Mono<HashMap<String, ClientResponseDTO>> convertToHashMapAndSaveAsync() {
        return Flux.fromIterable(clients.entrySet())
                .flatMap(entry ->
                        entry.getValue().getDTO()
                                .map(dto -> Map.entry(entry.getKey(), dto))
                )
                .collectMap(Map.Entry::getKey, Map.Entry::getValue)
                .map(HashMap::new)
                .flatMap(resultMap -> {
                    List<Client> entities = resultMap.values().stream()
                            .map(dto -> new Client(
                                    dto.getUsd(),
                                    dto.getGbp(),
                                    dto.getCad(),
                                    dto.getChf(),
                                    dto.getEur(),
                                    dto.getRub(),
                                    dto.getAed(),
                                    dto.getSyy(),
                                    dto.getClientName()
                            ))
                            .collect(Collectors.toList());
                    return Mono.fromCallable(() -> clientRepository.saveAll(entities))
                            .subscribeOn(Schedulers.boundedElastic())
                            .thenReturn(resultMap);
                })
                .doOnError(e -> System.out.println("Error occurred: " + e.getMessage()))
                .onErrorResume(e -> Mono.error(new RuntimeException("An error occurred while processing the exchange rates.")));
    }
}
