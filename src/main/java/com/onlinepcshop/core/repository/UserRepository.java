package com.onlinepcshop.core.repository;

import com.onlinepcshop.core.domain.entity.User;

import java.util.List;
import java.util.Optional;
import java.util.UUID;

public interface UserRepository {
    List<User> findAllUsers();


    Optional<User> findById(UUID userId);

    Optional<User> findUserByEmail(String email);

    User saveUser(User user);

    void deleteUser(UUID id);

    Optional<User> findUserByPrincipalId(String principalId);
}
