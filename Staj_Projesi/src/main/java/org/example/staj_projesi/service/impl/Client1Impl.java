package org.example.staj_projesi.service.impl;

import org.example.staj_projesi.config.ConfigurationService;
import org.example.staj_projesi.domain.model.dto.Client1DTO;
import org.example.staj_projesi.service.ClientService;
import org.springframework.stereotype.Component;
import org.springframework.web.reactive.function.client.WebClient;

@Component("client1")
public class Client1Impl implements ClientService<Client1DTO> {
    private final WebClient webClient;
    private final ConfigurationService configuration;

    public Client1Impl(ConfigurationService configuration) {
        this.configuration = configuration;
        String url = configuration.getValue("client_url");
        webClient = WebClient.builder().baseUrl(url).build();
    }

    @Override
    public Client1DTO getDTO() {
        String uri = "/client1";
        return webClient.get().uri(uri).retrieve()
                .bodyToMono(Client1DTO.class)
                .map(dto -> dto).block();
    }
}
