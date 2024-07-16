//package com.onlinepcshop.adapters.rest.mapper;
//
//import com.onlinepcshop.core.domain.value.Money;
//import org.mapstruct.Mapper;
//import org.mapstruct.Mapping;
//import org.mapstruct.Named;
//import org.mapstruct.factory.Mappers;
//
//import java.math.BigDecimal;
//import java.util.Currency;
//import java.util.List;
//import java.util.UUID;
//
//@Mapper
//public interface ObracunMapperApi {
//    ObracunMapperApi INSTACE = Mappers.getMapper(ObracunMapperApi.class);
//
//    @Named("mapMoneyToCurrency")
//    default String mapMoneyToCurrency(Money dug) {
//        return dug.getCurrency().getCurrencyCode();
//    }
//
//    @Named("mapMoneyToValue")
//    default BigDecimal mapMoneyToValue(Money dug) {
//        return dug.getAmount();
//    }
//
//    @Named("obracunskiPeriodToId")
//    default UUID obracunskiPeriodToId(ObracunskiPeriod op) {
//        return op.getId();
//    }
//
//    @Named("posebniDeoToId")
//    default UUID posebniDeoToId(PosebniDeo pd) {
//        return pd.getId();
//    }
//
//    @Mapping(target = "prethodniDug", source = "prethodniDug", qualifiedByName="mapMoneyToValue")
//    @Mapping(target = "valuta", source = "prethodniDug", qualifiedByName="mapMoneyToCurrency")
//    @Mapping(target = "obracunskiPeriodId", source = "obracunskiPeriod", qualifiedByName = "obracunskiPeriodToId")
//    @Mapping(target = "posebniDeoId", source = "posebniDeo", qualifiedByName = "posebniDeoToId")
//    ObracunDto obracunToObracunDto(Obracun obracun);
//
//    @Named("mapToMoney")
//    default Money mapToMoney(ObracunDto obracun) {
//        return new Money(obracun.getPrethodniDug(), Currency.getInstance(obracun.getValuta()));
//    }
//
//    @Named("idToObracunskiPeriod")
//    default ObracunskiPeriod idToObracunskiPeriod(UUID id) {
//        return ObracunskiPeriod.builder()
//            .id(id)
//            .build();
//    }
//
//    @Named("idToPosebniDeo")
//    default PosebniDeo idToPosebniDeo(UUID id) {
//        return PosebniDeo.builder()
//            .id(id)
//            .build();
//    }
//
//    @Mapping(target = "prethodniDug", source = ".", qualifiedByName = "mapToMoney")
//    @Mapping(source = "prethodniDug", target = ".", ignore = true)
//    @Mapping(source = "valuta", target = ".", ignore = true)
//    @Mapping(source = "obracunskiPeriodId", target = "obracunskiPeriod", qualifiedByName = "idToObracunskiPeriod")
//    @Mapping(source = "posebniDeoId", target = "posebniDeo", qualifiedByName = "idToPosebniDeo")
//    Obracun obracunDtoToObracun(ObracunDto obracunDto);
//
//    List<ObracunDto> obracunListToObracunDtoList(List<Obracun> obracunList);
//    List<Obracun> obracunDtoListToObracunList(List<ObracunDto> obracunDaoList);
//}
