package com.onlinepcshop.adapters.rest.mapper;

import com.onlinepcshop.adapters.rest.dto.CpuDto;
import com.onlinepcshop.core.domain.entity.Cpu;
import com.onlinepcshop.core.domain.value.Money;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.Named;
import org.mapstruct.factory.Mappers;

import java.math.BigDecimal;
import java.util.Currency;
import java.util.List;

@Mapper
public interface CpuMapperApi {
    CpuMapperApi INSTANCE = Mappers.getMapper(CpuMapperApi.class);

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
    CpuDto cpuToCpuDto(Cpu cpu);

    @Named("mapToMoney")
    default Money mapToMoney(CpuDto cpuDto) {
        return new Money(cpuDto.getPrice(), Currency.getInstance(cpuDto.getCurrency()));
    }

    @Mapping(target = "price", source = ".", qualifiedByName = "mapToMoney")
    @Mapping(source = "price", target = ".", ignore = true)
    @Mapping(source = "currency", target = ".", ignore = true)
    Cpu cpuDtoToCpu(CpuDto cpuDto);

    List<CpuDto> cpuListToCpuDtoList(List<Cpu> cpuList);

    List<Cpu> cpuDtoListToCpuList(List<CpuDto> cpuDtoList);
}
