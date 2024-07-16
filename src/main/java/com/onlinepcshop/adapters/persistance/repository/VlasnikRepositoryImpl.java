//package com.onlinepcshop.adapters.persistance.repository;
//
//import com.deavensoft.eobracuni.adapters.persistance.dao.VlasnikDao;
//import com.deavensoft.eobracuni.adapters.persistance.mapper.VlasnikMapperDB;
//import com.deavensoft.eobracuni.adapters.persistance.mapper.VlasnikMapperDB;
//import com.deavensoft.eobracuni.adapters.persistance.repository.jpa.VlasnikJpaRepository;
//import com.deavensoft.eobracuni.adapters.persistance.repository.jpa.filter.VlasnikSearchSpecification;
//import com.deavensoft.eobracuni.adapters.persistance.repository.paging.VlasnikPagingAndSortingRepository;
//import com.deavensoft.eobracuni.core.domain.entity.Vlasnik;
//import com.deavensoft.eobracuni.core.domain.entity.Vlasnik;
//import com.deavensoft.eobracuni.core.repository.VlasnikRepository;
//import com.deavensoft.eobracuni.core.repository.page.PageObject;
//import com.speedment.jpastreamer.application.JPAStreamer;
//import lombok.Builder;
//import org.springframework.data.domain.Page;
//import org.springframework.data.domain.PageRequest;
//import org.springframework.data.domain.Sort;
//
//import java.util.List;
//import java.util.Map;
//import java.util.Optional;
//import java.util.UUID;
//import java.util.stream.Collectors;
//
//@Builder
//public class VlasnikRepositoryImpl implements VlasnikRepository {
//    private VlasnikJpaRepository vlasnikJpaRepository;
//    private VlasnikPagingAndSortingRepository vlasnikPagingAndSortingRepository;
//    private JPAStreamer jpaStreamer;
//
//    @Override
//    public List<Vlasnik> findAllVlasniks() {
//        return VlasnikMapperDB.INSTACE.vlasnikDaoListToVlasnikList(vlasnikJpaRepository.findAll());
//    }
//
//    @Override
//    public Optional<Vlasnik> findById(UUID vlasnikId) {
//        Vlasnik vlasnik = VlasnikMapperDB.INSTACE.vlasnikDaoToVlasnik(vlasnikJpaRepository.findById(vlasnikId).orElse(null));
//        return Optional.ofNullable(vlasnik);
//    }
//
//    @Override
//    public Vlasnik saveVlasnik(Vlasnik vlasnik) {
//        VlasnikDao vlasnikDao = VlasnikMapperDB.INSTACE.vlasnikToVlasnikDao(vlasnik);
//        return VlasnikMapperDB.INSTACE.vlasnikDaoToVlasnik(vlasnikJpaRepository.save(vlasnikDao));
//    }
//
//    @Override
//    public void deleteVlasnik(UUID id) {
//        vlasnikJpaRepository.deleteById(id);
//    }
//
//    @Override
//    public PageObject<Vlasnik> findAllPagedAndSorted(int page, int size, String sortBy, boolean descending) {
//        Sort sort = descending ? Sort.by(sortBy).descending() : Sort.by(sortBy).ascending();
//        Page<VlasnikDao> result = vlasnikPagingAndSortingRepository.findAll(PageRequest.of(page, size, sort));
//
//        return new PageObject<Vlasnik>(
//                VlasnikMapperDB.INSTACE.vlasnikDaoListToVlasnikList(result.get().collect(Collectors.toList())),
//                page, size, result.getTotalElements(), descending, sortBy);
//    }
//
//    @Override
//    public PageObject<Vlasnik> findAllFiltered(Map<String, String[]> parameterMap, int page, int size, String sortBy,
//                                               boolean descending) {
//        List<Vlasnik> vlasnikList = jpaStreamer.stream(VlasnikDao.class)
//                .filter(VlasnikSearchSpecification.getPredicate(parameterMap))
//                .skip(page * size)
//                .limit(size)
//                .map(sz -> VlasnikMapperDB.INSTACE.vlasnikDaoToVlasnik(sz))
//                .toList();
//
//        long count = jpaStreamer.stream(VlasnikDao.class)
//                .filter(VlasnikSearchSpecification.getPredicate(parameterMap))
//                .count();
//
//        return new PageObject<Vlasnik>(vlasnikList, page, size, count, descending, sortBy);
//    }
//
//    @Override
//    public Optional<Vlasnik> findVlasnikByPrincipalId(String principalId) {
//        Vlasnik vlasnik = VlasnikMapperDB.INSTACE
//                .vlasnikDaoToVlasnik(vlasnikJpaRepository.findByPrincipalId(principalId).orElse(null));
//        return Optional.ofNullable(vlasnik);
//    }
//}
