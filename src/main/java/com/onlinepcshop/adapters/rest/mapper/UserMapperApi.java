package com.onlinepcshop.adapters.rest.mapper;

import com.onlinepcshop.adapters.rest.dto.UserDto;
import com.onlinepcshop.core.domain.entity.CreditCard;
import com.onlinepcshop.core.domain.entity.User;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.Named;
import org.mapstruct.factory.Mappers;

import java.util.List;
import java.util.UUID;

@Mapper
public interface UserMapperApi {

    @Named("mapCreditCardToId")
    default UUID mapCreditCardToId(CreditCard creditCard) {
        return creditCard == null ? null : creditCard.getId();
    }

    UserMapperApi INSTANCE = Mappers.getMapper(UserMapperApi.class);

    @Mapping(source = "creditCard", target = "creditCardId", qualifiedByName = "mapCreditCardToId")
    UserDto userToUserDto(User user);

    @Named("mapIdToCreditCard")
    default CreditCard mapIdToCreditCard(UUID creditCardId) {
        return creditCardId == null ? null : CreditCard.builder()
                .id(creditCardId)
                .build();
    }

    @Mapping(source = "creditCardId", target = "creditCard", qualifiedByName = "mapIdToCreditCard")
    User userDtoToUser(UserDto userDto);

    List<UserDto> userListToUserDtoList(List<User> userList);

    List<User> userDtoListToUserList(List<UserDto> userDtoList);
}
