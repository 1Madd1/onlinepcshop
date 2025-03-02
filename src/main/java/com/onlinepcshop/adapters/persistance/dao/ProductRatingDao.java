package com.onlinepcshop.adapters.persistance.dao;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.UUID;

@Entity(name = "product_rating")
@Data
@AllArgsConstructor
@NoArgsConstructor
public class ProductRatingDao {
    @Id
    @GeneratedValue(strategy = GenerationType.UUID)
    private UUID id;

    @Column(name = "product_id")
    UUID productId;

    @Column(name = "product_type")
    String productType;

    @Column(name = "rating")
    Integer rating;

    @ManyToOne
    UserDao user;
}
