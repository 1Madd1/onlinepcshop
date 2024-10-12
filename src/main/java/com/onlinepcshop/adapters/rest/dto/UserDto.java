package com.onlinepcshop.adapters.rest.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.UUID;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class UserDto {
    private UUID id;
    private String principalId;
    private String email;
    private String username;
    private String firstName;
    private String lastName;
    private String password;
    private String telephone;
}
