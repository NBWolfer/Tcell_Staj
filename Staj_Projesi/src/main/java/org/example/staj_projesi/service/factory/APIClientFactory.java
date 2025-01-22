package org.example.staj_projesi.service.factory;

import org.example.staj_projesi.domain.model.dto.ClientDTO;
import org.example.staj_projesi.service.ClientService;
import org.springframework.stereotype.Component;

import java.util.HashMap;
import java.util.Map;

@Component
public class APIClientFactory {
    private final Map<String, ClientService<?>> clients;

    public APIClientFactory(Map<String, ClientService<?>> clients) {
         this.clients = clients;
    }

    public ClientService<?> getClient(String clientName) {
        clientName = clientName.toLowerCase();
        return clients.get(clientName);
    }

    private HashMap<String, Object> convertToHashMap() {
            HashMap<String, Object> map = new HashMap<>();
            for (Map.Entry<String, ClientService<?>> entry : clients.entrySet()) {
                String name = entry.getKey();
                ClientService<?> dto = getClient(name);
                map.put(name, dto.getDTO());
            }
            return  map;
    }

    public ClientDTO  getAllDTOs() {
        return new ClientDTO(convertToHashMap());
    }
}
