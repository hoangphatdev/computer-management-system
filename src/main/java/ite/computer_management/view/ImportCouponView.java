
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
import javax.swing.border.BevelBorder;
import javax.swing.table.DefaultTableModel;


import ite.computer_management.controller.ImportsCouponController;

import ite.computer_management.dao.AccountDAO;
import ite.computer_management.dao.Details_ImportDAO;
import ite.computer_management.dao.ImportCouponDAO;
import ite.computer_management.dao.ImportDAO;

import ite.computer_management.dao.SupplierDAO;

import ite.computer_management.model.Details_Form;
import ite.computer_management.model.ImportsForm;

import javax.swing.JScrollPane;
import javax.swing.JTable;

import javax.swing.JTextField;
import javax.swing.JButton;


import java.awt.Font;

import java.text.DecimalFormat;
import java.text.SimpleDateFormat;
import java.util.ArrayList;

import javax.swing.BorderFactory;
import javax.swing.Box;
import javax.swing.ImageIcon;

public class ImportCouponView extends JPanel {
	public static DefaultTableModel model;
	private static final long serialVersionUID = 1L;
	public static JTable table;
	public JTextField searchTxt;
	public JButton excelBtn;

	public Dashboard dashboard;

	public JButton btnExcel;
	public JButton btnUpdate;
	public JButton btndelete;
	DecimalFormat formatter = new DecimalFormat("###,###,###");
    SimpleDateFormat formatDate = new SimpleDateFormat("dd/MM/YYYY HH:mm");
    private ImportsProductView IF;
    private Edit_ImportsCouponView EICV;
    public JButton btnshowdetail;
    public JButton btnRefresh;
	
    public DecimalFormat getFormatter() {
        return formatter;
    }

    public SimpleDateFormat getFormatDate() {
        return formatDate;
    }
    public ImportCouponView() {
    	init();
    	displayTable();
 
    }
    
	public void init() {
		ImportsCouponController importsCouponController = new ImportsCouponController(this);
		this.setSize(1250,800);
		setLayout(null);
		
		setBackground(new Color(72, 61, 139));
		JScrollPane scrollPane = new JScrollPane(JScrollPane.VERTICAL_SCROLLBAR_ALWAYS, JScrollPane.HORIZONTAL_SCROLLBAR_ALWAYS);
		scrollPane.setBounds(36, 243, 1163, 466);
		add(scrollPane);
		//create table and fetch data from database
		table = new JTable();
		table.setModel(new DefaultTableModel(
			new Object[][] {
			},
			new String[] {
				"Number", "Form code", "Supplier ", "Creator", "Time", "Total amount"
			}
		));
		ImportCouponDAO importCouponDAO = new ImportCouponDAO(this);
		importCouponDAO.selectAll();
		scrollPane.setViewportView(table);

		scrollPane.setViewportView(table);
		searchTxt = new JTextField();
		searchTxt.addKeyListener(importsCouponController);
		searchTxt.setBounds(792, 54, 385, 40);
		add(searchTxt);
		searchTxt.setColumns(10);
		
		JLabel searchLbl = new JLabel("Search:");
		searchLbl.setForeground(new Color(255, 255, 255));
		searchLbl.setFont(new Font("Dialog", Font.BOLD, 17));
		searchLbl.setBounds(793, 10, 134, 48);
		add(searchLbl);
		
		Box verticalBox = Box.createVerticalBox();
		verticalBox.setBorder(new BevelBorder(BevelBorder.LOWERED, null, null, null, null));
		verticalBox.setBounds(772, 20, 427, 102);
		add(verticalBox);
		
		 btndelete = new JButton("Delete");
		 btndelete.setForeground(Color.WHITE);
		 btndelete.setIcon(new ImageIcon("D:\\JAVA_project\\computer-management-system\\src\\main\\java\\ite\\computer_management\\img\\cancel 30.png"));
		 btndelete.setFont(new Font("Tahoma", Font.BOLD, 17));
		btndelete.setBackground(new Color(51, 0, 102));
		btndelete.setBounds(36, 86, 159, 40);
		add(btndelete);
		btndelete.addMouseListener(importsCouponController);
		
		 btnUpdate = new JButton("Update");
		 btnUpdate.setForeground(Color.WHITE);
		 btnUpdate.setIcon(new ImageIcon("D:\\JAVA_project\\computer-management-system\\src\\main\\java\\ite\\computer_management\\img\\edit 30.png"));
		 btnUpdate.setFont(new Font("Tahoma", Font.BOLD, 17));
		btnUpdate.setBackground(new Color(51, 0, 102));
		btnUpdate.setBounds(36, 136, 190, 40);
		add(btnUpdate);
		btnUpdate.addMouseListener(importsCouponController);
		
		btnExcel = new JButton("Export excel");
		btnExcel.setForeground(Color.WHITE);
		btnExcel.setIcon(new ImageIcon("D:\\JAVA_project\\computer-management-system\\src\\main\\java\\ite\\computer_management\\img\\excel 30.png"));
		btnExcel.setFont(new Font("Tahoma", Font.BOLD, 17));
		btnExcel.setBackground(new Color(51, 0, 102));
		btnExcel.setBounds(1018, 193, 181, 40);
		add(btnExcel);
		
		JLabel searchLbl_1 = new JLabel("");
		searchLbl_1.setIcon(new ImageIcon("D:\\JAVA_project\\computer-management-system\\src\\main\\java\\ite\\computer_management\\img\\logo2.png"));
		searchLbl_1.setForeground(Color.WHITE);
		searchLbl_1.setFont(new Font("Dialog", Font.BOLD, 17));
		searchLbl_1.setBounds(373, 10, 673, 424);
		add(searchLbl_1);
		
		btnshowdetail = new JButton("display detail");
		btnshowdetail.setIcon(new ImageIcon("D:\\JAVA_project\\computer-management-system\\src\\main\\java\\ite\\computer_management\\img\\detail 20.png"));
		btnshowdetail.setForeground(Color.WHITE);
		btnshowdetail.setFont(new Font("Tahoma", Font.BOLD, 17));
		btnshowdetail.setBackground(new Color(51, 0, 102));
		btnshowdetail.setBounds(36, 186, 223, 40);
		add(btnshowdetail);
		
		btnRefresh = new JButton("Refresh");
		btnRefresh.setIcon(new ImageIcon("D:\\JAVA_project\\computer-management-system\\src\\main\\java\\ite\\computer_management\\img\\reload 30.png"));
		btnRefresh.setForeground(Color.WHITE);
		btnRefresh.setFont(new Font("Tahoma", Font.BOLD, 17));
		btnRefresh.setBackground(new Color(51, 0, 102));
		btnRefresh.setBounds(837, 193, 159, 40);
		add(btnRefresh);
		btnExcel.addMouseListener(importsCouponController);


		
	}
	public void clickDeleteLbl() {
		 if (table.getSelectedRow() == -1) {
	            JOptionPane.showMessageDialog(this, "Please select the row to delete");
	        } else {
	            deletePhieuNhap(getPhieuNhapSelect());
	        }
	}
	public void deletePhieuNhap(ImportsForm pn) {
	    int result = JOptionPane.showConfirmDialog(this, "are you sure to delete " + pn.getForm_Code(), "yes", JOptionPane.YES_NO_OPTION);
	    if (result == JOptionPane.YES_OPTION) {
	        try {  
	            ArrayList<Details_Form> detailsForms = Details_ImportDAO.getInstance().selectAll(pn.getForm_Code());
	      
	            for (Details_Form detail : detailsForms) {
	                Details_ImportDAO.getInstance().delete(detail);
	            }     
	            ImportCouponDAO.getInstance().delete(pn);       
	            JOptionPane.showMessageDialog(this, "form successfully deleted" + pn.getForm_Code());  
	            displayTable();
	        } catch (Exception e) {
	            JOptionPane.showMessageDialog(this, "fail" + e.getMessage());
	            e.printStackTrace();
	        }
	    }
	}


