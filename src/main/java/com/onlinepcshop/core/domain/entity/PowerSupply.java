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
public class PowerSupply {
    UUID id;
    String componentName;
    Integer quantity;
    Money price;
    String description;
    String image;
    LocalDate dateOfCreation;
    Manufacturer manufacturer;
    Double avgRating;

    String efficiencyRating;
    SaleType saleType;
    Integer wattage;
    Colors color;
}
