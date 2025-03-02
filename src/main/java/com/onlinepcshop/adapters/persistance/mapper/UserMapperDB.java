package com.onlinepcshop.adapters.persistance.mapper;

import com.onlinepcshop.adapters.persistance.dao.UserDao;
import com.onlinepcshop.core.domain.entity.User;
import org.mapstruct.Mapper;
import org.mapstruct.factory.Mappers;

import java.util.List;

@Mapper(uses = {CreditCardMapperDB.class})
public interface UserMapperDB {
    UserMapperDB INSTANCE = Mappers.getMapper(UserMapperDB.class);

    UserDao userToUserDao(User user);

    User userDaoToUser(UserDao userDao);

    List<UserDao> userListToUserDaoList(List<User> userList);

    List<User> userDaoListToUserList(List<UserDao> userDaoList);
}
