package ite.computer_management.view;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JTextField;
import javax.swing.JLabel;
import java.awt.Font;
import javax.swing.JButton;
import javax.swing.Box;
import java.awt.Component;
import javax.swing.border.BevelBorder;
import javax.swing.JTable;
import javax.swing.JScrollPane;
import javax.swing.table.DefaultTableModel;

import ite.computer_management.controller.Imports_productController;
import ite.computer_management.dao.ImportDAO;

import javax.swing.JComboBox;
import java.awt.Color;

public class ExportProductView extends JPanel {

	private static final long serialVersionUID = 1L;
	private JTextField textField;
	private JTextField textField_1;
	private JTable table_product;
	private JTable table_1;
	private JTextField textField_2;
	private ImportDAO Import_Delivery_DAO;

	/**
	 * Launch the application.
	 */
//	public static void main(String[] args) {
//		EventQueue.invokeLater(new Runnable() {
//			public void run() {
//				try {
//					ImportsProductView frame = new ImportsProductView();
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
	public ExportProductView() {
		init();
		this.setVisible(true);
	}
	public void init() {
		Import_Delivery_DAO = new ImportDAO(this);
		Imports_productController Imports_productController = new Imports_productController(this);
		
		this.setSize(1032,763);
		setLayout(null);
		
		
		textField = new JTextField();
		textField.setBounds(37, 49, 278, 28);
		add(textField);
		textField.setColumns(10);
		
		JLabel lblNewLabel = new JLabel("Sreach:");
		lblNewLabel.setForeground(Color.BLACK);
		lblNewLabel.setFont(new Font("Tahoma", Font.BOLD, 16));
		lblNewLabel.setBounds(37, 26, 90, 13);
		add(lblNewLabel);
		
		Box verticalBox = Box.createVerticalBox();
		verticalBox.setBackground(Color.WHITE);
		verticalBox.setBorder(new BevelBorder(BevelBorder.LOWERED, null, null, null, null));
		verticalBox.setBounds(22, 10, 343, 87);
		add(verticalBox);
		
		JLabel lblFrom = new JLabel("From:");
		lblFrom.setForeground(Color.BLACK);
		lblFrom.setFont(new Font("Tahoma", Font.BOLD, 14));
		lblFrom.setBounds(508, 26, 90, 13);
		add(lblFrom);
		
		JLabel lblSupplier = new JLabel("Supplier:");
		lblSupplier.setForeground(Color.BLACK);
		lblSupplier.setFont(new Font("Tahoma", Font.BOLD, 14));
		lblSupplier.setBounds(508, 74, 90, 13);
		add(lblSupplier);
		
		textField_1 = new JTextField();
		textField_1.setColumns(10);
		textField_1.setBounds(651, 25, 349, 28);
		add(textField_1);
		
		table_product = new JTable();
		table_product.setModel(new DefaultTableModel(
			new Object[][] {
			},
			new String[] {
				"Number", "Code", "Name", "Quantity", "Price"
			}
		));
		table_product.getColumnModel().getColumn(0).setPreferredWidth(54);
		table_product.getColumnModel().getColumn(1).setPreferredWidth(42);
		table_product.getColumnModel().getColumn(2).setPreferredWidth(168);
		table_product.getColumnModel().getColumn(3).setPreferredWidth(53);
		table_product.getColumnModel().getColumn(4).setPreferredWidth(43);

		JScrollPane scrollPane_product = new JScrollPane(table_product);
		scrollPane_product.setBounds(22, 114, 452, 429);
		add(scrollPane_product);
		
		table_1 = new JTable();
		table_1.setModel(new DefaultTableModel(
			new Object[][] {
			},
			new String[] {
				"Number", "Code ", "Name", "Quantity", "Price"
			}
		));
		table_1.getColumnModel().getColumn(0).setPreferredWidth(50);
		table_1.getColumnModel().getColumn(1).setPreferredWidth(57);
		table_1.getColumnModel().getColumn(2).setPreferredWidth(185);
		table_1.getColumnModel().getColumn(3).setPreferredWidth(50);
		table_1.getColumnModel().getColumn(4).setPreferredWidth(37);
		table_1.setBounds(553, 203, 1, 1);
		add(table_1);
		
		JScrollPane scrollPane_Export = new JScrollPane(table_1);
		scrollPane_Export.setBounds(508, 114, 492, 356);
		add(scrollPane_Export);
		
		JComboBox comboBox = new JComboBox();
		comboBox.setBounds(651, 69, 349, 28);
		add(comboBox);
		
		JLabel lblQuantity = new JLabel("Quantity:");
		lblQuantity.setForeground(Color.RED);
		lblQuantity.setFont(new Font("Tahoma", Font.BOLD, 16));
		lblQuantity.setBounds(75, 578, 90, 13);
		add(lblQuantity);
		
		textField_2 = new JTextField();
		textField_2.setColumns(10);
		textField_2.setBounds(163, 573, 132, 28);
		add(textField_2);
		
		JButton btnNewButton = new JButton("Accept");
		btnNewButton.setBackground(Color.LIGHT_GRAY);
		btnNewButton.setForeground(new Color(0, 0, 0));
		btnNewButton.setFont(new Font("Tahoma", Font.PLAIN, 15));
		btnNewButton.setBounds(306, 573, 85, 28);
		add(btnNewButton);
		
		JButton btnExcel = new JButton("Excel");
		btnExcel.setBackground(Color.LIGHT_GRAY);
		btnExcel.setForeground(new Color(0, 0, 0));
		btnExcel.setFont(new Font("Tahoma", Font.PLAIN, 15));
		btnExcel.setBounds(548, 482, 85, 28);
		add(btnExcel);
		
		JButton btnChangeQuantity = new JButton("Change quantity");
		btnChangeQuantity.setBackground(Color.LIGHT_GRAY);
		btnChangeQuantity.setForeground(new Color(0, 0, 0));
		btnChangeQuantity.setFont(new Font("Tahoma", Font.PLAIN, 15));
		btnChangeQuantity.setBounds(651, 482, 160, 28);
		add(btnChangeQuantity);
		
		JButton btnDeleteProduct = new JButton("Delete product");
		btnDeleteProduct.setBackground(Color.LIGHT_GRAY);
		btnDeleteProduct.setForeground(new Color(0, 0, 0));
		btnDeleteProduct.setFont(new Font("Tahoma", Font.PLAIN, 15));
		btnDeleteProduct.setBounds(822, 480, 143, 28);
		add(btnDeleteProduct);
		
		JLabel lblTotalAmount = new JLabel("Total amount:");
		lblTotalAmount.setForeground(Color.BLACK);
		lblTotalAmount.setFont(new Font("Tahoma", Font.BOLD, 22));
		lblTotalAmount.setBounds(508, 548, 181, 28);
		add(lblTotalAmount);
		
		JLabel lblQuantity_1 = new JLabel("0Đ");
		lblQuantity_1.setForeground(Color.RED);
		lblQuantity_1.setFont(new Font("Tahoma", Font.BOLD, 29));
		lblQuantity_1.setBounds(681, 539, 90, 41);
		add(lblQuantity_1);
		
		JButton btnImportsProduct = new JButton("Delivery product");
		btnImportsProduct.setBackground(Color.LIGHT_GRAY);
		btnImportsProduct.setForeground(new Color(0, 0, 0));
		btnImportsProduct.setFont(new Font("Tahoma", Font.PLAIN, 15));
		btnImportsProduct.setBounds(824, 576, 160, 28);
		add(btnImportsProduct);
		
		// hien thị bang product
		Import_Delivery_DAO.display(table_product);
	}
}
