package com.onlinepcshop.core.usecase;

import com.onlinepcshop.core.domain.entity.User;

import java.util.List;
import java.util.Optional;
import java.util.UUID;

public interface UserUseCase {
    /***
     *  Create and persist an agent
     *
     * @param user newly created user
     * @return Valid user object with id
     */
    User createUser(User user);

    /***
     *  Update user data fields
     * @param user must be a valid user object with valid id
     * @return Updated user object
     */
    User updateUser(User user);

    /***
     *
     * @return List of all users
     */
    List<User> findAllUsers();


    /***
     * @param userId valid user UUID
     * @return User with provided agentId if one exists
     */
    Optional<User> findUserById(UUID userId);

    /***
     *
     * @param email address of an existing user
     * @return User with provided email if one exists
     */
    Optional<User> findUserByEmail(String email);

    /***
     * Delete user with specified id
     * @param id must be a valid
     */
    void deleteUser(UUID id);

    /***
     * Updates the password
     * @param principalId - must be a valid principalId
     * @param password valid password string
     */
    void updatePassword(String principalId, String password);

    /**
     * @param principalId must be a valid principalId
     * @return user with the given principalId
     */
    Optional<User> findUserByPrincipalId(String principalId);
}
