
package ite.computer_management.view;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

import ite.computer_management.controller.EditProductController;
import ite.computer_management.dao.ProductDAO;
import ite.computer_management.model.Computer;

import javax.swing.JTextField;
import javax.swing.JLabel;
import javax.swing.JButton;
import java.awt.Color;
import javax.swing.SwingConstants;
import java.awt.Font;
import java.math.BigDecimal;
import java.math.BigInteger;

import javax.swing.UIManager;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class EditProductView extends JFrame {
	private static final long serialVersionUID = 1L;
	public  JButton updateBtn;
	private JPanel contentPane;
	public JTextField computerNameTxt;
	public JTextField computerCodeTxt;
	public JTextField cpuTxt;
	public JTextField ramTxt;
	public JTextField screenCardTxt;
	public JTextField screenSizeTxt;
	public JTextField priceTxt;
	public JTextField quantityTxt;
	public JLabel machineTypeLbl;
	public JTextField machineTypeTxt;
	public JLabel batteryCapacityLbl;
	public JTextField batteryCapacityTxt;
	public JLabel originLbl;
	public JTextField originTxt;
	public JTextField sourceCapacityTxt;
	public JTextField romTxt;
	public JLabel addLbl1;
	public ProductView productView;
	public Dashboard dashboard;
	public JButton addLbl;
	public JButton btnRefresh;
	public JButton btnNewButton;
	public JButton btnCancel;
	
	public EditProductView(ProductView productView, Dashboard dashboard) {
		this.productView = productView;
		EditProductController editProductController = new EditProductController(this);

		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 900, 500);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JLabel computerNameLbl = new JLabel("Computer Name");
		computerNameLbl.setFont(new Font("Dialog", Font.BOLD, 14));
		computerNameLbl.setOpaque(true);
		computerNameLbl.setHorizontalAlignment(SwingConstants.CENTER);
		computerNameLbl.setBounds(22, 35, 190, 41);
		computerNameLbl.setBackground(new Color(70, 163, 100));
		computerNameLbl.setForeground(new Color(219, 219, 219));
		contentPane.add(computerNameLbl);
		
		JLabel computerCodeLbl = new JLabel("Computer Code");
		computerCodeLbl.setFont(new Font("Dialog", Font.BOLD, 14));
		computerCodeLbl.setOpaque(true);
		computerCodeLbl.setHorizontalAlignment(SwingConstants.CENTER);
		computerCodeLbl.setBackground(new Color(70, 163, 100));
		computerCodeLbl.setForeground(new Color(219, 219, 219));
		computerCodeLbl.setBounds(237, 35, 190, 41);
		contentPane.add(computerCodeLbl);
		
		JLabel cpuLbl = new JLabel("CPU");
		cpuLbl.setFont(new Font("Dialog", Font.BOLD, 14));
		cpuLbl.setOpaque(true);
		cpuLbl.setHorizontalAlignment(SwingConstants.CENTER);
		cpuLbl.setBounds(237, 136, 190, 41);
		cpuLbl.setBackground(new Color(70, 163, 100));
		cpuLbl.setForeground(new Color(219, 219, 219));
		contentPane.add(cpuLbl);
		
		JLabel ramLbl = new JLabel("RAM");
		ramLbl.setFont(new Font("Dialog", Font.BOLD, 14));
		ramLbl.setOpaque(true);
		ramLbl.setHorizontalAlignment(SwingConstants.CENTER);
		ramLbl.setBackground(new Color(70, 163, 100));
		ramLbl.setForeground(new Color(219, 219, 219));
		ramLbl.setBounds(22, 240, 190, 41);
		contentPane.add(ramLbl);
		
		JLabel screenCardLbl = new JLabel("Screen Card");
		screenCardLbl.setFont(new Font("Dialog", Font.BOLD, 14));
		screenCardLbl.setOpaque(true);
		screenCardLbl.setHorizontalAlignment(SwingConstants.CENTER);
		screenCardLbl.setBackground(new Color(70, 163, 100));
		screenCardLbl.setForeground(new Color(219, 219, 219));
		screenCardLbl.setBounds(237, 240, 190, 41);
		contentPane.add(screenCardLbl);
		
		JLabel screenSizeLbl = new JLabel("Screen Size");
		screenSizeLbl.setFont(new Font("Dialog", Font.BOLD, 14));
		screenSizeLbl.setOpaque(true);
		screenSizeLbl.setHorizontalAlignment(SwingConstants.CENTER);
		screenSizeLbl.setBackground(new Color(70, 163, 100));
		screenSizeLbl.setForeground(new Color(219, 219, 219));
		screenSizeLbl.setBounds(237, 348, 190, 41);
		contentPane.add(screenSizeLbl);
		
		JLabel priceLbl = new JLabel("Price");
		priceLbl.setFont(new Font("Dialog", Font.BOLD, 14));
		priceLbl.setOpaque(true);
		priceLbl.setHorizontalAlignment(SwingConstants.CENTER);
		priceLbl.setBackground(new Color(70, 163, 100));
		priceLbl.setForeground(new Color(219, 219, 219));
		priceLbl.setBounds(669, 35, 190, 41);
		contentPane.add(priceLbl);
		
		JLabel sourceCapacityLbl = new JLabel("Souce Capacity");
		sourceCapacityLbl.setFont(new Font("Dialog", Font.BOLD, 14));
		sourceCapacityLbl.setOpaque(true);
		sourceCapacityLbl.setHorizontalAlignment(SwingConstants.CENTER);
		sourceCapacityLbl.setBackground(new Color(70, 163, 100));
		sourceCapacityLbl.setForeground(new Color(219, 219, 219));
		sourceCapacityLbl.setBounds(22, 348, 190, 41);
		contentPane.add(sourceCapacityLbl);
		
		JLabel romLbl = new JLabel("Rom");
		romLbl.setFont(new Font("Dialog", Font.BOLD, 14));
		romLbl.setOpaque(true);
		romLbl.setHorizontalAlignment(SwingConstants.CENTER);
		romLbl.setBackground(new Color(70, 163, 100));
		romLbl.setForeground(new Color(219, 219, 219));
		romLbl.setBounds(22, 136, 190, 41);
		contentPane.add(romLbl);
		
		JLabel quantityLbl = new JLabel("Quantity");
		quantityLbl.setFont(new Font("Dialog", Font.BOLD, 14));
		quantityLbl.setOpaque(true);
		quantityLbl.setHorizontalAlignment(SwingConstants.CENTER);
		quantityLbl.setBackground(new Color(70, 163, 100));
		quantityLbl.setForeground(new Color(219, 219, 219));
		quantityLbl.setBounds(450, 35, 190, 41);
		contentPane.add(quantityLbl);
		

		originLbl = new JLabel("Origin");
		originLbl.setFont(new Font("Dialog", Font.BOLD, 14));
		originLbl.setOpaque(true);
		originLbl.setHorizontalAlignment(SwingConstants.CENTER);
		originLbl.setBackground(new Color(70, 163, 100));
		originLbl.setForeground(new Color(219, 219, 219));
		originLbl.setBounds(450, 136, 190, 41);
		contentPane.add(originLbl);
		
		machineTypeLbl = new JLabel("Machine Type");
		machineTypeLbl.setFont(new Font("Dialog", Font.BOLD, 14));
		machineTypeLbl.setOpaque(true);
		machineTypeLbl.setHorizontalAlignment(SwingConstants.CENTER);
		machineTypeLbl.setBackground(new Color(70, 163, 100));
		machineTypeLbl.setForeground(new Color(219, 219, 219));
		machineTypeLbl.setBounds(450, 240, 190, 41);
		contentPane.add(machineTypeLbl);
		
		batteryCapacityLbl = new JLabel("Battery Capacity");
		batteryCapacityLbl.setFont(new Font("Dialog", Font.BOLD, 14));
		batteryCapacityLbl.setOpaque(true);
		batteryCapacityLbl.setHorizontalAlignment(SwingConstants.CENTER);
		batteryCapacityLbl.setBackground(new Color(70, 163, 100));
		batteryCapacityLbl.setForeground(new Color(219, 219, 219));
		batteryCapacityLbl.setBounds(450, 348, 190, 41);
		contentPane.add(batteryCapacityLbl);
		
		
		computerNameTxt = new JTextField();
		computerNameTxt.setFont(new Font("Roboto", Font.PLAIN, 13));
		computerNameTxt.setBounds(22, 76, 190, 41);
		contentPane.add(computerNameTxt);
		computerNameTxt.setColumns(10);
		
		computerCodeTxt = new JTextField();
		computerCodeTxt.setFont(new Font("Roboto", Font.PLAIN, 13));
		computerCodeTxt.setColumns(10);
		computerCodeTxt.setBounds(237, 76, 190, 41);
		contentPane.add(computerCodeTxt);
		
		cpuTxt = new JTextField();
		cpuTxt.setFont(new Font("Roboto", Font.PLAIN, 13));
		cpuTxt.setColumns(10);
		cpuTxt.setBounds(237, 177, 190, 41);
		contentPane.add(cpuTxt);
		
		ramTxt = new JTextField();
		ramTxt.setFont(new Font("Roboto", Font.PLAIN, 13));
		ramTxt.setColumns(10);
		ramTxt.setBounds(22, 282, 190, 41);
		contentPane.add(ramTxt);
		
		screenCardTxt = new JTextField();
		screenCardTxt.setFont(new Font("Roboto", Font.PLAIN, 13));
		screenCardTxt.setColumns(10);
		screenCardTxt.setBounds(237, 282, 190, 41);
		contentPane.add(screenCardTxt);
		
		screenSizeTxt = new JTextField();
		screenSizeTxt.setFont(new Font("Roboto", Font.PLAIN, 13));
		screenSizeTxt.setColumns(10);
		screenSizeTxt.setBounds(237, 390, 190, 41);
		contentPane.add(screenSizeTxt);
		
		priceTxt = new JTextField();
		priceTxt.setFont(new Font("Roboto", Font.PLAIN, 13));
		priceTxt.setColumns(10);
		priceTxt.setBounds(669, 76, 190, 41);
		contentPane.add(priceTxt);
		
		quantityTxt = new JTextField();
		quantityTxt.setFont(new Font("Roboto", Font.PLAIN, 13));
		quantityTxt.setColumns(10);
		quantityTxt.setBounds(450, 76, 190, 41);
		contentPane.add(quantityTxt);
		
		machineTypeTxt = new JTextField();
		machineTypeTxt.setFont(new Font("Roboto", Font.PLAIN, 13));
		machineTypeTxt.setColumns(10);
		machineTypeTxt.setBounds(450, 282, 190, 41);
		contentPane.add(machineTypeTxt);
		
		batteryCapacityTxt = new JTextField();
		batteryCapacityTxt.setFont(new Font("Roboto", Font.PLAIN, 13));
		batteryCapacityTxt.setColumns(10);
		batteryCapacityTxt.setBounds(450, 390, 190, 41);
		contentPane.add(batteryCapacityTxt);
		
		originTxt = new JTextField();
		originTxt.setFont(new Font("Roboto", Font.PLAIN, 13));
		originTxt.setColumns(10);
		originTxt.setBounds(450, 177, 190, 41);
		contentPane.add(originTxt);
		
		sourceCapacityTxt = new JTextField();
		sourceCapacityTxt.setFont(new Font("Roboto", Font.PLAIN, 13));
		sourceCapacityTxt.setColumns(10);
		sourceCapacityTxt.setBounds(22, 390, 190, 41);
		contentPane.add(sourceCapacityTxt);
		
		romTxt = new JTextField();
		romTxt.setFont(new Font("Roboto", Font.PLAIN, 13));
		romTxt.setColumns(10);
		romTxt.setBounds(22, 177, 190, 41);
		contentPane.add(romTxt);
		
		btnNewButton = new JButton("Save");
		btnNewButton.setForeground(new Color(70, 163, 100));
		btnNewButton.setBackground(new Color(219, 219, 219));
		btnNewButton.setFont(new Font("Tahoma", Font.BOLD, 17));
		btnNewButton.setBounds(669, 175, 190, 41);
		contentPane.add(btnNewButton);
		btnNewButton.addMouseListener(editProductController);
		
		btnCancel = new JButton("Cancel");
		btnCancel.setBackground(new Color(219, 219, 219));
		btnCancel.setForeground(new Color(235, 64, 21));
		btnCancel.setFont(new Font("Tahoma", Font.BOLD, 17));
		btnCancel.setBounds(669, 280, 190, 41);
		contentPane.add(btnCancel);
		btnCancel.addMouseListener(editProductController);
		
		this.setLocationRelativeTo(null);
		this.setVisible(true);
	}
	public void clickUpdateBtn() {
		int selectedRowIndex = this.productView.table.getSelectedRow();
		String conditionComputerCode = (String) this.productView.table.getValueAt(selectedRowIndex, 1);
		System.out.println(conditionComputerCode);
		String screenCard = screenCardTxt.getText();
		String computerName = computerNameTxt.getText();
		String computerCode = computerCodeTxt.getText();
		String sourceCapacity = sourceCapacityTxt.getText();
		String cpuName = cpuTxt.getText();
		String ram = ramTxt.getText();
		String machineType = machineTypeTxt.getText();
		java.math.BigInteger price = BigInteger.valueOf(Long.valueOf(priceTxt.getText()));
		int quantity = Integer.valueOf(quantityTxt.getText());
		String rom = romTxt.getText(); 
		String origin = originTxt.getText();
		Double screenSize = Double.parseDouble(screenSizeTxt.getText());
		String batteryCapacity = batteryCapacityTxt.getText();
		Computer com = new Computer(computerCode, computerName, quantity, cpuName, ram, screenCard, price, sourceCapacity, machineType, rom, screenSize,
				batteryCapacity, origin);
		System.out.println(price);
		//back-end
		int check = ProductDAO.getInstance().update(com, conditionComputerCode);
			//front-end
			productView.model.setValueAt(computerName, selectedRowIndex, 0);
			productView.model.setValueAt(computerCode, selectedRowIndex, 1);
			productView.model.setValueAt(quantity, selectedRowIndex, 2);
			productView.model.setValueAt(cpuName, selectedRowIndex, 3);
			productView.model.setValueAt(ram, selectedRowIndex, 4);
			productView.model.setValueAt(screenCard, selectedRowIndex, 5);
			productView.model.setValueAt(price, selectedRowIndex, 6);
			productView.model.setValueAt(sourceCapacity, selectedRowIndex, 7);
			productView.model.setValueAt(machineType, selectedRowIndex, 8);
			productView.model.setValueAt(rom, selectedRowIndex, 9);
			productView.model.setValueAt(screenSize, selectedRowIndex, 10);
			productView.model.setValueAt(batteryCapacity, selectedRowIndex, 11);
			productView.model.setValueAt(origin, selectedRowIndex, 12);
	}
	public void clickCancelBtn() {
		this.dispose();
	}
	
	
}
