package com.onlinepcshop.adapters.persistance.mapper;

import com.onlinepcshop.adapters.persistance.dao.ComputerCaseFanDao;
import com.onlinepcshop.core.domain.entity.ComputerCaseFan;
import org.mapstruct.Mapper;
import org.mapstruct.factory.Mappers;

import java.util.List;

@Mapper(uses = {ComputerMapperDB.class, CaseFanMapperDB.class})
public interface ComputerCaseFanMapperDB {

    ComputerCaseFanMapperDB INSTANCE = Mappers.getMapper(ComputerCaseFanMapperDB.class);

    ComputerCaseFanDao computerCaseFanToComputerCaseFanDao(ComputerCaseFan computerCaseFan);

    ComputerCaseFan computerCaseFanDaoToComputerCaseFan(ComputerCaseFanDao computerCaseFanDao);

    List<ComputerCaseFanDao> computerCaseFanListToComputerCaseFanDaoList(List<ComputerCaseFan> computerCaseFanList);

    List<ComputerCaseFan> computerCaseFanDaoListToComputerCaseFanList(List<ComputerCaseFanDao> computerCaseFanDaoList);

}
