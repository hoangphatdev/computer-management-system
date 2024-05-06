
package ite.computer_management.view;

import java.awt.Color;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

import ite.computer_management.controller.AddProductController;
import ite.computer_management.controller.ProductController;
import ite.computer_management.dao.ProductDAO;
import ite.computer_management.model.Computer;

import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.SwingConstants;
import java.awt.Font;
import java.math.BigDecimal;
import java.util.ArrayList;

import javax.swing.JTextField;
import javax.swing.ImageIcon;

public class AddProductView extends JFrame {

	private static final long serialVersionUID = 1L;
	private JPanel contentPane;
	private JTextField computerNameTxt;
	private JTextField computerCodeTxt;
	private JTextField cpuTxt;
	private JTextField ramTxt;
	private JTextField screenCardTxt;
	private JTextField screenSizeTxt;
	private JTextField priceTxt;
	private JTextField quantityTxt;
	private JLabel machineTypeLbl;
	private JTextField machineTypeTxt;
	private JLabel batteryCapacityLbl;
	private JTextField batteryCapacityTxt;
	private JLabel originLbl;
	private JTextField originTxt;
	private JTextField sourceCapacityTxt;
	private JTextField romTxt;
	public JLabel refreshLbl;
	public JLabel addLbl;
	public JLabel cancelLbl;
	public ProductView productView;
	public Dashboard dashboard;
	
