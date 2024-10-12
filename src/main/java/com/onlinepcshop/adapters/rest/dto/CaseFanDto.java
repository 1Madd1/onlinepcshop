package com.onlinepcshop.adapters.rest.dto;

import com.onlinepcshop.adapters.rest.dto.abstracts.ComponentDto;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class CaseFanDto extends ComponentDto {
    Integer fanSize;
    String color;
    String rpm;
    String noiseLevel;
    Integer tdp;
}
