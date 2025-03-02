package com.onlinepcshop.adapters.persistance.mapper;

import com.onlinepcshop.adapters.persistance.dao.ProductRatingDao;
import com.onlinepcshop.core.domain.entity.ProductRating;
import org.mapstruct.Mapper;
import org.mapstruct.factory.Mappers;

import java.util.List;

@Mapper
public interface ProductRatingMapperDB {
    ProductRatingMapperDB INSTANCE = Mappers.getMapper(ProductRatingMapperDB.class);

    ProductRatingDao productRatingToProductRatingDao(ProductRating productRating);

    ProductRating productRatingDaoToProductRating(ProductRatingDao productRatingDao);

    List<ProductRatingDao> productRatingListToProductRatingDaoList(List<ProductRating> productRatingList);

    List<ProductRating> productRatingDaoListToProductRatingList(List<ProductRatingDao> productRatingDaoList);
}
