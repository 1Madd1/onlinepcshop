package com.onlinepcshop.adapters.rest.mapper;

import com.onlinepcshop.adapters.rest.dto.ComputerCaseDto;
import com.onlinepcshop.core.domain.entity.ComputerCase;
import com.onlinepcshop.core.domain.value.Money;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.Named;
import org.mapstruct.factory.Mappers;

import java.math.BigDecimal;
import java.util.Currency;
import java.util.List;

@Mapper
public interface ComputerCaseMapperApi {
    ComputerCaseMapperApi INSTANCE = Mappers.getMapper(ComputerCaseMapperApi.class);

    @Named("mapMoneyToCurrency")
    default String mapMoneyToCurrency(Money price) {
        return price.getCurrency().getCurrencyCode();
    }

    @Named("mapMoneyToValue")
    default BigDecimal mapMoneyToValue(Money price) {
        return price.getAmount();
    }

    @Mapping(target = "price", source = "price", qualifiedByName = "mapMoneyToValue")
    @Mapping(target = "currency", source = "price", qualifiedByName = "mapMoneyToCurrency")
    ComputerCaseDto computerCaseToComputerCaseDto(ComputerCase computerCase);

    @Named("mapToMoney")
    default Money mapToMoney(ComputerCaseDto computerCaseDto) {
        return new Money(computerCaseDto.getPrice(), Currency.getInstance(computerCaseDto.getCurrency()));
    }

    @Mapping(target = "price", source = ".", qualifiedByName = "mapToMoney")
    @Mapping(source = "price", target = ".", ignore = true)
    @Mapping(source = "currency", target = ".", ignore = true)
    ComputerCase computerCaseDtoToComputerCase(ComputerCaseDto computerCaseDto);

    List<ComputerCaseDto> computerCaseListToComputerCaseDtoList(List<ComputerCase> computerCaseList);

    List<ComputerCase> computerCaseDtoListToComputerCaseList(List<ComputerCaseDto> computerCaseDtoList);
}
