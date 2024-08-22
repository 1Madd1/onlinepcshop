package com.onlinepcshop.adapters.persistance.dao.abstracts;

import jakarta.persistence.Column;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.math.BigDecimal;
import java.util.UUID;

@Data
@AllArgsConstructor
@NoArgsConstructor
public abstract class ComponentDao {
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
}
