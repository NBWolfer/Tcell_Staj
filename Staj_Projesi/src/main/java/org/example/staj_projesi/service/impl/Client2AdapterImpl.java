package org.example.staj_projesi.service.impl;

import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.example.staj_projesi.domain.model.dto.ClientResponseDTO;
import org.example.staj_projesi.domain.model.dto.Client2;
import org.example.staj_projesi.domain.repository.ClientRepository;
import org.example.staj_projesi.service.ClientAdapterService;
import org.springframework.stereotype.Component;
import reactor.core.publisher.Mono;
import reactor.core.scheduler.Schedulers;

import java.util.HashMap;

@Component
public class Client2AdapterImpl implements ClientAdapterService {
    private final Client2 client2;
    private final ObjectMapper objectMapper = new ObjectMapper();
    private final ClientRepository clientRepository;

    public Client2AdapterImpl(Client2 client2, ClientRepository clientRepository) {
        this.client2 = client2;
        this.clientRepository = clientRepository;
    }

    @Override
    public Mono<ClientResponseDTO> getDTO() {
        return client2.fetchRatesAsync()
                .publishOn(Schedulers.boundedElastic())
                .flatMap(jsonResponse -> {
                    try {
                        HashMap<String, Double> currencyMap = objectMapper.readValue(
                                jsonResponse, new TypeReference<HashMap<String, Double>>() {});
                        ClientResponseDTO dto = new ClientResponseDTO();
                        dto.setClientName("Client2");
                        dto.setCurrencies(currencyMap);

                        return Mono.just(dto);
                    } catch (Exception e) {
                        return Mono.error(e);
                    }
                })
                .subscribeOn(Schedulers.boundedElastic());
    }

    @Override
    public String getClientName() {
        return "Client2";
    }
}
