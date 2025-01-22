package org.example.staj_projesi.service.impl;

import org.example.staj_projesi.config.ConfigurationService;
import org.example.staj_projesi.domain.model.dto.Client2DTO;
import org.example.staj_projesi.service.ClientService;
import org.springframework.stereotype.Component;
import org.springframework.web.reactive.function.client.WebClient;

@Component("client2")
public class Client2Impl implements ClientService<Client2DTO> {
    private final WebClient webClient;
    private final ConfigurationService configuration;

    public Client2Impl(ConfigurationService configuration){
        this.configuration = configuration;
        String url = configuration.getValue("client_url");
        webClient = WebClient.builder().baseUrl(url).build();
    }

    @Override
    public Client2DTO getDTO() {
        String uri = "/client2";
        return webClient.get().uri(uri).retrieve()
                .bodyToMono(Client2DTO.class)
                .map(dto -> dto).block();
    }
}
