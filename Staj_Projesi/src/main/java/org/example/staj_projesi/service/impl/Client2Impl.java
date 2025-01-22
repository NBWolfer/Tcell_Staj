package org.example.staj_projesi.service.impl;

import jakarta.validation.ConstraintViolation;
import jakarta.validation.ConstraintViolationException;
import jakarta.validation.Validator;
import org.example.staj_projesi.config.ConfigurationService;
import org.example.staj_projesi.domain.model.dto.Client2DTO;
import org.example.staj_projesi.service.ClientService;
import org.springframework.stereotype.Component;
import org.springframework.web.reactive.function.client.WebClient;

import java.util.Set;

@Component("client2")
public class Client2Impl implements ClientService<Client2DTO> {
    private final WebClient webClient;
    private final ConfigurationService configuration;
    private final Validator validator;

    public Client2Impl(ConfigurationService configuration, Validator validator) {
        this.validator = validator;
        this.configuration = configuration;
        String url = configuration.getValue("client_url");
        webClient = WebClient.builder().baseUrl(url).build();
    }

    @Override
    public Client2DTO getDTO() {
        String uri = "/client2";
        return webClient.get().uri(uri).retrieve()
                .bodyToMono(Client2DTO.class)
                .map(dto -> {
                    validate(dto);
                    return dto;
                }).block();
    }

    public void validate(Client2DTO dto) {
        Set<ConstraintViolation<Client2DTO>> violationSet = validator.validate(dto);
        if(!violationSet.isEmpty()) {
            StringBuilder sb = new StringBuilder();
            for (ConstraintViolation<Client2DTO> violation : violationSet) {
                sb.append("Violation: ").append(violation.getPropertyPath()).append(": ").append(violation.getMessage()).append("\n");
            }
            throw new ConstraintViolationException("Validation failed:\n" + sb.toString(), violationSet);
        }
    }
}
