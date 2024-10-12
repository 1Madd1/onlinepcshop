package com.onlinepcshop.adapters.rest.mapper;

import com.onlinepcshop.adapters.rest.dto.ComputerCaseFanDto;
import com.onlinepcshop.core.domain.entity.ComputerCaseFan;
import org.mapstruct.Mapper;
import org.mapstruct.factory.Mappers;

import java.util.List;

@Mapper(uses = ComputerMapperApi.class)
public interface ComputerCaseFanMapperApi {
    ComputerCaseFanMapperApi INSTANCE = Mappers.getMapper(ComputerCaseFanMapperApi.class);

    ComputerCaseFanDto computerCaseFanToComputerCaseFanDto(ComputerCaseFan computerCaseFan);

    ComputerCaseFan computerCaseFanDtoToComputerCaseFan(ComputerCaseFanDto computerCaseFanDto);

    List<ComputerCaseFanDto> computerCaseFanListToComputerCaseFanDtoList(List<ComputerCaseFan> computerCaseFanList);
    List<ComputerCaseFan> computerCaseFanDtoListToComputerCaseFanList(List<ComputerCaseFanDto> computerCaseFanDtoList);
}
