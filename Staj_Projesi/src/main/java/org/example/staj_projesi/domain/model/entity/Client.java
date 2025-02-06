package org.example.staj_projesi.domain.model.entity;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.Id;
import lombok.Getter;
import lombok.RequiredArgsConstructor;
import lombok.Setter;
import org.hibernate.annotations.CurrentTimestamp;


@Getter
@Entity
@RequiredArgsConstructor
@Setter
public class Client {

    @Id
    @GeneratedValue(strategy = jakarta.persistence.GenerationType.IDENTITY)
    private Long id;

    private Double usd;

    private Double gbp;

    private Double cad;

    private Double chf;

    private Double eur;

    private Double rub;

    private Double aed;

    private Double syy;

    private String clientName;

    @CurrentTimestamp
    private String timeStamp;
}
