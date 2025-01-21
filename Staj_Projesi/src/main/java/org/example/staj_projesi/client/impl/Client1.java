package org.example.staj_projesi.client.impl;

import org.example.staj_projesi.dtos.Client1DTO;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Component;
import org.springframework.web.reactive.function.client.WebClient;
import reactor.core.publisher.Mono;

// These descriptions are valid for all client classes
// Tagged, so spring framework can map between clients for APIClientFactory. Also, it is in use of creating beans and dependency injection.
@Component("client1")
@Scope("prototype") // Tagged as prototype, so we can get new instance for every request in ClientAPIController // Also, these instance automatically will be destroyed with the end of the function by Garbage Collector
public class Client1 implements Clients<Client1DTO> {
    private final WebClient webClient;

    // Sets webClient for requests
    public Client1() {
        String url = "https://6f0028f3-b77d-451e-8471-7ed5480d2e3d.mock.pstmn.io/";
        webClient = WebClient.builder().baseUrl(url).build();
    }

    @Override
    public Mono<Client1DTO> getDTO() {
        String uri = "/client1";
        return webClient.get().uri(uri).retrieve()
                .bodyToMono(Client1DTO.class)
                .map(dto -> dto); // Returns an instance of Client1DTO || We can process our DTO in map function.
    }
}
