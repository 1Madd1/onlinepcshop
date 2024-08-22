package com.onlinepcshop.adapters.rest.dto;

import com.onlinepcshop.adapters.rest.dto.abstracts.ComponentDto;
import com.onlinepcshop.core.domain.entity.enums.Colors;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class PowerSupplyDto extends ComponentDto {
    String efficiencyRating;
    Integer wattage;
    String color;
}
