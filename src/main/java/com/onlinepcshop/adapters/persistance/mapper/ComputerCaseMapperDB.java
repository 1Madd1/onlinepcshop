package com.onlinepcshop.adapters.persistance.mapper;

import com.onlinepcshop.adapters.persistance.dao.CaseFanDao;
import com.onlinepcshop.adapters.persistance.dao.ComputerCaseDao;
import com.onlinepcshop.core.domain.entity.ComputerCase;
import com.onlinepcshop.core.domain.value.Money;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.Named;
import org.mapstruct.factory.Mappers;

import java.math.BigDecimal;
import java.util.Currency;
import java.util.List;

@Mapper
public interface ComputerCaseMapperDB {

    ComputerCaseMapperDB INSTANCE = Mappers.getMapper(ComputerCaseMapperDB.class);

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
    ComputerCaseDao computerCaseToComputerCaseDao(ComputerCase computerCase);

    @Named("mapToMoney")
    default Money mapToMoney(ComputerCaseDao computerCaseDao) {
        if (computerCaseDao == null || computerCaseDao.getPrice() == null || computerCaseDao.getCurrency() == null) {
            return null;
        }
        return new Money(computerCaseDao.getPrice(), Currency.getInstance(computerCaseDao.getCurrency()));
    }

    @Mapping(target = "price", source = ".", qualifiedByName = "mapToMoney")
    @Mapping(source = "price", target = ".", ignore = true)
    @Mapping(source = "currency", target = ".", ignore = true)
    ComputerCase computerCaseDaoToComputerCase(ComputerCaseDao computerCaseDao);

    List<ComputerCaseDao> computerCaseListToComputerCaseDaoList(List<ComputerCase> computerCaseList);

    List<ComputerCase> computerCaseDaoListToComputerCaseList(List<ComputerCaseDao> computerCaseDaoList);

}
