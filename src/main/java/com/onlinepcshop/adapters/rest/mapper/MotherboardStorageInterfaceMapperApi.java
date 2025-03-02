package com.onlinepcshop.adapters.rest.mapper;

import com.onlinepcshop.adapters.rest.dto.MotherboardStorageInterfaceDto;
import com.onlinepcshop.core.domain.entity.MotherboardStorageInterface;
import org.mapstruct.Mapper;
import org.mapstruct.factory.Mappers;

import java.util.List;

@Mapper
public interface MotherboardStorageInterfaceMapperApi {
    MotherboardStorageInterfaceMapperApi INSTANCE = Mappers.getMapper(MotherboardStorageInterfaceMapperApi.class);

    MotherboardStorageInterfaceDto motherboardStorageInterfaceToMotherboardStorageInterfaceDto(MotherboardStorageInterface motherboardStorageInterface);

    MotherboardStorageInterface motherboardStorageInterfaceDtoToMotherboardStorageInterface(MotherboardStorageInterfaceDto motherboardStorageInterfaceDto);

    List<MotherboardStorageInterfaceDto> motherboardStorageInterfaceListToMotherboardStorageInterfaceDtoList(List<MotherboardStorageInterface> motherboardStorageInterfaceList);

    List<MotherboardStorageInterface> motherboardStorageInterfaceDtoListToMotherboardStorageInterfaceList(List<MotherboardStorageInterfaceDto> motherboardStorageInterfaceDtoList);
}
