package com.onlinepcshop.adapters.persistance.dao;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.math.BigDecimal;
import java.util.UUID;

@Entity(name = "purchase_transaction_product")
@Data
@AllArgsConstructor
@NoArgsConstructor
public class PurchaseTransactionProductDao {
    @Id
    @GeneratedValue(strategy = GenerationType.UUID)
    private UUID id;

    @Column(name = "product_id")
    private UUID productId;

    @Column(name = "product_type")
    String productType;

    @Column(name = "amount")
    Integer amount;

    @Column(name = "price_at_the_time")
    BigDecimal priceAtTheTime;

    @ManyToOne
    PurchaseTransactionDao purchaseTransaction;

}
