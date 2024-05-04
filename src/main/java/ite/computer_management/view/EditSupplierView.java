package ite.computer_management.view;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

import ite.computer_management.controller.EditProductController;
import ite.computer_management.controller.EditSupplierController;
import ite.computer_management.dao.ProductDAO;
import ite.computer_management.dao.SupplierDAO;
import ite.computer_management.model.Computer;
import ite.computer_management.model.Supplier;

import javax.swing.JTextField;
import javax.swing.JLabel;
import javax.swing.JButton;
import java.awt.Color;
import javax.swing.SwingConstants;
import java.awt.Font;
import java.math.BigDecimal;

public class EditSupplierView extends JFrame {

	private static final long serialVersionUID = 1L;
	private JPanel contentPane;
	public JButton cancelBtn;
	public  JButton updateBtn;
	/**
	 * Create the frame.
	 */
	public SupplierView supplierView;
	public JTextField SupplierNameTxt;
	public JTextField SupplierCodeTxt;
	public JTextField AddressTxt;
	public JTextField PhoneTxt;
	public JLabel savebtn;
	public JLabel cancelbtn;
	public Dashboard dashboard;
	
	public EditSupplierView(SupplierView supplierView, Dashboard dashboard) {
		this.supplierView = supplierView;
		EditSupplierController editSupplierController = new EditSupplierController(this);
		
		
		
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 700, 450);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));

		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JLabel titleLbl = new JLabel("EDIT SUPPLIER");
		titleLbl.setFont(new Font("Tahoma", Font.PLAIN, 21));
		titleLbl.setHorizontalAlignment(SwingConstants.CENTER);
		titleLbl.setBounds(0, 0, 700, 139);
		titleLbl.setBackground(Color.gray);
		titleLbl.setOpaque(true);
		contentPane.add(titleLbl);
		
		JLabel SupplierNameLbl = new JLabel("Supplier Name");
		SupplierNameLbl.setBackground(Color.gray);
		SupplierNameLbl.setOpaque(true);
		SupplierNameLbl.setHorizontalAlignment(SwingConstants.CENTER);
		SupplierNameLbl.setBounds(27, 162, 217, 41);
		contentPane.add(SupplierNameLbl);
		
		JLabel SupplierCodeLbl = new JLabel("Supplier Code");
		SupplierCodeLbl.setOpaque(true);
		SupplierCodeLbl.setHorizontalAlignment(SwingConstants.CENTER);
		SupplierCodeLbl.setBackground(Color.gray);
		SupplierCodeLbl.setBounds(281, 162, 217, 41);
		contentPane.add(SupplierCodeLbl);
		
		JLabel AddressLbl = new JLabel("Address");
		AddressLbl.setOpaque(true);
		AddressLbl.setHorizontalAlignment(SwingConstants.CENTER);
		AddressLbl.setBackground(Color.gray);
		AddressLbl.setBounds(27, 267, 217, 41);
		contentPane.add(AddressLbl);
		
		JLabel PhoneNumberLbl = new JLabel("Phone Number");
		PhoneNumberLbl.setOpaque(true);
		PhoneNumberLbl.setHorizontalAlignment(SwingConstants.CENTER);
		PhoneNumberLbl.setBackground(Color.gray);
		PhoneNumberLbl.setBounds(281, 267, 217, 41);
		contentPane.add(PhoneNumberLbl);
		
		SupplierNameTxt = new JTextField();
		SupplierNameTxt.setBounds(27, 204, 217, 41);
		contentPane.add(SupplierNameTxt);
		SupplierNameTxt.setColumns(10);
		
		SupplierCodeTxt = new JTextField();
		SupplierCodeTxt.setColumns(10);
		SupplierCodeTxt.setBounds(281, 204, 217, 41);
		contentPane.add(SupplierCodeTxt);
		
		AddressTxt = new JTextField();
		AddressTxt.setColumns(10);
		AddressTxt.setBounds(27, 304, 217, 41);
		contentPane.add(AddressTxt);
		
		PhoneTxt = new JTextField();
		PhoneTxt.setColumns(10);
		PhoneTxt.setBounds(281, 305, 217, 41);
		contentPane.add(PhoneTxt);
		
		savebtn = new JLabel("SAVE");
		savebtn.setBackground(Color.GREEN);
		savebtn.setOpaque(true);
		savebtn.setForeground(Color.white);
		savebtn.setHorizontalAlignment(SwingConstants.CENTER);
		savebtn.setBounds(357, 359, 141, 41);
		savebtn.addMouseListener(editSupplierController);
		contentPane.add(savebtn);
		
		cancelbtn = new JLabel("Cancel");
		cancelbtn.setBackground(Color.red);
		cancelbtn.setOpaque(true);
		cancelbtn.setForeground(Color.white);
		cancelbtn.setHorizontalAlignment(SwingConstants.CENTER);
		cancelbtn.setBounds(528, 359, 141, 41);
		cancelbtn.addMouseListener(editSupplierController);
		contentPane.add(cancelbtn);
		
		this.setLocationRelativeTo(null);
		setVisible(true);
	}
	public void clickUpdateBtn() {	
		int selectedRowIndex = this.supplierView.table.getSelectedRow();
		String condition_Supplier_Code = (String) this.supplierView.table.getValueAt(selectedRowIndex, 1);
		String Supplier_Code = SupplierCodeTxt.getText();
		String Supplier_Name = SupplierNameTxt.getText();
		String Phone_Number = PhoneTxt.getText();
		String Address = AddressTxt.getText();

		Supplier sup = new Supplier(Supplier_Code, Supplier_Name, Phone_Number, Address);
		//back-end
		int check = SupplierDAO.getInstance().update(sup, condition_Supplier_Code);
			//front-end
		supplierView.model.setValueAt(Supplier_Code, selectedRowIndex, 0);
		supplierView.model.setValueAt(Supplier_Name, selectedRowIndex, 1);
		supplierView.model.setValueAt(Phone_Number, selectedRowIndex, 2);
		supplierView.model.setValueAt(Address, selectedRowIndex, 3);
	
	}
	public void clickCancelBtn() {
			this.dispose();
	}
	
}
