package com.onlinepcshop.adapters.rest.mapper;

import com.onlinepcshop.adapters.rest.dto.PcieInterfaceDto;
import com.onlinepcshop.core.domain.entity.PcieInterface;
import org.mapstruct.Mapper;
import org.mapstruct.factory.Mappers;

import java.util.List;

@Mapper
public interface PcieInterfaceMapperApi {
    PcieInterfaceMapperApi INSTANCE = Mappers.getMapper(PcieInterfaceMapperApi.class);

    PcieInterfaceDto pcieInterfaceToPcieInterfaceDto(PcieInterface pcieInterface);

    PcieInterface pcieInterfaceDtoToPcieInterface(PcieInterfaceDto pcieInterfaceDto);

    List<PcieInterfaceDto> pcieInterfaceListToPcieInterfaceDtoList(List<PcieInterface> pcieInterfaceList);

    List<PcieInterface> pcieInterfaceDtoListToPcieInterfaceList(List<PcieInterfaceDto> pcieInterfaceDtoList);
}
