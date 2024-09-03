package com.onlinepcshop.adapters.rest.dto;

import com.onlinepcshop.core.domain.entity.*;
import com.onlinepcshop.core.domain.entity.enums.ComputerType;
import com.onlinepcshop.core.domain.value.Money;
import jakarta.persistence.Column;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.math.BigDecimal;
import java.util.UUID;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class ComputerDto {
    private UUID id;
    private String computerName;
    private Integer quantity;
    private BigDecimal price;
    private String computerType;
    private String description;
    private String image;
    private Integer tdp;
    private String saleType;

    private UUID computerCaseId;
    private UUID gpuId;
    private UUID powerSupplyId;
    private UUID coolerId;
    private UUID cpuId;
    private UUID motherboardId;
}
