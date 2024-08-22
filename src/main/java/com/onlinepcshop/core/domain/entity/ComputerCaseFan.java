package com.onlinepcshop.core.domain.entity;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.UUID;

@Builder
@Data
@AllArgsConstructor
@NoArgsConstructor
public class ComputerCaseFan {
    UUID id;
    Computer computer;
    CaseFan caseFan;
    Integer quantity;
}
