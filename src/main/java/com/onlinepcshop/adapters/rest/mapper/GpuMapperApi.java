package com.onlinepcshop.adapters.rest.mapper;

import com.onlinepcshop.adapters.rest.dto.GpuDto;
import com.onlinepcshop.core.domain.entity.Gpu;
import com.onlinepcshop.core.domain.value.Money;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.Named;
import org.mapstruct.factory.Mappers;

import java.math.BigDecimal;
import java.util.Currency;
import java.util.List;

@Mapper
public interface GpuMapperApi {
    GpuMapperApi INSTANCE = Mappers.getMapper(GpuMapperApi.class);

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
    GpuDto gpuToGpuDto(Gpu gpu);

    @Named("mapToMoney")
    default Money mapToMoney(GpuDto gpuDto) {
        return new Money(gpuDto.getPrice(), Currency.getInstance(gpuDto.getCurrency()));
    }

    @Mapping(target = "price", source = ".", qualifiedByName = "mapToMoney")
    @Mapping(source = "price", target = ".", ignore = true)
    @Mapping(source = "currency", target = ".", ignore = true)
    Gpu gpuDtoToGpu(GpuDto gpuDto);

    List<GpuDto> gpuListToGpuDtoList(List<Gpu> gpuList);
    List<Gpu> gpuDtoListToGpuList(List<GpuDto> gpuDtoList);
}
