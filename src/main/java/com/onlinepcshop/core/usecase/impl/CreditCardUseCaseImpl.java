package com.onlinepcshop.core.usecase.impl;

import com.onlinepcshop.core.domain.entity.CreditCard;
import com.onlinepcshop.core.repository.CreditCardRepository;
import com.onlinepcshop.core.usecase.CreditCardUseCase;
import lombok.Builder;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;

import java.util.Optional;
import java.util.UUID;

@RequiredArgsConstructor
@Slf4j
@Builder
public class CreditCardUseCaseImpl implements CreditCardUseCase {
    private final CreditCardRepository creditCardRepository;

    @Override
    public Optional<CreditCard> findCreditCardById(UUID creditCardId) {
        return creditCardRepository.findById(creditCardId);
    }

    @Override
    public CreditCard createCreditCard(CreditCard creditCard) {
        return creditCardRepository.saveCreditCard(creditCard);
    }

    @Override
    public CreditCard updateCreditCard(CreditCard creditCard) {
        return creditCardRepository.saveCreditCard(creditCard);
    }

    @Override
    public void deleteCreditCard(UUID id) {
        creditCardRepository.deleteCreditCard(id);
    }
}
