package org.example.staj_projesi.service.impl;

import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.example.staj_projesi.domain.model.dto.ClientResponseDTO;
import org.example.staj_projesi.domain.model.dto.Client2;
import org.example.staj_projesi.service.CurrencyRateAdapter;
import org.springframework.stereotype.Component;
import reactor.core.publisher.Mono;
import reactor.core.scheduler.Schedulers;

import java.util.HashMap;

@Component
public class Client2AdapterImpl implements CurrencyRateAdapter {
    private final Client2 client2;
    private final ObjectMapper objectMapper = new ObjectMapper();

    public Client2AdapterImpl(Client2 client2) {
        this.client2 = client2;
    }

    @Override
    public Mono<ClientResponseDTO> getDTO() {
        return client2.fetchRatesAsync()
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
}
