
package ite.computer_management.view;

import javax.swing.JPanel; 

import java.awt.Color;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;

import javax.swing.BorderFactory;
import javax.swing.JFileChooser;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.SwingConstants;
import javax.swing.border.Border;
import javax.swing.table.DefaultTableModel;
import javax.swing.table.TableRowSorter;

import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

import ite.computer_management.controller.AccountController;
import ite.computer_management.dao.AccountDAO;
import ite.computer_management.model.Account;

import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.JTextField;
import javax.swing.RowFilter;
import javax.swing.ImageIcon;
import java.awt.Font;

public class AccountView extends JPanel {

	private static final long serialVersionUID = 1L;
	public JTable table;
	public DefaultTableModel model;
	public JLabel addLbl;
	public JLabel deleteLbl;
	public JLabel editLbl;
	public JLabel exportExcelLbl;
	public AccountDAO accountDAO;
	public JTextField searchAreaTxt;
	public Dashboard dashboard;
	private JLabel label;
	private JLabel bgLbl;

	/**
	 * Create the panel.
	 */
	public AccountView(Dashboard dashboard) {
		this.dashboard = dashboard;
		init();
		this.setVisible(true);
		
	}
	public void init(){
		AccountController accountController = new AccountController(this);
		accountDAO = new AccountDAO(this);
		
		this.setSize(1250,800);
		setLayout(null);
		addLbl = new JLabel("Add");
		addLbl.setBorder(BorderFactory.createDashedBorder(Color.black));
		addLbl.setBackground(new Color(214, 210, 199));
		addLbl.setOpaque(true);
		addLbl.setFont(new Font("Inter", Font.BOLD, 14));
		addLbl.setIcon(new ImageIcon("C:\\Users\\latru\\Desktop\\computer_management\\src\\main\\java\\ite\\computer_management\\img\\add 20.png"));
		addLbl.setHorizontalAlignment(SwingConstants.CENTER);
		addLbl.setBounds(578, 150, 100, 44);
		addLbl.addMouseListener(accountController);
		add(addLbl);
		
		deleteLbl = new JLabel("Delete");
		deleteLbl.setFont(new Font("Inter", Font.BOLD, 14));
		deleteLbl.setIcon(new ImageIcon("C:\\Users\\latru\\Desktop\\computer_management\\src\\main\\java\\ite\\computer_management\\img\\delete 20.png"));
		deleteLbl.setHorizontalAlignment(SwingConstants.CENTER);
		deleteLbl.setBounds(688, 150, 100, 44);
		deleteLbl.setBorder(BorderFactory.createDashedBorder(Color.black) );
		deleteLbl.setBackground(new Color(214, 210, 199));
		deleteLbl.setOpaque(true);
		deleteLbl.addMouseListener(accountController);
		add(deleteLbl);
		
		editLbl = new JLabel("Edit");
		editLbl.setFont(new Font("Inter", Font.BOLD, 14));
		editLbl.setIcon(new ImageIcon("C:\\Users\\latru\\Desktop\\computer_management\\src\\main\\java\\ite\\computer_management\\img\\edit 20 (1).png"));
		editLbl.setHorizontalAlignment(SwingConstants.CENTER);
		editLbl.setBounds(798, 150, 100, 44);
		editLbl.setBackground(new Color(214, 210, 199));
		editLbl.setBorder(BorderFactory.createDashedBorder(Color.black));
		editLbl.setOpaque(true);
		editLbl.addMouseListener(accountController);
		add(editLbl);
		
		exportExcelLbl = new JLabel("Export Excel");
		exportExcelLbl.setIcon(new ImageIcon("C:\\Users\\latru\\Desktop\\computer_management\\src\\main\\java\\ite\\computer_management\\img\\excel 20.png"));
		exportExcelLbl.setFont(new Font("Inter", Font.BOLD, 14));
		exportExcelLbl.setHorizontalAlignment(SwingConstants.CENTER);
		exportExcelLbl.setBounds(1026, 150, 170, 44);
		exportExcelLbl.setBorder(BorderFactory.createDashedBorder(Color.black));
		exportExcelLbl.setBackground(new Color(214, 210, 199));
		exportExcelLbl.setOpaque(true);
		exportExcelLbl.addMouseListener(accountController);
		add(exportExcelLbl);
		
		JScrollPane scrollPane = new JScrollPane();
		scrollPane.setBounds(29, 244, 1168, 481);
		add(scrollPane);
		//Create table and fetch data from database
		table = new JTable();
		model = (DefaultTableModel) table.getModel();
		AccountDAO accountDAO = new AccountDAO(this);
		accountDAO.selectAll();
		
		scrollPane.setViewportView(table);
		
		searchAreaTxt = new JTextField();
		searchAreaTxt.setBounds(130, 148, 397, 44);
		add(searchAreaTxt);
		searchAreaTxt.addKeyListener(accountController);
		searchAreaTxt.setColumns(10);
		
		JLabel searchTitleLbl = new JLabel("Search: ");
		searchTitleLbl.setFont(new Font("Inter", Font.BOLD, 15));
		searchTitleLbl.setBounds(41, 154, 60, 27);
		add(searchTitleLbl);
		JLabel borderLbl = new JLabel("");
		borderLbl.setBounds(29, 128, 522, 87);
		Border border = BorderFactory.createLineBorder(Color.black);
		borderLbl.setBorder(border);
		add(borderLbl);
		
		JLabel seeDetailLbl = new JLabel("See Detail");
		seeDetailLbl.setIcon(new ImageIcon("C:\\Users\\latru\\Desktop\\computer_management\\src\\main\\java\\ite\\computer_management\\img\\detail 20.png"));
		seeDetailLbl.setOpaque(true);
		seeDetailLbl.setHorizontalAlignment(SwingConstants.CENTER);
		seeDetailLbl.setFont(new Font("Inter", Font.BOLD, 14));
		seeDetailLbl.setBorder(BorderFactory.createDashedBorder(Color.black));
		seeDetailLbl.setBackground(new Color(214, 210, 199));
		seeDetailLbl.setBounds(908, 150, 97, 44);
		add(seeDetailLbl);
		
		JLabel titleLbl = new JLabel("ACCOUNT MANAGEMENT");
		titleLbl.setFont(new Font("Bakery", Font.PLAIN, 35));
		titleLbl.setHorizontalAlignment(SwingConstants.CENTER);
		titleLbl.setBounds(0, 0, 1250, 110);
		titleLbl.setOpaque(true);
		titleLbl.setBackground(new Color(54, 51, 46));
		titleLbl.setForeground(new Color(222, 173, 91));
		add(titleLbl);
		
		label = new JLabel("New label");
		label.setBounds(10, 150, 26, -6);
		add(label);
		
		bgLbl = new JLabel("");
		bgLbl.setBounds(0, 105, 1250, 671);
		bgLbl.setOpaque(true);
		bgLbl.setBackground( new Color(191, 186, 166));
		add(bgLbl);
	}
	public void clickAddLbl() {
		dashboard.setVisible(false);
		new AddAccountView(this, dashboard);
	}
	public void clickDeleteLbl() {
		int frontEndCheck = table.getSelectedRowCount();
		
		if(frontEndCheck <1) {
			JOptionPane.showMessageDialog(null, "Please select row to delete.");
		}else {
			int confirm = JOptionPane.showConfirmDialog(null, "Are you sure?");
			if(confirm ==0) {
				int selectedRowIndex = table.getSelectedRow();
				String fullName = (String) model.getValueAt(selectedRowIndex, 0);
				String userName = (String)model.getValueAt(selectedRowIndex, 1);
				Account account = new Account();
				account.setUserName(userName);
				//back-end
				int check = accountDAO.delete(account);
				if(check ==1) {
					//front-end
					model.removeRow(selectedRowIndex);
				}
			}
		}
		
	}
	public void clickEditLbl() {
		int check = table.getSelectedRowCount();
		int selectedRowIndex = table.getSelectedRow();
		if(check <1) {
			JOptionPane.showMessageDialog(null, "Please select row to edit.");
		}else {
			dashboard.setVisible(false);
			String fullName = (String) model.getValueAt(selectedRowIndex, 0);  // getValueAt: first Parameter is: 0
			String userName = (String) model.getValueAt(selectedRowIndex, 1);
			String password = (String) model.getValueAt(selectedRowIndex, 2);
			String role = (String) model.getValueAt(selectedRowIndex, 3);
			
			EditAccountView editAccountView = new EditAccountView(this, dashboard);
			editAccountView.fullNameTxt.setText(fullName); 
			editAccountView.userNameTxt.setText(userName);
			editAccountView.passwordTxt.setText(password);
			editAccountView.roleTxt.setText(role);
			
		}
		
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
			JOptionPane.showMessageDialog(null, "Export successfully ><");
			}catch(FileNotFoundException e) {
				JOptionPane.showMessageDialog(null, e);
			}catch(IOException e) {
				JOptionPane.showMessageDialog(null, e);
			}
	}
	public void enterSearch() {
		DefaultTableModel demo = (DefaultTableModel) table.getModel();
		TableRowSorter<DefaultTableModel> trs = new TableRowSorter<>(demo);
		table.setRowSorter(trs);
		trs.setRowFilter(RowFilter.regexFilter(searchAreaTxt.getText()));
	}
}