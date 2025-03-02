package com.onlinepcshop.adapters.rest.mapper;

import com.onlinepcshop.adapters.rest.dto.StorageInterfaceDto;
import com.onlinepcshop.core.domain.entity.StorageInterface;
import org.mapstruct.Mapper;
import org.mapstruct.factory.Mappers;

import java.util.List;

@Mapper
public interface StorageInterfaceMapperApi {
    StorageInterfaceMapperApi INSTANCE = Mappers.getMapper(StorageInterfaceMapperApi.class);

    StorageInterfaceDto storageInterfaceToStorageInterfaceDto(StorageInterface storageInterface);

    StorageInterface storageInterfaceDtoToStorageInterface(StorageInterfaceDto storageInterfaceDto);

    List<StorageInterfaceDto> storageInterfaceListToStorageInterfaceDtoList(List<StorageInterface> storageInterfaceList);

    List<StorageInterface> storageInterfaceDtoListToStorageInterfaceList(List<StorageInterfaceDto> storageInterfaceDtoList);
}
