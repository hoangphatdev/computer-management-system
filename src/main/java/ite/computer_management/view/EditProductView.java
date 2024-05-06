
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

public class EditProductView extends JFrame {

	private static final long serialVersionUID = 1L;
	private JPanel contentPane;
	public JButton cancelBtn;
	public  JButton updateBtn;
	
	//-----
//	public static void main(String[] args) {
//		EventQueue.invokeLater(new Runnable() {
//			public void run() {
//				try {
//					EditProductView frame = new EditProductView();
//					frame.setVisible(true);
//				} catch (Exception e) {
//					e.printStackTrace();
//				}
//			}
//		});
//	}

	/**
	 * Create the frame.
	 */
	private ProductView productView;
	public JTextField computerNameTxt;
	public JTextField cpuTxt;
	public JTextField priceTxt;
	public JTextField romTxt;
	public JTextField computerCodeTxt;
	public JTextField ramTxt;
	public JTextField sourceCapacityTxt;
	public JTextField screenSizeTxt;
	public JTextField quantityTxt;
	public JTextField screenCardTxt;
	public JTextField machineTypeTxt;
	public JTextField batteryCapacityTxt;
	public JTextField originTxt;
	public EditProductView(ProductView productView, Dashboard dashboard) {
		this.productView = productView;
		EditProductController editProductController = new EditProductController(this);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 1022, 617);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
	
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		updateBtn = new JButton("Save");
		updateBtn.setBounds(338, 529, 115, 41);
		updateBtn.addMouseListener(editProductController);
		contentPane.add(updateBtn);
		
		cancelBtn = new JButton("Cancel");
		cancelBtn.setBounds(608, 529, 115, 41);
		cancelBtn.addMouseListener(editProductController);
		contentPane.add(cancelBtn);
		
		JLabel computerNameLbl = new JLabel("Computer Name");
		computerNameLbl.setOpaque(true);
		computerNameLbl.setHorizontalAlignment(SwingConstants.CENTER);
		computerNameLbl.setBackground(Color.GRAY);
		computerNameLbl.setBounds(10, 141, 217, 41);
		contentPane.add(computerNameLbl);
		
		computerNameTxt = new JTextField();
		computerNameTxt.setColumns(10);
		computerNameTxt.setBounds(10, 183, 217, 41);
		contentPane.add(computerNameTxt);
		
		JLabel cpuLbl = new JLabel("CPU");
		cpuLbl.setOpaque(true);
		cpuLbl.setHorizontalAlignment(SwingConstants.CENTER);
		cpuLbl.setBackground(Color.GRAY);
		cpuLbl.setBounds(10, 245, 217, 41);
		contentPane.add(cpuLbl);
		
		cpuTxt = new JTextField();
		cpuTxt.setColumns(10);
		cpuTxt.setBounds(10, 282, 217, 41);
		contentPane.add(cpuTxt);
		
		JLabel priceLbl = new JLabel("Price");
		priceLbl.setOpaque(true);
		priceLbl.setHorizontalAlignment(SwingConstants.CENTER);
		priceLbl.setBackground(Color.GRAY);
		priceLbl.setBounds(10, 345, 217, 41);
		contentPane.add(priceLbl);
		
		priceTxt = new JTextField();
		priceTxt.setColumns(10);
		priceTxt.setBounds(10, 383, 217, 41);
		contentPane.add(priceTxt);
		
		JLabel romLbl = new JLabel("Rom");
		romLbl.setOpaque(true);
		romLbl.setHorizontalAlignment(SwingConstants.CENTER);
		romLbl.setBackground(Color.GRAY);
		romLbl.setBounds(10, 434, 217, 41);
		contentPane.add(romLbl);
		
		romTxt = new JTextField();
		romTxt.setColumns(10);
		romTxt.setBounds(10, 474, 217, 41);
		contentPane.add(romTxt);
		
		JLabel computerCodeLbl = new JLabel("Computer Code");
		computerCodeLbl.setOpaque(true);
		computerCodeLbl.setHorizontalAlignment(SwingConstants.CENTER);
		computerCodeLbl.setBackground(Color.GRAY);
		computerCodeLbl.setBounds(264, 145, 217, 41);
		contentPane.add(computerCodeLbl);
		
		computerCodeTxt = new JTextField();
		computerCodeTxt.setColumns(10);
		computerCodeTxt.setBounds(264, 183, 217, 41);
		contentPane.add(computerCodeTxt);
		
		JLabel ramLbl = new JLabel("RAM");
		ramLbl.setOpaque(true);
		ramLbl.setHorizontalAlignment(SwingConstants.CENTER);
		ramLbl.setBackground(Color.GRAY);
		ramLbl.setBounds(264, 248, 217, 41);
		contentPane.add(ramLbl);
		
		ramTxt = new JTextField();
		ramTxt.setColumns(10);
		ramTxt.setBounds(264, 285, 217, 41);
		contentPane.add(ramTxt);
		
		JLabel sourceCapacityLbl = new JLabel("Souce Capacity");
		sourceCapacityLbl.setOpaque(true);
		sourceCapacityLbl.setHorizontalAlignment(SwingConstants.CENTER);
		sourceCapacityLbl.setBackground(Color.GRAY);
		sourceCapacityLbl.setBounds(264, 348, 217, 41);
		contentPane.add(sourceCapacityLbl);
		
