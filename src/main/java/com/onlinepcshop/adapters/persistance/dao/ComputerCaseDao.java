package com.onlinepcshop.adapters.persistance.dao;

import com.onlinepcshop.core.domain.entity.enums.CaseType;
import com.onlinepcshop.core.domain.entity.enums.Colors;
import com.onlinepcshop.core.domain.entity.enums.Manufacturer;
import com.onlinepcshop.core.domain.value.Money;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.math.BigDecimal;
import java.util.UUID;

@Entity(name = "computer_case")
@Data
@AllArgsConstructor
@NoArgsConstructor
public class ComputerCaseDao {
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


    @Column(name = "case_type")
    String caseType;

    @Column(name = "color")
    String color;
}
