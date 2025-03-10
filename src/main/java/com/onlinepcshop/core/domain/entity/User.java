package com.onlinepcshop.core.domain.entity;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.UUID;

@Builder
@Data
@AllArgsConstructor
@NoArgsConstructor
public class User {
    UUID id;
    String principalId;
    String username;
    String email;
    String firstName;
    String lastName;
    String street;
    String postalCode;
    String phoneNumber;
    String password;
    CreditCard creditCard;
}