	public void clickSearchBtn() {
	
	}
	public void clickExportExcel() {
			
    }
	public void clickEditBtn() {
		int check = table.getSelectedRowCount();
		int selectedRowIndex = table.getSelectedRow();
		if(check <1) { 
			JOptionPane.showMessageDialog(null, "Please select row to edit >< ");
		}else {
			Edit_ImportsCouponView view = new Edit_ImportsCouponView(this);
			view.loadDataToTableProduct(this);
			view.setVisible(true);
		}
	}
	public void displayTable() {
	    try {
	        DefaultTableModel table_model = (DefaultTableModel) table.getModel();
	        ArrayList<ImportsForm> allPhieuNhap = ImportCouponDAO.getInstance().selectAll();
	        table_model.setRowCount(0);
	        int stt = 1;
	        for (int i = 0; i < allPhieuNhap.size(); i++) {
	            table_model.addRow(new Object[]{
	                stt++, allPhieuNhap.get(i).getForm_Code(), SupplierDAO.getInstance().selectById(allPhieuNhap.get(i).getSupplier()).getSupplier_Name(), AccountDAO.getInstance().selectById(allPhieuNhap.get(i).getCreator()).getFullName(), formatDate.format(allPhieuNhap.get(i).getTime_Start()), formatter.format(allPhieuNhap.get(i).getTotal_Amount()) + "đ"
	            });
	        }
	        System.out.println("Data loaded successfully!");
	    } catch (Exception e) {
	        System.out.println("Failed to load data: " + e.getMessage());
	        e.printStackTrace();
	    }
	}
    public ImportsForm getPhieuNhapSelect() {
    	DefaultTableModel table_model = (DefaultTableModel) table.getModel();
        int i_row = table.getSelectedRow();
        ImportsForm pn = ImportDAO.getInstance().selectById(table_model.getValueAt(i_row, 1).toString());
        return pn;
    }
}

