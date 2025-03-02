package com.onlinepcshop.adapters.persistance.dao;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.math.BigDecimal;
import java.time.LocalDate;
import java.util.UUID;

@Entity(name = "ram")
@Data
@AllArgsConstructor
@NoArgsConstructor
public class RamDao {
    @Id
    @GeneratedValue(strategy = GenerationType.UUID)
    private UUID id;

    @Column(name = "component_name")
    String componentName;

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

    @Column(name = "date_of_creation")
    LocalDate dateOfCreation;

    @Column(name = "manufacturer")
    String manufacturer;

    @Column(name = "sale_type")
    String saleType;


    @Column(name = "memory_type")
    String memoryType;

    @Column(name = "ram_speed")
    Integer ramSpeed;

    @Column(name = "ram_storage")
    Integer ramStorage;

    @Column(name = "tdp")
    Integer tdp;
}
