package com.onlinepcshop.adapters.persistance.dao;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.math.BigDecimal;
import java.util.UUID;

@Entity(name = "computer")
@Data
@AllArgsConstructor
@NoArgsConstructor
public class ComputerDao {
    @Id
    @GeneratedValue(strategy = GenerationType.UUID)
    private UUID id;

    @Column(name = "computer_name")
    String computerName;

    @Column(name = "quantity")
    Integer quantity;

    @Column(name = "price")
    BigDecimal price;

    @Column(name = "currency")
    String currency;

    @Column(name = "description")
    String description;

    @Column(name = "image")
    String image;

    @Column(name = "computer_type")
    String computerType;

    @Column(name = "sale_type")
    String saleType;

    @Column(name = "purchased")
    Boolean purchased;

    @Column(name = "tdp")
    Integer tdp;

    @ManyToOne
    MotherboardDao motherboard;

    @ManyToOne
    ComputerCaseDao computerCase;

    @ManyToOne
    CpuDao cpu;

    @ManyToOne
    GpuDao gpu;

    @ManyToOne
    PowerSupplyDao powerSupply;

    @ManyToOne
    CoolerDao cooler;
}
