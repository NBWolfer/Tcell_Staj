package org.example.staj_projesi.client.impl;

import org.example.staj_projesi.dtos.Client1DTO;
import org.example.staj_projesi.dtos.Client2DTO;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Component;
import org.springframework.web.reactive.function.client.WebClient;
import reactor.core.publisher.Mono;

@Component("client2")
@Scope("prototype")
public class Client2 implements Clients<Client2DTO> {
    private final WebClient webClient;

    public Client2(){
        String url = "https://6f0028f3-b77d-451e-8471-7ed5480d2e3d.mock.pstmn.io/";
        webClient = WebClient.builder().baseUrl(url).build();
    }

    @Override
    public Mono<Client2DTO> getDTO() {
        String uri = "/client2";
        return webClient.get().uri(uri).retrieve()
                .bodyToMono(Client2DTO.class)
                .map(dto -> dto); // Returns an instance of Client2DTO
    }
}
