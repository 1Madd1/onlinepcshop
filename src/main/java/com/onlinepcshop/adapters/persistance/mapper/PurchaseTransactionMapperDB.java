package com.onlinepcshop.adapters.persistance.mapper;

import com.onlinepcshop.adapters.persistance.dao.PurchaseTransactionDao;
import com.onlinepcshop.core.domain.entity.PurchaseTransaction;
import org.mapstruct.Mapper;
import org.mapstruct.factory.Mappers;

import java.util.List;

@Mapper
public interface PurchaseTransactionMapperDB {

    PurchaseTransactionMapperDB INSTANCE = Mappers.getMapper(PurchaseTransactionMapperDB.class);

    PurchaseTransactionDao purchaseTransactionToPurchaseTransactionDao(PurchaseTransaction purchaseTransaction);

    PurchaseTransaction purchaseTransactionDaoToPurchaseTransaction(PurchaseTransactionDao purchaseTransactionDao);

    List<PurchaseTransactionDao> purchaseTransactionListToPurchaseTransactionDaoList(List<PurchaseTransaction> purchaseTransactionList);

    List<PurchaseTransaction> purchaseTransactionDaoListToPurchaseTransactionList(List<PurchaseTransactionDao> purchaseTransactionDaoList);

}
