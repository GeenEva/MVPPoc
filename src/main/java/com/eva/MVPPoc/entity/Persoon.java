package com.eva.MVPPoc.entity;

import com.fasterxml.jackson.annotation.JsonIgnore;
import jakarta.persistence.*;
import lombok.Data;
import lombok.RequiredArgsConstructor;
import lombok.ToString.Exclude;

import java.util.List;

@Entity
@Data
@RequiredArgsConstructor
public class Persoon {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long persoonId;

    @Exclude
    @OneToMany(mappedBy = "persoon")
    @JsonIgnore
    private List<Transactie> transacties;

    private String persoonNaam;

}
