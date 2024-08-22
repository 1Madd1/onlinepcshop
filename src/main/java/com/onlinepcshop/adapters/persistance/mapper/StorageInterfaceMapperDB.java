package com.onlinepcshop.adapters.persistance.mapper;

import com.onlinepcshop.adapters.persistance.dao.StorageInterfaceDao;
import com.onlinepcshop.core.domain.entity.StorageInterface;
import org.mapstruct.Mapper;
import org.mapstruct.factory.Mappers;

import java.util.List;

@Mapper
public interface StorageInterfaceMapperDB {

    StorageInterfaceMapperDB INSTANCE = Mappers.getMapper(StorageInterfaceMapperDB.class);

    StorageInterfaceDao storageInterfaceToStorageInterfaceDao(StorageInterface storageInterface);

    StorageInterface storageInterfaceDaoToStorageInterface(StorageInterfaceDao storageInterfaceDao);

    List<StorageInterfaceDao> storageInterfaceListToStorageInterfaceDaoList(List<StorageInterface> storageInterfaceList);
    List<StorageInterface> storageInterfaceDaoListToStorageInterfaceList(List<StorageInterfaceDao> storageInterfaceDaoList);

}
