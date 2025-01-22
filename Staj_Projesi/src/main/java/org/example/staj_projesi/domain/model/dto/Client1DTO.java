package org.example.staj_projesi.domain.model.dto;

import com.fasterxml.jackson.annotation.JsonAlias;

import java.util.HashMap;

public class Client1DTO {
    @JsonAlias({"result", "Result"})
    private final String result;

    @JsonAlias({"faq", "FAQ", "Faq"})
    private final String faq;

    @JsonAlias({"terms_of_use", "termsOfUse"})
    private final String termsOfUse;

    @JsonAlias({"start_date", "startDate"})
    private final String startDate;

    @JsonAlias({"end_date", "endDate"})
    private final String endDate;

    @JsonAlias({"base_code", "baseCode"})
    private final String baseCode;

    @JsonAlias({"conversion_rates", "conversionRates"})
    private final HashMap<String,Double> conversionRates;


    public Client1DTO(String result, String faq, String termsOfUse, String startDate, String endDate, String baseCode, HashMap<String, Double> conversionRates) {
        this.result = result;
        this.faq = faq;
        this.termsOfUse = termsOfUse;
        this.startDate = startDate;
        this.endDate = endDate;
        this.baseCode = baseCode;
        this.conversionRates = conversionRates;
    }

    public String getResult() {
        return result;
    }

    public String getFaq() {
        return faq;
    }

    public String getTermsOfUse() {
        return termsOfUse;
    }

    public String getStartDate() {
        return startDate;
    }

    public String getEndDate() {
        return endDate;
    }

    public String getBaseCode() {
        return baseCode;
    }

    public HashMap<String, Double> getConversionRates() {
        return conversionRates;
    }
}
