package com.onlinepcshop.adapters.rest.dto.abstracts;

import com.onlinepcshop.core.domain.entity.enums.Manufacturer;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.math.BigDecimal;
import java.util.UUID;

@Data
@AllArgsConstructor
@NoArgsConstructor
public abstract class ComponentDto {
    UUID id;
    String componentName;
    Integer quantity;
    BigDecimal price;
    String currency;
    String description;
    String image;
    Manufacturer manufacturer;
}
