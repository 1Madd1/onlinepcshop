package com.onlinepcshop.adapters.rest.mapper;

import com.onlinepcshop.adapters.rest.dto.MotherboardDto;
import com.onlinepcshop.core.domain.entity.Motherboard;
import com.onlinepcshop.core.domain.value.Money;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.Named;
import org.mapstruct.factory.Mappers;

import java.math.BigDecimal;
import java.util.Currency;
import java.util.List;

@Mapper
public interface MotherboardMapperApi {
    MotherboardMapperApi INSTANCE = Mappers.getMapper(MotherboardMapperApi.class);

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
    MotherboardDto motherboardToMotherboardDto(Motherboard motherboard);

    @Named("mapToMoney")
    default Money mapToMoney(MotherboardDto motherboardDto) {
        return new Money(motherboardDto.getPrice(), Currency.getInstance(motherboardDto.getCurrency()));
    }

    @Mapping(target = "price", source = ".", qualifiedByName = "mapToMoney")
    @Mapping(source = "price", target = ".", ignore = true)
    @Mapping(source = "currency", target = ".", ignore = true)
    Motherboard motherboardDtoToMotherboard(MotherboardDto motherboardDto);

    List<MotherboardDto> motherboardListToMotherboardDtoList(List<Motherboard> motherboardList);
    List<Motherboard> motherboardDtoListToMotherboardList(List<MotherboardDto> motherboardDtoList);
}
