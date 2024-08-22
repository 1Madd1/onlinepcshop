package com.onlinepcshop.adapters.persistance.mapper;

import com.onlinepcshop.adapters.persistance.dao.ComputerDao;
import com.onlinepcshop.core.domain.entity.Computer;
import com.onlinepcshop.core.domain.value.Money;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.Named;
import org.mapstruct.factory.Mappers;

import java.math.BigDecimal;
import java.util.Currency;
import java.util.List;

@Mapper(uses = {MotherboardMapperDB.class, ComputerCaseMapperDB.class, CpuMapperDB.class,
        GpuMapperDB.class, PowerSupplyMapperDB.class, CoolerMapperDB.class
})
public interface ComputerMapperDB {

    ComputerMapperDB INSTANCE = Mappers.getMapper(ComputerMapperDB.class);

    @Named("mapComputerPriceToCurrency")
    default String mapPriceToCurrency(Money price) {
        return price.getCurrency().getCurrencyCode();
    }

    @Named("mapComputerPriceToValue")
    default BigDecimal mapPriceToValue(Money price) {
        return price.getAmount();
    }

    @Mapping(target = "price", source = "price", qualifiedByName="mapComputerPriceToValue")
    @Mapping(target = "currency", source = "price", qualifiedByName="mapComputerPriceToCurrency")
    ComputerDao computerToComputerDao(Computer computer);

    @Named("mapComputerToMoney")
    default Money mapToMoney(ComputerDao computerDao) {
        return new Money(computerDao.getPrice(), Currency.getInstance(computerDao.getCurrency()));
    }

    @Mapping(target = "price", source = ".", qualifiedByName = "mapComputerToMoney")
    @Mapping(source = "price", target = ".", ignore = true)
    @Mapping(source = "currency", target = ".", ignore = true)
    Computer computerDaoToComputer(ComputerDao computerDao);

    List<ComputerDao> computerListToComputerDaoList(List<Computer> computerList);
    List<Computer> computerDaoListToComputerList(List<ComputerDao> computerDaoList);

}
