package com.eva.MVPPoc.entity;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;

import java.util.Objects;

@Entity
public class Persoon {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long persoonId;

    private String persoonNaam;

    public Persoon() {
    }

    public Persoon(Long persoonId, String persoonNaam) {
        this.persoonId = persoonId;
        this.persoonNaam = persoonNaam;
    }

    public Long getPersoonId() {
        return persoonId;
    }

    public String getPersoonNaam() {
        return persoonNaam;
    }

    public void setPersoonNaam(String name) {
        this.persoonNaam = name;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof Persoon)) return false;
        Persoon persoon = (Persoon) o;
        return getPersoonId().equals(persoon.getPersoonId()) && getPersoonNaam().equals(persoon.getPersoonNaam());
    }

    @Override
    public int hashCode() {
        return Objects.hash(getPersoonId(), getPersoonNaam());
    }

    @Override
    public String toString() {
        return "Persoon{" +
                "id=" + persoonId +
                ", name='" + persoonNaam + '\'' +
                '}';
    }
}
