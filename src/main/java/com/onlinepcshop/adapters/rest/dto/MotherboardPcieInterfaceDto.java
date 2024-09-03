package com.onlinepcshop.adapters.rest.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.UUID;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class MotherboardPcieInterfaceDto {
    UUID id;
    UUID motherboardId;
    UUID pcieInterfaceId;
}
