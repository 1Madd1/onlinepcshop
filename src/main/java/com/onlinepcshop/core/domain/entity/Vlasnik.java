package com.onlinepcshop.core.domain.entity;

import com.deavensoft.eobracuni.core.domain.value.TipVlasnika;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDate;
import java.util.List;
import java.util.UUID;
@Builder
@Data
@AllArgsConstructor
@NoArgsConstructor
public class Vlasnik{
    UUID id;
    String ime;
    String principalId;
    String prezime;
    TipVlasnika tip;
    String srednjeIme;
    String brojLicneKarte;
    String brojPasosa;
    LocalDate datumRodjenja;
    String jmbg;
    String naziv;
    String pib;
    String maticniBroj;
    String sifraDelatnosti;
    String adresa;
    String postanskiBroj;
    String mesto;
    String opstina;
    String email;
    List<TekuciRacun> tekuciRacunList;
    List<BrojTelefona> brojTelefonaList;
}
