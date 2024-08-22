package com.onlinepcshop.adapters.rest.dto;

import com.onlinepcshop.adapters.rest.dto.abstracts.ComponentDto;
import com.onlinepcshop.core.domain.entity.enums.MemoryType;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class RamDto extends ComponentDto {
    String memoryType;
    Integer ramSpeed;
    Integer ramStorage;
    Integer tdp;
}
