package com.onlinepcshop.core.domain.entity;

import com.onlinepcshop.core.domain.entity.enums.Manufacturer;
import com.onlinepcshop.core.domain.entity.enums.SaleType;
import com.onlinepcshop.core.domain.entity.enums.SocketType;
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
public class Cpu {
    UUID id;
    String componentName;
    Integer quantity;
    Money price;
    String description;
    String image;
    Manufacturer manufacturer;

    SocketType socketType;
    SaleType saleType;
    Integer coreCount;
    String performanceCoreClock;
    String performanceCoreBoostClock;
    Boolean includesCooler;
    Boolean includesIntegratedGpu;
    Integer tdp;
}
