package com.onlinepcshop.adapters.persistance.dao;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.UUID;

@Entity(name = "credit_card")
@Data
@AllArgsConstructor
@NoArgsConstructor
public class CreditCardDao {
    @Id
    @GeneratedValue(strategy = GenerationType.UUID)
    private UUID id;

    @Column(name = "card_number")
    private String cardNumber;

    @Column(name = "name_on_card")
    private String nameOnCard;

    @Column(name = "expiry_date")
    private String expiryDate;

    @Column(name = "cvv")
    private String cvv;
}
