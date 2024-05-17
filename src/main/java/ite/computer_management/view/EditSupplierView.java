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
import javax.swing.ImageIcon;

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
	public Dashboard dashboard;
	public JButton btnSave;
	public JButton btnCancel;
	
	public EditSupplierView(SupplierView supplierView, Dashboard dashboard) {
		this.supplierView = supplierView;
		EditSupplierController editSupplierController = new EditSupplierController(this);
		
		
		
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 700, 450);
		contentPane = new JPanel();
		contentPane.setBackground(new Color(0, 0, 51));
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));

		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JLabel SupplierNameLbl = new JLabel("Supplier Name");
		SupplierNameLbl.setFont(new Font("Tahoma", Font.BOLD, 14));
		SupplierNameLbl.setForeground(new Color(255, 255, 102));
		SupplierNameLbl.setBackground(new Color(51, 51, 102));
		SupplierNameLbl.setOpaque(true);
		SupplierNameLbl.setHorizontalAlignment(SwingConstants.CENTER);
		SupplierNameLbl.setBounds(84, 53, 217, 41);
		contentPane.add(SupplierNameLbl);
		
		JLabel SupplierCodeLbl = new JLabel("Supplier Code");
		SupplierCodeLbl.setFont(new Font("Tahoma", Font.BOLD, 14));
		SupplierCodeLbl.setForeground(new Color(255, 255, 102));
		SupplierCodeLbl.setOpaque(true);
		SupplierCodeLbl.setHorizontalAlignment(SwingConstants.CENTER);
		SupplierCodeLbl.setBackground(new Color(51, 51, 102));
		SupplierCodeLbl.setBounds(338, 53, 217, 41);
		contentPane.add(SupplierCodeLbl);
		
		JLabel AddressLbl = new JLabel("Address");
		AddressLbl.setFont(new Font("Tahoma", Font.BOLD, 14));
		AddressLbl.setForeground(new Color(255, 255, 102));
		AddressLbl.setOpaque(true);
		AddressLbl.setHorizontalAlignment(SwingConstants.CENTER);
		AddressLbl.setBackground(new Color(51, 51, 102));
		AddressLbl.setBounds(84, 170, 217, 41);
		contentPane.add(AddressLbl);
		
		JLabel PhoneNumberLbl = new JLabel("Phone Number");
		PhoneNumberLbl.setFont(new Font("Tahoma", Font.BOLD, 14));
		PhoneNumberLbl.setForeground(new Color(255, 255, 102));
		PhoneNumberLbl.setOpaque(true);
		PhoneNumberLbl.setHorizontalAlignment(SwingConstants.CENTER);
		PhoneNumberLbl.setBackground(new Color(51, 51, 102));
		PhoneNumberLbl.setBounds(338, 170, 217, 41);
		contentPane.add(PhoneNumberLbl);
		
		SupplierNameTxt = new JTextField();
		SupplierNameTxt.setBounds(84, 95, 217, 41);
		contentPane.add(SupplierNameTxt);
		SupplierNameTxt.setColumns(10);
		
		SupplierCodeTxt = new JTextField();
		SupplierCodeTxt.setColumns(10);
		SupplierCodeTxt.setBounds(338, 95, 217, 41);
		contentPane.add(SupplierCodeTxt);
		
		AddressTxt = new JTextField();
		AddressTxt.setColumns(10);
		AddressTxt.setBounds(84, 207, 217, 41);
		contentPane.add(AddressTxt);
		
		PhoneTxt = new JTextField();
		PhoneTxt.setColumns(10);
		PhoneTxt.setBounds(338, 208, 217, 41);
		contentPane.add(PhoneTxt);
		
		btnSave = new JButton("SAVE");
		btnSave.setIcon(new ImageIcon("D:\\JAVA_project\\computer-management-system\\src\\main\\java\\ite\\computer_management\\img\\save 30.png"));
		btnSave.setBackground(Color.GRAY);
		btnSave.setFont(new Font("Tahoma", Font.BOLD, 15));
		btnSave.setBounds(160, 298, 141, 41);
		contentPane.add(btnSave);
		btnSave.addMouseListener(editSupplierController);
		
		btnCancel = new JButton("Cancel");
		btnCancel.setIcon(new ImageIcon("D:\\JAVA_project\\computer-management-system\\src\\main\\java\\ite\\computer_management\\img\\cancel 30.png"));
		btnCancel.setBackground(Color.RED);
		btnCancel.setForeground(Color.BLACK);
		btnCancel.setFont(new Font("Tahoma", Font.BOLD, 15));
		btnCancel.setBounds(338, 298, 141, 41);
		contentPane.add(btnCancel);
		btnCancel.addMouseListener(editSupplierController);
		
		this.setLocationRelativeTo(null);
		setVisible(true);
	}
	public void clickUpdateBtn() {	
		int selectedRowIndex = SupplierView.table.getSelectedRow();
		String Supplier_Code = SupplierCodeTxt.getText();
		String Supplier_Name = SupplierNameTxt.getText();
		String Phone_Number = PhoneTxt.getText();
		String Address = AddressTxt.getText();

		Supplier sup = new Supplier(Supplier_Code, Supplier_Name, Phone_Number, Address);
		//back-end
		int check = SupplierDAO.getInstance().update(sup);			//front-end
		supplierView.model.setValueAt(Supplier_Code, selectedRowIndex, 0);
		supplierView.model.setValueAt(Supplier_Name, selectedRowIndex, 1);
		supplierView.model.setValueAt(Phone_Number, selectedRowIndex, 2);
		supplierView.model.setValueAt(Address, selectedRowIndex, 3);
	
	}
	public void clickCancelBtn() {
			this.dispose();
	}
	
}
