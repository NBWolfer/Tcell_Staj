package org.example.staj_projesi.dtos;

import java.util.HashMap;

// Class definition according to API that we request || IDE suggests to convert this class into record class type (Research)
public class Client1DTO {
    private final String result;
    private final String faq;
    private final String terms_of_use;
    private final String start_date;
    private final String end_date;
    private final String base_code;
    private final HashMap<String,Double> conversion_rates;


    public Client1DTO(String result, String faq, String terms_of_use, String start_date, String end_date, String base_code, HashMap<String, Double> conversion_rates) {
        this.result = result;
        this.faq = faq;
        this.terms_of_use = terms_of_use;
        this.start_date = start_date;
        this.end_date = end_date;
        this.base_code = base_code;
        this.conversion_rates = conversion_rates;
    }

    public String getResult() {
        return result;
    }

    public String getFaq() {
        return faq;
    }

    public String getTerms_of_use() {
        return terms_of_use;
    }

    public String getStart_date() {
        return start_date;
    }

    public String getEnd_date() {
        return end_date;
    }

    public String getBase_code() {
        return base_code;
    }

    public HashMap<String, Double> getConversion_rates() {
        return conversion_rates;
    }
}
