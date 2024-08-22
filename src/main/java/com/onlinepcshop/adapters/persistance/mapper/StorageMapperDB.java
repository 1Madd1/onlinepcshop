package com.onlinepcshop.adapters.persistance.mapper;

import com.onlinepcshop.adapters.persistance.dao.StorageDao;
import com.onlinepcshop.core.domain.entity.Storage;
import com.onlinepcshop.core.domain.value.Money;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.Named;
import org.mapstruct.factory.Mappers;

import java.math.BigDecimal;
import java.util.Currency;
import java.util.List;

@Mapper
public interface StorageMapperDB {

    StorageMapperDB INSTANCE = Mappers.getMapper(StorageMapperDB.class);

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
    StorageDao storageToStorageDao(Storage storage);

    @Named("mapToMoney")
    default Money mapToMoney(StorageDao storageDao) {
        return new Money(storageDao.getPrice(), Currency.getInstance(storageDao.getCurrency()));
    }

    @Mapping(target = "price", source = ".", qualifiedByName = "mapToMoney")
    @Mapping(source = "price", target = ".", ignore = true)
    @Mapping(source = "currency", target = ".", ignore = true)
    Storage storageDaoToStorage(StorageDao storageDao);

    List<StorageDao> storageListToStorageDaoList(List<Storage> storageList);
    List<Storage> storageDaoListToStorageList(List<StorageDao> storageDaoList);

}
