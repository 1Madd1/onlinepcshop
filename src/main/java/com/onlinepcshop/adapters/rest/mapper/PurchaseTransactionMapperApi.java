package com.onlinepcshop.adapters.rest.mapper;

import com.onlinepcshop.adapters.rest.dto.PurchaseTransactionDto;
import com.onlinepcshop.core.domain.entity.PurchaseTransaction;
import com.onlinepcshop.core.domain.entity.User;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.Named;
import org.mapstruct.factory.Mappers;

import java.util.List;
import java.util.UUID;

@Mapper
public interface PurchaseTransactionMapperApi {
    PurchaseTransactionMapperApi INSTANCE = Mappers.getMapper(PurchaseTransactionMapperApi.class);

    @Named("mapUserToId")
    default UUID mapUserToId(User user) {
        return user == null ? null : user.getId();
    }

    @Mapping(source = "user", target = "userId", qualifiedByName = "mapUserToId")
    PurchaseTransactionDto purchaseTransactionToPurchaseTransactionDto(PurchaseTransaction purchaseTransaction);

    @Named("mapIdToUser")
    default User mapIdToUser(UUID userId) {
        return userId == null ? null : User.builder()
                .id(userId)
                .build();
    }

    @Mapping(source = "userId", target = "user", qualifiedByName = "mapIdToUser")
    PurchaseTransaction purchaseTransactionDtoToPurchaseTransaction(PurchaseTransactionDto purchaseTransactionDto);

    List<PurchaseTransactionDto> purchaseTransactionListToPurchaseTransactionDtoList(List<PurchaseTransaction> purchaseTransactionList);

    List<PurchaseTransaction> purchaseTransactionDtoListToPurchaseTransactionList(List<PurchaseTransactionDto> purchaseTransactionDtoList);
}
