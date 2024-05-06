package ite.computer_management.view;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JTextField;
import javax.swing.JLabel;
import java.awt.Font;
import java.awt.SystemColor;
import java.awt.Window;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.util.List;

import javax.swing.JButton;
import javax.swing.Box;
import javax.swing.ImageIcon;

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
	private JLabel bgLbl;
	private JLabel lblQuantity_1;
	private Component btn_DeleteProduct;
	private JButton btn_accept;
	private JTextField TF_Sreach;
	private ImportDAO Imports_DAO;
	private JTextField TF_Form;
	private JTable table_Product;
	private JTable table_Imports;
	private JTextField TF_Quantity;

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
		Imports_DAO = new ImportDAO(this);
		Imports_productController Imports_productController = new Imports_productController(this);
		
		this.setSize(1250,800);
		setLayout(null);

		TF_Sreach = new JTextField();
		TF_Sreach.setBounds(37, 49, 282, 28);
		add(TF_Sreach);
		TF_Sreach.setColumns(10);
		
		JLabel lblNewLabel = new JLabel("Sreach:");
		lblNewLabel.setForeground(Color.BLACK);
		lblNewLabel.setFont(new Font("Tahoma", Font.BOLD, 16));
		lblNewLabel.setBounds(37, 26, 90, 13);
		add(lblNewLabel);
		
		Box verticalBox = Box.createVerticalBox();
		verticalBox.setBackground(SystemColor.inactiveCaptionText);
		verticalBox.setBorder(new BevelBorder(BevelBorder.LOWERED, null, null, null, null));
		verticalBox.setBounds(22, 10, 317, 87);
		add(verticalBox);
		
		JLabel lblFrom = new JLabel("Form:");
		lblFrom.setForeground(Color.BLACK);
		lblFrom.setFont(new Font("Tahoma", Font.BOLD, 14));
		lblFrom.setBounds(518, 26, 90, 13);
		add(lblFrom);
		
		JLabel lblSupplier = new JLabel("Supplier:");
		lblSupplier.setForeground(Color.BLACK);
		lblSupplier.setFont(new Font("Tahoma", Font.BOLD, 14));
		lblSupplier.setBounds(518, 75, 90, 13);
		add(lblSupplier);
		
		TF_Form = new JTextField();
		TF_Form.setColumns(10);
		TF_Form.setBounds(600, 26, 349, 28);
		TF_Form.setEditable(false);
		add(TF_Form);
		
		table_Product = new JTable();
		table_Product.setModel(new DefaultTableModel(
			new Object[][] {
			},
			new String[] {
				"Number", "Code", "Name", "Quantity", "Price"
			}
		));
		table_Product.getColumnModel().getColumn(0).setPreferredWidth(54);
		table_Product.getColumnModel().getColumn(1).setPreferredWidth(42);
		table_Product.getColumnModel().getColumn(2).setPreferredWidth(168);
		table_Product.getColumnModel().getColumn(3).setPreferredWidth(53);
		table_Product.getColumnModel().getColumn(4).setPreferredWidth(43);

		table_Product.addMouseListener(new MouseAdapter() {
			public int r;

			@Override
			public void mouseClicked(MouseEvent e) {
				r= table_Product.getSelectedRow();
				if(r!=-1) {
					TF_Quantity.setText(table_Product.getValueAt(r, 3)+"");
			      
				}
			}
		});
		
		
		JScrollPane scrollPane = new JScrollPane(table_Product);
		scrollPane.setBounds(22, 114, 452, 571);
		add(scrollPane);
		
		table_Imports = new JTable();
		table_Imports.setModel(new DefaultTableModel(
			new Object[][] {
			},
			new String[] {
				"Number", "Code ", "Name", "Quantity", "Price"
			}
		));
		table_Imports.getColumnModel().getColumn(0).setPreferredWidth(50);
		table_Imports.getColumnModel().getColumn(1).setPreferredWidth(57);
		table_Imports.getColumnModel().getColumn(2).setPreferredWidth(185);
		table_Imports.getColumnModel().getColumn(3).setPreferredWidth(50);
		table_Imports.getColumnModel().getColumn(4).setPreferredWidth(37);
		table_Imports.setBounds(553, 203, 1, 1);
		add(table_Imports);
		
		JScrollPane scrollPane_1 = new JScrollPane(table_Imports);
		scrollPane_1.setBounds(512, 144, 700, 510);
		add(scrollPane_1);
		
		JComboBox Combo_Supplier = new JComboBox();
		Combo_Supplier.setBounds(600, 69, 349, 28);
		add(Combo_Supplier);
		
		JLabel lblQuantity = new JLabel("Quantity:");
		lblQuantity.setForeground(SystemColor.inactiveCaptionText);
		lblQuantity.setFont(new Font("Tahoma", Font.BOLD, 16));
		lblQuantity.setBounds(26, 710, 90, 13);
		add(lblQuantity);
		
		TF_Quantity = new JTextField();
		TF_Quantity.setColumns(10);
		TF_Quantity.setBounds(111, 705, 125, 28);
		add(TF_Quantity);
		
		btn_accept = new JButton("Accept");
		btn_accept.setBackground(Color.LIGHT_GRAY);
		btn_accept.setForeground(new Color(0, 0, 0));
		btn_accept.setFont(new Font("Tahoma", Font.PLAIN, 15));
		btn_accept.setBounds(246, 702, 85, 28);
		add(btn_accept);
		btn_accept.addMouseListener(Imports_productController);
		
		JButton btn_Excel = new JButton("Excel");
		btn_Excel.setIcon(new ImageIcon("D:\\JAVA_project\\computer-management-system\\src\\main\\java\\ite\\computer_management\\img\\excel 30.png"));
		btn_Excel.setBackground(Color.LIGHT_GRAY);
		btn_Excel.setForeground(new Color(0, 0, 0));
		btn_Excel.setFont(new Font("Tahoma", Font.PLAIN, 15));
		btn_Excel.setBounds(1024, 26, 188, 28);
		add(btn_Excel);
		
		JButton btn_ChangeQuantity = new JButton("Change quantity");
		btn_ChangeQuantity.setIcon(new ImageIcon("D:\\JAVA_project\\computer-management-system\\src\\main\\java\\ite\\computer_management\\img\\reload 20.png"));
		btn_ChangeQuantity.setBackground(Color.LIGHT_GRAY);
		btn_ChangeQuantity.setForeground(new Color(0, 0, 0));
		btn_ChangeQuantity.setFont(new Font("Tahoma", Font.PLAIN, 15));
		btn_ChangeQuantity.setBounds(1024, 67, 188, 28);
		add(btn_ChangeQuantity);
		
		 btn_DeleteProduct = new JButton("Delete product");

		btn_DeleteProduct.setBackground(Color.LIGHT_GRAY);
		btn_DeleteProduct.setForeground(new Color(0, 0, 0));
		btn_DeleteProduct.setFont(new Font("Tahoma", Font.PLAIN, 15));
		btn_DeleteProduct.setBounds(1024, 106, 188, 28);
		add(btn_DeleteProduct);
		btn_DeleteProduct.addMouseListener(Imports_productController);
		
		JLabel lblTotalAmount = new JLabel("Total amount:");
		lblTotalAmount.setForeground(Color.BLACK);
		lblTotalAmount.setFont(new Font("Tahoma", Font.BOLD, 22));
		lblTotalAmount.setBounds(518, 664, 181, 28);
		add(lblTotalAmount);
		
		lblQuantity_1 = new JLabel("0Đ");
		lblQuantity_1.setForeground(Color.RED);
		lblQuantity_1.setFont(new Font("Tahoma", Font.BOLD, 25));
		lblQuantity_1.setBounds(697, 657, 341, 41);
		add(lblQuantity_1);
		
		JButton btn_ImportsProduct = new JButton("Imports product");
		btn_ImportsProduct.setBackground(Color.LIGHT_GRAY);
		btn_ImportsProduct.setForeground(new Color(0, 0, 0));
		btn_ImportsProduct.setFont(new Font("Tahoma", Font.PLAIN, 15));
		btn_ImportsProduct.setBounds(1052, 682, 160, 41);
		add(btn_ImportsProduct);
		
		Imports_DAO.display(table_Product);
		
		Box verticalBox_1 = Box.createVerticalBox();
		verticalBox_1.setBorder(new BevelBorder(BevelBorder.LOWERED, null, null, null, null));
		verticalBox_1.setBackground(SystemColor.desktop);
		verticalBox_1.setBounds(512, 10, 461, 107);
		add(verticalBox_1);
		
		bgLbl = new JLabel("");
		bgLbl.setBounds(0, -27, 1250, 817);
		bgLbl.setBackground(new Color(224, 218, 218));
		bgLbl.setBackground(new Color(191, 186, 166));
		bgLbl.setOpaque(true);
		add(bgLbl);
		
		// lấy dữ liệu từ bảng supplier trong database để hiện thị trong Jcombobox
		ImportDAO importDAO = new ImportDAO();
		List<String> supplierNames = importDAO.getSupplierNames();
		for (String supplierName : supplierNames) {
		    Combo_Supplier.addItem(supplierName);
		}
		ImportsProductView view = new ImportsProductView();

		view.setRandomFormValue();
	}
}
