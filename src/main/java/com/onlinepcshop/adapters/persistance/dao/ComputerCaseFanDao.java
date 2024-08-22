package com.onlinepcshop.adapters.persistance.dao;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.UUID;

@Entity(name = "computer_case_fan")
@Data
@AllArgsConstructor
@NoArgsConstructor
public class ComputerCaseFanDao {
    @Id
    @GeneratedValue(strategy = GenerationType.UUID)
    private UUID id;

    @Column(name = "quantity")
    private Integer quantity;

    @ManyToOne
    private ComputerDao computer;

    @ManyToOne
    private CaseFanDao caseFan;
}
