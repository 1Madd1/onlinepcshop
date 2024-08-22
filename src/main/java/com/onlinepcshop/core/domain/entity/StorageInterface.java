package com.onlinepcshop.core.domain.entity;

import com.onlinepcshop.core.domain.entity.enums.StorageType;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.UUID;

@Builder
@Data
@AllArgsConstructor
@NoArgsConstructor
public class StorageInterface {
    UUID id;
    StorageType storageType;
}
