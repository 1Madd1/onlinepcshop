package com.onlinepcshop.adapters.persistance.dao;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.math.BigDecimal;
import java.time.LocalDate;
import java.util.UUID;

@Entity(name = "obracun")
@Data
@AllArgsConstructor
@NoArgsConstructor
public class ObracunDao {

    @Id
    @GeneratedValue(strategy = GenerationType.UUID)
    UUID id;

    @Column
    String broj;

    @Column(name = "datum_izdavanja_racuna")
    LocalDate datumIzdavanjaRacuna;

    @Column(name = "datum_prometa")
    LocalDate datumPrometa;

    @Column(name = "datum_valute")
    LocalDate datumValute;

    @Column(name = "prethodni_dug")
    BigDecimal prethodniDug;

    @Column(name = "valuta")
    String valuta;

//    @ManyToOne
//    ObracunskiPeriodDao obracunskiPeriod;
//
//    @ManyToOne
//    PosebniDeoDao posebniDeo;

}
