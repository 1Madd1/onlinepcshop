package com.onlinepcshop.adapters.persistance.dao;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.UUID;

@Entity(name = "agent")
@Data
@AllArgsConstructor
@NoArgsConstructor
public class AgentDao {
    @Id
    @GeneratedValue(strategy = GenerationType.UUID)
    private UUID id;

    @Column
    private String principalId;

    @Column(name = "email")
    private String email;

    @Column(name = "naziv")
    private String naziv;

    @Column(name = "telefon")
    private String telefon;

//    @ManyToOne
//    UpravnikDao upravnik;
}
