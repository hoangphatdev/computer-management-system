
package ite.computer_management.view;

import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

import javax.swing.JPanel; 

import java.awt.Color;
import java.awt.Desktop;

import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.SwingConstants;
import javax.swing.table.DefaultTableModel;
import javax.swing.table.TableRowSorter;

import ite.computer_management.controller.ImportsCouponController;
import ite.computer_management.controller.ProductController;
import ite.computer_management.dao.ImportCouponDAO;
import ite.computer_management.dao.ProductDAO;
import ite.computer_management.model.Computer;

import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.RowFilter;
import javax.swing.JTextField;
import javax.swing.JButton;
import javax.swing.JFileChooser;

import java.awt.Font;
import java.awt.print.PageFormat;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;

import javax.swing.BorderFactory;
import javax.swing.ImageIcon;

public class ImportCouponView extends JPanel {
	public JLabel seeDetailLbl;
	public JLabel deleteLbl;
	public JLabel editLbl;
	public static DefaultTableModel model;
	private static final long serialVersionUID = 1L;
	public static JTable table;
	public JTextField searchTxt;
	public JButton excelBtn;
	private JLabel titleLbl;
	private JLabel borderLbl;
	public Dashboard dashboard;
	private JLabel bgLbl;
	
	public ImportCouponView(Dashboard dashboard) {
		this.dashboard = dashboard;
		ImportsCouponController importsCouponController = new ImportsCouponController(this);
		this.setSize(1250,800);
		setLayout(null);
		
		deleteLbl = new JLabel("Delete");
		deleteLbl.setFont(new Font("Inter", Font.BOLD, 12));
		deleteLbl.setIcon(new ImageIcon("C:\\Users\\latru\\Desktop\\computer_management\\src\\main\\java\\ite\\computer_management\\img\\delete 20.png"));
		deleteLbl.setOpaque(true);
		deleteLbl.setHorizontalAlignment(SwingConstants.CENTER);
	
		deleteLbl.setBounds(670, 152, 100, 40);
		deleteLbl.setBorder(BorderFactory.createDashedBorder(Color.black) );
		deleteLbl.setBackground(new Color(214, 210, 199));
		deleteLbl.addMouseListener(importsCouponController);
		add(deleteLbl);
		
		editLbl = new JLabel("Edit");
		editLbl.setFont(new Font("Inter", Font.BOLD, 12));
		editLbl.setIcon(new ImageIcon("C:\\Users\\latru\\Desktop\\computer_management\\src\\main\\java\\ite\\computer_management\\img\\edit 20 (1).png"));
		editLbl.setOpaque(true);
		editLbl.setHorizontalAlignment(SwingConstants.CENTER);
		editLbl.setBackground(new Color(214, 210, 199));
		editLbl.setBorder(BorderFactory.createDashedBorder(Color.black));
		editLbl.setBounds(791, 152, 100, 40);
		editLbl.addMouseListener(importsCouponController);
		add(editLbl);
		
		seeDetailLbl = new JLabel("See Detail");
		seeDetailLbl.setFont(new Font("Inter", Font.BOLD, 12));
		seeDetailLbl.setIcon(new ImageIcon("C:\\Users\\latru\\Desktop\\computer_management\\src\\main\\java\\ite\\computer_management\\img\\detail 20.png"));
		seeDetailLbl.setOpaque(true);
		seeDetailLbl.setHorizontalAlignment(SwingConstants.CENTER);
		seeDetailLbl.setBorder(BorderFactory.createDashedBorder(Color.black));
		seeDetailLbl.setBackground(new Color(214, 210, 199));
		seeDetailLbl.setBounds(912, 152, 100, 40);
		seeDetailLbl.addMouseListener(importsCouponController);
		add(seeDetailLbl);
		
		excelBtn = new JButton("Export Excel");
		excelBtn.setIcon(new ImageIcon("C:\\Users\\latru\\Desktop\\computer_management\\src\\main\\java\\ite\\computer_management\\img\\excel 20.png"));
		excelBtn.setBounds(1032, 153, 167, 40);
		excelBtn.setOpaque(true);
		excelBtn.setBackground(new Color(214, 210, 199));
		excelBtn.addMouseListener(importsCouponController);
		add(excelBtn);
		
		
		JScrollPane scrollPane = new JScrollPane(JScrollPane.VERTICAL_SCROLLBAR_ALWAYS, JScrollPane.HORIZONTAL_SCROLLBAR_ALWAYS);
		scrollPane.setBounds(36, 243, 1163, 466);
		add(scrollPane);
		//create table and fetch data from database
		table = new JTable();
		model = (DefaultTableModel) table.getModel();
		ImportCouponDAO importCouponDAO = new ImportCouponDAO(this);
		importCouponDAO.selectAll();
		scrollPane.setViewportView(table);
		
		searchTxt = new JTextField();
		searchTxt.addKeyListener(importsCouponController);
		searchTxt.setBounds(105, 154, 407, 40);
		add(searchTxt);
		searchTxt.setColumns(10);
		
		JLabel searchLbl = new JLabel("Search:");
		searchLbl.setFont(new Font("Inter", Font.BOLD, 13));
		searchLbl.setBounds(47, 152, 48, 40);
		add(searchLbl);
		
		titleLbl = new JLabel("PRODUCT MANAGEMENT");
		titleLbl.setFont(new Font("Bakery", Font.PLAIN, 35));
		titleLbl.setHorizontalAlignment(SwingConstants.CENTER);
		titleLbl.setBounds(0, 0, 1250, 110);
		titleLbl.setOpaque(true);
		titleLbl.setBackground(new Color(54, 51, 46));
		titleLbl.setForeground(new Color(222, 173, 91));
		add(titleLbl);
		
		borderLbl = new JLabel("");
		borderLbl.setBounds(35, 130, 488, 88);
		borderLbl.setBorder(BorderFactory.createDashedBorder(Color.black));
		add(borderLbl);
		
		bgLbl = new JLabel("");
		bgLbl.setBounds(0, 114, 1250, 676);
		bgLbl.setBackground(new Color(191, 186, 166));
		bgLbl.setOpaque(true);
		add(bgLbl);
		
	}
	public void clickDeleteLbl() {
		int check = table.getSelectedRowCount();
		int selectedRow = table.getSelectedRow();
		
		if(check <1) {
			JOptionPane.showMessageDialog(null, "Please select row to delete.");
		}else {
			int confirm = JOptionPane.showConfirmDialog(null, "Are you sure?"); // yes:0, no:1
			if(confirm == 0) {
				String computerCode =  model.getValueAt(selectedRow, 1).toString(); // index cua gelValuAt bat dau tu 0
				String computerName = model.getValueAt(selectedRow,0).toString();
				Computer deleteProduct = new Computer();
				deleteProduct.setComputerCode(computerCode);
				int result = ProductDAO.getInstance().delete(deleteProduct);
				System.out.println(result);
				if(result == 1) {
					model.removeRow(selectedRow);
				}
			}
			
		}
	}
	public void clickSearchBtn() {
		DefaultTableModel demo = (DefaultTableModel) table.getModel();
		TableRowSorter<DefaultTableModel> trs = new TableRowSorter<>(demo);
		table.setRowSorter(trs);
		trs.setRowFilter(RowFilter.regexFilter(searchTxt.getText()));
	}
	public void clickExportExcel() {
			try {
				JFileChooser jFileChooser = new JFileChooser();
				jFileChooser.showSaveDialog(this);
				File saveFile = jFileChooser.getSelectedFile();
				
				if(saveFile != null) {
					saveFile = new File(saveFile.toString() + ".xlsx");
					Workbook wb = new XSSFWorkbook();
					Sheet sheet = wb.createSheet("product");
					
					Row rowCol = sheet.createRow(0);
					for(int i=0; i<table.getColumnCount(); i++) {
						Cell cell = rowCol.createCell(i);
						cell.setCellValue(table.getColumnName(i));
					}
					for(int j=0; j<table.getRowCount(); j++) {
						Row row = sheet.createRow(j);
						for(int k=0; k<table.getColumnCount(); k++) {
							Cell cell = row.createCell(k);
							if(table.getValueAt(j, k) != null) {
								cell.setCellValue(table.getValueAt(j, k).toString());
							}
						}
					}
					FileOutputStream out = new FileOutputStream(new File(saveFile.toString()));
					wb.write(out);
					wb.close();
					out.close();
					}
//				JOptionPane.showMessageDialog(null, "Export successfully ><");
				}catch(FileNotFoundException e) {
					JOptionPane.showMessageDialog(null, e);
				}catch(IOException e) {
					JOptionPane.showMessageDialog(null, e);
				}
    }
	public void clickEditBtn() {
			
		int check = table.getSelectedRowCount();
		int selectedRowIndex = table.getSelectedRow();
		if(check <1) { 
			JOptionPane.showMessageDialog(null, "Please select row to edit >< ");
		}else {
			dashboard.setVisible(false);
			Edit_ImportsCouponView edit_ImportsCouponView = new Edit_ImportsCouponView(this, dashboard);
			// chưa xong
	
		}
		
	}
	
	
	
}

