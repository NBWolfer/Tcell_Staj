package org.example.staj_projesi.domain.model.dto;

import com.fasterxml.jackson.annotation.JsonAlias;

public class Client2DTO {

    @JsonAlias({"USD", "usd"})
    private final Double usd;

    @JsonAlias({"EUR", "eur"})
    private final Double eur;

    @JsonAlias({"GPB", "gpb"})
    private final Double gpb;

    @JsonAlias({"CAD", "cad"})
    private final Double cad;

    @JsonAlias({"CHF", "chf"})
    private final Double chf;

    @JsonAlias({"RUB", "rub"})
    private final Double rub;

    public Client2DTO(Double usd, Double eur, Double gpb, Double cad, Double chf, Double rub) {
        this.usd = usd;
        this.eur = eur;
        this.gpb = gpb;
        this.cad = cad;
        this.chf = chf;
        this.rub = rub;
    }

    public Double getUsd() {
        return usd;
    }

    public Double getEur() {
        return eur;
    }

    public Double getGpb() {
        return gpb;
    }

    public Double getCad() {
        return cad;
    }

    public Double getChf() {
        return chf;
    }

    public Double getRub() {
        return rub;
    }

}
