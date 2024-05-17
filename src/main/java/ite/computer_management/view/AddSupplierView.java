
package ite.computer_management.view;

import java.awt.Color;
import java.awt.EventQueue;

import javax.swing.JButton;
import javax.swing.JComponent;
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
import javax.swing.ImageIcon;
 
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
	public JButton btnadd;
	public JComponent btnCancel;
	public JButton btnRefresh;
	
	public AddSupplierView(SupplierView supplierView, Dashboard dashboard) {
		this.supplierView = supplierView;
		this.dashboard = dashboard;
		AddSupplierController addSupplierController = new AddSupplierController(this);

		
		
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
		
		btnadd = new JButton("Add");
		btnadd.setIcon(new ImageIcon("D:\\JAVA_project\\computer-management-system\\src\\main\\java\\ite\\computer_management\\img\\add 30.png"));
		btnadd.setForeground(Color.YELLOW);
		btnadd.setBackground(Color.GRAY);
		btnadd.setFont(new Font("Tahoma", Font.BOLD, 15));
		btnadd.setBounds(160, 300, 141, 41);
		contentPane.add(btnadd);
		btnadd.addMouseListener(addSupplierController);
		
		btnCancel = new JButton("Cancel");
		btnCancel.setBackground(Color.RED);
		btnCancel.setForeground(Color.BLACK);
		btnCancel.setFont(new Font("Tahoma", Font.BOLD, 15));
		btnCancel.setBounds(247, 351, 141, 41);
		contentPane.add(btnCancel);
		
		btnRefresh = new JButton("Refresh");
		btnRefresh.setIcon(new ImageIcon("D:\\JAVA_project\\computer-management-system\\src\\main\\java\\ite\\computer_management\\img\\reload 30.png"));
		btnRefresh.setForeground(Color.YELLOW);
		btnRefresh.setFont(new Font("Tahoma", Font.BOLD, 15));
		btnRefresh.setBackground(Color.GRAY);
		btnRefresh.setBounds(338, 300, 141, 41);
		contentPane.add(btnRefresh);
		btnCancel.addMouseListener(addSupplierController);
		
		this.setLocationRelativeTo(null);
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


