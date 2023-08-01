package com.example.StudentMangementSystem.utils;

import java.io.IOException;
import java.util.List;
import jakarta.servlet.http.HttpServletResponse;
import com.example.StudentMangementSystem.entity.Student;
import com.lowagie.text.Document;
import com.lowagie.text.DocumentException;
import com.lowagie.text.Font;
import com.lowagie.text.FontFactory;
import com.lowagie.text.PageSize;
import com.lowagie.text.Paragraph;
import com.lowagie.text.Phrase;
import com.lowagie.text.pdf.CMYKColor;
import com.lowagie.text.pdf.PdfPCell;
import com.lowagie.text.pdf.PdfPTable;
import com.lowagie.text.pdf.PdfWriter;

public class PdfGenerator {
    public void generate(List < Student > studentList, HttpServletResponse response) throws DocumentException, IOException {
        Document document = new Document(PageSize.A4);
        PdfWriter.getInstance(document, response.getOutputStream());
        document.open();
        Font fontTitle = FontFactory.getFont(FontFactory.TIMES_ROMAN);
        fontTitle.setSize(20);
        Paragraph paragraph1 = new Paragraph("List of the Students", fontTitle);
        paragraph1.setAlignment(Paragraph.ALIGN_CENTER);
        document.add(paragraph1);
        PdfPTable table = new PdfPTable(4);
        table.setWidthPercentage(100 );
        table.setWidths(new int[] {3,3,3,3});
        table.setSpacingBefore(5);
        PdfPCell cell = new PdfPCell();
        cell.setBackgroundColor(CMYKColor.BLUE);
        cell.setPadding(5);
        Font font = FontFactory.getFont(FontFactory.TIMES_ROMAN);
        font.setColor(CMYKColor.WHITE);
        cell.setPhrase(new Phrase("ID", font));
        table.addCell(cell);
        cell.setPhrase(new Phrase("Student Name", font));
        table.addCell(cell);
        cell.setPhrase(new Phrase("Email", font));
        table.addCell(cell);
        cell.setPhrase(new Phrase("Mobile Number", font));
        table.addCell(cell);
        for (Student student: studentList) {
            table.addCell(String.valueOf(student.getId()));
            table.addCell(student.getStudentName());
            table.addCell(student.getEmail());
            table.addCell(student.getMobileNumber());
        }
        document.add(table);
        document.close();
    }
}