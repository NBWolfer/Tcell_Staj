package org.example.staj_projesi.domain.model.entity;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.Id;
import lombok.Getter;
import lombok.Setter;
import org.hibernate.annotations.CurrentTimestamp;


@Getter
@Entity
public class Client {

    @Id
    @GeneratedValue(strategy = jakarta.persistence.GenerationType.IDENTITY)
    private Long id;

    @Setter
    private Double usd;

    @Setter
    private Double gbp;

    @Setter
    private Double cad;

    @Setter
    private Double chf;

    @Setter
    private Double eur;

    @Setter
    private Double rub;

    @Setter
    private Double aed;

    @Setter
    private Double syy;

    @Setter
    private String clientName;

    @Setter
    @CurrentTimestamp
    private String timeStamp;

    public Client() {
    }


    public Client(Double usd, Double gbp, Double cad, Double chf, Double eur, Double rub, Double aed, Double syy, String clientName) {
        this.usd = usd;
        this.gbp = gbp;
        this.cad = cad;
        this.chf = chf;
        this.eur = eur;
        this.rub = rub;
        this.aed = aed;
        this.syy = syy;
        this.clientName = clientName;
    }
}
