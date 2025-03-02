package com.onlinepcshop.adapters.security.keycloak.mapper;


import com.onlinepcshop.adapters.security.keycloak.dto.CredentialsDto;
import com.onlinepcshop.adapters.security.keycloak.dto.PrincipalDto;
import com.onlinepcshop.core.domain.entity.User;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.Named;
import org.mapstruct.factory.Mappers;

import java.util.List;

@Mapper(componentModel = "Spring")
public interface PrincipalMapper {

    PrincipalMapper INSTANCE = Mappers.getMapper(PrincipalMapper.class);

    @Named(value = "passwordToCredentialsDtoList")
    static List<CredentialsDto> passwordToCredentialsDtoList(String password) {
        return List.of(CredentialsDto.builder().value(password).temporary(false).build());
    }

    @Mapping(target = "enabled", constant = "true")
    @Mapping(source = "username", target = "username")
    @Mapping(source = "email", target = "email")
    PrincipalDto userToPrincipal(User user);
}
