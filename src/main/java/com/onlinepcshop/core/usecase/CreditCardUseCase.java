package com.onlinepcshop.core.usecase;

import com.onlinepcshop.core.domain.entity.CreditCard;

import java.util.Optional;
import java.util.UUID;

public interface CreditCardUseCase {

    /**
     * @param creditCardId must be a valid creditCardId
     * @return credit card with the given creditCardId
     */
    Optional<CreditCard> findCreditCardById(UUID creditCardId);

    /***
     *  Create and persist a credit card
     *
     * @param creditCard newly created credit card
     * @return Valid credit card object with id
     */
    CreditCard createCreditCard(CreditCard creditCard);

    /***
     *  Update credit card data fields
     * @param creditCard must be a valid credit card object with valid id
     * @return Updated credit card object
     */
    CreditCard updateCreditCard(CreditCard creditCard);

    /***
     * Delete credit card with specified id
     * @param id must be a valid
     */
    void deleteCreditCard(UUID id);
}
