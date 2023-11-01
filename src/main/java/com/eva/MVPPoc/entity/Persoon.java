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

    private String name;

    public Persoon() {
    }

    public Persoon(Long persoonId, String name) {
        this.persoonId = persoonId;
        this.name = name;
    }

    public Long getPersoonId() {
        return persoonId;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof Persoon)) return false;
        Persoon persoon = (Persoon) o;
        return getPersoonId().equals(persoon.getPersoonId()) && getName().equals(persoon.getName());
    }

    @Override
    public int hashCode() {
        return Objects.hash(getPersoonId(), getName());
    }

    @Override
    public String toString() {
        return "Persoon{" +
                "id=" + persoonId +
                ", name='" + name + '\'' +
                '}';
    }
}
