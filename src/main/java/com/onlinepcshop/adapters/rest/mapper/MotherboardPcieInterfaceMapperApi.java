package com.onlinepcshop.adapters.rest.mapper;

import com.onlinepcshop.adapters.rest.dto.MotherboardPcieInterfaceDto;
import com.onlinepcshop.core.domain.entity.MotherboardPcieInterface;
import org.mapstruct.Mapper;
import org.mapstruct.factory.Mappers;

import java.util.List;

@Mapper
public interface MotherboardPcieInterfaceMapperApi {
    MotherboardPcieInterfaceMapperApi INSTANCE = Mappers.getMapper(MotherboardPcieInterfaceMapperApi.class);

    MotherboardPcieInterfaceDto motherboardPcieInterfaceToMotherboardPcieInterfaceDto(MotherboardPcieInterface motherboardPcieInterface);

    MotherboardPcieInterface motherboardPcieInterfaceDtoToMotherboardPcieInterface(MotherboardPcieInterfaceDto motherboardPcieInterfaceDto);

    List<MotherboardPcieInterfaceDto> motherboardPcieInterfaceListToMotherboardPcieInterfaceDtoList(List<MotherboardPcieInterface> motherboardPcieInterfaceList);
    List<MotherboardPcieInterface> motherboardPcieInterfaceDtoListToMotherboardPcieInterfaceList(List<MotherboardPcieInterfaceDto> motherboardPcieInterfaceDtoList);
}
