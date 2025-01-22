package org.example.staj_projesi.domain.model.dto;

import com.fasterxml.jackson.annotation.JsonAlias;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Pattern;
import org.springframework.validation.annotation.Validated;

import java.util.HashMap;

@Validated
@JsonIgnoreProperties(ignoreUnknown = true)
public class Client1DTO {
    @JsonAlias({"result", "Result"})
    @NotNull(message = "Cannot be null")
    @NotBlank(message = "Cannot be blank")
    private final String result;

    @JsonAlias({"faq", "FAQ", "Faq"})
    @NotNull(message = "Cannot be null")
    private final String faq;

    @JsonAlias({"terms_of_use", "termsOfUse"})
    @NotNull(message = "Cannot be null")
    private final String termsOfUse;

    @JsonAlias({"start_date", "startDate"})
    @NotNull(message = "Cannot be null")
    @NotBlank(message = "Cannot be blank")
    @Pattern(regexp = "^(\\d{4})-(\\d{2})-(\\d{2})$", message = "Invalid date format")
    private final String startDate;

    @JsonAlias({"end_date", "endDate"})
    @NotNull(message = "Cannot be null")
    @NotBlank(message = "Cannot be blank")
    @Pattern(regexp = "^(\\d{4})-(\\d{2})-(\\d{2})$", message = "Invalid date format")
    private final String endDate;

    @JsonAlias({"base_code", "baseCode"})
    @NotNull(message = "Cannot be null")
    @NotBlank(message = "Cannot be blank")
    private final String baseCode;

    @JsonAlias({"conversion_rates", "conversionRates"})
    @NotNull(message = "Cannot be null")
    private final HashMap<String,Double> conversionRates;

    @NotNull(message = "Cannot be null")
    @NotBlank(message = "Cannot be blank")
    private final String test;


    public Client1DTO(String result, String faq, String termsOfUse, String startDate, String endDate, String baseCode, HashMap<String, Double> conversionRates, String test) {
        this.result = result;
        this.faq = faq;
        this.termsOfUse = termsOfUse;
        this.startDate = startDate;
        this.endDate = endDate;
        this.baseCode = baseCode;
        this.conversionRates = conversionRates;
        this.test = test;
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

    public String getTest() {
        return test;
    }
}
