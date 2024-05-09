package ite.computer_management.controller;


import com.itextpdf.text.Chunk;
import com.itextpdf.text.Document;
import com.itextpdf.text.DocumentException;
import com.itextpdf.text.Element;
import com.itextpdf.text.Paragraph;
import com.itextpdf.text.pdf.PdfPTable;
import com.itextpdf.text.pdf.PdfWriter;
import com.itextpdf.text.Font;
import com.itextpdf.text.Phrase;
import com.itextpdf.text.TabSettings;
import com.itextpdf.text.pdf.BaseFont;
import com.itextpdf.text.pdf.PdfPCell;
import com.itextpdf.text.pdf.draw.VerticalPositionMark;

import ite.computer_management.dao.AccountDAO;
import ite.computer_management.dao.Details_ImportDAO;
import ite.computer_management.dao.ImportDAO;
import ite.computer_management.dao.SupplierDAO;
import ite.computer_management.dao.computerDAO;
import ite.computer_management.model.Computer;
import ite.computer_management.model.Details_Form;
import ite.computer_management.model.ImportsForm;

import java.awt.Desktop;
import java.awt.FileDialog;
import java.awt.Point;
import java.awt.Rectangle;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.math.BigDecimal;
import java.text.DecimalFormat;
import java.text.SimpleDateFormat;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JFrame;
import javax.swing.JOptionPane;

public class WirtePDF_File {

    DecimalFormat formatter = new DecimalFormat("###,###,###");
    SimpleDateFormat formatDate = new SimpleDateFormat("dd/MM/YYYY HH:mm");
    Document document = new Document();
    FileOutputStream file;
    JFrame jf = new JFrame();
    FileDialog fd = new FileDialog(jf, "Xuất pdf", FileDialog.SAVE);
    Font fontData;
    Font fontTitle;	
    Font fontHeader;

