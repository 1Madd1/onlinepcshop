package com.onlinepcshop.core.domain.entity;

import com.onlinepcshop.core.domain.entity.enums.Colors;
import com.onlinepcshop.core.domain.entity.enums.Manufacturer;
import com.onlinepcshop.core.domain.entity.enums.SaleType;
import com.onlinepcshop.core.domain.value.Money;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDate;
import java.util.UUID;

@Builder
@Data
@AllArgsConstructor
@NoArgsConstructor
public class CaseFan {
    UUID id;
    String componentName;
    Integer quantity;
    Money price;
    String description;
    String image;
    Double avgRating;
    Manufacturer manufacturer;

    Integer fanSize;
    Colors color;
    String rpm;
    String noiseLevel;
    SaleType saleType;
    Integer tdp;
    LocalDate dateOfCreation;
}
