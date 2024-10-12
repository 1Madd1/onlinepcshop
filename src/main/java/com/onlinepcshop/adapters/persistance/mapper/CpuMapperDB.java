package com.onlinepcshop.adapters.persistance.mapper;

import com.onlinepcshop.adapters.persistance.dao.CpuDao;
import com.onlinepcshop.adapters.persistance.dao.GpuDao;
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
public interface CpuMapperDB {

    CpuMapperDB INSTANCE = Mappers.getMapper(CpuMapperDB.class);

    @Named("mapPriceToCurrency")
    default String mapPriceToCurrency(Money price) {
        if (price == null || price.getCurrency() == null) {
            return null;
        }
        return price.getCurrency().getCurrencyCode();
    }

    @Named("mapPriceToValue")
    default BigDecimal mapPriceToValue(Money price) {
        if (price == null) {
            return null;
        }
        return price.getAmount();
    }

    @Mapping(target = "price", source = "price", qualifiedByName="mapPriceToValue")
    @Mapping(target = "currency", source = "price", qualifiedByName="mapPriceToCurrency")
    CpuDao cpuToCpuDao(Cpu cpu);

    @Named("mapToMoney")
    default Money mapToMoney(CpuDao cpuDao) {
        if (cpuDao == null || cpuDao.getPrice() == null || cpuDao.getCurrency() == null) {
            return null;
        }
        return new Money(cpuDao.getPrice(), Currency.getInstance(cpuDao.getCurrency()));
    }

    @Mapping(target = "price", source = ".", qualifiedByName = "mapToMoney")
    @Mapping(source = "price", target = ".", ignore = true)
    @Mapping(source = "currency", target = ".", ignore = true)
    Cpu cpuDaoToCpu(CpuDao cpuDao);

    List<CpuDao> cpuListToCpuDaoList(List<Cpu> cpuList);
    List<Cpu> cpuDaoListToCpuList(List<CpuDao> cpuDaoList);

}
