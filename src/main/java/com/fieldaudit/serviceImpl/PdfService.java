package com.fieldaudit.serviceImpl;

import com.fieldaudit.dto.DoctorPdfDTO;
import com.lowagie.text.Document;
import com.lowagie.text.Font;
import com.lowagie.text.Paragraph;
import com.lowagie.text.pdf.PdfPTable;
import com.lowagie.text.pdf.PdfWriter;
import org.springframework.stereotype.Service;


import java.io.ByteArrayOutputStream;
import java.util.List;

@Service
public class PdfService {

    public byte[] generateDoctorsPdf(List<DoctorPdfDTO> doctors) {
        ByteArrayOutputStream baos = new ByteArrayOutputStream();

        try {
            Document document = new Document();
            PdfWriter.getInstance(document, baos);

            document.open();

            // Title
            Font titleFont = new Font(Font.HELVETICA, 16, Font.BOLD);
            document.add(new Paragraph("Doctors List", titleFont));
            document.add(new Paragraph("\n"));

            PdfPTable table = new PdfPTable(6);
            table.setWidthPercentage(100);

            table.addCell("Doctor ID");
            table.addCell("First Name");
            table.addCell("Last Name");
            table.addCell("Gender");
            table.addCell("Contact No");
            table.addCell("Hospital");

            for (DoctorPdfDTO d : doctors) {
                table.addCell(String.valueOf(d.getId()));
                table.addCell(d.getFirstName());
                table.addCell(d.getLastName());
                table.addCell(d.getGender());
                table.addCell(d.getContactNo());
                table.addCell(d.getHospitalName());
            }

            document.add(table);
            document.close();

        } catch (Exception e) {
            e.printStackTrace();
        }

        return baos.toByteArray();
    }
}

