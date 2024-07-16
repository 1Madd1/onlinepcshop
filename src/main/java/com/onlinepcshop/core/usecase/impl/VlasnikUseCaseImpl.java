package com.onlinepcshop.core.usecase.impl;

import com.onlinepcshop.core.domain.entity.Vlasnik;
import com.onlinepcshop.core.domain.value.Money;
import com.onlinepcshop.core.repository.VlasnikRepository;
import com.onlinepcshop.core.repository.page.PageObject;
import com.onlinepcshop.core.security.Role;
import com.onlinepcshop.core.security.SecurityProvider;
import com.onlinepcshop.core.usecase.VlasnikUseCase;
import lombok.Builder;
import lombok.RequiredArgsConstructor;

import java.util.List;
import java.util.Map;
import java.util.Optional;
import java.util.UUID;

@RequiredArgsConstructor
@Builder
public class VlasnikUseCaseImpl implements VlasnikUseCase {
    private final VlasnikRepository vlasnikRepository;
    private final SecurityProvider securityProvider;

//    @Override
//    public Vlasnik createVlasnik(Vlasnik vlasnik) {
//        String principalId = securityProvider.createPrincipal(vlasnik);
//        securityProvider.assignRoles(principalId, Role.UNKNOWN);
//        vlasnik.setPrincipalId(principalId);
//        return vlasnikRepository.saveVlasnik(vlasnik);
//    }

    @Override
    public Vlasnik createVlasnik(Vlasnik vlasnik) {
        return null;
    }

    @Override
    public Vlasnik updateVlasnik(Vlasnik vlasnik) {
        securityProvider.updatePrincipal(vlasnik.getPrincipalId(), vlasnik.getEmail());
        return vlasnikRepository.saveVlasnik(vlasnik);
    }

    @Override
    public void deleteVlasnik(UUID vlasnikId) {
        vlasnikRepository.deleteVlasnik(vlasnikId);
    }

    @Override
    public Optional<Vlasnik> findVlasnikById(UUID vlasnikId) {
        return vlasnikRepository.findById(vlasnikId);
    }

    @Override
    public Money getTotalDug() {
        return null;
    }

    @Override
    public List<Vlasnik> findAll() {
        return vlasnikRepository.findAllVlasniks();
    }


    @Override
    public PageObject<Vlasnik> findAllPagedAndSorted(int page, int size, String sortBy, boolean descending) {
        return vlasnikRepository.findAllPagedAndSorted(page, size, sortBy, descending);
    }

    @Override
    public PageObject<Vlasnik> findAllFiltered(Map<String, String[]> parameterMap, int page, int size, String sortBy,
            boolean descending) {
        return vlasnikRepository.findAllFiltered(parameterMap, page, size, sortBy, descending);
    }

    @Override
    public Optional<Vlasnik> findVlasnikByPrincipalId(String principalId) {
        return vlasnikRepository.findVlasnikByPrincipalId(principalId);
    }

}
