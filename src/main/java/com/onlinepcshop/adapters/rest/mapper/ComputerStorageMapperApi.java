package com.onlinepcshop.adapters.rest.mapper;

import com.onlinepcshop.adapters.rest.dto.ComputerStorageDto;
import com.onlinepcshop.core.domain.entity.ComputerStorage;
import org.mapstruct.Mapper;
import org.mapstruct.factory.Mappers;

import java.util.List;

@Mapper
public interface ComputerStorageMapperApi {
    ComputerStorageMapperApi INSTANCE = Mappers.getMapper(ComputerStorageMapperApi.class);

    ComputerStorageDto computerStorageToComputerStorageDto(ComputerStorage computerStorage);

    ComputerStorage computerStorageDtoToComputerStorage(ComputerStorageDto computerStorageDto);

    List<ComputerStorageDto> computerStorageListToComputerStorageDtoList(List<ComputerStorage> computerStorageList);
    List<ComputerStorage> computerStorageDtoListToComputerStorageList(List<ComputerStorageDto> computerStorageDtoList);
}
