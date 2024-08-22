package com.onlinepcshop.core.domain.entity;

import com.onlinepcshop.core.domain.entity.enums.ComputerType;
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
public class Computer {
    UUID id;
    String computerName;
    Money price;
    ComputerType computerType;
    String description;
    String image;
    Integer tdp;
    ComputerCase computerCase;
    Gpu gpu;
    PowerSupply powerSupply;
    Cooler cooler;
    Cpu cpu;
    Motherboard motherboard;

}
