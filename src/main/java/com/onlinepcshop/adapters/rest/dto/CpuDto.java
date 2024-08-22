package com.onlinepcshop.adapters.rest.dto;

import com.onlinepcshop.adapters.rest.dto.abstracts.ComponentDto;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class CpuDto extends ComponentDto {
    String socketType;
    Integer coreCount;
    String performanceCoreClock;
    String performanceCoreBoostClock;
    Boolean includesCooler;
    Boolean includesIntegratedGpu;
    Integer tdp;
}
