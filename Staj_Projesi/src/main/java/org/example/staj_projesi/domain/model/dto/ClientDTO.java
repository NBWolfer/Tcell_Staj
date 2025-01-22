package org.example.staj_projesi.domain.model.dto;

import java.util.HashMap;

public class ClientDTO  {
        private final HashMap<String, Object> clientMap;

        public ClientDTO (HashMap<String, Object> clientMap) {
            this.clientMap = clientMap;
        }

        public HashMap<String, Object> getClientMap() {
            return clientMap;
        }
}
