//package com.onlinepcshop.core.usecase.impl;
//
//import com.itextpdf.text.*;
//import com.itextpdf.text.pdf.*;
//import com.onlinepcshop.core.usecase.ObracunPDFUseCase;
//import com.onlinepcshop.core.util.PDFBuilder;
//import lombok.Builder;
//import lombok.RequiredArgsConstructor;
//import lombok.extern.slf4j.Slf4j;
//import org.apache.commons.io.FileUtils;
//import org.apache.commons.io.IOUtils;
//import org.springframework.core.io.ClassPathResource;
//
//import java.io.ByteArrayOutputStream;
//import java.io.File;
//import java.io.IOException;
//import java.io.InputStream;
//import java.math.BigDecimal;
//import java.math.RoundingMode;
//import java.text.DecimalFormat;
//import java.util.List;
//import java.util.Optional;
//import java.util.UUID;
//import java.util.concurrent.atomic.AtomicInteger;
//
//@RequiredArgsConstructor
//@Slf4j
//@Builder
//public class ObracunPDFUseCaseImpl implements ObracunPDFUseCase {
//
//    private static final String FONT_FILE_PATH = "/tmp/Arial.ttf";
//
//    private final StambenaZajednicaRepository stambenaZajednicaRepository;
//    private final ObracunRepository obracunRepository;
//    private final ObracunskiPeriodRepository obracunskiPeriodRepository;
//    private final PosebniDeoVlasnikRepository posebniDeoVlasnikRepository;
//    private final ObracunStavkaRepository obracunStavkaRepository;
//    private final PosebniDeoRepository posebniDeoRepository;
//
//
//    private static BaseFont fontFamily = null;
//    private static final DecimalFormat decfor = new DecimalFormat("0.00");
//
//    /**
//     * Method that prints PDF file of given obracunId
//     * @param obracunId - Id of given obracun
//     * @return - byte array of created obracun PDF file
//     * @throws DocumentException
//     * @throws IOException
//     */
//    @Override
//    public byte[] generateObracunPDF(UUID obracunId) throws DocumentException, IOException {
//        StambenaZajednica stambenaZajednica = new StambenaZajednica();
//
//        Optional<Obracun> obracun = this.obracunRepository.findById(obracunId);
//        ObracunskiPeriod obracunskiPeriod = null;
//        PosebniDeo posebniDeo = null;
//        if (obracun.isPresent()) {
//            posebniDeo = posebniDeoRepository.findById(obracun.get().getPosebniDeo().getId()).orElse(null);
//            obracunskiPeriod = obracun.get().getObracunskiPeriod();
//            if (posebniDeo != null && posebniDeo.getStambenaZajednica() != null) {
//                stambenaZajednica = posebniDeo.getStambenaZajednica();
//            }
//        }
//
//        List<ObracunStavka> obracunStavkaList = this.obracunStavkaRepository.findAllByObracunId(obracun.get().getId());
//        Vlasnik vlasnik = this.posebniDeoVlasnikRepository.findCurrentVlasnik(obracun.get().getPosebniDeo().getId()).getVlasnik();
//
//        Document document = new Document();
//        ByteArrayOutputStream byteArrayOutputStream = new ByteArrayOutputStream();
//        PdfWriter writer = PdfWriter.getInstance(document, byteArrayOutputStream);
//        document.open();
//
//        String filename = getFontFilePath();
//        fontFamily = BaseFont.createFont(filename, BaseFont.CP1250, BaseFont.EMBEDDED);
//
//        /*
//         * Paragraph of the document title
//         */
//        Paragraph titleParagraph = new Paragraph("Obračun\nbr. " + obracun.get().getBroj());
////        PDFBuilder.createDataTableDataRow("Faktura Broj:", obracun.get().getBroj(), Element.ALIGN_RIGHT, f).forEach(posebniDeoTable::addCell);// obracun.broj
//        titleParagraph.setAlignment(Element.ALIGN_CENTER);
//        Font titleFont = new Font(fontFamily,14.0f,Font.BOLD);
//        titleParagraph.setFont(titleFont);
//
//        /*
//         * table for showing firm and owner data
//         */
//        PdfPTable parentTable = new PdfPTable(3);
//        parentTable.setWidthPercentage(100);
//        parentTable.addCell(createFirmaDataParagraph(stambenaZajednica));
//
//        /*
//         * Adding title paragraph to a cell
//         */
//        PdfPCell titleCell = new PdfPCell();
//        titleCell.addElement(titleParagraph);
//        titleCell.setBorder(0);
//        titleCell.setPaddingTop(30);
//        titleCell.setHorizontalAlignment(Element.ALIGN_CENTER);
//        parentTable.addCell(titleCell);
//
//        parentTable.addCell(createPosebniDeoDataTable(obracun.get(), vlasnik));
//
//        /*
//         * Table for payment slip and payment report
//         */
//        PdfPTable uplateTable = new PdfPTable(3);
//        uplateTable.setWidthPercentage(100);
//
//        PdfPCell nalogZaUplatuCell = new PdfPCell(createNalogZaUplatuDataTable(stambenaZajednica, vlasnik, obracunskiPeriod, posebniDeo, PDFBuilder.calculateStavkeUkupno(obracunStavkaList)));
//        nalogZaUplatuCell.setColspan(2);
//        nalogZaUplatuCell.setBorder(Rectangle.NO_BORDER);
//
//        PdfPCell izvestajOUplatiCell = new PdfPCell(createIzvestajOUplatiDataTable(stambenaZajednica, vlasnik, obracunskiPeriod, posebniDeo));
//        izvestajOUplatiCell.setBorder(Rectangle.LEFT);
//
//        uplateTable.addCell(nalogZaUplatuCell);
//        uplateTable.addCell(izvestajOUplatiCell);
//        uplateTable.setSpacingBefore(10);
//        uplateTable.setWidthPercentage(100);
//
//        PdfPTable stavkeDataTable = createStavkeDataTable(obracunStavkaList, obracunskiPeriod, posebniDeo);
//        document.add(parentTable);
//        document.add(stavkeDataTable);
//        writeFooterTable(writer, document, uplateTable);
//        float combinedHight = parentTable.getTotalHeight() + stavkeDataTable.getTotalHeight() + uplateTable.getTotalHeight();
//        if (combinedHight > document.getPageSize().getHeight() - document.bottom() * 2) {
//            Document newDocument = new Document();
//            writer = PdfWriter.getInstance(newDocument, byteArrayOutputStream);
//            newDocument.open();
//            newDocument.add(parentTable);
//            newDocument.add(stavkeDataTable);
//            newDocument.newPage();
//            newDocument.add(uplateTable);
//            newDocument.close();
//        } else {
//            document.close();
//        }
//
//        return byteArrayOutputStream.toByteArray();
//    }
//
//    private static String getFontFilePath() throws IOException {
//
//        File fontfile = new File(FONT_FILE_PATH);
//        if (!fontfile.exists()) {
//            if (!fontfile.getParentFile().exists()) {
//                boolean ignored = fontfile.getParentFile().mkdirs();
//            }
//            ClassPathResource classPathResource = new ClassPathResource("/fonts/Arial.ttf");
//
//            InputStream inputStream = classPathResource.getInputStream();
//            try {
//                FileUtils.copyInputStreamToFile(inputStream, fontfile);
//            } finally {
//                IOUtils.closeQuietly(inputStream);
//            }
//        }
//
//        return fontfile.getAbsolutePath();
//    }
//
//    private void writeFooterTable(PdfWriter writer, Document document, PdfPTable table) {
//        final int FIRST_ROW = 0;
//        final int LAST_ROW = -1;
//        //Table must have absolute width set.
//        if(table.getTotalWidth()==0)
//            table.setTotalWidth((document.right()-document.left())*table.getWidthPercentage()/100f);
//        table.writeSelectedRows(FIRST_ROW, LAST_ROW, document.left(), document.bottom()+table.getTotalHeight(), writer.getDirectContent());
//    }
//
//    /**
//     * Method that prints PDF file with all obracuni by given obracunskiPeriodId
//     * @param obracunskiPeriodId - Id of orbacunski period
//     * @return - byte array of all obracun PDF files in one PDF file
//     * @throws IOException
//     * @throws DocumentException
//     */
//    @Override
//    public byte[] generateObracuniPDF(UUID obracunskiPeriodId, UUID posebanDeoId) throws IOException, DocumentException {
//        ByteArrayOutputStream byteArrayOutputStream = new ByteArrayOutputStream();
//        Document pDFCombineUsingJava = new Document();
//        Optional<ObracunskiPeriod> obracunskiPeriod = Optional.empty();
//        Optional<PosebniDeo> posebniDeo = Optional.empty();
//        if (obracunskiPeriodId != null) {
//            obracunskiPeriod = obracunskiPeriodRepository.findById(obracunskiPeriodId);
//        } else {
//            posebniDeo = posebniDeoRepository.findById(posebanDeoId);
//        }
//        PdfCopy copy = new PdfCopy(pDFCombineUsingJava , byteArrayOutputStream);
//
//        pDFCombineUsingJava.open();
//        PdfReader ReadInputPDF;
//
//            List<Obracun> result = obracunskiPeriod.isPresent() ? obracunRepository.findByObracunskiPeriodId(obracunskiPeriod.get().getId()) : obracunRepository.findAllByPosebniDeoId(posebniDeo.get().getId());
//            for (Obracun obracun : result) {
//                ReadInputPDF = new PdfReader(generateObracunPDF(obracun.getId()));
//                copy.addDocument(ReadInputPDF);
//                copy.freeReader(ReadInputPDF);
//            }
//
//        pDFCombineUsingJava.close();
//
//        return byteArrayOutputStream.toByteArray();
//    }
//
//    /**
//     * Creates stavke data table
//     * @return - Data table with all stavke from given posebni deo id
//     * @throws DocumentException
//     */
//    private PdfPTable createStavkeDataTable(List<ObracunStavka> obracunStavkaList, ObracunskiPeriod obracunskiPeriod, PosebniDeo posebniDeo) throws DocumentException {
//        //TODO: Needs to generate all stavke from given posebni deo id
//        PdfPTable stavkeTable = new PdfPTable(5);
//        stavkeTable.setWidths(new int[]{ 5, 1, 2, 2, 2});
//        PdfPCell cell;
//        Font stavkeInfoFont = new Font(fontFamily,9.0f, Font.ITALIC);
//        Font stavkeFont = new Font(fontFamily, 8.0f, Font.BOLD);
//
//        cell = new PdfPCell();
//        cell.addElement(PDFBuilder.createParagraphLineData("*poreski obaveznik nije u sistemu PDV-a", Element.ALIGN_LEFT, stavkeInfoFont));
//        cell.setColspan(8);
//        cell.setBorder(0);
//        stavkeTable.addCell(cell);
//        cell = new PdfPCell();
//        cell.addElement(PDFBuilder.createParagraphLineData("*ovaj račun je punovažan bez pečata", Element.ALIGN_LEFT, stavkeInfoFont));
//        cell.setColspan(8);
//        cell.setBorder(0);
//        cell.setPaddingBottom(5);
//        cell.setBorder(Rectangle.BOTTOM);
//        stavkeTable.addCell(cell);
//
//        cell = new PdfPCell();
//        cell.addElement(PDFBuilder.createParagraphLineData("Usluga", Element.ALIGN_LEFT, stavkeFont));
//        cell.setBorder(Rectangle.BOTTOM);
//        cell.setBackgroundColor(BaseColor.LIGHT_GRAY);
//        cell.setUseAscender(true);
//        cell.setVerticalAlignment(Element.ALIGN_MIDDLE);
//        cell.setPaddingTop(5);
//        cell.setPaddingBottom(5);
//        stavkeTable.addCell(cell);
//        cell = new PdfPCell();
//        cell.addElement(PDFBuilder.createParagraphLineData("Količina", Element.ALIGN_CENTER, stavkeFont));
//        cell.setBorder(Rectangle.BOTTOM);
//        cell.setBackgroundColor(BaseColor.LIGHT_GRAY);
//        cell.setUseAscender(true);
//        cell.setVerticalAlignment(Element.ALIGN_MIDDLE);
//        stavkeTable.addCell(cell);
//        cell = new PdfPCell();
//        cell.addElement(PDFBuilder.createParagraphLineData("J.M.", Element.ALIGN_CENTER, stavkeFont));
//        cell.setBorder(Rectangle.BOTTOM);
//        cell.setBackgroundColor(BaseColor.LIGHT_GRAY);
//        cell.setUseAscender(true);
//        cell.setVerticalAlignment(Element.ALIGN_MIDDLE);
//        stavkeTable.addCell(cell);
//        cell = new PdfPCell();
//        cell.addElement(PDFBuilder.createParagraphLineData("Cena", Element.ALIGN_RIGHT, stavkeFont));
//        cell.setBorder(Rectangle.BOTTOM);
//        cell.setBackgroundColor(BaseColor.LIGHT_GRAY);
//        cell.setUseAscender(true);
//        cell.setVerticalAlignment(Element.ALIGN_MIDDLE);
//        stavkeTable.addCell(cell);
////        cell = new PdfPCell();
////        cell.addElement(PDFBuilder.createParagraphLineData("Osnovica", Element.ALIGN_RIGHT, stavkeFont));
////        cell.setBorder(Rectangle.BOTTOM);
////        cell.setBackgroundColor(BaseColor.LIGHT_GRAY);
////        cell.setUseAscender(true);
////        cell.setVerticalAlignment(Element.ALIGN_MIDDLE);
////        stavkeTable.addCell(cell);
////        cell = new PdfPCell();
////        cell.addElement(PDFBuilder.createParagraphLineData("Stopa", Element.ALIGN_RIGHT, stavkeFont));
////        cell.setBorder(Rectangle.BOTTOM);
////        cell.setBackgroundColor(BaseColor.LIGHT_GRAY);
////        cell.setUseAscender(true);
////        cell.setVerticalAlignment(Element.ALIGN_MIDDLE);
////        stavkeTable.addCell(cell);
////        cell = new PdfPCell();
////        cell.addElement(PDFBuilder.createParagraphLineData("PDV", Element.ALIGN_RIGHT, stavkeFont));
////        cell.setBorder(Rectangle.BOTTOM);
////        cell.setBackgroundColor(BaseColor.LIGHT_GRAY);
////        cell.setUseAscender(true);
////        cell.setVerticalAlignment(Element.ALIGN_MIDDLE);
////        stavkeTable.addCell(cell);
//        cell = new PdfPCell();
//        cell.addElement(PDFBuilder.createParagraphLineData("Iznos", Element.ALIGN_RIGHT, stavkeFont));
//        cell.setBorder(Rectangle.BOTTOM);
//        cell.setBackgroundColor(BaseColor.LIGHT_GRAY);
//        cell.setUseAscender(true);
//        cell.setVerticalAlignment(Element.ALIGN_MIDDLE);
//        stavkeTable.addCell(cell);
//
//        for (int i = 0; i < obracunStavkaList.size(); i++) { // rows
//            for (int j = 1; j <= 5; j++) { // columns
//                cell = createStavkeDataTableRowData(j, i, obracunStavkaList.get(i));
//                cell.setBorder(Rectangle.NO_BORDER);
//                stavkeTable.addCell(cell);
//            }
//        }
//
////        for (int i = 0; i < 10; i++) { // rows
////            for (int j = 1; j <= 5; j++) { // columns
////                cell = createStavkeDataTableRowData(j, i, obracunStavkaList.getFirst());
////                cell.setBorder(Rectangle.NO_BORDER);
////                stavkeTable.addCell(cell);
////            }
////        }
//
//        cell = new PdfPCell(new Phrase());
//        cell.setColspan(3);
//        cell.setBorder(0);
//        stavkeTable.addCell(cell);
//        cell = new PdfPCell(createStavkeDataTableTotal(obracunStavkaList, posebniDeo));
//        cell.setColspan(2);
//        cell.setBorder(0);
//        stavkeTable.addCell(cell);
//        cell = new PdfPCell(new Phrase(obracunskiPeriod.getNaziv()));
//        cell.setBorder(0);
//        cell.setColspan(3);
//        cell.setHorizontalAlignment(Element.ALIGN_LEFT);
//        cell.setVerticalAlignment(Element.ALIGN_BOTTOM);
//        stavkeTable.addCell(cell);
//        cell = new PdfPCell(createStavkeUplateHistory());
//        cell.setBorder(0);
//        cell.setColspan(2);
//        cell.setHorizontalAlignment(Element.ALIGN_RIGHT);
//
//        stavkeTable.addCell(cell);
//        stavkeTable.setSpacingAfter(10);
//        stavkeTable.setWidthPercentage(100);
//
//        return stavkeTable;
//    }
//
//    /**
//     * Method for creating a table of payment history
//     * @return - PdfPTable of payment history
//     */
//    private PdfPTable createStavkeUplateHistory() {
//        PdfPTable uplateHistoryTable = new PdfPTable(2);
//        PdfPCell cell;
//        cell = new PdfPCell(new Paragraph("Uplate u proteklih 60 dana"));
//        cell.setBorder(0);
//        cell.setColspan(2);
//        cell.setHorizontalAlignment(Element.ALIGN_CENTER);
//        uplateHistoryTable.addCell(cell);
//        cell = new PdfPCell();
//        cell.addElement(PDFBuilder.createParagraphLineData("Datum", Element.ALIGN_CENTER, PDFBuilder.stavkeDataFont));
//        cell.setBorder(0);
//        cell.setBackgroundColor(BaseColor.LIGHT_GRAY);
//        uplateHistoryTable.addCell(cell);
//        cell = new PdfPCell();
//        cell.addElement(PDFBuilder.createParagraphLineData("Iznos", Element.ALIGN_CENTER, PDFBuilder.stavkeDataFont));
//        cell.setBorder(0);
//        cell.setBackgroundColor(BaseColor.LIGHT_GRAY);
//        uplateHistoryTable.addCell(cell);
//        cell = new PdfPCell(new Paragraph("15.11.2023"));
//        cell.setBorder(0);
//        cell.setHorizontalAlignment(Element.ALIGN_CENTER);
//        uplateHistoryTable.addCell(cell);
//        cell = new PdfPCell(new Paragraph("1770.89"));
//        cell.setBorder(0);
//        cell.setHorizontalAlignment(Element.ALIGN_CENTER);
//        uplateHistoryTable.addCell(cell);
//        cell = new PdfPCell(new Paragraph("09.10.2023"));
//        cell.setBorder(0);
//        cell.setHorizontalAlignment(Element.ALIGN_CENTER);
//        uplateHistoryTable.addCell(cell);
//        cell = new PdfPCell(new Paragraph("885.51"));
//        cell.setBorder(0);
//        cell.setHorizontalAlignment(Element.ALIGN_CENTER);
//        uplateHistoryTable.addCell(cell);
//        uplateHistoryTable.setSpacingBefore(30);
//        return uplateHistoryTable;
//    }
//
//    /**
//     * Method for creating a table of payment slip data
//     * @param stambenaZajednica
//     * @param vlasnik
//     * @return - PdfPTable with payment slip data
//     * @throws BadElementException
//     * @throws IOException
//     * @throws BadPdfFormatException
//     */
//    private PdfPTable createNalogZaUplatuDataTable (StambenaZajednica stambenaZajednica, Vlasnik vlasnik,
//            ObracunskiPeriod obracunskiPeriod, PosebniDeo posebniDeo, BigDecimal stavkeTotal) throws BadElementException, IOException, BadPdfFormatException {
//        PdfPTable nalogZaUplatuTable = new PdfPTable(2);
//        PdfPCell titleCell = new PdfPCell();
//        titleCell.addElement(new Paragraph("Nalog za uplatu"));
//        titleCell.setBorder(Rectangle.TOP);
//        titleCell.setColspan(2);
//        nalogZaUplatuTable.addCell(titleCell);
//        nalogZaUplatuTable.addCell(createUplatilacInfoTable(vlasnik, obracunskiPeriod, 100));
//        nalogZaUplatuTable.addCell(createUplataTable(stambenaZajednica, posebniDeo));
//        nalogZaUplatuTable.addCell(createPrimalacInfoCell(stambenaZajednica));
//        nalogZaUplatuTable.addCell(PDFBuilder.createQRCode(stambenaZajednica, vlasnik, obracunskiPeriod, posebniDeo, stavkeTotal));
//
//        return  nalogZaUplatuTable;
//    }
//
//    private PdfPTable createIzvestajOUplatiDataTable(StambenaZajednica stambenaZajednica, Vlasnik vlasnik,
//            ObracunskiPeriod obracunskiPeriod, PosebniDeo posebniDeo) {
//        PdfPTable izvestajOUplatiDataTable = new PdfPTable(1);
//
//        PdfPCell titleCell = new PdfPCell();
//        Paragraph titleParagraph = new Paragraph("Izveštaj o uplati");
//        titleParagraph.setIndentationRight(9);
//        titleParagraph.setAlignment(Element.ALIGN_RIGHT);
//        titleCell.addElement(titleParagraph);
//        titleCell.setBorder(Rectangle.TOP);
//        izvestajOUplatiDataTable.addCell(titleCell);
//
//        izvestajOUplatiDataTable.addCell(createUplataTable(stambenaZajednica, posebniDeo));
//        izvestajOUplatiDataTable.addCell(createUplatilacInfoTable(vlasnik, obracunskiPeriod, 90));
//
//        return  izvestajOUplatiDataTable;
//    }
//
//    private PdfPCell createPrimalacInfoCell(StambenaZajednica stambenaZajednica) {
//        PdfPTable primalacInfoTable = new PdfPTable(1);
//        Font f = new Font(fontFamily,8.0f,Font.NORMAL);
//        PdfPCell cell;
//        cell = new PdfPCell();
//        cell.addElement(PDFBuilder.createParagraphLineData("Primalac:", Element.ALIGN_LEFT, f));
//        cell.setBorder(0);
//        primalacInfoTable.addCell(cell);
//        f.setSize(12);
//        cell = new PdfPCell();
//        cell.addElement(PDFBuilder.createParagraphLineData(stambenaZajednica.getNaziv() + " " +
//                stambenaZajednica.getUlica() + " " + stambenaZajednica.getBroj(), Element.ALIGN_LEFT, f));
//        // stambena_zajednica.naziv + stambena_zajednica.ulica + stambena_zajednica.broj
//        cell.setBorder(0);
//        cell.setPaddingBottom(20);
//        primalacInfoTable.addCell(cell);
//        cell = new PdfPCell();
//        f.setSize(9);
//        cell.addElement(PDFBuilder.createParagraphLineData(stambenaZajednica.getUlica() + " " + stambenaZajednica.getBroj(), Element.ALIGN_LEFT, f));// stambena_zajednica.ulica + stambena_zajednica.broj
//        cell.setBorder(0);
//        primalacInfoTable.addCell(cell);
//        cell = new PdfPCell();
//        cell.addElement(PDFBuilder.createParagraphLineData(stambenaZajednica.getOpstina().getPostanskiBroj() + " " + stambenaZajednica.getOpstina().getNaziv(), Element.ALIGN_LEFT, f));
//        cell.setBorder(0);
//        primalacInfoTable.addCell(cell);
//        cell = new PdfPCell();
//        cell.addElement(PDFBuilder.createParagraphLineData("PIB: " + stambenaZajednica.getPib(), Element.ALIGN_LEFT, f));// stambena_zajednica.pib
//        cell.setBorder(0);
//        primalacInfoTable.addCell(cell);
//        cell = new PdfPCell(primalacInfoTable);
//        cell.setBorder(0);
//
//        return cell;
//    }
//
//    private PdfPCell createUplatilacInfoTable(Vlasnik vlasnik, ObracunskiPeriod obracunskiPeriod, int widthPercentage) {
//        PdfPTable uplatilacInfoTable = new PdfPTable(1);
//        Font uplatilacFont = new Font(fontFamily,8.0f,Font.NORMAL);
//        PdfPCell cell;
//        cell = new PdfPCell();
//        cell.addElement(PDFBuilder.createParagraphLineData("Uplatilac:", Element.ALIGN_LEFT, uplatilacFont));
//        cell.setBorder(0);
//        uplatilacInfoTable.addCell(cell);
//        cell = new PdfPCell();
//        if (vlasnik.getTip().equals(TipVlasnika.FIZIČKO_LICE_DOMAĆE) || vlasnik.getTip().equals(TipVlasnika.FIZIČKO_LICE_STRANO)) {
//            cell.addElement(PDFBuilder.createParagraphLineData(vlasnik.getIme() + " " + vlasnik.getPrezime() + ", " + vlasnik.getAdresa() + ", " + vlasnik.getOpstina(), Element.ALIGN_LEFT, uplatilacFont));
//        } else {
//            cell.addElement(PDFBuilder.createParagraphLineData(vlasnik.getNaziv() + ", " + vlasnik.getAdresa() + ", " + vlasnik.getOpstina(), Element.ALIGN_LEFT, uplatilacFont));
//        }
//        cell.setFixedHeight(45);
//        cell.setBorder(0);
//        cell.setBackgroundColor(BaseColor.LIGHT_GRAY);
//        uplatilacInfoTable.addCell(cell);
//        cell = new PdfPCell();
//        cell.addElement(PDFBuilder.createParagraphLineData("Svrha uplate:", Element.ALIGN_LEFT, uplatilacFont));
//        cell.setBorder(0);
//        uplatilacInfoTable.addCell(cell);
//        cell = new PdfPCell();
//        cell.addElement(PDFBuilder.createParagraphLineData("Obračun period: " + obracunskiPeriod.getNaziv(), Element.ALIGN_LEFT, uplatilacFont)); // Racun period: obracunski_period.naziv
//        cell.setBorder(0);
//        cell.setBackgroundColor(BaseColor.LIGHT_GRAY);
//        cell.setFixedHeight(27);
//        uplatilacInfoTable.addCell(cell);
//        cell = new PdfPCell();
//        uplatilacInfoTable.setWidthPercentage(widthPercentage);
//        cell.addElement(uplatilacInfoTable);
//        cell.setBorder(0);
//
//        return cell;
//    }
//
//    private PdfPCell createUplataTable(StambenaZajednica stambenaZajednica, PosebniDeo posebniDeo) {
//        Font f = new Font(fontFamily,8.0f,Font.NORMAL);
//        PdfPTable uplataTable = new PdfPTable(4);
//        PdfPCell cell;
//        cell = new PdfPCell();
//        cell.addElement(PDFBuilder.createParagraphLineData("Šifra:", Element.ALIGN_LEFT, f));
//        cell.setBorder(0);
//        uplataTable.addCell(cell);
//        cell = new PdfPCell();
//        cell.addElement(PDFBuilder.createParagraphLineData("Valuta:", Element.ALIGN_LEFT, f));
//        cell.setBorder(0);
//        uplataTable.addCell(cell);
//        cell = new PdfPCell();
//        cell.addElement(PDFBuilder.createParagraphLineData("Iznos:", Element.ALIGN_LEFT, f));
//        cell.setBorder(0);
//        cell.setColspan(2);
//        uplataTable.addCell(cell);
//
//        cell = new PdfPCell();
//        cell.addElement(PDFBuilder.createParagraphLineData("189", Element.ALIGN_LEFT, f));
//        cell.setBorder(Rectangle.RIGHT);
//        cell.setBorderColor(BaseColor.WHITE);
//        cell.setBackgroundColor(BaseColor.LIGHT_GRAY);
//        cell.setFixedHeight(19);
//        uplataTable.addCell(cell);
//        cell = new PdfPCell();
//        cell.addElement(PDFBuilder.createParagraphLineData("RSD", Element.ALIGN_LEFT, f));
//        cell.setBorder(Rectangle.RIGHT);
//        cell.setBorderColor(BaseColor.WHITE);
//        cell.setBackgroundColor(BaseColor.LIGHT_GRAY);
//        uplataTable.addCell(cell);
//        cell = new PdfPCell();
//        cell.addElement(PDFBuilder.createParagraphLineData("", Element.ALIGN_LEFT, f));
//        cell.setBorder(Rectangle.RIGHT);
//        cell.setBorderColor(BaseColor.WHITE);
//        cell.setBackgroundColor(BaseColor.LIGHT_GRAY);
//        cell.setColspan(2);
//        uplataTable.addCell(cell);
//
//        cell = new PdfPCell();
//        cell.addElement(PDFBuilder.createParagraphLineData("Račun primaoca:", Element.ALIGN_LEFT, f));
//        cell.setBorder(0);
//        cell.setColspan(4);
//        uplataTable.addCell(cell);
//        cell = new PdfPCell();
//        cell.addElement(PDFBuilder.createParagraphLineData(stambenaZajednica.getZiroRacun(), Element.ALIGN_LEFT, f));
//        cell.setBorder(Rectangle.BOX);
//        cell.setBorderColor(BaseColor.WHITE);
//        cell.setColspan(4);
//        cell.setFixedHeight(19);
//        cell.setBackgroundColor(BaseColor.LIGHT_GRAY);
//        uplataTable.addCell(cell);
//
//        cell = new PdfPCell();
//        cell.addElement(PDFBuilder.createParagraphLineData("Model:", Element.ALIGN_LEFT, f));
//        cell.setBorder(0);
//        uplataTable.addCell(cell);
//        cell = new PdfPCell();
//        cell.addElement(PDFBuilder.createParagraphLineData("Poziv na broj:", Element.ALIGN_LEFT, f));
//        cell.setBorder(0);
//        cell.setColspan(3);
//        uplataTable.addCell(cell);
//
//        cell = new PdfPCell();
//        cell.addElement(PDFBuilder.createParagraphLineData("97", Element.ALIGN_LEFT, f));
//        cell.setBorder(Rectangle.BOX);
//        cell.setBorderColor(BaseColor.WHITE);
//        cell.setBackgroundColor(BaseColor.LIGHT_GRAY);
//        cell.setFixedHeight(19);
//        uplataTable.addCell(cell);
//        cell = new PdfPCell();
//        String pozivNaBrojPoModelu97 = posebniDeo.getPozivNaBroj() != null ? Model97Util.createValidModel97PozivNaBroj(posebniDeo.getPozivNaBroj()) : "";
//        cell.addElement(PDFBuilder.createParagraphLineData(pozivNaBrojPoModelu97, Element.ALIGN_LEFT, f));// jedinstven broj svakog posebnog dela
//        cell.setBorder(Rectangle.BOX);
//        cell.setBorderColor(BaseColor.WHITE);
//        cell.setBackgroundColor(BaseColor.LIGHT_GRAY);
//        cell.setColspan(3);
//        uplataTable.addCell(cell);
//        cell = new PdfPCell();
//        uplataTable.setWidthPercentage(90);
//        cell.addElement(uplataTable);
//        cell.setBorder(Rectangle.NO_BORDER);
//        cell.setPaddingBottom(10);
//
//        return cell;
//    }
//
//    private PdfPCell createStavkeDataTableRowData(int j, int i, ObracunStavka obracunStavka) {
//        Font f = new Font(fontFamily,7.0f, Font.NORMAL);
//        PdfPCell cell;
//        switch (j) {
//            case 1:
//                cell = new PdfPCell();
//                cell.addElement(PDFBuilder.createParagraphLineData(obracunStavka.getStavka().getNaziv(), Element.ALIGN_LEFT, f));// stavka.naziv
//                break;
//            case 2:
//                cell = new PdfPCell();
//                cell.addElement(PDFBuilder.createParagraphLineData(obracunStavka.getKolicina().toPlainString(), Element.ALIGN_CENTER, f));// obracun_stavka.kolicina
//                break;
//            case 3:
//                cell = new PdfPCell();
//                cell.addElement(PDFBuilder.createJMParagraphLineData(obracunStavka.getStavka().getJedinicaMere(), Element.ALIGN_CENTER, f));// stavka.jedinica_mere
//                break;
//            case 4:
//                cell = new PdfPCell();
//                cell.addElement(PDFBuilder.createParagraphLineData(obracunStavka.getCenaPoJM().getAmount().setScale(2, RoundingMode.UP).toPlainString(), Element.ALIGN_RIGHT, f));// obracun_stavka.cena_po_jedinici_mere
//                break;
//            case 5:
//                cell = new PdfPCell();
//                cell.addElement(PDFBuilder.createParagraphLineData(obracunStavka.getCenaUkupno().getAmount().setScale(2, RoundingMode.UP).toPlainString(), Element.ALIGN_RIGHT, f));// obracun_stavka.ukupna_cena
//                break;
////            case 6:
////                cell = new PdfPCell();
////                cell.addElement(PDFBuilder.createParagraphLineData("Stopa" + i, Element.ALIGN_RIGHT, f));//
////                break;
////            case 7:
////                cell = new PdfPCell();
////                cell.addElement(PDFBuilder.createParagraphLineData("PDV" + i, Element.ALIGN_RIGHT, f));//
////                break;
////            case 8:
////                cell = new PdfPCell();
////                cell.addElement(PDFBuilder.createParagraphLineData(obracunStavka.getCenaUkupno().getAmount().toPlainString(), Element.ALIGN_RIGHT, f));// obracun_stavka.ukupna_cena
////                break;
//            default:
//                cell = null;
//                break;
//        }
//
//        return cell;
//    }
//
//    private PdfPCell createFirmaDataParagraph(StambenaZajednica stambenaZajednica) {
//        PdfPCell firmaCell = new PdfPCell();
//        Paragraph firmaCellParagraphTitle = new Paragraph("SZ " + stambenaZajednica.getNaziv());// stambena_zajednica.naziv
//        firmaCellParagraphTitle.setExtraParagraphSpace(10);
//        Font f = new Font(fontFamily,16.0f,Font.BOLD);
//        firmaCellParagraphTitle.setFont(f);
//        firmaCell.addElement(firmaCellParagraphTitle);
//        f.setSize(10.0f);
//        f.setStyle(Font.NORMAL);
//        firmaCell.addElement(PDFBuilder.createParagraphLineData(stambenaZajednica.getUlica() + " " + stambenaZajednica.getBroj(), Element.ALIGN_LEFT, f));// stambena_zajednica.ulica + stambena_zajednica.broj
//        firmaCell.addElement(PDFBuilder.createParagraphLineData(stambenaZajednica.getOpstina().getPostanskiBroj() + " " + stambenaZajednica.getOpstina().getNaziv(), Element.ALIGN_LEFT, f));// stambena_zajednica.opstina_id.postanski_broj +
//        firmaCell.addElement(PDFBuilder.createParagraphLineData("tel: 065/1322342 014/3141224", Element.ALIGN_LEFT, f));//
//        firmaCell.addElement(PDFBuilder.createParagraphLineData("PIB: " + stambenaZajednica.getPib(), Element.ALIGN_LEFT, f));// stambena_zajednica.pib
//        firmaCell.addElement(PDFBuilder.createParagraphLineData("Maticni broj: " + stambenaZajednica.getMaticniBroj(), Element.ALIGN_LEFT, f));// stambena_zajednica.maticni_broj
//        firmaCell.addElement(PDFBuilder.createParagraphLineData("Racun: " + stambenaZajednica.getZiroRacun(), Element.ALIGN_LEFT, f));// stambena_zajednica.ziro_racun
////        firmaCell.addElement(PDFBuilder.createParagraphLineData("Indetifikaciona oznaka lica: JZ", Element.ALIGN_LEFT, f));//
//        firmaCell.setBorder(0);
//        return firmaCell;
//    }
//
//    private PdfPCell createPosebniDeoDataTable(Obracun obracun, Vlasnik vlasnik) {
//        PdfPTable posebniDeoTable = new PdfPTable(2);
//        Font f = new Font(fontFamily,10.5f,Font.BOLD);
//        PDFBuilder.createDataTableDataRow("Datum izdavanja:", obracun.getDatumIzdavanjaRacuna().toString(), Element.ALIGN_RIGHT, f).forEach(posebniDeoTable::addCell);// obracun.datum_izdavanja_racuna
//        PDFBuilder.createDataTableDataRow("Datum valute:", obracun.getDatumPrometa().toString(), Element.ALIGN_RIGHT, f).forEach(posebniDeoTable::addCell);// obracun.datum_prometa
//        PDFBuilder.createDataTableDataRow("Mesto izdavanja:", "Valjevo", Element.ALIGN_RIGHT, f).forEach(posebniDeoTable::addCell);//
//        PDFBuilder.createDataTableDataRow("Period:", obracun.getObracunskiPeriod().getNaziv(), Element.ALIGN_RIGHT, f).forEach(posebniDeoTable::addCell);// obracun.obracunski_period_id.naziv
//        posebniDeoTable.addCell(createPosebniDeoVlasnikInfoCell(vlasnik));
//        PdfPCell posebniDeoCell = new PdfPCell(posebniDeoTable);
//        posebniDeoCell.setBorder(0);
//        return posebniDeoCell;
//    }
//
//    private PdfPCell createPosebniDeoVlasnikInfoCell(Vlasnik vlasnik) {
//        PdfPCell vlasnikInfoCell = new PdfPCell();
//        Font f = new Font(fontFamily,12.0f,Font.BOLD);
//        if (vlasnik.getTip().equals(TipVlasnika.FIZIČKO_LICE_DOMAĆE) || vlasnik.getTip().equals(TipVlasnika.FIZIČKO_LICE_STRANO)) {
//            vlasnikInfoCell.addElement(PDFBuilder.createParagraphLineData(vlasnik.getIme() + " " + vlasnik.getPrezime(), Element.ALIGN_RIGHT, f));
//        } else {
//            vlasnikInfoCell.addElement(PDFBuilder.createParagraphLineData(vlasnik.getNaziv(), Element.ALIGN_RIGHT, f));
//        }
//        f.setStyle(Font.NORMAL);
//        f.setSize(11);
//        vlasnikInfoCell.addElement(PDFBuilder.createParagraphLineData(vlasnik.getAdresa(), Element.ALIGN_RIGHT, f));// posebnideo.vlasnik_id.adresa
//        vlasnikInfoCell.addElement(PDFBuilder.createParagraphLineData(vlasnik.getPostanskiBroj() + " " + vlasnik.getMesto(), Element.ALIGN_RIGHT, f));// posebnideo.vlasnik_id.postanski_broj + posebnideo.vlasnik_id.mesto
//        vlasnikInfoCell.setColspan(2);
//        vlasnikInfoCell.setBorder(0);
//        vlasnikInfoCell.setPaddingRight(30);
//        return vlasnikInfoCell;
//    }
//
//    private PdfPTable createStavkeDataTableTotal(List<ObracunStavka> obracunStavkaList, PosebniDeo posebniDeo) {
//        PdfPTable stavkeTable = new PdfPTable(2);
//        Font f = new Font(fontFamily,10.0f,Font.BOLD);
//        AtomicInteger counter = new AtomicInteger();
//        BigDecimal total = PDFBuilder.calculateStavkeUkupno(obracunStavkaList);
//        PDFBuilder.createDataTableDataRow("RSD", total.setScale(2, RoundingMode.UP).toPlainString(), Element.ALIGN_RIGHT, f).forEach(c -> {// zbir iznosa svih stavki
//            c.setBackgroundColor(BaseColor.LIGHT_GRAY);
//            stavkeTable.addCell(c);
//        });
//        PDFBuilder.createDataTableDataRow("DUG:", posebniDeo.getDug().getAmount().setScale(2, RoundingMode.UP).toPlainString(), Element.ALIGN_RIGHT, f).forEach(c -> {// posebni_deo.dug
//            if(counter.get() == 1) {
//                c.setBackgroundColor(BaseColor.LIGHT_GRAY);
//            }
//            stavkeTable.addCell(c);
//            counter.getAndIncrement();
//        });
//        counter.set(0);
//        PDFBuilder.createDataTableDataRow("UKUPNO:", total.add(posebniDeo.getDug().getAmount()).setScale(2, RoundingMode.UP).toPlainString(), Element.ALIGN_RIGHT, f).forEach(c -> {// zbir prvog i drugog dela
//            if(counter.get() == 1) {
//                c.setBackgroundColor(BaseColor.LIGHT_GRAY);
//            }
//            stavkeTable.addCell(c);
//            counter.getAndIncrement();
//        });
//
//        return stavkeTable;
//    }
//}
