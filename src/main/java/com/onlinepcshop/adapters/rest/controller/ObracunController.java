//package com.onlinepcshop.adapters.rest.controller;
//
//
//import com.onlinepcshop.adapters.rest.dto.ObracunDto;
//import lombok.Data;
//import lombok.RequiredArgsConstructor;
//import lombok.extern.slf4j.Slf4j;
//import org.springframework.web.bind.annotation.*;
//
//import java.util.ArrayList;
//import java.util.List;
//import java.util.Optional;
//import java.util.UUID;
//
//@RestController()
//@RequestMapping("obracun")
//@RequiredArgsConstructor
//@Data
//@Slf4j
//public class ObracunController {
//    private final ObracunUseCase obracunUseCase;
//    private final ObracunStavkaUseCase obracunStavkaUseCase;
//    private final PosebniDeoUseCase posebniDeoUseCase;
//
//    @GetMapping("/{id}")
//    public ObracunDto getById(@PathVariable(name = "id") UUID obracunId) {
//        log.info("ObracunController.geyById with id: {} called", obracunId);
//        Optional<Obracun> obracun = obracunUseCase.findObracunById(obracunId);
//        if(obracun.isEmpty()) {
//            log.info("Not found");
//            return null;
//        }
//        return ObracunMapperApi.INSTACE.obracunToObracunDto(obracun.get());
//    }
//
//    @PostMapping("/{obracunski_period_id}/{stambena_zajednica_id}")
//    public void createObracun(@PathVariable(name = "obracunski_period_id") UUID obracunskiPeiodId,
//            @PathVariable(name = "stambena_zajednica_id") UUID stambenaZajednicaId,
//            @RequestBody List<UUID> excludedFakturaList) {
//        log.info("ObracunController.createObracun called - {}", obracunskiPeiodId);
//        obracunUseCase.generateObracuni(obracunskiPeiodId, stambenaZajednicaId, excludedFakturaList);
//    }
//
//    @PutMapping
//    public ObracunDto updateObracun(@RequestBody ObracunDto obracunDto) {
//        log.info("ObracunController.updateObracun called - {}", obracunDto);
//
//        Obracun updatedObracun = obracunUseCase.updateObracun(ObracunMapperApi.INSTACE.obracunDtoToObracun(obracunDto));
//        return ObracunMapperApi.INSTACE.obracunToObracunDto(updatedObracun);
//    }
//
//    @DeleteMapping("/{id}")
//    public void deleteObracunById(@PathVariable(name = "id") UUID obracunId) {
//        obracunUseCase.deleteObracun(obracunId);
//    }
//
//    @GetMapping
//    public List<ObracunDto> findAll() {
//        return ObracunMapperApi.INSTACE.obracunListToObracunDtoList(obracunUseCase.findAll());
//    }
//
//    @GetMapping("/obracunski-period/{obracunski_period_id}")
//    public List<ObracunDto> findByObracunskiPeriod(@PathVariable(name = "obracunski_period_id") UUID obracunskiPeriodId) {
//        return ObracunMapperApi.INSTACE.obracunListToObracunDtoList(obracunUseCase.findByObracunskiPeriod(obracunskiPeriodId));
//    }
//
//    @GetMapping("/{obracun_id}/stavke")
//    public List<ObracunStavkaDto> findAllObracunStavkasByObracun(@PathVariable(name = "obracun_id") UUID obracunId) {
//        return ObracunStavkaMapperApi.INSTACE.obracunStavkaListToObracunStavkaDtoList(obracunStavkaUseCase.findAllByObracunId(obracunId));
//    }
//
//    @GetMapping("/posebni-deo/{posebni_deo_id}")
//    public List<ObracunDto> findAllObracunByPosebniDeo(@PathVariable(name = "posebni_deo_id") UUID posebniDeoId) {
//        return  ObracunMapperApi.INSTACE.obracunListToObracunDtoList(
//                obracunUseCase.findAllByPosebniDeoId(posebniDeoId));
//    }
//
//    @GetMapping("/stavkas-no-price/{stambena_zajednica_id}")
//    public List<StavkaDto> findAllStavkasWithoutPrice(@PathVariable(name = "stambena_zajdenica_id") UUID stambenaZajednicaId) {
//        return StavkaMapperApi.INSTANCE.stavkaListToStavkaDtoList(
//                obracunUseCase.findAllStavkasWithoutPrice(stambenaZajednicaId)
//        );
//    }
//
//    @GetMapping("/obracun-details/{obracun_id}")
//    public ObracunDetailsResponse getObracunDetails(@PathVariable(name = "obracun_id") UUID obracunId) {
//
//        Optional<Obracun> obracun = obracunUseCase.findObracunById(obracunId);
//        Vlasnik vlasnik = null;
//        List<Stavka> stavkaList = new ArrayList<>();
//        if (obracun.isPresent()) {
//            vlasnik = posebniDeoUseCase.getVlasnik(obracun.get().getPosebniDeo().getId()).getVlasnik();
//            obracunStavkaUseCase.findAllByObracunId(obracun.get().getId()).forEach(obracunStavka -> {
//                stavkaList.add(obracunStavka.getStavka());
//            });
//        }
//        return ObracunDetailsResponse.builder()
//                .stavkaList(StavkaMapperApi.INSTANCE.stavkaListToStavkaDtoList(stavkaList))
//                .vlasnik(VlasnikMapperApi.INSTANCE.vlasnikToVlasnikDto(vlasnik))
//                .obracunskiPeriod(ObracunskiPeriodMapperApi.INSTANCE.obracunskiPeriodToObracunskiPeriodDto(obracun.get().getObracunskiPeriod()))
//                .posebniDeo(PosebniDeoMapperApi.INSTACE.posebniDeoToPosebniDeoDto(obracun.get().getPosebniDeo()))
//                .build();
//    }
//}
