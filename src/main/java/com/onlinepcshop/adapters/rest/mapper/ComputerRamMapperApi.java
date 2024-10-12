package com.onlinepcshop.adapters.rest.mapper;

import com.onlinepcshop.adapters.rest.dto.ComputerRamDto;
import com.onlinepcshop.core.domain.entity.ComputerRam;
import org.mapstruct.Mapper;
import org.mapstruct.factory.Mappers;

import java.util.List;

@Mapper(uses = ComputerMapperApi.class)
public interface ComputerRamMapperApi {
    ComputerRamMapperApi INSTANCE = Mappers.getMapper(ComputerRamMapperApi.class);

    ComputerRamDto computerRamToComputerRamDto(ComputerRam computerRam);

    ComputerRam computerRamDtoToComputerRam(ComputerRamDto computerRamDto);

    List<ComputerRamDto> computerRamListToComputerRamDtoList(List<ComputerRam> computerRamList);
    List<ComputerRam> computerRamDtoListToComputerRamList(List<ComputerRamDto> computerRamDtoList);
}
