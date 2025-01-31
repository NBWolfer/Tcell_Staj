package org.example.staj_projesi.controller;

import org.example.staj_projesi.domain.model.dto.ClientDTO;
import org.example.staj_projesi.domain.model.dto.ClientMappingDTO;
import org.example.staj_projesi.domain.model.dto.ClientResponseDTO;
import org.example.staj_projesi.domain.model.entity.Client;
import org.example.staj_projesi.domain.repository.ClientRepository;
import org.example.staj_projesi.service.factory.APIClientFactory;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.ArrayList;
import java.util.List;


@RestController
public class ClientAPIController {

    private final APIClientFactory clientFactory;
    private ClientRepository clientRepository;

    public ClientAPIController(APIClientFactory clientFactory, ClientRepository clientRepository) {
        this.clientFactory = clientFactory;
        this.clientRepository = clientRepository;
    }

    @GetMapping(value = "/fetchClient")
    public ResponseEntity<ClientMappingDTO> fetchDataFromClient(){
            ClientMappingDTO clientDTO = clientFactory.getResponseDTO();
            ArrayList<Client> clients = new ArrayList<>();
            for(ClientResponseDTO client : clientDTO.getClients()){
                Client clientEntity = new Client(client.getUsd(), client.getGbp(), client.getCad(), client.getChf(), client.getEur(), client.getRub(), client.getAed(), client.getSyy(), client.getClientName());
                clients.add(clientEntity);
            }
            clientRepository.saveAll(clients);
            return ResponseEntity.status(200).body(clientDTO);
    }
}
