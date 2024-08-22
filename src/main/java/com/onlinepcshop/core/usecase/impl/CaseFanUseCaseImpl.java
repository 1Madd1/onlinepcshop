package com.onlinepcshop.core.usecase.impl;

import com.onlinepcshop.core.domain.entity.CaseFan;
import com.onlinepcshop.core.repository.CaseFanRepository;
import com.onlinepcshop.core.usecase.CaseFanUseCase;
import lombok.Builder;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;

import java.util.List;
import java.util.Optional;
import java.util.UUID;

@RequiredArgsConstructor
@Slf4j
@Builder
public class CaseFanUseCaseImpl implements CaseFanUseCase {
    private final CaseFanRepository caseFanRepository;

    @Override
    public CaseFan createCaseFan(CaseFan caseFan) {
        return caseFanRepository.saveCaseFan(caseFan);
    }

    @Override
    public CaseFan updateCaseFan(CaseFan caseFan) {
        return caseFanRepository.saveCaseFan(caseFan);
    }

    @Override
    public List<CaseFan> findAllCaseFans() {
        return caseFanRepository.findAllCaseFans();
    }

    @Override
    public Optional<CaseFan> findCaseFanById(UUID caseFanId) {
        return caseFanRepository.findById(caseFanId);
    }

    @Override
    public void deleteCaseFan(UUID id) {
        caseFanRepository.deleteCaseFan(id);
    }
}
