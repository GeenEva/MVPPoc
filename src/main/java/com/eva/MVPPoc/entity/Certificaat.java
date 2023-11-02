package com.eva.MVPPoc.entity;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;

import java.util.Objects;

@Entity
public class Certificaat {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long certificaatId;

    private Integer certificaatNummer;
    private Long persoonId;

    public Certificaat() {
    }

    public Certificaat(Integer certificaatNummer, Long persoonId) {
        this.certificaatNummer = certificaatNummer;
        this.persoonId = persoonId;
    }

    public Certificaat(Long certificaatId, Integer certificaatNummer, Long persoonId) {
        this.certificaatId = certificaatId;
        this.certificaatNummer = certificaatNummer;
        this.persoonId = persoonId;
    }

    public Long getCertificaatId() {
        return certificaatId;
    }

    public Integer getCertificaatNummer() {
        return certificaatNummer;
    }

    public void setCertificaatNummer(Integer certificaatNummer) {
        this.certificaatNummer = certificaatNummer;
    }

    public Long getPersoonId() {
        return persoonId;
    }

    public void setPersoonId(Long eigenaar) {
        this.persoonId = eigenaar;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof Certificaat)) return false;
        Certificaat that = (Certificaat) o;
        return getCertificaatId().equals(that.getCertificaatId()) && getCertificaatNummer().equals(that.getCertificaatNummer()) && getPersoonId().equals(that.getPersoonId());
    }

    @Override
    public int hashCode() {
        return Objects.hash(getCertificaatId(), getCertificaatNummer(), getPersoonId());
    }

    @Override
    public String toString() {
        return "Certificaat{" +
                "id=" + certificaatId +
                ", certificaatNummer=" + certificaatNummer +
                ", eigenaar='" + persoonId + '\'' +
                '}';
    }
}
