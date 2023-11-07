package com.eva.MVPPoc.entity;

import jakarta.persistence.*;
import lombok.Data;
import lombok.NonNull;
import lombok.RequiredArgsConstructor;

@Entity
@Data
@RequiredArgsConstructor
public class Certificaat {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long certificaatId;

    @Column
    private Integer certificaatNummer;

    @ManyToOne
    @JoinColumn(name = "persoon_id", nullable = false)
    private Persoon persoonId;


}
