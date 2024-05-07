
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
import ite.computer_management.dao.AccountDAO;
import ite.computer_management.dao.ImportCouponDAO;
import ite.computer_management.dao.ProductDAO;
import ite.computer_management.dao.SupplierDAO;
import ite.computer_management.model.Computer;
import ite.computer_management.model.ImportsForm;

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
import java.text.DecimalFormat;
import java.text.SimpleDateFormat;
import java.util.ArrayList;

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
	DecimalFormat formatter = new DecimalFormat("###,###,###");
    SimpleDateFormat formatDate = new SimpleDateFormat("dd/MM/YYYY HH:mm");
	
    public DecimalFormat getFormatter() {
        return formatter;
    }

    public SimpleDateFormat getFormatDate() {
        return formatDate;
    }
    
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
		table.setModel(new DefaultTableModel(
			new Object[][] {
			},
			new String[] {
				"Number", "Form code", "Supplier", "Creator", "Creation time", "Total amount"
			}
		));
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
	
	}
	public void clickSearchBtn() {
	
	}
	public void clickExportExcel() {
			
    }
	public void clickEditBtn() {
	
		
	}
	
	  public void loadDataToTable() {
	        try {
	            ArrayList<ImportsForm> allPhieuNhap = ImportCouponDAO.getInstance().selectAll();
	            model.setRowCount(0);
	            for (int i = 0; i < allPhieuNhap.size(); i++) {
	                model.addRow(new Object[]{
	                    i + 1, allPhieuNhap.get(i).getForm_Code(), SupplierDAO.getInstance().selectById(allPhieuNhap.get(i).getSupplier()).getSupplier_Name(), AccountDAO.getInstance().selectById(allPhieuNhap.get(i).getCreator()).getFullName(), formatDate.format(allPhieuNhap.get(i).getTime_Start()), formatter.format(allPhieuNhap.get(i).getTotal_Amount()) + "đ"
	                });
	            }
	        } catch (Exception e) {
	        }
	    }
}

