//package com.onlinepcshop.adapters.rest.controller;
//
//import com.itextpdf.text.DocumentException;
//import com.onlinepcshop.adapters.rest.dto.request.GenerateObracunPDFRequest;
//import com.onlinepcshop.core.usecase.ObracunPDFUseCase;
//import lombok.Data;
//import lombok.RequiredArgsConstructor;
//import lombok.extern.slf4j.Slf4j;
//import org.springframework.core.io.ByteArrayResource;
//import org.springframework.core.io.Resource;
//import org.springframework.http.MediaType;
//import org.springframework.web.bind.annotation.*;
//
//import java.io.IOException;
//
//@RestController()
//@RequestMapping("obracunpdf")
//@RequiredArgsConstructor
//@Data
//@Slf4j
//public class PDFGeneratorController {
//
//    private final ObracunPDFUseCase obracunPDFUseCase;
//
//    @PostMapping(produces = MediaType.APPLICATION_PDF_VALUE)
//    public @ResponseBody Resource generateObracunPDF(@RequestBody GenerateObracunPDFRequest generateObracunPDFRequest) throws DocumentException, IOException {
////        response.setContentType("application/pdf");
////        DateFormat dateFormater = new SimpleDateFormat("yyyy-MM-dd:hh:mm:ss");
////        String currentDateTime = dateFormater.format(new Date());
////
////        String headerKey = "Content-Disposition";
////        String headerValue = String.format("attachment; filename=obracunpdf_" + currentDateTime + ".pdf");
////        response.setHeader(headerKey, headerValue);
//        byte[] contents = null;
//        if (generateObracunPDFRequest.getObracunId() != null) {
//            contents = this.obracunPDFUseCase.generateObracunPDF(generateObracunPDFRequest.getObracunId());
//        } else {
//            contents = this.obracunPDFUseCase.generateObracuniPDF(generateObracunPDFRequest.getObracunskiPeriodId(), generateObracunPDFRequest.getPosebanDeoId());
//        }
//
//
////        HttpHeaders headers = new HttpHeaders();
////        headers.setContentType(MediaType.APPLICATION_PDF);
////        // Here you have to set the actual filename of your pdf
////        String filename = "obracun.pdf";
////        headers.setContentDispositionFormData(filename, filename);
////        headers.setCacheControl("must-revalidate, post-check=0, pre-check=0");
//
//        return new ByteArrayResource(contents);
////        return ResponseEntity.ok()
////                .header(HttpHeaders.CONTENT_DISPOSITION, "attachment; filename=\"" + filename + "\"")
////                .body(contents);
//    }
//
//}
