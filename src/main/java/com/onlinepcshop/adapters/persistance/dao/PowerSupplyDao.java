package com.onlinepcshop.adapters.persistance.dao;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.math.BigDecimal;
import java.time.LocalDate;
import java.util.UUID;

@Entity(name = "power_supply")
@Data
@AllArgsConstructor
@NoArgsConstructor
public class PowerSupplyDao {
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


    @Column(name = "efficiency_rating")
    String efficiencyRating;

    @Column(name = "color")
    String color;

    @Column(name = "wattage")
    Integer wattage;
}
