//package com.onlinepcshop.adapters.persistance.mapper;
//
//import com.onlinepcshop.adapters.persistance.dao.ObracunDao;
//import com.onlinepcshop.core.domain.value.Money;
//import org.mapstruct.Mapper;
//import org.mapstruct.Mapping;
//import org.mapstruct.Named;
//import org.mapstruct.factory.Mappers;
//
//import java.math.BigDecimal;
//import java.util.Currency;
//import java.util.List;
//
//@Mapper(uses = PosebniDeoMapperDB.class)
//public interface ObracunMapperDB {
//    ObracunMapperDB INSTACE = Mappers.getMapper(ObracunMapperDB.class);
//
//    @Named("mapPrethodniDugToCurrency")
//    default String mapPrethodniDugToCurrency(Money dug) {
//        return dug.getCurrency().getCurrencyCode();
//    }
//
//    @Named("mapPrethodniDugToValue")
//    default BigDecimal mapPrethodniDugToValue(Money dug) {
//        return dug.getAmount();
//    }
//
//    @Mapping(target = "prethodniDug", source = "prethodniDug", qualifiedByName="mapPrethodniDugToValue")
//    @Mapping(target = "valuta", source = "prethodniDug", qualifiedByName="mapPrethodniDugToCurrency")
//    ObracunDao obracunToObracunDao(Obracun obracun);
//
//    @Named("mapToMoney")
//    default Money mapToMoney(ObracunDao obracun) {
//        return new Money(obracun.getPrethodniDug(), Currency.getInstance(obracun.getValuta()));
//    }
//
//    @Mapping(target = "prethodniDug", source = ".", qualifiedByName = "mapToMoney")
//    @Mapping(source = "prethodniDug", target = ".", ignore = true)
//    @Mapping(source = "valuta", target = ".", ignore = true)
//    Obracun obracunDaoToObracun(ObracunDao obracunDao);
//
//    List<ObracunDao> obracunListToObracunDaoList(List<Obracun> obracunList);
//    List<Obracun> obracunDaoListToObracunList(List<ObracunDao> obracunDaoList);
//}
