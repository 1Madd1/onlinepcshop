package com.onlinepcshop.adapters.persistance.mapper;

import com.onlinepcshop.adapters.persistance.dao.MotherboardPcieInterfaceDao;
import com.onlinepcshop.core.domain.entity.MotherboardPcieInterface;
import org.mapstruct.Mapper;
import org.mapstruct.factory.Mappers;

import java.util.List;

@Mapper(uses = MotherboardMapperDB.class)
public interface MotherboardPcieInterfaceMapperDB {

    MotherboardPcieInterfaceMapperDB INSTANCE = Mappers.getMapper(MotherboardPcieInterfaceMapperDB.class);

    MotherboardPcieInterfaceDao motherboardPcieInterfaceToMotherboardPcieInterfaceDao(MotherboardPcieInterface motherboardPcieInterface);

    MotherboardPcieInterface motherboardPcieInterfaceDaoToMotherboardPcieInterface(MotherboardPcieInterfaceDao motherboardPcieInterfaceDao);

    List<MotherboardPcieInterfaceDao> motherboardPcieInterfaceListToMotherboardPcieInterfaceDaoList(List<MotherboardPcieInterface> motherboardPcieInterfaceList);
    List<MotherboardPcieInterface> motherboardPcieInterfaceDaoListToMotherboardPcieInterfaceList(List<MotherboardPcieInterfaceDao> motherboardPcieInterfaceDaoList);

}
