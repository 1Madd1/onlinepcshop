package com.onlinepcshop.adapters.rest.mapper;

import com.onlinepcshop.adapters.rest.dto.StorageDto;
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
public interface StorageMapperApi {
    StorageMapperApi INSTANCE = Mappers.getMapper(StorageMapperApi.class);

    @Named("mapMoneyToCurrency")
    default String mapMoneyToCurrency(Money price) {
        return price.getCurrency().getCurrencyCode();
    }

    @Named("mapMoneyToValue")
    default BigDecimal mapMoneyToValue(Money price) {
        return price.getAmount();
    }

    @Mapping(target = "price", source = "price", qualifiedByName = "mapMoneyToValue")
    @Mapping(target = "currency", source = "price", qualifiedByName = "mapMoneyToCurrency")
    StorageDto storageToStorageDto(Storage storage);

    @Named("mapToMoney")
    default Money mapToMoney(StorageDto storageDto) {
        return new Money(storageDto.getPrice(), Currency.getInstance(storageDto.getCurrency()));
    }

    @Mapping(target = "price", source = ".", qualifiedByName = "mapToMoney")
    @Mapping(source = "price", target = ".", ignore = true)
    @Mapping(source = "currency", target = ".", ignore = true)
    Storage storageDtoToStorage(StorageDto storageDto);

    List<StorageDto> storageListToStorageDtoList(List<Storage> storageList);

    List<Storage> storageDtoListToStorageList(List<StorageDto> storageDtoList);
}
