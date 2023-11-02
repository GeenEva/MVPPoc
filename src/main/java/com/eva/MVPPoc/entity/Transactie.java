package com.eva.MVPPoc.entity;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;

import java.util.Objects;

@Entity
public class Transactie {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long transactieId;

    private Long persoonId;

    private Integer koopt;

    private Integer verkoopt;

    public Transactie() {
    }

    public Transactie(Long transactieId, Long persoonId, Integer koopt, Integer verkoopt) {
        this.transactieId = transactieId;
        this.persoonId = persoonId;
        this.koopt = koopt;
        this.verkoopt = verkoopt;
    }

    public Long getTransactieId() {
        return transactieId;
    }

    public Long getPersoonId() {
        return persoonId;
    }

    public void setPersoonId(Long persoonId) {
        this.persoonId = persoonId;
    }

    public Integer getKoopt() {
        return koopt;
    }

    public void setKoopt(Integer koopt) {
        this.koopt = koopt;
    }

    public Integer getVerkoopt() {
        return verkoopt;
    }

    public void setVerkoopt(Integer verkoopt) {
        this.verkoopt = verkoopt;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof Transactie)) return false;
        Transactie that = (Transactie) o;
        return getTransactieId().equals(that.getTransactieId()) && getPersoonId().equals(that.getPersoonId()) && Objects.equals(getKoopt(), that.getKoopt()) && Objects.equals(getVerkoopt(), that.getVerkoopt());
    }

    @Override
    public int hashCode() {
        return Objects.hash(getTransactieId(), getPersoonId(), getKoopt(), getVerkoopt());
    }

    @Override
    public String toString() {
        return "Transactie{" +
                "id=" + transactieId +
                ", persoonId=" + persoonId +
                ", koopt=" + koopt +
                ", verkoopt=" + verkoopt +
                '}';
    }
}
