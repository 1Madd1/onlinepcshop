package com.onlinepcshop.adapters.rest.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDate;
import java.util.List;
import java.util.UUID;


@Data
@AllArgsConstructor
@NoArgsConstructor
public class VlasnikDto {
    private UUID id;
    String principalId;
    String ime;
    String prezime;
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
    List<BrojTelefonaDto> brojTelefonaList;

}