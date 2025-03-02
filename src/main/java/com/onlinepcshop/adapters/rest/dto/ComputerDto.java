package com.onlinepcshop.adapters.rest.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.math.BigDecimal;
import java.time.LocalDate;
import java.util.UUID;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class ComputerDto {
    private UUID id;
    private String computerName;
    private Integer quantity;
    private BigDecimal price;
    private String currency;
    private String computerType;
    private String description;
    private String image;
    private Integer tdp;
    private String saleType;
    private Double avgRating;
    private LocalDate dateOfCreation;

    private UUID computerCaseId;
    private UUID gpuId;
    private UUID powerSupplyId;
    private UUID coolerId;
    private UUID cpuId;
    private UUID motherboardId;
}
