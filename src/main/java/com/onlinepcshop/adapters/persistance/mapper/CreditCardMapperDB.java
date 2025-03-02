package com.onlinepcshop.adapters.persistance.mapper;

import com.onlinepcshop.adapters.persistance.dao.CreditCardDao;
import com.onlinepcshop.core.domain.entity.CreditCard;
import org.mapstruct.Mapper;
import org.mapstruct.factory.Mappers;

import java.util.List;

@Mapper
public interface CreditCardMapperDB {
    CreditCardMapperDB INSTANCE = Mappers.getMapper(CreditCardMapperDB.class);

    CreditCardDao creditCardToCreditCardDao(CreditCard creditCard);

    CreditCard creditCardDaoToCreditCard(CreditCardDao creditCardDao);

    List<CreditCardDao> creditCardListToCreditCardDaoList(List<CreditCard> creditCardList);

    List<CreditCard> creditCardDaoListToCreditCardList(List<CreditCardDao> creditCardDaoList);
}
