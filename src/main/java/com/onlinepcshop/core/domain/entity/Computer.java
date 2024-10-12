package com.onlinepcshop.core.domain.entity;

import com.onlinepcshop.core.domain.entity.enums.ComputerType;
import com.onlinepcshop.core.domain.entity.enums.SaleType;
import com.onlinepcshop.core.domain.value.Money;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.Objects;
import java.util.UUID;

@Builder
@Data
@AllArgsConstructor
@NoArgsConstructor
public class Computer {
    UUID id;
    String computerName;
    Integer quantity;
    Money price;
    ComputerType computerType;
    String description;
    String image;
    Integer tdp;
    SaleType saleType;
    Boolean purchased;
    ComputerCase computerCase;
    Gpu gpu;
    PowerSupply powerSupply;
    Cooler cooler;
    Cpu cpu;
    Motherboard motherboard;

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Computer computer = (Computer) o;
        return getComputerType() == computer.getComputerType() &&
                Objects.equals(getComputerCase().getId(), computer.getComputerCase().getId()) &&
                Objects.equals(getGpu().getId(), computer.getGpu().getId()) &&
                Objects.equals(getPowerSupply().getId(), computer.getPowerSupply().getId()) &&
                Objects.equals(getCooler().getId(), computer.getCooler().getId()) &&
                Objects.equals(getCpu().getId(), computer.getCpu().getId()) &&
                Objects.equals(getMotherboard().getId(), computer.getMotherboard().getId());
    }

    @Override
    public int hashCode() {
        return Objects.hash(
                getComputerType(),
                getComputerCase().getId(),
                getGpu().getId(),
                getPowerSupply().getId(),
                getCooler().getId(),
                getCpu().getId(),
                getMotherboard().getId()
        );
    }
}
