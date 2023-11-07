package com.eva.MVPPoc.entity;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import lombok.Data;
import lombok.RequiredArgsConstructor;

@Entity
@Data
@RequiredArgsConstructor
public class Certificaat {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long certificaatId;


    private Integer certificaatNummer;


    private Long persoonId;

}
