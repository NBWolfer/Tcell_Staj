package org.example.staj_projesi.controller;

import org.example.staj_projesi.domain.model.dto.ClientDTO;
import org.example.staj_projesi.service.factory.APIClientFactory;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;


@RestController
public class ClientAPIController {

    private final APIClientFactory clientFactory;

    public ClientAPIController(APIClientFactory clientFactory) {
        this.clientFactory = clientFactory;
    }

    @GetMapping(value = "/fetchClient")
    public ResponseEntity<ClientDTO> fetchDataFromClient(){
            ClientDTO clientDTO = clientFactory.getAllDTOs();
            return ResponseEntity.status(200).body(clientDTO);
    }
}
