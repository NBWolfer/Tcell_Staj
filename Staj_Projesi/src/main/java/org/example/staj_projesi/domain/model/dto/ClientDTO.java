package org.example.staj_projesi.domain.model.dto;

import java.util.HashMap;

public class ClientDTO  {
        private final HashMap<String, Object> clients;

        public ClientDTO (HashMap<String, Object> clients) {
            this.clients = clients;
        }

        public HashMap<String, Object> getClients() {
            return clients;
        }
}
