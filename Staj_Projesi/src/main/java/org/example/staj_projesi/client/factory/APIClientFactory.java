package org.example.staj_projesi.client.factory;

import org.example.staj_projesi.client.impl.Clients;
import org.springframework.stereotype.Component;

import java.util.Map;

// Tagged for mapping clients
@Component
public class APIClientFactory {
    private final Map<String, Clients<?>> clients; // <client_name, Clients_Objects>

    public APIClientFactory(Map<String, Clients<?>> clients) {
         this.clients = clients;
    }

    //
    //TODO Add here exception handling || Might not be needed, you can add here or the place this function being called
    public Clients<?> getClient(String clientName) {
        clientName = clientName.toLowerCase();
        return clients.get(clientName);
    }
}
