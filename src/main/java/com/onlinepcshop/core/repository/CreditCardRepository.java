package com.onlinepcshop.core.repository;

import com.onlinepcshop.core.domain.entity.CreditCard;

import java.util.List;
import java.util.Optional;
import java.util.UUID;

public interface CreditCardRepository {
    List<CreditCard> findAllCreditCards();

    Optional<CreditCard> findById(UUID creditCardId);

    CreditCard saveCreditCard(CreditCard creditCard);

    void deleteCreditCard(UUID id);
}
