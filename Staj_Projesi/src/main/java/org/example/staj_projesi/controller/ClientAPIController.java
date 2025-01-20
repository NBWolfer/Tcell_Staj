package org.example.staj_projesi.controller;

import org.example.staj_projesi.Client1DTO;
import org.example.staj_projesi.Client2DTO;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.reactive.function.client.WebClient;

@RestController
public class ClientAPIController {

    private final WebClient wc;

    public ClientAPIController(WebClient.Builder builder) {
        this.wc = builder.baseUrl("https://6f0028f3-b77d-451e-8471-7ed5480d2e3d.mock.pstmn.io/").build();
    }

    @GetMapping(value = "/client1")
    public Client1DTO fetchDataFromClient1(){
        var data = wc.get().uri("/client1").retrieve().bodyToMono(Client1DTO.class).block();
        return data;
    }

    @GetMapping(value = "/client2")
    public Client2DTO fetchDataFromClient2(){
        var data = wc.get().uri("/client2").retrieve().bodyToMono(Client2DTO.class).block();
        return data;
    }

}