	public AddProductView(ProductView productView, Dashboard dashboard) {
		this.dashboard = dashboard;
		this.productView = productView;
		init();
		this.setLocationRelativeTo(null);
		this.setUndecorated(true);
		setVisible(true);
	}
	public void init() {
		AddProductController addProductController = new AddProductController(this);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 1024, 668);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));

		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JLabel titleLbl = new JLabel("ADD COMPUTER");
		titleLbl.setFont(new Font("Bakery", Font.PLAIN, 34));
		titleLbl.setHorizontalAlignment(SwingConstants.CENTER);
		titleLbl.setBounds(0, 0, 1024, 121);
		titleLbl.setBackground(Color.gray);
		titleLbl.setOpaque(true);
		titleLbl.setBackground(new Color(54, 51, 46));
		titleLbl.setForeground(new Color(222, 173, 91));
		contentPane.add(titleLbl);
		
		JLabel computerNameLbl = new JLabel("Computer Name");
		computerNameLbl.setFont(new Font("Inter", Font.BOLD, 12));
		computerNameLbl.setOpaque(true);
		computerNameLbl.setHorizontalAlignment(SwingConstants.CENTER);
		computerNameLbl.setBounds(26, 306, 190, 41);
		computerNameLbl.setForeground(new Color(222, 173, 91));
		computerNameLbl.setBackground(new Color(54, 51, 46));
		contentPane.add(computerNameLbl);
		
		JLabel computerCodeLbl = new JLabel("Computer Code");
		computerCodeLbl.setFont(new Font("Inter", Font.BOLD, 12));
		computerCodeLbl.setOpaque(true);
		computerCodeLbl.setHorizontalAlignment(SwingConstants.CENTER);
		computerCodeLbl.setBackground(new Color(54, 51, 46));
		computerCodeLbl.setForeground(new Color(222, 173, 91));
		computerCodeLbl.setBounds(265, 162, 190, 41);
		contentPane.add(computerCodeLbl);
		
		JLabel cpuLbl = new JLabel("CPU");
		cpuLbl.setFont(new Font("Inter", Font.BOLD, 12));
		cpuLbl.setOpaque(true);
		cpuLbl.setHorizontalAlignment(SwingConstants.CENTER);
		cpuLbl.setBounds(777, 162, 190, 41);
		cpuLbl.setBackground(new Color(54, 51, 46));
		cpuLbl.setForeground(new Color(222, 173, 91));
		contentPane.add(cpuLbl);
		
		JLabel ramLbl = new JLabel("RAM");
		ramLbl.setFont(new Font("Inter", Font.BOLD, 12));
		ramLbl.setOpaque(true);
		ramLbl.setHorizontalAlignment(SwingConstants.CENTER);
		ramLbl.setForeground(new Color(222, 173, 91));
		ramLbl.setBackground(new Color(54, 51, 46));
		ramLbl.setBounds(265, 255, 190, 41);
		contentPane.add(ramLbl);
		
		JLabel screenCardLbl = new JLabel("Screen Card");
		screenCardLbl.setFont(new Font("Inter", Font.BOLD, 12));
		screenCardLbl.setOpaque(true);
		screenCardLbl.setHorizontalAlignment(SwingConstants.CENTER);
		screenCardLbl.setBackground(new Color(54, 51, 46));
		screenCardLbl.setForeground(new Color(222, 173, 91));
		screenCardLbl.setBounds(526, 255, 190, 41);
		contentPane.add(screenCardLbl);
		
		JLabel screenSizeLbl = new JLabel("Screen Size");
		screenSizeLbl.setFont(new Font("Inter", Font.BOLD, 12));
		screenSizeLbl.setOpaque(true);
		screenSizeLbl.setHorizontalAlignment(SwingConstants.CENTER);
		screenSizeLbl.setForeground(new Color(222, 173, 91));
		screenSizeLbl.setBackground(new Color(54, 51, 46));
		screenSizeLbl.setBounds(526, 348, 190, 41);
		contentPane.add(screenSizeLbl);
		
		JLabel priceLbl = new JLabel("Price");
		priceLbl.setFont(new Font("Inter", Font.BOLD, 12));
		priceLbl.setOpaque(true);
		priceLbl.setHorizontalAlignment(SwingConstants.CENTER);
		priceLbl.setForeground(new Color(222, 173, 91));
		priceLbl.setBackground(new Color(54, 51, 46));
		priceLbl.setBounds(777, 255, 190, 41);
		contentPane.add(priceLbl);
		
		JLabel sourceCapacityLbl = new JLabel("Souce Capacity");
		sourceCapacityLbl.setFont(new Font("Inter", Font.BOLD, 12));
		sourceCapacityLbl.setOpaque(true);
		sourceCapacityLbl.setHorizontalAlignment(SwingConstants.CENTER);
		sourceCapacityLbl.setForeground(new Color(222, 173, 91));
		sourceCapacityLbl.setBackground(new Color(54, 51, 46));
		sourceCapacityLbl.setBounds(265, 351, 190, 41);
		contentPane.add(sourceCapacityLbl);
		
		JLabel romLbl = new JLabel("Rom");
		romLbl.setFont(new Font("Inter", Font.BOLD, 12));
		romLbl.setOpaque(true);
		romLbl.setHorizontalAlignment(SwingConstants.CENTER);
		romLbl.setForeground(new Color(222, 173, 91));
		romLbl.setBackground(new Color(54, 51, 46));
		romLbl.setBounds(265, 448, 190, 41);
		contentPane.add(romLbl);
		
		JLabel quantityLbl = new JLabel("Quantity");
		quantityLbl.setFont(new Font("Inter", Font.BOLD, 12));
		quantityLbl.setOpaque(true);
		quantityLbl.setHorizontalAlignment(SwingConstants.CENTER);
		quantityLbl.setBackground(new Color(54, 51, 46));
		quantityLbl.setForeground(new Color(222, 173, 91));
		quantityLbl.setBounds(526, 162, 190, 41);
		contentPane.add(quantityLbl);
		

		originLbl = new JLabel("Origin");
		originLbl.setFont(new Font("Inter", Font.BOLD, 12));
		originLbl.setOpaque(true);
		originLbl.setHorizontalAlignment(SwingConstants.CENTER);
		originLbl.setForeground(new Color(222, 173, 91));
		originLbl.setBackground(new Color(54, 51, 46));
		originLbl.setBounds(526, 448, 190, 41);
		contentPane.add(originLbl);
		
		machineTypeLbl = new JLabel("Machine Type");
		machineTypeLbl.setFont(new Font("Inter", Font.BOLD, 12));
		machineTypeLbl.setOpaque(true);
		machineTypeLbl.setHorizontalAlignment(SwingConstants.CENTER);
		machineTypeLbl.setBackground(new Color(54, 51, 46));
		machineTypeLbl.setForeground(new Color(222, 173, 91));
		machineTypeLbl.setBounds(777, 348, 190, 41);
		contentPane.add(machineTypeLbl);
		
		batteryCapacityLbl = new JLabel("Battery Capacity");
		batteryCapacityLbl.setFont(new Font("Inter", Font.BOLD, 12));
		batteryCapacityLbl.setOpaque(true);
		batteryCapacityLbl.setHorizontalAlignment(SwingConstants.CENTER);
		batteryCapacityLbl.setBackground(new Color(54, 51, 46));
		batteryCapacityLbl.setForeground(new Color(222, 173, 91));
		batteryCapacityLbl.setBounds(777, 448, 190, 41);
		contentPane.add(batteryCapacityLbl);
		
		
		computerNameTxt = new JTextField();
		computerNameTxt.setFont(new Font("Roboto", Font.PLAIN, 13));
		computerNameTxt.setBounds(26, 348, 190, 41);
		contentPane.add(computerNameTxt);
		computerNameTxt.setColumns(10);
		
		computerCodeTxt = new JTextField();
		computerCodeTxt.setFont(new Font("Roboto", Font.PLAIN, 13));
		computerCodeTxt.setColumns(10);
		computerCodeTxt.setBounds(265, 204, 190, 41);
		contentPane.add(computerCodeTxt);
		
		cpuTxt = new JTextField();
		cpuTxt.setFont(new Font("Roboto", Font.PLAIN, 13));
		cpuTxt.setColumns(10);
		cpuTxt.setBounds(777, 204, 190, 41);
		contentPane.add(cpuTxt);
		
		ramTxt = new JTextField();
		ramTxt.setFont(new Font("Roboto", Font.PLAIN, 13));
		ramTxt.setColumns(10);
		ramTxt.setBounds(265, 297, 190, 41);
		contentPane.add(ramTxt);
		
		screenCardTxt = new JTextField();
		screenCardTxt.setFont(new Font("Roboto", Font.PLAIN, 13));
		screenCardTxt.setColumns(10);
		screenCardTxt.setBounds(526, 297, 190, 41);
		contentPane.add(screenCardTxt);
		
		screenSizeTxt = new JTextField();
		screenSizeTxt.setFont(new Font("Roboto", Font.PLAIN, 13));
		screenSizeTxt.setColumns(10);
		screenSizeTxt.setBounds(526, 390, 190, 41);
		contentPane.add(screenSizeTxt);
		
		priceTxt = new JTextField();
		priceTxt.setFont(new Font("Roboto", Font.PLAIN, 13));
		priceTxt.setColumns(10);
		priceTxt.setBounds(777, 297, 190, 41);
		contentPane.add(priceTxt);
		
		quantityTxt = new JTextField();
		quantityTxt.setFont(new Font("Roboto", Font.PLAIN, 13));
		quantityTxt.setColumns(10);
		quantityTxt.setBounds(526, 204, 190, 41);
		contentPane.add(quantityTxt);
		
		machineTypeTxt = new JTextField();
		machineTypeTxt.setFont(new Font("Roboto", Font.PLAIN, 13));
		machineTypeTxt.setColumns(10);
		machineTypeTxt.setBounds(777, 390, 190, 41);
		contentPane.add(machineTypeTxt);
		
		batteryCapacityTxt = new JTextField();
		batteryCapacityTxt.setFont(new Font("Roboto", Font.PLAIN, 13));
		batteryCapacityTxt.setColumns(10);
		batteryCapacityTxt.setBounds(777, 490, 190, 41);
		contentPane.add(batteryCapacityTxt);
		
		originTxt = new JTextField();
		originTxt.setFont(new Font("Roboto", Font.PLAIN, 13));
		originTxt.setColumns(10);
		originTxt.setBounds(526, 490, 190, 41);
		contentPane.add(originTxt);
		
		addLbl = new JLabel("ADD PRODUCT");
		addLbl.setIcon(new ImageIcon("C:\\Users\\latru\\Desktop\\computer_management\\src\\main\\java\\ite\\computer_management\\img\\add\\icons8-add-35.png"));
		addLbl.setBackground(Color.GREEN);
		addLbl.setOpaque(true);
		addLbl.setForeground(Color.white);
		addLbl.setHorizontalAlignment(SwingConstants.CENTER);
		addLbl.setBounds(152, 571, 190, 41);
		addLbl.addMouseListener(addProductController);
		contentPane.add(addLbl);
		
		cancelLbl = new JLabel("Cancel");
		cancelLbl.setIcon(new ImageIcon("C:\\Users\\latru\\Desktop\\computer_management\\src\\main\\java\\ite\\computer_management\\img\\cancel 30.png"));
		cancelLbl.setBackground(Color.red);
		cancelLbl.setOpaque(true);
		cancelLbl.setForeground(Color.white);
		cancelLbl.setHorizontalAlignment(SwingConstants.CENTER);
		cancelLbl.setBounds(466, 571, 190, 41);
		cancelLbl.addMouseListener(addProductController);
		contentPane.add(cancelLbl);
		
		sourceCapacityTxt = new JTextField();
		sourceCapacityTxt.setFont(new Font("Roboto", Font.PLAIN, 13));
		sourceCapacityTxt.setColumns(10);
		sourceCapacityTxt.setBounds(265, 393, 190, 41);
		contentPane.add(sourceCapacityTxt);
		
		romTxt = new JTextField();
		romTxt.setFont(new Font("Roboto", Font.PLAIN, 13));
		romTxt.setColumns(10);
		romTxt.setBounds(265, 490, 190, 41);
		contentPane.add(romTxt);
		
		refreshLbl = new JLabel("REFRESH");
		refreshLbl.setIcon(new ImageIcon("C:\\Users\\latru\\Desktop\\computer_management\\src\\main\\java\\ite\\computer_management\\img\\reload 30.png"));
		refreshLbl.setOpaque(true);
		refreshLbl.setHorizontalAlignment(SwingConstants.CENTER);
		refreshLbl.setForeground(Color.WHITE);
		refreshLbl.setBackground(Color.GREEN);
		refreshLbl.setBounds(767, 571, 141, 41);
		refreshLbl.addMouseListener(addProductController);
		contentPane.add(refreshLbl);
	}
	
	public void clickAddLbl() {
		String preparedScreenCard = screenCardTxt.getText();
		String preparedComputerName = computerNameTxt.getText();
		String preparedComputerCode = computerCodeTxt.getText();
		String preparedSourceCapacity = sourceCapacityTxt.getText();
		String preparedCpuName = cpuTxt.getText();
		String preparedRam = ramTxt.getText();
		String preparedMachineType = machineTypeTxt.getText();
		BigDecimal preparedPrice = BigDecimal.valueOf( Double.parseDouble(priceTxt.getText()) );
		int preparedQuantity = Integer.parseInt(quantityTxt.getText());
		String preparedRom = romTxt.getText();
		String preparedOrigin = originTxt.getText();
		Double preparedScreenSize = Double.parseDouble(screenSizeTxt.getText());
		String preparedBatteryCapacity = batteryCapacityTxt.getText();
		Computer preparedComputer = new Computer(preparedComputerCode, preparedComputerName, preparedQuantity, preparedCpuName, preparedRam, preparedScreenCard,
					preparedPrice, preparedSourceCapacity, preparedMachineType, preparedRom, preparedScreenSize,preparedBatteryCapacity, preparedOrigin);
		

		int check = ProductDAO.getInstance().insert(preparedComputer);
		if(check == 1) {
			//front-end
			String[] rowData = {preparedComputerName, preparedComputerCode, String.valueOf(preparedQuantity), preparedCpuName, preparedRam, preparedScreenCard,String.valueOf(preparedPrice),
														 preparedSourceCapacity, preparedMachineType, preparedRom,String.valueOf(preparedScreenSize),	preparedBatteryCapacity, preparedOrigin};
			productView.model.addRow(rowData);
		}
		
	}
	public void clickCancelLbl() {
		this.dispose();
		dashboard.setVisible(true);
		
	}
	public void clickRefreshLbl() {
		computerNameTxt.setText(null);
		computerCodeTxt.setText(null);
		quantityTxt.setText(null);
		cpuTxt.setText(null);
		ramTxt.setText(null);
		screenCardTxt.setText(null);
		priceTxt.setText(null);
		sourceCapacityTxt.setText(null);
		machineTypeTxt.setText(null);
		romTxt.setText(null);
		screenSizeTxt.setText(null);
		batteryCapacityTxt.setText(null);
		originTxt.setText(null);
	}
}