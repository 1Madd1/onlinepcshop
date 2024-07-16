package com.onlinepcshop.adapters.rest.mapper;

import com.onlinepcshop.adapters.rest.dto.BrojTelefonaDto;
import com.onlinepcshop.core.domain.entity.BrojTelefona;
import com.onlinepcshop.core.domain.entity.Vlasnik;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.Named;
import org.mapstruct.factory.Mappers;

import java.util.List;
import java.util.UUID;

@Mapper
public interface BrojTelefonaMapperApi {
    BrojTelefonaMapperApi INSTANCE = Mappers.getMapper(BrojTelefonaMapperApi.class);

    @Named("vlasnikToVlasnikId")
    default UUID vlasnikToVlasnikId(Vlasnik vlasnik) {
        return vlasnik == null ? null : vlasnik.getId();
    }

    @Named("vlasnikIdToVlasnik")
    default Vlasnik vlasnikIdToVlasnik(UUID vlasnikID) {
        return Vlasnik.builder()
                .id(vlasnikID)
                .build();
    }

    @Mapping(source = "vlasnik", target = "vlasnik", qualifiedByName = "vlasnikToVlasnikId")
    BrojTelefonaDto brojTelefonaToBrojTelefonaDto(BrojTelefona brojTelefona);

    @Mapping(source = "vlasnik", target = "vlasnik", qualifiedByName = "vlasnikIdToVlasnik")
    BrojTelefona brojTelefonaDtoToBrojTelefona(BrojTelefonaDto  brojTelefonaDto);

    List<BrojTelefonaDto> brojTelefonaListToBrojTelefonaDtoList(List<BrojTelefona> brojTelefonaList);
    List<BrojTelefona> brojTelefonaDtoListToBrojTelefonaList(List<BrojTelefonaDto> brojTelefonaDtoList);
}
