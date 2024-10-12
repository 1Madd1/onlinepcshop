package com.onlinepcshop.adapters.persistance.mapper;

import com.onlinepcshop.adapters.persistance.dao.CaseFanDao;
import com.onlinepcshop.adapters.persistance.dao.CoolerDao;
import com.onlinepcshop.core.domain.entity.CaseFan;
import com.onlinepcshop.core.domain.value.Money;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.Named;
import org.mapstruct.factory.Mappers;

import java.math.BigDecimal;
import java.util.Currency;
import java.util.List;

@Mapper
public interface CaseFanMapperDB {
    CaseFanMapperDB INSTANCE = Mappers.getMapper(CaseFanMapperDB.class);

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
    CaseFanDao caseFanToCaseFanDao(CaseFan caseFan);

    @Named("mapToMoney")
    default Money mapToMoney(CaseFanDao caseFanDao) {
        if (caseFanDao == null || caseFanDao.getPrice() == null || caseFanDao.getCurrency() == null) {
            return null;
        }
        return new Money(caseFanDao.getPrice(), Currency.getInstance(caseFanDao.getCurrency()));
    }

    @Mapping(target = "price", source = ".", qualifiedByName = "mapToMoney")
    @Mapping(source = "price", target = ".", ignore = true)
    @Mapping(source = "currency", target = ".", ignore = true)
    CaseFan caseFanDaoToCaseFan(CaseFanDao caseFanDao);

    List<CaseFanDao> caseFanListToCaseFanDaoList(List<CaseFan> caseFanList);
    List<CaseFan> caseFanDaoListToCaseFanList(List<CaseFanDao> caseFanDaoList);
}
