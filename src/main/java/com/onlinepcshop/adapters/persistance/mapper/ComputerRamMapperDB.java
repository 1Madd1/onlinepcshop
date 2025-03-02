package com.onlinepcshop.adapters.persistance.mapper;

import com.onlinepcshop.adapters.persistance.dao.ComputerRamDao;
import com.onlinepcshop.core.domain.entity.ComputerRam;
import org.mapstruct.Mapper;
import org.mapstruct.factory.Mappers;

import java.util.List;

@Mapper(uses = {ComputerMapperDB.class, RamMapperDB.class})
public interface ComputerRamMapperDB {

    ComputerRamMapperDB INSTANCE = Mappers.getMapper(ComputerRamMapperDB.class);

    ComputerRamDao computerRamToComputerRamDao(ComputerRam computerRam);

    ComputerRam computerRamDaoToComputerRam(ComputerRamDao computerRamDao);

    List<ComputerRamDao> computerRamListToComputerRamDaoList(List<ComputerRam> computerRamList);

    List<ComputerRam> computerRamDaoListToComputerRamList(List<ComputerRamDao> computerRamDaoList);

}
