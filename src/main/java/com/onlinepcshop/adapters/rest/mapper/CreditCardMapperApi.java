package com.onlinepcshop.adapters.rest.mapper;

import com.onlinepcshop.adapters.rest.dto.CreditCardDto;
import com.onlinepcshop.core.domain.entity.CreditCard;
import org.mapstruct.Mapper;
import org.mapstruct.factory.Mappers;

import java.util.List;

@Mapper
public interface CreditCardMapperApi {
    CreditCardMapperApi INSTANCE = Mappers.getMapper(CreditCardMapperApi.class);

    CreditCardDto creditCardToCreditCardDto(CreditCard creditCard);

    CreditCard creditCardDtoToCreditCard(CreditCardDto creditCardDto);

    List<CreditCardDto> creditCardListToCreditCardDtoList(List<CreditCard> creditCardList);

    List<CreditCard> creditCardDtoListToCreditCardList(List<CreditCardDto> creditCardDtoList);
}
