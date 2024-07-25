package com.onlinepcshop.core.util;

import com.itextpdf.text.*;
import com.itextpdf.text.pdf.PdfPCell;
import lombok.extern.slf4j.Slf4j;
import java.util.List;

@Slf4j
public class PDFBuilder {

    public static Font stavkeDataFont = new Font(Font.FontFamily.TIMES_ROMAN,8.0f,Font.BOLD);

    public static Paragraph createParagraphLineData(String value, int alignment, Font font) {
        Paragraph lineData = new Paragraph(value);
        lineData.setExtraParagraphSpace(0);
        lineData.setAlignment(alignment);

        if(font != null) {
            lineData.setFont(font);
        }

        return lineData;
    }

    public static List<PdfPCell> createDataTableDataRow(String label, String value, int alignment, Font font) {
        PdfPCell labelCell = new PdfPCell();
        Font f = new Font(Font.FontFamily.TIMES_ROMAN,10.0f,Font.BOLD);
        Paragraph labelParagraph = new Paragraph(label);
        labelParagraph.setAlignment(alignment);
        labelParagraph.setFont(font);
        labelCell.addElement(labelParagraph);
        labelCell.setBorder(0);
        labelCell.setUseAscender(true);
        labelCell.setVerticalAlignment(Element.ALIGN_MIDDLE);
        PdfPCell valueCell = new PdfPCell();
        Paragraph valueParagraph = new Paragraph(value);
        valueParagraph.setAlignment(alignment);
        valueParagraph.setFont(f);
        valueCell.addElement(valueParagraph);
        valueCell.setBorder(0);
        valueCell.setUseAscender(true);
        valueCell.setPadding(5);
        valueCell.setVerticalAlignment(Element.ALIGN_MIDDLE);
        return List.of(labelCell, valueCell);
    }
}
