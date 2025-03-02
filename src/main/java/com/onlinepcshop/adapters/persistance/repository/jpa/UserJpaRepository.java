package com.onlinepcshop.adapters.persistance.repository.jpa;

import com.onlinepcshop.adapters.persistance.dao.UserDao;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;
import java.util.UUID;

public interface UserJpaRepository extends JpaRepository<UserDao, UUID> {
    Optional<UserDao> findByEmail(String email);

    Optional<UserDao> findByPrincipalId(String principalId);
}
