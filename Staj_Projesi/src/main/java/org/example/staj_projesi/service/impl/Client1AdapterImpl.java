package org.example.staj_projesi.service.impl;

import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.JsonNode;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.example.staj_projesi.domain.model.dto.ClientResponseDTO;
import org.example.staj_projesi.domain.model.dto.Client1;
import org.example.staj_projesi.service.CurrencyRateAdapter;
import org.springframework.stereotype.Component;
import reactor.core.publisher.Mono;
import reactor.core.scheduler.Schedulers;

import java.util.HashMap;

@Component
public class Client1AdapterImpl implements CurrencyRateAdapter {
    private final Client1 client1;
    private final ObjectMapper objectMapper = new ObjectMapper();

    public Client1AdapterImpl(Client1 client1) {
        this.client1 = client1;
    }

    @Override
    public Mono<ClientResponseDTO> getDTO() {
        return client1.fetchRatesAsync() // Mono<String> döndüğünü varsayıyoruz.
                .flatMap(jsonResponse -> {
                    try {
                        JsonNode root = objectMapper.readTree(jsonResponse);
                        if (!"success".equalsIgnoreCase(root.path("result").asText())) {
                            return Mono.empty();
                        }
                        JsonNode conversionRatesNode = root.path("conversion_rates");
                        HashMap<String, Double> currencyMap = objectMapper.convertValue(
                                conversionRatesNode, new TypeReference<HashMap<String, Double>>() {});
                        ClientResponseDTO dto = new ClientResponseDTO();
                        dto.setClientName("Client1");
                        dto.setCurrencies(currencyMap);
                        return Mono.just(dto);
                    } catch (Exception e) {
                        return Mono.error(e);
                    }
                })
                .subscribeOn(Schedulers.boundedElastic());
    }
}