    public WirtePDF_File() {
        try {
            fontData = new Font(BaseFont.createFont("lib/Roboto/Roboto-Regular.ttf", BaseFont.IDENTITY_H, BaseFont.EMBEDDED), 11, Font.NORMAL);
            fontTitle = new Font(BaseFont.createFont("lib/Roboto/Roboto-Regular.ttf", BaseFont.IDENTITY_H, BaseFont.EMBEDDED), 25, Font.NORMAL);
            fontHeader = new Font(BaseFont.createFont("lib/Roboto/Roboto-Regular.ttf", BaseFont.IDENTITY_H, BaseFont.EMBEDDED), 11, Font.NORMAL);
        } catch (DocumentException | FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException ex) {
            Logger.getLogger(WirtePDF_File.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    public void chooseURL(String url) {
        try {
            document.close();
            document = new Document();
            file = new FileOutputStream(url);
            PdfWriter writer = PdfWriter.getInstance(document, file);
            document.open();
        } catch (FileNotFoundException ex) {
            JOptionPane.showMessageDialog(null, "Khong tim thay duong dan file " + url);
        } catch (DocumentException ex) {
            JOptionPane.showMessageDialog(null, "Khong goi duoc document !");
        }
    }

    public void setTitle(String title) {
        try {
            Paragraph pdfTitle = new Paragraph(new Phrase(title, fontTitle));
            pdfTitle.setAlignment(Element.ALIGN_CENTER);
            document.add(pdfTitle);
            document.add(Chunk.NEWLINE);
        } catch (DocumentException ex) {
            ex.printStackTrace();
        }
    }

    private String getFile(String name) {
        fd.pack();
        fd.setSize(800, 600);
        fd.validate();
        Rectangle rect = jf.getContentPane().getBounds();
        double width = fd.getBounds().getWidth();
        double height = fd.getBounds().getHeight();
        double x = rect.getCenterX() - (width / 2);
        double y = rect.getCenterY() - (height / 2);
        Point leftCorner = new Point();
        leftCorner.setLocation(x, y);
        fd.setLocation(leftCorner);
        fd.setFile(name + ".pdf");
        fd.setVisible(true);
        String url = fd.getDirectory() + fd.getFile();
        if (url.equals("null")) {
            return null;
        }
        return url;
    }

    public void writePhieuNhap(String mapn) {
        String url = "";
        try {
            fd.setTitle("In phiếu nhập");
            fd.setLocationRelativeTo(null);
            url = getFile(mapn);
            if (url == null) {
                return;
            }
            file = new FileOutputStream(url);
            document = new Document();
            PdfWriter writer = PdfWriter.getInstance(document, file);
            document.open();

            setTitle("THÔNG TIN PHIẾU NHẬP");

            ImportsForm pn = ImportDAO.getInstance().selectById(mapn);

            Chunk glue = new Chunk(new VerticalPositionMark());// Khoang trong giua hang
            Paragraph para1 = new Paragraph();
            para1.setFont(fontData);
            para1.add("Mã phiếu: " + pn.getForm_Code());
            para1.add("\nThời gian tạo: " + formatDate.format(pn.getTime_Start()));
            para1.setIndentationLeft(40);
            Paragraph para2 = new Paragraph();
            para2.setPaddingTop(30);
            para2.setFont(fontData);
            para2.add(String.valueOf("Người tạo: " + AccountDAO.getInstance().selectById(pn.getCreator()).getFullName()));
            para2.add(String.valueOf("\nNhà cung cấp: " + SupplierDAO.getInstance().selectById(pn.getSupplier()).getSupplier_Name() + "  -  " + pn.getSupplier()));
            para2.setIndentationLeft(40);
            document.add(para1);
            document.add(para2);
            document.add(Chunk.NEWLINE);//add hang trong de tao khoang cach

            //Tao table cho cac chi tiet cua hoa don
            PdfPTable pdfTable = new PdfPTable(5);
            pdfTable.setWidths(new float[]{10f, 30f, 15f, 5f, 15f});
            PdfPCell cell;

            //Set headers cho table chi tiet
            pdfTable.addCell(new PdfPCell(new Phrase("Mã máy", fontHeader)));
            pdfTable.addCell(new PdfPCell(new Phrase("Tên máy", fontHeader)));
            pdfTable.addCell(new PdfPCell(new Phrase("Đơn giá", fontHeader)));
            pdfTable.addCell(new PdfPCell(new Phrase("SL", fontHeader)));
            pdfTable.addCell(new PdfPCell(new Phrase("Tổng tiền", fontHeader)));

            for (int i = 0; i < 5; i++) {
                cell = new PdfPCell(new Phrase(""));
                pdfTable.addCell(cell);
            }

            //Truyen thong tin tung chi tiet vao table
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

            Paragraph paraTongThanhToan = new Paragraph(new Phrase("Tổng thanh toán: " + formatter.format(pn.getTotal_Amount()) + "đ", fontData));
            paraTongThanhToan.setIndentationLeft(300);
            document.add(paraTongThanhToan);
            document.close();
            JOptionPane.showMessageDialog(null, "Ghi file thành công " + url);
            openFile(url);

        } catch (DocumentException | FileNotFoundException ex) {
            JOptionPane.showMessageDialog(null, "Lỗi khi ghi file " + url);
        }
    }

    private void openFile(String file) {
        try {
            File path = new File(file);
            Desktop.getDesktop().open(path);
        } catch (IOException e) {
            System.out.println(e);
        }
    }

    public void writePhieuXuat(String mapn) {
        String url = "";
        try {
            fd.setTitle("In phiếu Xuất");
            fd.setLocationRelativeTo(null);
            url = getFile(mapn);
            if (url == null) {
                return;
            }
            file = new FileOutputStream(url);
            document = new Document();
            PdfWriter writer = PdfWriter.getInstance(document, file);
            document.open();

            setTitle("THÔNG TIN PHIẾU XUẤT");

            ImportsForm pn = ImportDAO.getInstance().selectById(mapn);

            Paragraph para1 = new Paragraph(new Phrase("Mã phiếu: " + mapn, fontData));
            Paragraph para2 = new Paragraph(new Phrase("Thời gian tạo: " + formatDate.format(pn.getTime_Start()), fontData));
            Paragraph para3 = new Paragraph(new Phrase("Người tạo: " + AccountDAO.getInstance().selectById(pn.getCreator()).getFullName(), fontData));
            para1.setIndentationLeft(40);
            para2.setIndentationLeft(40);
            para3.setIndentationLeft(40);
            document.add(para1);
            document.add(para2);
            document.add(para3);
            document.add(Chunk.NEWLINE);//add hang trong de tao khoang cach

            //Tao table cho cac chi tiet cua hoa don
            PdfPTable pdfTable = new PdfPTable(5);
            pdfTable.setWidths(new float[]{10f, 30f, 15f, 5f, 15f});
            PdfPCell cell;

            //Set headers cho table chi tiet
            pdfTable.addCell(new PdfPCell(new Phrase("Mã máy", fontHeader)));
            pdfTable.addCell(new PdfPCell(new Phrase("Tên máy", fontHeader)));
            pdfTable.addCell(new PdfPCell(new Phrase("Đơn giá", fontHeader)));
            pdfTable.addCell(new PdfPCell(new Phrase("SL", fontHeader)));
            pdfTable.addCell(new PdfPCell(new Phrase("Tổng tiền", fontHeader)));

            for (int i = 0; i < 5; i++) {
                cell = new PdfPCell(new Phrase(""));
                pdfTable.addCell(cell);
            }

            //Truyen thong tin tung chi tiet vao table
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
            Paragraph paraTongThanhToan = new Paragraph(new Phrase("Tổng thanh toán: " + formatter.format(pn.getTotal_Amount()) + "đ", fontData));
            paraTongThanhToan.setIndentationLeft(300);
            document.add(paraTongThanhToan);
            document.close();
            JOptionPane.showMessageDialog(null, "Ghi file thành công: " + url);
            openFile(url);

        } catch (DocumentException | FileNotFoundException ex) {
            JOptionPane.showMessageDialog(null, "Lỗi khi ghi file " + url);
        }

    }
}