		sourceCapacityTxt = new JTextField();
		sourceCapacityTxt.setColumns(10);
		sourceCapacityTxt.setBounds(264, 386, 217, 41);
		contentPane.add(sourceCapacityTxt);
		
		JLabel screenSizeLbl = new JLabel("Screen Size");
		screenSizeLbl.setOpaque(true);
		screenSizeLbl.setHorizontalAlignment(SwingConstants.CENTER);
		screenSizeLbl.setBackground(Color.GRAY);
		screenSizeLbl.setBounds(264, 437, 217, 41);
		contentPane.add(screenSizeLbl);
		
		screenSizeTxt = new JTextField();
		screenSizeTxt.setColumns(10);
		screenSizeTxt.setBounds(264, 475, 217, 41);
		contentPane.add(screenSizeTxt);
		
		JLabel quantityLbl = new JLabel("Quantity");
		quantityLbl.setOpaque(true);
		quantityLbl.setHorizontalAlignment(SwingConstants.CENTER);
		quantityLbl.setBackground(Color.GRAY);
		quantityLbl.setBounds(527, 145, 217, 41);
		contentPane.add(quantityLbl);
		
		quantityTxt = new JTextField();
		quantityTxt.setColumns(10);
		quantityTxt.setBounds(527, 183, 217, 41);
		contentPane.add(quantityTxt);
		
		JLabel screenCardLbl = new JLabel("Screen Card");
		screenCardLbl.setOpaque(true);
		screenCardLbl.setHorizontalAlignment(SwingConstants.CENTER);
		screenCardLbl.setBackground(Color.GRAY);
		screenCardLbl.setBounds(527, 248, 217, 41);
		contentPane.add(screenCardLbl);
		
		screenCardTxt = new JTextField();
		screenCardTxt.setColumns(10);
		screenCardTxt.setBounds(527, 285, 217, 41);
		contentPane.add(screenCardTxt);
		
		JLabel machineTypeLbl = new JLabel("Machine Type");
		machineTypeLbl.setOpaque(true);
		machineTypeLbl.setHorizontalAlignment(SwingConstants.CENTER);
		machineTypeLbl.setBackground(Color.GRAY);
		machineTypeLbl.setBounds(527, 342, 217, 41);
		contentPane.add(machineTypeLbl);
		
		machineTypeTxt = new JTextField();
		machineTypeTxt.setColumns(10);
		machineTypeTxt.setBounds(527, 383, 217, 41);
		contentPane.add(machineTypeTxt);
		
		JLabel batteryCapacityLbl = new JLabel("Battery Capacity");
		batteryCapacityLbl.setOpaque(true);
		batteryCapacityLbl.setHorizontalAlignment(SwingConstants.CENTER);
		batteryCapacityLbl.setBackground(Color.GRAY);
		batteryCapacityLbl.setBounds(527, 437, 217, 41);
		contentPane.add(batteryCapacityLbl);
		
		batteryCapacityTxt = new JTextField();
		batteryCapacityTxt.setColumns(10);
		batteryCapacityTxt.setBounds(527, 478, 217, 41);
		contentPane.add(batteryCapacityTxt);
		
		JLabel originLbl = new JLabel("Origin");
		originLbl.setOpaque(true);
		originLbl.setHorizontalAlignment(SwingConstants.CENTER);
		originLbl.setBackground(Color.GRAY);
		originLbl.setBounds(776, 304, 217, 41);
		contentPane.add(originLbl);
		
		originTxt = new JTextField();
		originTxt.setColumns(10);
		originTxt.setBounds(776, 345, 217, 41);
		contentPane.add(originTxt);
		
		JLabel editLbl = new JLabel("EDIT COMPUTER");
		editLbl.setFont(new Font("Roboto", Font.BOLD, 24));
		editLbl.setHorizontalAlignment(SwingConstants.CENTER);
		editLbl.setBounds(0, 0, 1008, 112);
		contentPane.add(editLbl);
		
		this.setLocationRelativeTo(null);
		this.setVisible(true);
	}
	public void clickUpdateBtn() {
		int selectedRowIndex = this.productView.table.getSelectedRow();
		String conditionComputerCode = (String) this.productView.table.getValueAt(selectedRowIndex, 1);
		String screenCard = screenCardTxt.getText();
		String computerName = computerNameTxt.getText();
		String computerCode = computerCodeTxt.getText();
		String sourceCapacity = sourceCapacityTxt.getText();
		String cpuName = cpuTxt.getText();
		String ram = ramTxt.getText();
		String machineType = machineTypeTxt.getText();
		BigDecimal price = BigDecimal.valueOf( Long.parseLong(priceTxt.getText()) );
		
		System.out.println(price);
		int quantity = Integer.parseInt(quantityTxt.getText());
		String rom = romTxt.getText();
		String origin = originTxt.getText();
		Double screenSize = Double.parseDouble(screenSizeTxt.getText());
		String batteryCapacity = batteryCapacityTxt.getText();
		Computer com = new Computer(computerCode, computerName, quantity, cpuName, ram, screenCard, price, sourceCapacity, machineType, rom, screenSize,
				batteryCapacity, origin);
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
