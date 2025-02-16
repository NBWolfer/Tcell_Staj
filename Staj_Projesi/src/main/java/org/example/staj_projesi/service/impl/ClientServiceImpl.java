package org.example.staj_projesi.service.impl;

import org.example.staj_projesi.domain.model.dto.ClientResponseDTO;
import org.example.staj_projesi.domain.repository.ClientRepository;
import org.example.staj_projesi.service.ClientAdapterService;
import org.example.staj_projesi.service.ClientService;
import org.example.staj_projesi.service.MapperService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;
import reactor.core.scheduler.Schedulers;

import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

@Service
public class ClientServiceImpl implements ClientService {
    private final Map<String, ClientAdapterService> clients;
    private final ClientRepository clientRepository;
    private final MapperService mapperService;

    @Autowired
    public ClientServiceImpl(List<ClientAdapterService> clients, ClientRepository clientRepository, MapperService mapperService) {
        this.clients = clients.stream().collect(Collectors.toMap(
                ClientAdapterService::getClientName,
                client -> client
        ));
        this.clientRepository = clientRepository;
        this.mapperService = mapperService;
    }

    @Override
    public Mono<HashMap<String, ClientResponseDTO>> convertToHashMapAndSaveAsync() {
        return Flux.fromIterable(clients.entrySet())
                .flatMap(entry ->
                        entry.getValue().getDTO()
                                .publishOn(Schedulers.boundedElastic())
                                .map(dto -> Map.entry(entry.getKey(), dto))
                )
                .collectMap(Map.Entry::getKey, Map.Entry::getValue)
                .map(HashMap::new)
                .flatMap(clientMap ->
                        Flux.fromIterable(clientMap.keySet())
                                .flatMap(mapperService::mapToEntity)
                                .collectList()
                                .flatMap(clientList ->
                                        Mono.fromCallable(() -> {
                                            clientRepository.saveAll(clientList);
                                            return clientList;
                                        }).subscribeOn(Schedulers.boundedElastic())
                                ).thenReturn(clientMap)
                )
                .doOnError(e -> System.out.println("Error occurred: " + e.getMessage()))
                .onErrorResume(e -> Mono.error(new RuntimeException("An error occurred while processing the exchange rates.")));
    }





}
