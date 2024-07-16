package com.onlinepcshop.adapters.persistance.mapper;

import com.onlinepcshop.adapters.persistance.dao.BrojTelefonaDao;
import com.onlinepcshop.core.domain.entity.BrojTelefona;
import org.mapstruct.Mapper;
import org.mapstruct.factory.Mappers;

import java.util.List;

@Mapper
public interface BrojTelefonaMapperDB {
    BrojTelefonaMapperDB INSTACE = Mappers.getMapper(BrojTelefonaMapperDB.class);

    BrojTelefonaDao brojTelefonaToBrojTelefonaDao(BrojTelefona brojTelefona);

    BrojTelefona brojTelefonaDaoToBrojTelefona(BrojTelefonaDao  brojTelefonaDao);

    List<BrojTelefonaDao> brojTelefonaListToBrojTelefonaDaoList(List<BrojTelefona> brojTelefonaList);
    List<BrojTelefona> brojTelefonaDaoListToBrojTelefonaList(List<BrojTelefonaDao> brojTelefonaDaoList);
}
