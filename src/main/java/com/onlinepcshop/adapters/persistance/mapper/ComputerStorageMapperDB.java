package com.onlinepcshop.adapters.persistance.mapper;

import com.onlinepcshop.adapters.persistance.dao.ComputerStorageDao;
import com.onlinepcshop.core.domain.entity.ComputerStorage;
import org.mapstruct.Mapper;
import org.mapstruct.factory.Mappers;

import java.util.List;

@Mapper(uses = {ComputerMapperDB.class, StorageMapperDB.class})
public interface ComputerStorageMapperDB {

    ComputerStorageMapperDB INSTANCE = Mappers.getMapper(ComputerStorageMapperDB.class);

    ComputerStorageDao computerStorageToComputerStorageDao(ComputerStorage computerStorage);

    ComputerStorage computerStorageDaoToComputerStorage(ComputerStorageDao computerStorageDao);

    List<ComputerStorageDao> computerStorageListToComputerStorageDaoList(List<ComputerStorage> computerStorageList);
    List<ComputerStorage> computerStorageDaoListToComputerStorageList(List<ComputerStorageDao> computerStorageDaoList);

}
