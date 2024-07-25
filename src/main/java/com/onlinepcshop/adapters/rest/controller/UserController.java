package com.onlinepcshop.adapters.rest.controller;


import com.onlinepcshop.adapters.rest.dto.UserDto;
import com.onlinepcshop.adapters.rest.dto.request.ChangePasswordRequest;
import com.onlinepcshop.adapters.rest.mapper.UserMapperApi;
import com.onlinepcshop.core.domain.entity.User;
import com.onlinepcshop.core.error.exception.UserNotFoundException;
import com.onlinepcshop.core.usecase.UserUseCase;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

import java.security.Principal;
import java.util.List;
import java.util.Optional;
import java.util.UUID;

@RestController
@RequestMapping("user")
@RequiredArgsConstructor
public class UserController {

    private final UserUseCase userUseCase;

    @GetMapping("/{id}")
    public UserDto getById(@PathVariable(name = "id") UUID userId) {
        System.out.println("UserController.geyById with id: " + userId + " called");
        Optional<User> user = userUseCase.findUserById(userId);
        if(user.isEmpty()) {
            System.out.println("User with id " + userId + " not found");
            return null;
        }
        return UserMapperApi.INSTANCE.userToUserDto(user.get());
    }

    @PutMapping("/change-password")
    public void updatePassword(Principal principal, @RequestBody ChangePasswordRequest request) {
        userUseCase.updatePassword(principal.getName(), request.getNewPassword());
    }

    @GetMapping("/me")
    public UserDto getLoggedUser(Principal principal) {
        System.out.println("UserController.getLoggedUser called - principalId " + principal.getName());
        Optional<User> userOptional = userUseCase.findUserByPrincipalId(principal.getName());
        if ( userOptional.isEmpty()) {
            throw new UserNotFoundException("User not found for the given principal id!");
        }
        return UserMapperApi.INSTANCE.userToUserDto(userOptional.get());
    }

    @PostMapping
    public UserDto createUser(@RequestBody UserDto userDto) {
        System.out.println("AgentController.createUser called - " + userDto);

        User createdUser = userUseCase.createUser(UserMapperApi.INSTANCE.userDtoToUser(userDto));
        return UserMapperApi.INSTANCE.userToUserDto(createdUser);
    }

    @PutMapping
    public UserDto updateUser(@RequestBody UserDto userDto) {
        System.out.println("UserController.updateUser called - " + userDto);

        User updatedAgent = userUseCase.updateUser(UserMapperApi.INSTANCE.userDtoToUser(userDto));
        return UserMapperApi.INSTANCE.userToUserDto(updatedAgent);
    }

    @DeleteMapping
    public void deleteAgentById(@RequestParam UUID userId) {
        System.out.println("UserController.deleteUser called for userId - " + userId);
        userUseCase.deleteUser(userId);
    }

    @GetMapping
    public List<UserDto> findAll() {
        System.out.println("UserController.findAll called");
        return UserMapperApi.INSTANCE.userListToUserDtoList(userUseCase.findAllUsers());
    }

}
