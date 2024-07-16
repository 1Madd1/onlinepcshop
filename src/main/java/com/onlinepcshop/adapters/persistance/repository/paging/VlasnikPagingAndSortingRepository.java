package com.onlinepcshop.adapters.persistance.repository.paging;

import com.onlinepcshop.adapters.persistance.dao.VlasnikDao;
import org.springframework.data.repository.PagingAndSortingRepository;

import java.util.UUID;

public interface VlasnikPagingAndSortingRepository extends PagingAndSortingRepository<VlasnikDao, UUID> {
}
