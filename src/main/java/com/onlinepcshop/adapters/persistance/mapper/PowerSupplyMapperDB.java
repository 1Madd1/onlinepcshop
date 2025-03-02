package com.onlinepcshop.adapters.persistance.mapper;

import com.onlinepcshop.adapters.persistance.dao.PowerSupplyDao;
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
public interface PowerSupplyMapperDB {

    PowerSupplyMapperDB INSTANCE = Mappers.getMapper(PowerSupplyMapperDB.class);

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

    @Mapping(target = "price", source = "price", qualifiedByName = "mapPriceToValue")
    @Mapping(target = "currency", source = "price", qualifiedByName = "mapPriceToCurrency")
    PowerSupplyDao powerSupplyToPowerSupplyDao(PowerSupply powerSupply);

    @Named("mapToMoney")
    default Money mapToMoney(PowerSupplyDao powerSupplyDao) {
        if (powerSupplyDao == null || powerSupplyDao.getPrice() == null || powerSupplyDao.getCurrency() == null) {
            return null;
        }
        return new Money(powerSupplyDao.getPrice(), Currency.getInstance(powerSupplyDao.getCurrency()));
    }

    @Mapping(target = "price", source = ".", qualifiedByName = "mapToMoney")
    @Mapping(source = "price", target = ".", ignore = true)
    @Mapping(source = "currency", target = ".", ignore = true)
    PowerSupply powerSupplyDaoToPowerSupply(PowerSupplyDao powerSupplyDao);

    List<PowerSupplyDao> powerSupplyListToPowerSupplyDaoList(List<PowerSupply> powerSupplyList);

    List<PowerSupply> powerSupplyDaoListToPowerSupplyList(List<PowerSupplyDao> powerSupplyDaoList);

}
