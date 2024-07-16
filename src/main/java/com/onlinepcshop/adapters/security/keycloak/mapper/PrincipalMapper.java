package com.onlinepcshop.adapters.security.keycloak.mapper;


import com.onlinepcshop.adapters.security.keycloak.dto.CredentialsDto;
import com.onlinepcshop.adapters.security.keycloak.dto.PrincipalDto;
import com.onlinepcshop.adapters.security.keycloak.dto.PrincipalUpdateRequestDto;
import com.onlinepcshop.core.domain.entity.Agent;
import com.onlinepcshop.core.domain.entity.Vlasnik;
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

//    @Mapping(target = "enabled", constant = "true")
//    @Mapping(source = "email", target = "username")
//    PrincipalUpdateRequestDto operatorToPrincipalUpdateRequestDto(Operator operator);

    @Mapping(target = "enabled", constant = "true")
    @Mapping(source = "email", target = "username")
    PrincipalDto vlasnikToPrincipal(Vlasnik vlasnik);

    @Mapping(target = "enabled", constant = "true")
    @Mapping(source = "email", target = "username")
    PrincipalDto agentToPrincipal(Agent agent);
}
