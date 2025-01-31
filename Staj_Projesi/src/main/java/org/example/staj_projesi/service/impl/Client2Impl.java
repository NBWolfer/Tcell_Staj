package org.example.staj_projesi.service.impl;

import jakarta.validation.ConstraintViolation;
import jakarta.validation.ConstraintViolationException;
import jakarta.validation.Validator;
import org.example.staj_projesi.config.ClientConfig;
import org.example.staj_projesi.domain.model.dto.Client2DTO;
import org.example.staj_projesi.service.ClientService;
import org.springframework.stereotype.Component;
import org.springframework.web.reactive.function.client.WebClient;
import reactor.core.publisher.Mono;

import java.util.Set;

@Component("client2")
public class Client2Impl implements ClientService<Client2DTO> {
    private final ClientConfig configuration;
    private final Validator validator;

    private final String url;

    public Client2Impl(ClientConfig configuration, Validator validator) {
        this.validator = validator;
        this.configuration = configuration;
        this.url = configuration.getClient2_url();
    }

    @Override
    public Mono<Client2DTO> getDTO() {
        WebClient webClient = WebClient.builder().baseUrl(url).build();

        return webClient.get().retrieve()
                .bodyToMono(Client2DTO.class)
                .map(dto -> {
                    validate(dto);
                    return dto;
                });
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
