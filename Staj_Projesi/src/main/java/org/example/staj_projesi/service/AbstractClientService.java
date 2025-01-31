package org.example.staj_projesi.service;

import jakarta.validation.ConstraintViolation;
import jakarta.validation.ConstraintViolationException;
import jakarta.validation.Validator;
import org.example.staj_projesi.config.ClientConfig;
import org.example.staj_projesi.domain.model.dto.Client2DTO;
import org.example.staj_projesi.domain.model.dto.ClientResponseDTO;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Component;
import org.springframework.web.reactive.function.client.WebClient;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

import java.util.ArrayList;
import java.util.List;
import java.util.Set;

@Component
public abstract class AbstractClientService<T>{
    private static final Logger log = LoggerFactory.getLogger(AbstractClientService.class);
    private Validator validator;
    private WebClient webClient;
    private ClientConfig clientConfig;

    protected void validate(T dto) {
        Set<ConstraintViolation<T>> violationSet = validator.validate(dto);
        if(!violationSet.isEmpty()) {
            StringBuilder sb = new StringBuilder();
            for (ConstraintViolation<T> violation : violationSet) {
                sb.append("Violation: ").append(violation.getPropertyPath()).append(": ").append(violation.getMessage()).append("\n");
            }
            throw new ConstraintViolationException("Validation failed:\n" + sb, violationSet);
        }
    }

    // abstract  public T getDTO();

    protected Mono<T> getDTO(){

        return null;
    }

    protected ClientResponseDTO getInParallel(ClientService<T>... services) {
        ArrayList<Mono<T>> monoList = new ArrayList<>();
        for (ClientService<T> client: services) {
            monoList.add(client.getDTO());
        }

        return null;
    }
}
