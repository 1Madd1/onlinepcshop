package com.onlinepcshop.adapters.persistance.mapper;

import com.onlinepcshop.adapters.persistance.dao.PcieInterfaceDao;
import com.onlinepcshop.core.domain.entity.PcieInterface;
import org.mapstruct.Mapper;
import org.mapstruct.factory.Mappers;

import java.util.List;

@Mapper
public interface PcieInterfaceMapperDB {

    PcieInterfaceMapperDB INSTANCE = Mappers.getMapper(PcieInterfaceMapperDB.class);

    PcieInterfaceDao pcieInterfaceToPcieInterfaceDao(PcieInterface pcieInterface);

    PcieInterface pcieInterfaceDaoToPcieInterface(PcieInterfaceDao pcieInterfaceDao);

    List<PcieInterfaceDao> pcieInterfaceListToPcieInterfaceDaoList(List<PcieInterface> pcieInterfaceList);

    List<PcieInterface> pcieInterfaceDaoListToPcieInterfaceList(List<PcieInterfaceDao> pcieInterfaceDaoList);

}
