package com.onlinepcshop.adapters.persistance.repository;

import com.onlinepcshop.adapters.persistance.dao.CreditCardDao;
import com.onlinepcshop.adapters.persistance.mapper.CreditCardMapperDB;
import com.onlinepcshop.adapters.persistance.repository.jpa.CreditCardJpaRepository;
import com.onlinepcshop.core.domain.entity.CreditCard;
import com.onlinepcshop.core.repository.CreditCardRepository;
import lombok.Builder;

import java.util.List;
import java.util.Optional;
import java.util.UUID;

@Builder
public class CreditCardRepositoryImpl implements CreditCardRepository {
    private final CreditCardJpaRepository creditCardJpaRepository;

    @Override
    public List<CreditCard> findAllCreditCards() {
        return CreditCardMapperDB.INSTANCE.creditCardDaoListToCreditCardList(creditCardJpaRepository.findAll());
    }

    @Override
    public Optional<CreditCard> findById(UUID creditCardId) {
        CreditCard creditCard = CreditCardMapperDB.INSTANCE.creditCardDaoToCreditCard(creditCardJpaRepository.findById(creditCardId).orElse(null));
        return Optional.ofNullable(creditCard);
    }

    @Override
    public CreditCard saveCreditCard(CreditCard creditCard) {
        CreditCardDao creditCardDao = CreditCardMapperDB.INSTANCE.creditCardToCreditCardDao(creditCard);
        return CreditCardMapperDB.INSTANCE.creditCardDaoToCreditCard(creditCardJpaRepository.save(creditCardDao));
    }

    @Override
    public void deleteCreditCard(UUID id) {
        creditCardJpaRepository.deleteById(id);
    }
}
