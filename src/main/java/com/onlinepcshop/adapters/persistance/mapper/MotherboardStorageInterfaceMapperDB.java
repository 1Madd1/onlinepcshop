package com.onlinepcshop.adapters.persistance.mapper;

import com.onlinepcshop.adapters.persistance.dao.MotherboardStorageInterfaceDao;
import com.onlinepcshop.core.domain.entity.MotherboardStorageInterface;
import org.mapstruct.Mapper;
import org.mapstruct.factory.Mappers;

import java.util.List;

@Mapper(uses = MotherboardMapperDB.class)
public interface MotherboardStorageInterfaceMapperDB {

    MotherboardStorageInterfaceMapperDB INSTANCE = Mappers.getMapper(MotherboardStorageInterfaceMapperDB.class);

    MotherboardStorageInterfaceDao motherboardStorageInterfaceToMotherboardStorageInterfaceDao(MotherboardStorageInterface motherboardStorageInterface);

    MotherboardStorageInterface motherboardStorageInterfaceDaoToMotherboardStorageInterface(MotherboardStorageInterfaceDao motherboardStorageInterfaceDao);

    List<MotherboardStorageInterfaceDao> motherboardStorageInterfaceListToMotherboardStorageInterfaceDaoList(List<MotherboardStorageInterface> motherboardStorageInterfaceList);
    List<MotherboardStorageInterface> motherboardStorageInterfaceDaoListToMotherboardStorageInterfaceList(List<MotherboardStorageInterfaceDao> motherboardStorageInterfaceDaoList);

}
