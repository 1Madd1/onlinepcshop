package com.onlinepcshop.adapters.persistance.dao;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.UUID;

@Entity(name = "broj_telefona")
@Data
@AllArgsConstructor
@NoArgsConstructor
public class BrojTelefonaDao {
    @Id
    @GeneratedValue(strategy = GenerationType.UUID)
    private UUID id;

    @Column(name = "broj_telefona")
    private String brojTelefona;


}
