package org.example.staj_projesi.service.factory;

import org.example.staj_projesi.domain.model.dto.*;
import org.example.staj_projesi.service.ClientService;
import org.springframework.stereotype.Component;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;
import reactor.core.scheduler.Schedulers;

import java.util.HashMap;
import java.util.Map;

@Component
public class APIClientFactory {
    private final Map<String, ClientService<?>> clients;

    public APIClientFactory(Map<String, ClientService<?>> clients) {
         this.clients = clients;
    }

    private ClientService<?> getClient(String clientName) {
        clientName = clientName.toLowerCase();
        return clients.get(clientName);
    }

    private Mono<HashMap<String, Object>> convertToHashMapAsync() {
        return Flux.fromIterable(clients.keySet())
                .flatMap(clientName -> Flux.just(getClient(clientName).getDTO())
                        .subscribeOn(Schedulers.boundedElastic())
                        .map(dto -> {
                            Object dtoObject = dto.block();
                            return Map.entry(clientName, dtoObject);
                        })
                )
                .collectMap(Map.Entry::getKey, Map.Entry::getValue)
                .map(HashMap::new); // HashMap'e dönüştür ve döndür
    }


    public ClientDTO  getAllDTOs() {
        System.out.println("Getting all DTOs");
        HashMap<String, Object> map = convertToHashMapAsync(). block();
        return new ClientDTO(map);
    }

    public ClientMappingDTO getResponseDTO() {
        ClientDTO clientDTO = getAllDTOs();
        ClientMappingDTO clientMappingDTO = new ClientMappingDTO();
        for(Map.Entry<String, Object> entry : clientDTO.getClients().entrySet()) {
            if(entry.getKey().equals("client1")) {
                // Mapping into clientResponseDTO for creating clientMappingDTO
                Client1DTO client1DTO = (Client1DTO) entry.getValue();
                ClientResponseDTO client1ResponseDTO = new ClientResponseDTO();
                client1ResponseDTO.setCurrencies(client1DTO.getConversionRates());
                client1ResponseDTO.setClientName(entry.getKey());
                clientMappingDTO.setClient1(client1ResponseDTO);
            } else if(entry.getKey().equals("client2")) {
                // Mapping into clientResponseDTO for creating clientMappingDTO
                Client2DTO client2DTO = (Client2DTO)  entry.getValue();
                ClientResponseDTO client2ResponseDTO = new ClientResponseDTO();
                client2ResponseDTO.setUsd(client2DTO.getUsd());
                client2ResponseDTO.setGbp(client2DTO.getGbp());
                client2ResponseDTO.setCad(client2DTO.getCad());
                client2ResponseDTO.setChf(client2DTO.getChf());
                client2ResponseDTO.setEur(client2DTO.getEur());
                client2ResponseDTO.setRub(client2DTO.getRub());
                client2ResponseDTO.setClientName(entry.getKey());
                clientMappingDTO.setClient2(client2ResponseDTO);
            }
        }

        return clientMappingDTO;
    }
}
