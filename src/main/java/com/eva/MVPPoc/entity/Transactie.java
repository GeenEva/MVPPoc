package com.eva.MVPPoc.entity;

import jakarta.persistence.*;
import lombok.Data;
import lombok.RequiredArgsConstructor;

@Entity
@Data
@RequiredArgsConstructor
public class Transactie {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long transactieId;

    @ManyToOne
    @JoinColumn(name = "optieplan_id", nullable = false)
    private Optieplan optieplan;

    @ManyToOne
    @JoinColumn(name="persoon_id", nullable = false)
    private Persoon persoon;

    private String typeToewijzing;

    private Integer aantal;

    @ManyToOne
    @JoinColumn(name = "zetOmVanOptieplan", nullable = true)
    private Optieplan zetOmVanOptieplan;


}
