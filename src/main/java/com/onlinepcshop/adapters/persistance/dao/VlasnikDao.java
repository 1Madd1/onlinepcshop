package com.onlinepcshop.adapters.persistance.dao;

import jakarta.persistence.*;
import lombok.*;

import java.time.LocalDate;
import java.util.Set;
import java.util.UUID;


//@Entity(name = "vlasnik")
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class VlasnikDao {
    @Id
    @GeneratedValue(strategy = GenerationType.UUID)
    @Column(name = "id")
    private UUID id;
    @Column(name = "principal_id")
    private String principalId;
    @Column(name = "ime")
    String ime;
    @Column(name = "prezime")
    String prezime;
    @Column(name = "tip")
    String tip;
    @Column(name = "srednje_ime")
    String srednjeIme;
    @Column(name = "broj_licne_karte")
    String brojLicneKarte;
    @Column(name = "broj_pasosa")
    String brojPasosa;
    @Column(name = "datum_rodjenja")
    LocalDate datumRodjenja;
    @Column(name = "jmbg")
    String jmbg;
    @Column(name = "naziv")
    String naziv;
    @Column(name = "pib")
    String pib;
    @Column(name = "maticni_broj")
    String maticniBroj;
    @Column(name = "sifra_delatnosti")
    String sifraDelatnosti;
    @Column(name = "adresa")
    String adresa;
    @Column(name = "postanski_broj")
    String postanskiBroj;
    @Column(name = "mesto")
    String mesto;
    @Column(name = "opstina")
    String opstina;
    @Column(name = "email")
    String email;

    @OneToMany(cascade = CascadeType.ALL, orphanRemoval = true)
    @JoinColumn(name = "vlasnik_id", referencedColumnName = "id")
    Set<BrojTelefonaDao> brojTelefonaList;

//    @OneToMany(cascade = CascadeType.ALL, orphanRemoval = true)
//    @JoinColumn(name = "vlasnik_id", referencedColumnName = "id")
//    Set<TekuciRacunDao> tekuciRacunList;
}