package com.onlinepcshop.adapters.persistance.mapper;

import com.onlinepcshop.adapters.persistance.dao.PurchaseTransactionProductDao;
import com.onlinepcshop.core.domain.entity.PurchaseTransactionProduct;
import org.mapstruct.Mapper;
import org.mapstruct.factory.Mappers;

import java.util.List;

@Mapper(uses = PurchaseTransactionMapperDB.class)
public interface PurchaseTransactionProductMapperDB {

    PurchaseTransactionProductMapperDB INSTANCE = Mappers.getMapper(PurchaseTransactionProductMapperDB.class);

    PurchaseTransactionProductDao purchaseTransactionProductToPurchaseTransactionProductDao(PurchaseTransactionProduct purchaseTransactionProduct);

    PurchaseTransactionProduct purchaseTransactionProductDaoToPurchaseTransactionProduct(PurchaseTransactionProductDao purchaseTransactionProductDao);

    List<PurchaseTransactionProductDao> purchaseTransactionProductListToPurchaseTransactionProductDaoList(List<PurchaseTransactionProduct> purchaseTransactionProductList);

    List<PurchaseTransactionProduct> purchaseTransactionProductDaoListToPurchaseTransactionProductList(List<PurchaseTransactionProductDao> purchaseTransactionProductDaoList);

}
