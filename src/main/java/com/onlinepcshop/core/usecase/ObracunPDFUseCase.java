package com.onlinepcshop.core.usecase;

import com.itextpdf.text.DocumentException;

import java.io.IOException;
import java.util.UUID;

public interface ObracunPDFUseCase {

    byte[] generateObracunPDF(UUID obracunId) throws IOException, DocumentException;

    byte[] generateObracuniPDF(UUID obracunskiPeriodId, UUID posebanDeoId) throws IOException, DocumentException;


}
