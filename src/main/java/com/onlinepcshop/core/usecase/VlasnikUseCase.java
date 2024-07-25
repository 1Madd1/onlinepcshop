package com.onlinepcshop.core.usecase;

import com.onlinepcshop.core.domain.entity.Vlasnik;
import com.onlinepcshop.core.domain.value.Money;
import com.onlinepcshop.core.repository.page.PageObject;

import java.util.List;
import java.util.Map;
import java.util.Optional;
import java.util.UUID;

public interface VlasnikUseCase {
    Vlasnik createVlasnik(Vlasnik vlasnik);

    Vlasnik updateVlasnik(Vlasnik vlasnik);

    void deleteVlasnik(UUID vlasnikId);

    Optional<Vlasnik> findVlasnikById(UUID vlasnikId);

    Money getTotalDug();

    List<Vlasnik>  findAll();

    PageObject<Vlasnik> findAllPagedAndSorted(int page, int size, String sortBy, boolean descending);

    PageObject<Vlasnik> findAllFiltered(Map<String, String[]> parameterMap, int page, int size, String sortBy,
            boolean descending);

    Optional<Vlasnik> findVlasnikByPrincipalId(String name);
}
