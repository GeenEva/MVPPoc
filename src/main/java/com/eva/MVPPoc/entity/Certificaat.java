package com.eva.MVPPoc.entity;

import jakarta.persistence.*;
import lombok.Data;
import lombok.RequiredArgsConstructor;

@Entity
@Data
@RequiredArgsConstructor
public class Certificaat {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long certificaatId;


    private Integer certificaatNummer;

    @ManyToOne
    @JoinColumn(name = "persoon_id", nullable = false)
    private Persoon persoon;

    @ManyToOne
    @JoinColumn(name = "optieplan_bij_aankoop", nullable = false)
    private Optieplan optieplanBijAankoop;

    @ManyToOne
    @JoinColumn(name = "optieplan_bij_verkoop", nullable = true)
    private Optieplan optieplanBijVerkoop;



}
