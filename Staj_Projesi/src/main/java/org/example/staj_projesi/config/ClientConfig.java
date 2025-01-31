package org.example.staj_projesi.config;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;

@Component
public class ClientConfig {
        @Value("${client1_url}")
        private String client1_url;

        @Value("${client2_url}")
        private String client2_url;

        public ClientConfig() {

        }

        public String getClient1_url() {
            return client1_url;
        }

        public String getClient2_url() {
            return client2_url;
        }
}
