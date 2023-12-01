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
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long optieplanId;

    private Integer optieplanNaam;

    @ToString.Exclude
    @JsonIgnore
    @OneToMany(mappedBy = "optieplanBijAankoop")
    private List<Certificaat> certificaten;



    @ToString.Exclude
    @JsonIgnore
    @OneToMany(mappedBy = "optieplan")
    private List<Transactie> transacties;

}
