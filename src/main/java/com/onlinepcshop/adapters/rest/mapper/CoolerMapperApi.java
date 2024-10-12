package com.onlinepcshop.adapters.rest.mapper;

import com.onlinepcshop.adapters.rest.dto.CoolerDto;
import com.onlinepcshop.core.domain.entity.Cooler;
import com.onlinepcshop.core.domain.value.Money;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.Named;
import org.mapstruct.factory.Mappers;

import java.math.BigDecimal;
import java.util.Currency;
import java.util.List;

@Mapper
public interface CoolerMapperApi {
    CoolerMapperApi INSTANCE = Mappers.getMapper(CoolerMapperApi.class);

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
    CoolerDto coolerToCoolerDto(Cooler cooler);

    @Named("mapToMoney")
    default Money mapToMoney(CoolerDto coolerDto) {
        return new Money(coolerDto.getPrice(), Currency.getInstance(coolerDto.getCurrency()));
    }

    @Mapping(target = "price", source = ".", qualifiedByName = "mapToMoney")
    @Mapping(source = "price", target = ".", ignore = true)
    @Mapping(source = "currency", target = ".", ignore = true)
    Cooler coolerDtoToCooler(CoolerDto coolerDto);

    List<CoolerDto> coolerListToCoolerDtoList(List<Cooler> coolerList);
    List<Cooler> coolerDtoListToCoolerList(List<CoolerDto> coolerDtoList);
}
