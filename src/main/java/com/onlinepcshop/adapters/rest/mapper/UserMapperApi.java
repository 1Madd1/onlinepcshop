package com.onlinepcshop.adapters.rest.mapper;

import com.onlinepcshop.adapters.rest.dto.UserDto;
import com.onlinepcshop.core.domain.entity.User;
import org.mapstruct.Mapper;
import org.mapstruct.factory.Mappers;

import java.util.List;

@Mapper
public interface UserMapperApi {
    UserMapperApi INSTANCE = Mappers.getMapper(UserMapperApi.class);

    UserDto userToUserDto(User user);

    User userDtoToUser(UserDto userDto);

    List<UserDto> userListToUserDtoList(List<User> userList);
    List<User> userDtoListToUserList(List<UserDto> userDtoList);
}
