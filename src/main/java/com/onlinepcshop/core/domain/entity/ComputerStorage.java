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
public class ComputerStorage {
    UUID id;
    Computer computer;
    Storage storage;
    Integer quantity;
}
