package com.onlinepcshop.adapters.persistance.dao;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.math.BigDecimal;
import java.time.LocalDate;
import java.util.UUID;

@Entity(name = "purchase_transaction")
@Data
@AllArgsConstructor
@NoArgsConstructor
public class PurchaseTransactionDao {
    @Id
    @GeneratedValue(strategy = GenerationType.UUID)
    private UUID id;

    @Column(name = "buyer_first_name")
    String buyerFirstName;

    @Column(name = "buyer_last_name")
    String buyerLastName;

    @Column(name = "buyer_street")
    String buyerStreet;

    @Column(name = "buyer_postal_code")
    String buyerPostalCode;

    @Column(name = "buyer_email")
    String buyerEmail;

    @Column(name = "buyer_phone_number")
    String buyerPhoneNumber;

    @Column(name = "payment_type")
    String paymentType;

    @Column(name = "date_of_purchase")
    LocalDate dateOfPurchase;

    @Column(name = "total_price")
    BigDecimal totalPrice;

    @ManyToOne
    UserDao user;

}
