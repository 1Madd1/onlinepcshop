package com.onlinepcshop.adapters.persistance.mapper;

import com.onlinepcshop.adapters.persistance.dao.MotherboardDao;
import com.onlinepcshop.core.domain.entity.Motherboard;
import com.onlinepcshop.core.domain.value.Money;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.Named;
import org.mapstruct.factory.Mappers;

import java.math.BigDecimal;
import java.util.Currency;
import java.util.List;

@Mapper
public interface MotherboardMapperDB {

    MotherboardMapperDB INSTANCE = Mappers.getMapper(MotherboardMapperDB.class);

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
    MotherboardDao motherboardToMotherboardDao(Motherboard motherboard);

    @Named("mapToMoney")
    default Money mapToMoney(MotherboardDao motherboardDao) {
        if (motherboardDao == null || motherboardDao.getPrice() == null || motherboardDao.getCurrency() == null) {
            return null;
        }
        return new Money(motherboardDao.getPrice(), Currency.getInstance(motherboardDao.getCurrency()));
    }

    @Mapping(target = "price", source = ".", qualifiedByName = "mapToMoney")
    @Mapping(source = "price", target = ".", ignore = true)
    @Mapping(source = "currency", target = ".", ignore = true)
    Motherboard motherboardDaoToMotherboard(MotherboardDao motherboardDao);

    List<MotherboardDao> motherboardListToMotherboardDaoList(List<Motherboard> motherboardList);
    List<Motherboard> motherboardDaoListToMotherboardList(List<MotherboardDao> motherboardDaoList);

}
