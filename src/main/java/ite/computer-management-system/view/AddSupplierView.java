
package ite.computer_management.view;

import java.awt.Color;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

import ite.computer_management.controller.AddProductController;
import ite.computer_management.controller.AddSupplierController;
import ite.computer_management.controller.ProductController;
import ite.computer_management.dao.ProductDAO;
import ite.computer_management.dao.SupplierDAO;
import ite.computer_management.model.Computer;
import ite.computer_management.model.Supplier;

import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.SwingConstants;
import java.awt.Font;
import java.math.BigDecimal;
import java.util.ArrayList;

import javax.swing.JTextField;
 
public class AddSupplierView extends JFrame {

	private static final long serialVersionUID = 1L;
	private JPanel contentPane;
	private JTextField SupplierNameTxt;
	private JTextField SupplierCodeTxt;
	private JTextField AddressTxt;
	private JTextField PhoneTxt;
	public JLabel refreshLbl;
	public JLabel addLbl;
	public JLabel cancelLbl;
	public SupplierView supplierView;
	public Dashboard dashboard;
	
	public AddSupplierView(SupplierView supplierView, Dashboard dashboard) {
		this.supplierView = supplierView;
		this.dashboard = dashboard;
		AddSupplierController addSupplierController = new AddSupplierController(this);
		
		
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 700, 450);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));

		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JLabel titleLbl = new JLabel("ADD SUPPLIER");
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
		
		addLbl = new JLabel("ADD PRODUCT");
		addLbl.setBackground(Color.GREEN);
		addLbl.setOpaque(true);
		addLbl.setForeground(Color.white);
		addLbl.setHorizontalAlignment(SwingConstants.CENTER);
		addLbl.setBounds(398, 380, 141, 41);
		addLbl.addMouseListener(addSupplierController);
		contentPane.add(addLbl);
		
		cancelLbl = new JLabel("Cancel");
		cancelLbl.setBackground(Color.red);
		cancelLbl.setOpaque(true);
		cancelLbl.setForeground(Color.white);
		cancelLbl.setHorizontalAlignment(SwingConstants.CENTER);
		cancelLbl.setBounds(549, 380, 141, 41);
		cancelLbl.addMouseListener(addSupplierController);
		contentPane.add(cancelLbl);
		
		refreshLbl = new JLabel("REFRESH");
		refreshLbl.setOpaque(true);
		refreshLbl.setHorizontalAlignment(SwingConstants.CENTER);
		refreshLbl.setForeground(Color.WHITE);
		refreshLbl.setBackground(Color.GREEN);
		refreshLbl.setBounds(528, 162, 141, 41);
		refreshLbl.addMouseListener(addSupplierController);
		contentPane.add(refreshLbl);
		
		this.setLocationRelativeTo(null);
		this.setUndecorated(true);
		setVisible(true);
	}
	
	public void clickAddLbl() {
		String NameSupplier = SupplierNameTxt.getText();
		String CodeSupplier = SupplierCodeTxt.getText();
		String PhoneNumber = PhoneTxt.getText();
		String Address = AddressTxt.getText();
		
		Supplier Sup = new Supplier(CodeSupplier, NameSupplier, PhoneNumber, Address);
		

		int check = SupplierDAO.getInstance().insert(Sup);
		if(check == 1) {
			//front-end
			String[] rowData = {CodeSupplier, NameSupplier, PhoneNumber, Address};
			SupplierView.model.addRow(rowData);
		}
		
	}
	public void clickCancelLbl() {
		this.dispose();
	    dashboard.setVisible(true);
	}
	public void clickRefreshLbl() {
		SupplierNameTxt.setText(null);
		SupplierCodeTxt.setText(null);
		PhoneTxt.setText(null);
		AddressTxt.setText(null);
	}
}


