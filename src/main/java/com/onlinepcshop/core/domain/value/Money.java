package com.onlinepcshop.core.domain.value;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.Setter;

import java.math.BigDecimal;
import java.util.Currency;
import java.util.Objects;

@Getter
@Setter
@Builder
@AllArgsConstructor
public class Money {
    BigDecimal amount;
    Currency currency;

    public Money add(Money money) {
        return Money.builder().currency(currency).amount(amount.add(money.getAmount())).build();
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof Money money)) return false;
        return Objects.equals(amount, money.amount) && Objects.equals(currency, money.currency);
    }

    @Override
    public int hashCode() {
        return Objects.hash(amount, currency);
    }
}
