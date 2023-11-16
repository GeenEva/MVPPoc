package com.eva.MVPPoc.entity;

import com.fasterxml.jackson.annotation.JsonIgnore;
import jakarta.persistence.*;
import lombok.Data;
import lombok.RequiredArgsConstructor;
import lombok.ToString;

import java.util.List;

@Entity
@Data
@RequiredArgsConstructor
public class Optieplan {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long optieplanId;

    private Integer optieplanNaam;

    @ToString.Exclude
    @JsonIgnore
    @OneToMany(mappedBy = "optieplan")
    private List<Certificaat> certificaten;


    @ToString.Exclude
    @JsonIgnore
    @OneToOne(mappedBy = "optieplan", optional = true)
    private TransactieMoment transactieMoment;


}
