package com.onlinepcshop.adapters.rest.mapper;

import com.onlinepcshop.adapters.rest.dto.CaseFanDto;
import com.onlinepcshop.core.domain.entity.CaseFan;
import com.onlinepcshop.core.domain.value.Money;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.Named;
import org.mapstruct.factory.Mappers;

import java.math.BigDecimal;
import java.util.Currency;
import java.util.List;

@Mapper
public interface CaseFanMapperApi {
    CaseFanMapperApi INSTANCE = Mappers.getMapper(CaseFanMapperApi.class);

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
    CaseFanDto caseFanToCaseFanDto(CaseFan caseFan);

    @Named("mapToMoney")
    default Money mapToMoney(CaseFanDto caseFanDto) {
        return new Money(caseFanDto.getPrice(), Currency.getInstance(caseFanDto.getCurrency()));
    }

    @Mapping(target = "price", source = ".", qualifiedByName = "mapToMoney")
    @Mapping(source = "price", target = ".", ignore = true)
    @Mapping(source = "currency", target = ".", ignore = true)
    CaseFan caseFanDtoToCaseFan(CaseFanDto caseFanDto);

    List<CaseFanDto> caseFanListToCaseFanDtoList(List<CaseFan> caseFanList);
    List<CaseFan> caseFanDtoListToCaseFanList(List<CaseFanDto> caseFanDtoList);
}
