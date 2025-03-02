package com.onlinepcshop.adapters.rest.controller;


import com.onlinepcshop.adapters.rest.dto.CreditCardDto;
import com.onlinepcshop.adapters.rest.dto.request.CreateCreditCardRequest;
import com.onlinepcshop.adapters.rest.dto.request.RemoveCreditCardRequest;
import com.onlinepcshop.adapters.rest.mapper.CreditCardMapperApi;
import com.onlinepcshop.core.domain.entity.CreditCard;
import com.onlinepcshop.core.domain.entity.User;
import com.onlinepcshop.core.error.exception.UserNotFoundException;
import com.onlinepcshop.core.usecase.CreditCardUseCase;
import com.onlinepcshop.core.usecase.UserUseCase;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

import java.util.Optional;
import java.util.UUID;

@RestController
@RequestMapping("credit-card")
@RequiredArgsConstructor
public class CreditCardController {

    private final CreditCardUseCase creditCardUseCase;
    private final UserUseCase userUseCase;

    @GetMapping("/{id}")
    public CreditCardDto getById(@PathVariable(name = "id") UUID creditCardId) {
        System.out.println("CreditCardController.geyById with id: " + creditCardId + " called");
        Optional<CreditCard> creditCard = creditCardUseCase.findCreditCardById(creditCardId);
        if (creditCard.isEmpty()) {
            System.out.println("CreditCard with id " + creditCardId + " not found");
            return null;
        }
        return CreditCardMapperApi.INSTANCE.creditCardToCreditCardDto(creditCard.get());
    }

    @PostMapping
    public CreditCardDto createCreditCard(@RequestBody CreateCreditCardRequest creditCardRequest) {
        System.out.println("CreditCardController.createCreditCard called - " + creditCardRequest.getCreditCard());

        Optional<User> optionalUser = userUseCase.findUserById(creditCardRequest.getUserId());

        CreditCard createdCreditCard = creditCardUseCase.createCreditCard(CreditCardMapperApi.INSTANCE.creditCardDtoToCreditCard(creditCardRequest.getCreditCard()));

        if (!optionalUser.isEmpty()) {
            User user = optionalUser.get();
            user.setCreditCard(createdCreditCard);
            userUseCase.updateUser(user);
        } else {
            System.out.println("User with id " + creditCardRequest.getUserId() + " not found");
            throw new UserNotFoundException("User with id " + creditCardRequest.getUserId() + " not found");
        }

        return CreditCardMapperApi.INSTANCE.creditCardToCreditCardDto(createdCreditCard);
    }

    @PutMapping
    public CreditCardDto updateCreditCard(@RequestBody CreditCardDto creditCardDto) {
        System.out.println("CreditCardController.updateCreditCard called - " + creditCardDto);

        CreditCard updatedCreditCard = creditCardUseCase.updateCreditCard(CreditCardMapperApi.INSTANCE.creditCardDtoToCreditCard(creditCardDto));
        return CreditCardMapperApi.INSTANCE.creditCardToCreditCardDto(updatedCreditCard);
    }

    @DeleteMapping
    public boolean deleteCreditCardById(@RequestBody RemoveCreditCardRequest creditCardRequest) {
        System.out.println("CreditCardController.deleteCreditCardById called for creditCardId - " + creditCardRequest.getCreditCardId());

        Optional<User> optionalUser = userUseCase.findUserById(creditCardRequest.getUserId());
        User updatedUser;
        if (!optionalUser.isEmpty()) {
            User user = optionalUser.get();
            user.setCreditCard(null);
            updatedUser = userUseCase.updateUser(user);
        } else {
            System.out.println("User with id " + creditCardRequest.getUserId() + " not found");
            throw new UserNotFoundException("User with id " + creditCardRequest.getUserId() + " not found");
        }

        creditCardUseCase.deleteCreditCard(creditCardRequest.getCreditCardId());
        return updatedUser.getCreditCard() == null;
    }

}
