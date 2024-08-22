package com.onlinepcshop.core.domain.entity;

import com.onlinepcshop.core.domain.entity.enums.Manufacturer;
import com.onlinepcshop.core.domain.entity.enums.StorageType;
import com.onlinepcshop.core.domain.value.Money;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.UUID;

@Builder
@Data
@AllArgsConstructor
@NoArgsConstructor
public class Storage {
    UUID id;
    String componentName;
    Integer quantity;
    Money price;
    String description;
    String image;
    Manufacturer manufacturer;

    StorageType storageType;
    Integer capacity;
    Integer tdp;
}
