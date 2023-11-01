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
    private String eigenaar;

    public Certificaat() {
    }

    public Certificaat(Long certificaatId, Integer certificaatNummer, String eigenaar) {
        this.certificaatId = certificaatId;
        this.certificaatNummer = certificaatNummer;
        this.eigenaar = eigenaar;
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

    public String getEigenaar() {
        return eigenaar;
    }

    public void setEigenaar(String eigenaar) {
        this.eigenaar = eigenaar;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof Certificaat)) return false;
        Certificaat that = (Certificaat) o;
        return getCertificaatId().equals(that.getCertificaatId()) && getCertificaatNummer().equals(that.getCertificaatNummer()) && getEigenaar().equals(that.getEigenaar());
    }

    @Override
    public int hashCode() {
        return Objects.hash(getCertificaatId(), getCertificaatNummer(), getEigenaar());
    }

    @Override
    public String toString() {
        return "Certificaat{" +
                "id=" + certificaatId +
                ", certificaatNummer=" + certificaatNummer +
                ", eigenaar='" + eigenaar + '\'' +
                '}';
    }
}
