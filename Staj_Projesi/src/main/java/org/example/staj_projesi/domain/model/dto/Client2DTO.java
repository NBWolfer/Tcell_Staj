package org.example.staj_projesi.domain.model.dto;

import com.fasterxml.jackson.annotation.JsonAlias;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import jakarta.validation.constraints.NotNull;
import org.springframework.validation.annotation.Validated;

@Validated
@JsonIgnoreProperties(ignoreUnknown = true)
public class Client2DTO {

    @JsonAlias({"USD", "usd"})
    @NotNull(message = "Cannot be null")
    private final Double usd;

    @JsonAlias({"EUR", "eur"})
    @NotNull(message = "Cannot be null")
    private final Double eur;

    @JsonAlias({"GPB", "gpb"})
    @NotNull(message = "Cannot be null")
    private final Double gbp;

    @JsonAlias({"CAD", "cad"})
    @NotNull(message = "Cannot be null")
    private final Double cad;

    @JsonAlias({"CHF", "chf"})
    @NotNull(message = "Cannot be null")
    private final Double chf;

    @JsonAlias({"RUB", "rub"})
    @NotNull(message = "Cannot be null")
    private final Double rub;

    public Client2DTO(Double usd, Double eur, Double gbp, Double cad, Double chf, Double rub) {
        this.usd = usd;
        this.eur = eur;
        this.gbp = gbp;
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

    public Double getGbp() {
        return gbp;
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
