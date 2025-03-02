package com.onlinepcshop.adapters.rest.mapper;

import com.onlinepcshop.adapters.rest.dto.PowerSupplyDto;
import com.onlinepcshop.core.domain.entity.PowerSupply;
import com.onlinepcshop.core.domain.value.Money;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.Named;
import org.mapstruct.factory.Mappers;

import java.math.BigDecimal;
import java.util.Currency;
import java.util.List;

@Mapper
public interface PowerSupplyMapperApi {
    PowerSupplyMapperApi INSTANCE = Mappers.getMapper(PowerSupplyMapperApi.class);

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
    PowerSupplyDto powerSupplyToPowerSupplyDto(PowerSupply powerSupply);

    @Named("mapToMoney")
    default Money mapToMoney(PowerSupplyDto powerSupplyDto) {
        return new Money(powerSupplyDto.getPrice(), Currency.getInstance(powerSupplyDto.getCurrency()));
    }

    @Mapping(target = "price", source = ".", qualifiedByName = "mapToMoney")
    @Mapping(source = "price", target = ".", ignore = true)
    @Mapping(source = "currency", target = ".", ignore = true)
    PowerSupply powerSupplyDtoToPowerSupply(PowerSupplyDto powerSupplyDto);

    List<PowerSupplyDto> powerSupplyListToPowerSupplyDtoList(List<PowerSupply> powerSupplyList);

    List<PowerSupply> powerSupplyDtoListToPowerSupplyList(List<PowerSupplyDto> powerSupplyDtoList);
}
