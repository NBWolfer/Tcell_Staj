package org.example.staj_projesi.domain.repository;

import org.example.staj_projesi.domain.model.entity.Client;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ClientRepository extends JpaRepository<Client, Long> {
        Client findByClientName(String clientName);
}
