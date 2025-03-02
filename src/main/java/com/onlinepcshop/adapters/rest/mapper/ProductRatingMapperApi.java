package com.onlinepcshop.adapters.rest.mapper;

import com.onlinepcshop.adapters.rest.dto.ProductRatingDto;
import com.onlinepcshop.core.domain.entity.ProductRating;
import com.onlinepcshop.core.domain.entity.User;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.Named;
import org.mapstruct.factory.Mappers;

import java.util.List;
import java.util.UUID;

@Mapper
public interface ProductRatingMapperApi {

    @Named("mapUserToId")
    default UUID mapUserToId(User user) {
        return user == null ? null : user.getId();
    }

    ProductRatingMapperApi INSTANCE = Mappers.getMapper(ProductRatingMapperApi.class);

    @Mapping(source = "user", target = "userId", qualifiedByName = "mapUserToId")
    ProductRatingDto productRatingToProductRatingDto(ProductRating productRating);

    @Named("mapIdToUser")
    default User mapIdToUser(UUID userId) {
        return userId == null ? null : User.builder()
                .id(userId)
                .build();
    }

    @Mapping(source = "userId", target = "user", qualifiedByName = "mapIdToUser")
    ProductRating productRatingDtoToProductRating(ProductRatingDto productRatingDto);

    List<ProductRatingDto> productRatingListToProductRatingDtoList(List<ProductRating> productRatingList);

    List<ProductRating> productRatingDtoListToProductRatingList(List<ProductRatingDto> productRatingDtoList);
}
