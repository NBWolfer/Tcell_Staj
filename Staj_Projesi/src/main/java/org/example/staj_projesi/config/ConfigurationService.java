package org.example.staj_projesi.config;

import org.springframework.context.annotation.Configuration;
import org.springframework.core.env.Environment;

@Configuration
public class ConfigurationService {
        // Configuration  variables will be taken from environment
        private final Environment environment;

        public ConfigurationService(Environment environment) {
            this.environment = environment;
        }

        public String getValue(String key){
            return environment.getProperty(key);
        }
}
