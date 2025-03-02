package com.onlinepcshop.adapters.persistance.mapper;

import com.onlinepcshop.adapters.persistance.dao.CoolerDao;
import com.onlinepcshop.core.domain.entity.Cooler;
import com.onlinepcshop.core.domain.value.Money;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.Named;
import org.mapstruct.factory.Mappers;

import java.math.BigDecimal;
import java.util.Currency;
import java.util.List;

@Mapper
public interface CoolerMapperDB {

    CoolerMapperDB INSTANCE = Mappers.getMapper(CoolerMapperDB.class);

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
    CoolerDao coolerToCoolerDao(Cooler cooler);

    @Named("mapToMoney")
    default Money mapToMoney(CoolerDao coolerDao) {
        if (coolerDao == null || coolerDao.getPrice() == null || coolerDao.getCurrency() == null) {
            return null;
        }
        return new Money(coolerDao.getPrice(), Currency.getInstance(coolerDao.getCurrency()));
    }

    @Mapping(target = "price", source = ".", qualifiedByName = "mapToMoney")
    @Mapping(source = "price", target = ".", ignore = true)
    @Mapping(source = "currency", target = ".", ignore = true)
    Cooler coolerDaoToCooler(CoolerDao coolerDao);

    List<CoolerDao> coolerListToCoolerDaoList(List<Cooler> coolerList);

    List<Cooler> coolerDaoListToCoolerList(List<CoolerDao> coolerDaoList);

}
