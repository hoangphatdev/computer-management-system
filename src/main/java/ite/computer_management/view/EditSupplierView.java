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
import javax.swing.JOptionPane;
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
	public JTextField AddressTxt;
	public JTextField PhoneTxt;
	public Dashboard dashboard;
	public JButton btnSave;
	public JButton btnCancel;
	
	public EditSupplierView(SupplierView supplierView, Dashboard dashboard) {
		this.supplierView = supplierView;
		EditSupplierController editSupplierController = new EditSupplierController(this);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 814, 380);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JLabel SupplierNameLbl = new JLabel("Supplier Name");
		SupplierNameLbl.setFont(new Font("Tahoma", Font.BOLD, 14));
		SupplierNameLbl.setForeground(new Color(219, 219, 219));
		SupplierNameLbl.setBackground(new Color(70, 163, 100));
		SupplierNameLbl.setOpaque(true);
		SupplierNameLbl.setHorizontalAlignment(SwingConstants.CENTER);
		SupplierNameLbl.setBounds(28, 60, 217, 41);
		contentPane.add(SupplierNameLbl);
		
		JLabel AddressLbl = new JLabel("Address");
		AddressLbl.setFont(new Font("Tahoma", Font.BOLD, 14));
		AddressLbl.setForeground(new Color(219, 219, 219));
		AddressLbl.setOpaque(true);
		AddressLbl.setHorizontalAlignment(SwingConstants.CENTER);
		AddressLbl.setBackground(new Color(70, 163, 100));
		AddressLbl.setBounds(281, 65, 217, 41);
		contentPane.add(AddressLbl);
		
		JLabel PhoneNumberLbl = new JLabel("Phone Number");
		PhoneNumberLbl.setFont(new Font("Tahoma", Font.BOLD, 14));
		PhoneNumberLbl.setForeground(new Color(219, 219, 219));
		PhoneNumberLbl.setOpaque(true);
		PhoneNumberLbl.setHorizontalAlignment(SwingConstants.CENTER);
		PhoneNumberLbl.setBackground(new Color(70, 163, 100));
		PhoneNumberLbl.setBounds(553, 65, 217, 41);
		contentPane.add(PhoneNumberLbl);
		
		SupplierNameTxt = new JTextField();
		SupplierNameTxt.setBounds(28, 102, 217, 41);
		contentPane.add(SupplierNameTxt);
		SupplierNameTxt.setColumns(10);
		
		AddressTxt = new JTextField();
		AddressTxt.setColumns(10);
		AddressTxt.setBounds(281, 102, 217, 41);
		contentPane.add(AddressTxt);
		
		PhoneTxt = new JTextField();
		PhoneTxt.setColumns(10);
		PhoneTxt.setBounds(553, 103, 217, 41);
		contentPane.add(PhoneTxt);
		
		btnSave = new JButton("SAVE");
		btnSave.setIcon(new ImageIcon("D:\\JAVA_project\\computer-management-system\\src\\main\\java\\ite\\computer_management\\img\\save 30.png"));
		btnSave.setBackground(new Color(227, 227, 227));
		btnSave.setForeground(new Color(70, 163, 100));
		btnSave.setFont(new Font("Tahoma", Font.BOLD, 15));
		btnSave.setBounds(230, 222, 141, 41);
		contentPane.add(btnSave);
		btnSave.addMouseListener(editSupplierController);
		
		btnCancel = new JButton("Cancel");
		btnCancel.setIcon(new ImageIcon("D:\\JAVA_project\\computer-management-system\\src\\main\\java\\ite\\computer_management\\img\\cancel 30.png"));
		btnCancel.setBackground(new Color(227, 227, 227));
		btnCancel.setForeground(new Color(214, 46, 9));
		btnCancel.setFont(new Font("Tahoma", Font.BOLD, 15));
		btnCancel.setBounds(408, 222, 141, 41);
		contentPane.add(btnCancel);
		btnCancel.addMouseListener(editSupplierController);
		
		this.setLocationRelativeTo(null);
		setVisible(true);
	}
	public void clickUpdateBtn() {	
		int selectedRowIndex = SupplierView.table.getSelectedRow();
		
		String Supplier_Name = SupplierNameTxt.getText();
		String Phone_Number = PhoneTxt.getText();
		String Address = AddressTxt.getText();
		
		String supplierCodeInitial = String.valueOf(supplierView.table.getValueAt(selectedRowIndex, 0));
		Supplier sup = new Supplier( Supplier_Name, Phone_Number, Address);
		//back-end
		int check = SupplierDAO.getInstance().updateWithCondition(sup, supplierCodeInitial);
		//front-end
		if(check >0) {
			JOptionPane.showMessageDialog(null, "Edit successfully");
			
			supplierView.model.setValueAt(Supplier_Name, selectedRowIndex, 1);
			supplierView.model.setValueAt(Phone_Number, selectedRowIndex, 2);
			supplierView.model.setValueAt(Address, selectedRowIndex, 3);
		}
		
	
	}
	public void clickCancelBtn() {
			this.dispose();
	}
	
}
