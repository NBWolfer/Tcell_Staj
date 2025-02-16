package org.example.staj_projesi.domain.model.dto;

import org.example.staj_projesi.config.ClientConfig;
import org.springframework.stereotype.Component;
import org.springframework.web.reactive.function.client.WebClient;
import reactor.core.publisher.Mono;

@Component
public class Client2 {
    ClientConfig clientConfig;

    public Client2(ClientConfig clientConfig) {
        this.clientConfig = clientConfig;
    }

    public Mono<String> fetchRatesAsync(){
        WebClient webClient = WebClient.builder().baseUrl(clientConfig.getClient2Url()).build();
        return webClient
                    .get()
                    .retrieve()
                    .bodyToMono(String.class);
    }
}
