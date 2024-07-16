package com.onlinepcshop.core.repository;



import com.onlinepcshop.core.domain.entity.Vlasnik;
import com.onlinepcshop.core.repository.page.PageObject;

import java.util.List;
import java.util.Map;
import java.util.Optional;
import java.util.UUID;

public interface VlasnikRepository {
    List<Vlasnik> findAllVlasniks();

    Optional<Vlasnik> findById(UUID vlasnikId);

    Vlasnik saveVlasnik(Vlasnik vlasnik);

    void deleteVlasnik(UUID id);

    PageObject<Vlasnik> findAllPagedAndSorted(int page, int size, String sortBy, boolean descending);

    PageObject<Vlasnik> findAllFiltered(Map<String, String[]> parameterMap, int page, int size, String sortBy,
            boolean descending);

    Optional<Vlasnik> findVlasnikByPrincipalId(String principalId);
}
