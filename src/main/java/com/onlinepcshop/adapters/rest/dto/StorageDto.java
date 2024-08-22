package com.onlinepcshop.adapters.rest.dto;

import com.onlinepcshop.adapters.rest.dto.abstracts.ComponentDto;
import com.onlinepcshop.core.domain.entity.enums.StorageType;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class StorageDto extends ComponentDto {
    String storageType;
    Integer capacity;
    Integer tdp;
}
