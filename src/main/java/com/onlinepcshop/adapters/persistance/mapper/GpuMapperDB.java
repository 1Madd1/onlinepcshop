package com.onlinepcshop.adapters.persistance.mapper;

import com.onlinepcshop.adapters.persistance.dao.GpuDao;
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
public interface GpuMapperDB {

    GpuMapperDB INSTANCE = Mappers.getMapper(GpuMapperDB.class);

    @Named("mapPriceToCurrency")
    default String mapPriceToCurrency(Money price) {
        return price.getCurrency().getCurrencyCode();
    }

    @Named("mapPriceToValue")
    default BigDecimal mapPriceToValue(Money price) {
        return price.getAmount();
    }

    @Mapping(target = "price", source = "price", qualifiedByName="mapPriceToValue")
    @Mapping(target = "currency", source = "price", qualifiedByName="mapPriceToCurrency")
    GpuDao gpuToGpuDao(Gpu gpu);

    @Named("mapToMoney")
    default Money mapToMoney(GpuDao gpuDao) {
        return new Money(gpuDao.getPrice(), Currency.getInstance(gpuDao.getCurrency()));
    }

    @Mapping(target = "price", source = ".", qualifiedByName = "mapToMoney")
    @Mapping(source = "price", target = ".", ignore = true)
    @Mapping(source = "currency", target = ".", ignore = true)
    Gpu gpuDaoToGpu(GpuDao gpuDao);

    List<GpuDao> gpuListToGpuDaoList(List<Gpu> gpuList);
    List<Gpu> gpuDaoListToGpuList(List<GpuDao> gpuDaoList);

}
