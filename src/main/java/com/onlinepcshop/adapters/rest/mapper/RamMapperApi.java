package com.onlinepcshop.adapters.rest.mapper;

import com.onlinepcshop.adapters.rest.dto.RamDto;
import com.onlinepcshop.core.domain.entity.Ram;
import com.onlinepcshop.core.domain.value.Money;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.Named;
import org.mapstruct.factory.Mappers;

import java.math.BigDecimal;
import java.util.Currency;
import java.util.List;

@Mapper
public interface RamMapperApi {
    RamMapperApi INSTANCE = Mappers.getMapper(RamMapperApi.class);

    @Named("mapMoneyToCurrency")
    default String mapMoneyToCurrency(Money price) {
        return price.getCurrency().getCurrencyCode();
    }

    @Named("mapMoneyToValue")
    default BigDecimal mapMoneyToValue(Money price) {
        return price.getAmount();
    }

    @Mapping(target = "price", source = "price", qualifiedByName="mapMoneyToValue")
    @Mapping(target = "currency", source = "price", qualifiedByName="mapMoneyToCurrency")
    RamDto ramToRamDto(Ram ram);

    @Named("mapToMoney")
    default Money mapToMoney(RamDto ramDto) {
        return new Money(ramDto.getPrice(), Currency.getInstance(ramDto.getCurrency()));
    }

    @Mapping(target = "price", source = ".", qualifiedByName = "mapToMoney")
    @Mapping(source = "price", target = ".", ignore = true)
    @Mapping(source = "currency", target = ".", ignore = true)
    Ram ramDtoToRam(RamDto ramDto);

    List<RamDto> ramListToRamDtoList(List<Ram> ramList);
    List<Ram> ramDtoListToRamList(List<RamDto> ramDtoList);
}
