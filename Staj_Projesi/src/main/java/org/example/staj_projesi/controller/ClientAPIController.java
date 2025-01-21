package org.example.staj_projesi.controller;

import org.example.staj_projesi.client.factory.APIClientFactory;
import org.example.staj_projesi.client.impl.Clients;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class ClientAPIController {

    private final APIClientFactory clientFactory;

    public ClientAPIController(APIClientFactory clientFactory) {
        this.clientFactory = clientFactory;
    }

    // Makes requests to specified URL according to URI, and take fetched objects as DTO defined in dtos package
    // Params: client1, client2
    @GetMapping(value = "/fetchClient")
    public ResponseEntity<?> fetchDataFromClient(@RequestParam String clientName){
        Clients<?> client = clientFactory.getClient(clientName);

        // If client is null, returns 404
        if (client == null)
        {
            return ResponseEntity.notFound().build();
        }

        return ResponseEntity.ok().body(client.getDTO().block()); // block() makes this process synchron and makes thread that runs http request wait
                                                                  // So, research this line and look if you can asynchron this process
    }
}
