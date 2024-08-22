package com.onlinepcshop.adapters.persistance.dao;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.UUID;

@Entity(name = "computer_storage")
@Data
@AllArgsConstructor
@NoArgsConstructor
public class ComputerStorageDao {
    @Id
    @GeneratedValue(strategy = GenerationType.UUID)
    private UUID id;

    @Column(name = "quantity")
    private Integer quantity;

    @ManyToOne
    private ComputerDao computer;

    @ManyToOne
    private StorageDao storage;
}
