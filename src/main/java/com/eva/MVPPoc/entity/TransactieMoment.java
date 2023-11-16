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
public class TransactieMoment {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long transactieMomentId;


    @OneToOne
    @JoinColumn(name = "optieplan_id", nullable = false)
    private Optieplan optieplan;


    @ToString.Exclude
    @JsonIgnore
    @OneToMany(mappedBy = "transactieMoment")
    private List<Transactie> transacties;
}
