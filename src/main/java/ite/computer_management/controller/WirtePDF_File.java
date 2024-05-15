package ite.computer_management.controller;

import com.itextpdf.text.Chunk;
import com.itextpdf.text.Document;
import com.itextpdf.text.DocumentException;
import com.itextpdf.text.Element;
import com.itextpdf.text.Font;
import com.itextpdf.text.FontFactory;
import com.itextpdf.text.Paragraph;
import com.itextpdf.text.Phrase;
import com.itextpdf.text.pdf.BaseFont;
import com.itextpdf.text.pdf.PdfPCell;
import com.itextpdf.text.pdf.PdfPTable;
import com.itextpdf.text.pdf.PdfWriter;

import ite.computer_management.dao.AccountDAO;
import ite.computer_management.dao.Details_ImportDAO;
import ite.computer_management.dao.ImportDAO;
import ite.computer_management.dao.SupplierDAO;
import ite.computer_management.dao.computerDAO;
import ite.computer_management.model.Computer;
import ite.computer_management.model.Details_Form;
import ite.computer_management.model.ImportsForm;

import javax.swing.*;
import java.awt.*;
import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.math.BigDecimal;
import java.text.DecimalFormat;
import java.text.SimpleDateFormat;

public class WirtePDF_File {

    DecimalFormat formatter = new DecimalFormat("###,###,###");
    SimpleDateFormat formatDate = new SimpleDateFormat("dd/MM/YYYY HH:mm");
    Document document = new Document();
    Font fontData;
    Font fontTitle;
    Font fontHeader;

    public WirtePDF_File() throws DocumentException {
        // Load fonts
		fontData = FontFactory.getFont("Arial", BaseFont.IDENTITY_H, BaseFont.EMBEDDED, 11);
		fontTitle = FontFactory.getFont("Arial", BaseFont.IDENTITY_H, BaseFont.EMBEDDED, 25);
		fontHeader = FontFactory.getFont("Arial", BaseFont.IDENTITY_H, BaseFont.EMBEDDED, 11);
    }

    public void chooseURL(String url) {
        try {
            document.close();
            document = new Document();
            PdfWriter.getInstance(document, new FileOutputStream(url));
            document.open();
        } catch (Exception ex) {
            ex.printStackTrace();
            JOptionPane.showMessageDialog(null, "Cannot create PDF document!");
        }
    }

    public void setTitle(String title) {
        try {
            Paragraph pdfTitle = new Paragraph(title, fontTitle);
            pdfTitle.setAlignment(Element.ALIGN_CENTER);
            document.add(pdfTitle);
            document.add(Chunk.NEWLINE);
        } catch (DocumentException ex) {
            ex.printStackTrace();
        }
    }

    private String getFile(String name) {
        FileDialog fd = new FileDialog((JFrame)null, "Export PDF", FileDialog.SAVE);
        fd.setFile(name + ".pdf");
        fd.setVisible(true);
        String url = fd.getDirectory() + fd.getFile();
        if (url.equals("nullnull.pdf")) {
            return null;
        }
        return url;
    }

    public void writePhieuNhap(String mapn) {
        String url = getFile(mapn);
        if (url == null) {
            return;
        }
        try {
            document = new Document();
            PdfWriter.getInstance(document, new FileOutputStream(url));
            document.open();

            setTitle("ENTRY FORM INFORMATION");

            ImportsForm pn = ImportDAO.getInstance().selectById(mapn);

            Paragraph para1 = new Paragraph("Form code: " + pn.getForm_Code() + "\nTime: " + formatDate.format(pn.getTime_Start()), fontData);
            Paragraph para2 = new Paragraph("Creator: " + AccountDAO.getInstance().selectById(pn.getCreator()).getFullName()
                    + "\nSupplier: " + SupplierDAO.getInstance().selectById(pn.getSupplier()).getSupplier_Name() + "  -  " + pn.getSupplier(), fontData);
            document.add(para1);
            document.add(para2);
            document.add(Chunk.NEWLINE);

            // Create table for details
            PdfPTable pdfTable = new PdfPTable(5);
            pdfTable.setWidths(new float[]{10f, 30f, 15f, 5f, 15f});

            // Set headers for the table
            pdfTable.addCell(new PdfPCell(new Phrase("Computer code", fontHeader)));
            pdfTable.addCell(new PdfPCell(new Phrase("Computer name", fontHeader)));
            pdfTable.addCell(new PdfPCell(new Phrase("Price", fontHeader)));
            pdfTable.addCell(new PdfPCell(new Phrase("quantity", fontHeader)));
            pdfTable.addCell(new PdfPCell(new Phrase("Total amount", fontHeader)));

            // Fill table with data
            for (Details_Form ctpn : Details_ImportDAO.getInstance().selectAll(mapn)) {
                Computer mt = computerDAO.getInstance().selectById(ctpn.getComputer_Code());
                pdfTable.addCell(new PdfPCell(new Phrase(ctpn.getComputer_Code(), fontData)));
                pdfTable.addCell(new PdfPCell(new Phrase(mt.getComputerName(), fontData)));
                pdfTable.addCell(new PdfPCell(new Phrase(formatter.format(mt.getPrice()) + "đ", fontData)));
                pdfTable.addCell(new PdfPCell(new Phrase(String.valueOf(ctpn.getQuantity()), fontData)));
                BigDecimal quantity = BigDecimal.valueOf(ctpn.getQuantity());
                BigDecimal totalPrice = quantity.multiply(mt.getPrice());
                pdfTable.addCell(new PdfPCell(new Phrase(formatter.format(totalPrice) + "đ", fontData)));
            }

            document.add(pdfTable);
            document.add(Chunk.NEWLINE);

            Paragraph paraTongThanhToan = new Paragraph("Total amount: " + formatter.format(pn.getTotal_Amount()) + "đ", fontData);
            document.add(paraTongThanhToan);
            document.close();
            JOptionPane.showMessageDialog(null, "The PDF file has been created successfully: " + url);
            openFile(url);

        } catch (Exception ex) {
            ex.printStackTrace();
            JOptionPane.showMessageDialog(null, "There was an error creating the PDF file: " + url);
        }
    }

    private void openFile(String file) {
        try {
            File path = new File(file);
            Desktop.getDesktop().open(path);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
