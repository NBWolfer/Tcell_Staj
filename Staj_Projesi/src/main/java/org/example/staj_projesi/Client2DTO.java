package org.example.staj_projesi;

import java.util.HashMap;

public class Client2DTO {
    private final Double USD;
    private final Double EUR;
    private final Double GPB;
    private final Double CAD;
    private final Double CHF;
    private final Double RUB;

    public Client2DTO(Double USD, Double EUR, Double GPB, Double CAD, Double CHF, Double RUB) {
        this.USD = USD;
        this.EUR = EUR;
        this.GPB = GPB;
        this.CAD = CAD;
        this.CHF = CHF;
        this.RUB = RUB;
    }

    public Double getUSD() {
        return USD;
    }

    public Double getEUR() {
        return EUR;
    }

    public Double getGPB() {
        return GPB;
    }

    public Double getCAD() {
        return CAD;
    }

    public Double getCHF() {
        return CHF;
    }

    public Double getRUB() {
        return RUB;
    }

}
