package org.example.staj_projesi.domain.model.dto;

import com.fasterxml.jackson.annotation.JsonAlias;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import lombok.Getter;
import lombok.Setter;
import org.springframework.validation.annotation.Validated;

import java.util.HashMap;

@Setter
@Getter
@Validated
@JsonIgnoreProperties(ignoreUnknown = true)
public class ClientResponseDTO {

    @JsonAlias({"clientName", "clientname"})
    private String clientName;

    @JsonAlias({"USD", "usd"})
    private Double usd = 0.0;

    @JsonAlias({"GPB", "gpb"})
    private Double gbp = 0.0;

    @JsonAlias({"CAD", "cad"})
    private  Double cad = 0.0;

    @JsonAlias({"CHF", "chf"})
    private  Double chf = 0.0;

    @JsonAlias({"EUR", "eur"})
    private  Double eur = 0.0;

    @JsonAlias({"RUB", "rub"})
    private  Double rub = 0.0;

    @JsonAlias({"AED", "aed"})
    private  Double aed = 0.0;

    @JsonAlias({"SYY", "syy"})
    private  Double syy = 0.0;

    public ClientResponseDTO(){
    }

    public void setCurrencies(HashMap<String, Double> currencyRates){
        this.usd = currencyRates.getOrDefault("USD", 0.0);
        this.gbp = currencyRates.getOrDefault("GPB", 0.0);
        this.cad = currencyRates.getOrDefault("CAD", 0.0);
        this.chf = currencyRates.getOrDefault("CHF", 0.0);
        this.eur = currencyRates.getOrDefault("EUR", 0.0);
        this.rub = currencyRates.getOrDefault("RUB", 0.0);
        this.aed = currencyRates.getOrDefault("AED", 0.0);
        this.syy = currencyRates.getOrDefault("SYY", 0.0);
    }

}
