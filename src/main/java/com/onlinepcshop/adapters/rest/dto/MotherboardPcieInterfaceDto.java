package com.onlinepcshop.adapters.rest.dto;

import com.onlinepcshop.adapters.rest.dto.abstracts.ComponentDto;
import com.onlinepcshop.core.domain.entity.Motherboard;
import com.onlinepcshop.core.domain.entity.PcieInterface;
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
