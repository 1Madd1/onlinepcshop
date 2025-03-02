package com.onlinepcshop.core.usecase.impl;

import com.onlinepcshop.core.domain.entity.User;
import com.onlinepcshop.core.repository.UserRepository;
import com.onlinepcshop.core.security.Role;
import com.onlinepcshop.core.security.SecurityProvider;
import com.onlinepcshop.core.usecase.UserUseCase;
import lombok.Builder;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;

import java.util.List;
import java.util.Optional;
import java.util.UUID;

@RequiredArgsConstructor
@Slf4j
@Builder
public class UserUseCaseImpl implements UserUseCase {
    private final UserRepository userRepository;
    private final SecurityProvider securityProvider;

    @Override
    public User createUser(User user) {
        String principalId = securityProvider.createPrincipal(user);
        securityProvider.assignRoles(principalId, Role.USER);
        user.setPrincipalId(principalId);
        return userRepository.saveUser(user);
    }

    @Override
    public User updateUser(User user) {
        securityProvider.updatePrincipal(user);
        return userRepository.saveUser(user);
    }

    @Override
    public List<User> findAllUsers() {
        return userRepository.findAllUsers();
    }

    @Override
    public Optional<User> findUserById(UUID userId) {
        return userRepository.findById(userId);
    }

    @Override
    public Optional<User> findUserByEmail(String email) {
        return userRepository.findUserByEmail(email);
    }

    @Override
    public void deleteUser(UUID id) {
        userRepository.deleteUser(id);
    }

    @Override
    public void updatePassword(String principalId, String password) {
        securityProvider.changePassword(principalId, password);
    }

    @Override
    public Optional<User> findUserByPrincipalId(String principalId) {
        return userRepository.findUserByPrincipalId(principalId);
    }
}
