package com.onlinepcshop.adapters.rest.dto;

import com.onlinepcshop.adapters.rest.dto.abstracts.ComponentDto;
import com.onlinepcshop.core.domain.entity.enums.MemoryType;
import com.onlinepcshop.core.domain.entity.enums.SocketType;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class MotherboardDto extends ComponentDto {
    String socketType;
    String memoryType;
    Integer tdp;
}
