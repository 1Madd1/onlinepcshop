package com.onlinepcshop.adapters.persistance.dao;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.math.BigDecimal;
import java.util.UUID;

@Entity(name = "cpu")
@Data
@AllArgsConstructor
@NoArgsConstructor
public class CpuDao {
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

    @Column(name = "sale_type")
    String saleType;


    @Column(name = "socket_type")
    String socketType;

    @Column(name = "core_count")
    Integer coreCount;

    @Column(name = "performance_core_clock")
    String performanceCoreClock;

    @Column(name = "performance_core_boost_clock")
    String performanceCoreBoostClock;

    @Column(name = "includes_cooler")
    Boolean includesCooler;

    @Column(name = "includes_integrated_gpu")
    Boolean includesIntegratedGpu;

    @Column(name = "tdp")
    Integer tdp;
}
