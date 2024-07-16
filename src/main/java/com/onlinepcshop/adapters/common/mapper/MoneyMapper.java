package com.onlinepcshop.adapters.common.mapper;


import com.onlinepcshop.core.domain.value.Money;
import org.mapstruct.Mapper;
import org.mapstruct.Named;
import org.mapstruct.factory.Mappers;

import java.math.BigDecimal;

@Mapper
public interface MoneyMapper {
    MoneyMapper INSTANCE = Mappers.getMapper(MoneyMapper.class);

    @Named("mapMoneyToCurrency")
    default String mapMoneyToCurrency(Money dug) {
        return dug == null ? "RSD" : dug.getCurrency().getCurrencyCode();
    }

    @Named("mapMoneyToValue")
    default BigDecimal mapMoneyToValue(Money dug) {
        return dug == null ? BigDecimal.valueOf(0) : dug.getAmount();
    }

}
