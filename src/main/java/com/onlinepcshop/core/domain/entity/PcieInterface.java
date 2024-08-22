package com.onlinepcshop.core.domain.entity;

import com.onlinepcshop.core.domain.entity.enums.PcieType;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.UUID;

@Builder
@Data
@AllArgsConstructor
@NoArgsConstructor
public class PcieInterface {
    UUID id;
    PcieType pcieType;
}
