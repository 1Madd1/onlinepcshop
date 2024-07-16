//package com.onlinepcshop.adapters.rest.controller;
//
//
//import com.onlinepcshop.adapters.rest.dto.VlasnikDto;
//import com.onlinepcshop.core.domain.entity.Vlasnik;
//import com.onlinepcshop.core.repository.page.PageObject;
//import com.onlinepcshop.core.usecase.VlasnikUseCase;
//import jakarta.servlet.http.HttpServletRequest;
//import lombok.Data;
//import lombok.RequiredArgsConstructor;
//import lombok.extern.slf4j.Slf4j;
//
//import org.springframework.web.bind.annotation.*;
//
//import java.security.Principal;
//import java.util.Optional;
//import java.util.UUID;
//
//@RestController()
//@RequestMapping("vlasnik")
//@RequiredArgsConstructor
//@Data
//@Slf4j
//public class VlasnikController {
//    private final VlasnikUseCase vlasnikUseCase;
//
//    @GetMapping("/{id}")
//    public VlasnikDto getById(@PathVariable(name = "id") UUID vlasnikId) {
//        log.info("VlasnikController.geyById with id: {} called", vlasnikId);
//        Optional<Vlasnik> vlasnik = vlasnikUseCase.findVlasnikById(vlasnikId);
//        if(vlasnik.isEmpty()) {
//            log.info("Not found");
//            return null;
//        }
//        return VlasnikMapperApi.INSTANCE.vlasnikToVlasnikDto(vlasnik.get());
//    }
//
//    @PostMapping
//    public VlasnikDto createVlasnik(@RequestBody VlasnikDto vlasnikDto) {
//        log.info("VlasnikController.createVlasnik called - {}", vlasnikDto);
//
//        Vlasnik createdVlasnik = vlasnikUseCase.createVlasnik(VlasnikMapperApi.INSTANCE.vlasnikDtoToVlasnik(vlasnikDto));
//        return VlasnikMapperApi.INSTANCE.vlasnikToVlasnikDto(createdVlasnik);
//    }
//
//    @PutMapping
//    public VlasnikDto updateVlasnik(@RequestBody VlasnikDto vlasnikDto) {
//        log.info("VlasnikController.updateVlasnik called - {}", vlasnikDto);
//
//        Vlasnik updatedVlasnik = vlasnikUseCase.updateVlasnik(VlasnikMapperApi.INSTANCE.vlasnikDtoToVlasnik(vlasnikDto));
//        return VlasnikMapperApi.INSTANCE.vlasnikToVlasnikDto(updatedVlasnik);
//    }
//
//    @DeleteMapping
//    public void deleteVlasnikById(@RequestParam UUID vlasnikId) {
//        vlasnikUseCase.deleteVlasnik(vlasnikId);
//    }
//
//    @GetMapping
//    public PageObject<VlasnikDto> findAllPagedAndSorted(HttpServletRequest request,
//                                                        @RequestParam(name = "page") int page,
//                                                        @RequestParam(name = "rows-per-page") int size,
//                                                        @RequestParam(name = "sort-by") String sortBy,
//                                                        @RequestParam(name = "descending") boolean descending) {
//        PageObject<Vlasnik> result = vlasnikUseCase.findAllFiltered(request.getParameterMap(), page, size, sortBy, descending);
//
//        return new PageObject<>(
//                VlasnikMapperApi.INSTANCE.vlasnikListToVlasnikDtoList(result.getData()),
//                page,
//                size,
//                result.getRowsNumber(),
//                descending,
//                sortBy);
//
//    }
//
//    @GetMapping("/logged-in")
//    public VlasnikDto getLoggedIn(Principal principal) {
//        Optional<Vlasnik> vlasnikOptional = vlasnikUseCase.findVlasnikByPrincipalId(principal.getName());
//        if ( vlasnikOptional.isEmpty()) {
//            throw new VlasnikNotFoundException("Vlasnik not found for the given principal id!");
//        }
//        return VlasnikMapperApi.INSTANCE.vlasnikToVlasnikDto(vlasnikOptional.get());
//    }
//}
