package com.onlinepcshop.adapters.persistance.repository;

import com.onlinepcshop.adapters.persistance.dao.UserDao;
import com.onlinepcshop.adapters.persistance.mapper.UserMapperDB;
import com.onlinepcshop.adapters.persistance.repository.jpa.UserJpaRepository;
import com.onlinepcshop.core.domain.entity.User;
import com.onlinepcshop.core.repository.UserRepository;
import lombok.Builder;

import java.util.List;
import java.util.Optional;
import java.util.UUID;

@Builder
public class UserRepositoryImpl implements UserRepository {
    private UserJpaRepository userJpaRepository;
    @Override
    public List<User> findAllUsers() {
        return UserMapperDB.INSTANCE.userDaoListToUserList(userJpaRepository.findAll());
    }

    @Override
    public Optional<User> findById(UUID userId) {
        User user = UserMapperDB.INSTANCE.userDaoToUser(userJpaRepository.findById(userId).orElse(null));
        return Optional.ofNullable(user);
    }

    @Override
    public Optional<User> findUserByEmail(String email) {
        User user = UserMapperDB.INSTANCE.userDaoToUser(userJpaRepository.findByEmail(email).orElse(null));
        return Optional.ofNullable(user);
    }

    @Override
    public User saveUser(User user) {
        UserDao userDao = UserMapperDB.INSTANCE.userToUserDao(user);
        return UserMapperDB.INSTANCE.userDaoToUser(userJpaRepository.save(userDao));
    }

    @Override
    public void deleteUser(UUID id) {
        userJpaRepository.deleteById(id);
    }

    @Override
    public Optional<User> findUserByPrincipalId(String principalId) {
        User user = UserMapperDB.INSTANCE.userDaoToUser(userJpaRepository.findByPrincipalId(principalId).orElse(null));
        return Optional.ofNullable(user);
    }
}
