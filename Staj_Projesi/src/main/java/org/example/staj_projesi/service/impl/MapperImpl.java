package org.example.staj_projesi.service.impl;

import com.fasterxml.jackson.databind.ObjectMapper;
import org.example.staj_projesi.domain.model.entity.Client;
import org.example.staj_projesi.service.ClientAdapterService;
import org.example.staj_projesi.service.MapperService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import reactor.core.publisher.Mono;

import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

@Service
public class MapperImpl implements MapperService {

    private final ObjectMapper objectMapper = new ObjectMapper();

    private final Map<String, ClientAdapterService> clients;

    @Autowired
    public MapperImpl(List<ClientAdapterService> clients) {
        this.clients = clients.stream()
                .collect(Collectors.toMap(ClientAdapterService::getClientName, client -> client));
    }


    @Override
    public Mono<Client> mapToEntity(String clientName) {
        return clients.get(clientName).getDTO()
                .map(dto -> objectMapper.convertValue(dto, Client.class));
    }

}
