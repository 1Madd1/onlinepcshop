package com.onlinepcshop.adapters.rest.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.UUID;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class MotherboardStorageInterfaceDto {
    UUID id;
    UUID motherboardId;
    UUID storageInterfaceId;
}
