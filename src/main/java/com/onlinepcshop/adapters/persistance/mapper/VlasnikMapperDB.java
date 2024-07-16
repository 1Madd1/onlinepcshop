package com.onlinepcshop.adapters.persistance.mapper;

import com.onlinepcshop.adapters.persistance.dao.VlasnikDao;
import com.onlinepcshop.core.domain.entity.Vlasnik;
import org.mapstruct.Mapper;
import org.mapstruct.factory.Mappers;

import java.util.List;

@Mapper
public interface VlasnikMapperDB {
    VlasnikMapperDB INSTACE = Mappers.getMapper(VlasnikMapperDB.class);

    VlasnikDao vlasnikToVlasnikDao(Vlasnik vlasnik);

    Vlasnik vlasnikDaoToVlasnik(VlasnikDao  vlasnikDao);

    List<VlasnikDao> vlasnikListToVlasnikDaoList(List<Vlasnik> vlasnikList);
    List<Vlasnik> vlasnikDaoListToVlasnikList(List<VlasnikDao> vlasnikDaoList);
}
