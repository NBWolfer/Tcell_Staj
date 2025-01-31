package org.example.staj_projesi.domain.model.dto;

import lombok.Setter;

import java.util.List;

@Setter
public class ClientMappingDTO {
    /*
  public ClientResponseDTO getClient1() {
        return client1;
    }

    public ClientResponseDTO getClient2() {
        return client2;
    }
*/
    private ClientResponseDTO client1;
    private ClientResponseDTO client2;

    public ClientMappingDTO() {

    }

    public List<ClientResponseDTO> getClients() {
        return List.of(client1, client2);
    }
}
