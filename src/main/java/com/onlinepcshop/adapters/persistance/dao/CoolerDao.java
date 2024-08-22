package com.onlinepcshop.adapters.persistance.dao;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.math.BigDecimal;
import java.util.UUID;

@Entity(name = "cooler")
@Data
@AllArgsConstructor
@NoArgsConstructor
public class CoolerDao {
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

    @Column(name = "manufacturer")
    String manufacturer;


    @Column(name = "socket_type")
    String socketType;

    @Column(name = "water_cooled")
    Boolean waterCooled;

    @Column(name = "tdp")
    Integer tdp;
}
