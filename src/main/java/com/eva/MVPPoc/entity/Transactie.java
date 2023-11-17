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
    @JoinColumn(name = "transactie_moment_id", nullable = false)
    private TransactieMoment transactieMoment;

    @ManyToOne
    @JoinColumn(name="persoon_id", nullable = false)
    private Persoon persoon;

    private Integer koopt;

    private Integer verkoopt;

    private Integer zetOm;

    private String zetOmVanOptieplan;


}
