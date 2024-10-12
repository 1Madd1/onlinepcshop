package com.onlinepcshop.adapters.persistance.mapper;

import com.onlinepcshop.adapters.persistance.dao.MotherboardDao;
import com.onlinepcshop.adapters.persistance.dao.RamDao;
import com.onlinepcshop.core.domain.entity.Ram;
import com.onlinepcshop.core.domain.value.Money;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.Named;
import org.mapstruct.factory.Mappers;

import java.math.BigDecimal;
import java.util.Currency;
import java.util.List;

@Mapper
public interface RamMapperDB {

    RamMapperDB INSTANCE = Mappers.getMapper(RamMapperDB.class);

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
    RamDao ramToRamDao(Ram ram);

    @Named("mapToMoney")
    default Money mapToMoney(RamDao ramDao) {
        if (ramDao == null || ramDao.getPrice() == null || ramDao.getCurrency() == null) {
            return null;
        }
        return new Money(ramDao.getPrice(), Currency.getInstance(ramDao.getCurrency()));
    }

    @Mapping(target = "price", source = ".", qualifiedByName = "mapToMoney")
    @Mapping(source = "price", target = ".", ignore = true)
    @Mapping(source = "currency", target = ".", ignore = true)
    Ram ramDaoToRam(RamDao ramDao);

    List<RamDao> ramListToRamDaoList(List<Ram> ramList);
    List<Ram> ramDaoListToRamList(List<RamDao> ramDaoList);

}
