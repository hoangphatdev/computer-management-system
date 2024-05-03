package ite.computer_management.view;

import java.awt.Color;
import java.awt.EventQueue;
import java.awt.Font;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.util.List;

import javax.swing.Box;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.JTextField;
import javax.swing.border.BevelBorder;
import javax.swing.border.EmptyBorder;
import javax.swing.table.DefaultTableModel;

import ite.computer_management.controller.Details_ImportsCouponController;
import ite.computer_management.controller.Imports_productController;
import ite.computer_management.dao.ImportDAO;

public class Details_ImportCouponView extends JFrame {

	private static final long serialVersionUID = 1L;
	private JPanel contentPane;
	public JTextField TF_Sreach;
	public JTextField TF_Form;
	public JTable table_Product;
	public JTable table_Imports;
	public JTextField TF_Quantity;
	public ImportDAO Import_Delivery_DAO;
	private JLabel lblQuantity_1;
	public static JButton btn_accept;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					Details_ImportCouponView frame = new Details_ImportCouponView();
					frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the frame.
	 */
	public Details_ImportCouponView() {
		Details_ImportsCouponController details_ImportsCouponController = new Details_ImportsCouponController(this);
		
		this.setSize(1032,763);
		setLayout(null);

		TF_Sreach = new JTextField();
		TF_Sreach.setBounds(37, 49, 278, 28);
		add(TF_Sreach);
		TF_Sreach.setColumns(10);
		
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
		
		JLabel lblFrom = new JLabel("Form:");
		lblFrom.setForeground(Color.BLACK);
		lblFrom.setFont(new Font("Tahoma", Font.BOLD, 14));
		lblFrom.setBounds(508, 26, 90, 13);
		add(lblFrom);
		
		JLabel lblSupplier = new JLabel("Supplier:");
		lblSupplier.setForeground(Color.BLACK);
		lblSupplier.setFont(new Font("Tahoma", Font.BOLD, 14));
		lblSupplier.setBounds(508, 74, 90, 13);
		add(lblSupplier);
		
		JLabel lblCreator = new JLabel("Creator:");
		lblCreator.setForeground(Color.BLACK);
		lblCreator.setFont(new Font("Tahoma", Font.BOLD, 14));
		lblCreator.setBounds(508, 114, 90, 13);
		add(lblCreator);
		
		TF_Form = new JTextField();
		TF_Form.setColumns(10);
		TF_Form.setBounds(651, 25, 349, 28);
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
		scrollPane.setBounds(22, 114, 452, 429);
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
		scrollPane_1.setBounds(508, 159, 492, 311);
		add(scrollPane_1);
		
		JComboBox Combo_Supplier = new JComboBox();
		Combo_Supplier.setBounds(651, 69, 349, 28);
		add(Combo_Supplier);
		
		JLabel lblQuantity = new JLabel("Quantity:");
		lblQuantity.setForeground(Color.RED);
		lblQuantity.setFont(new Font("Tahoma", Font.BOLD, 16));
		lblQuantity.setBounds(75, 578, 90, 13);
		add(lblQuantity);
		
		TF_Quantity = new JTextField();
		TF_Quantity.setColumns(10);
		TF_Quantity.setBounds(163, 573, 132, 28);
		add(TF_Quantity);
		
		btn_accept = new JButton("Accept");
		btn_accept.setBackground(Color.LIGHT_GRAY);
		btn_accept.setForeground(new Color(0, 0, 0));
		btn_accept.setFont(new Font("Tahoma", Font.PLAIN, 15));
		btn_accept.setBounds(306, 573, 85, 28);
		add(btn_accept);
		btn_accept.addMouseListener(details_ImportsCouponController);
		
		JButton btn_Excel = new JButton("Excel");
		btn_Excel.setBackground(Color.LIGHT_GRAY);
		btn_Excel.setForeground(new Color(0, 0, 0));
		btn_Excel.setFont(new Font("Tahoma", Font.PLAIN, 15));
		btn_Excel.setBounds(548, 482, 85, 28);
		add(btn_Excel);
		
		JButton btn_ChangeQuantity = new JButton("Change quantity");
		btn_ChangeQuantity.setBackground(Color.LIGHT_GRAY);
		btn_ChangeQuantity.setForeground(new Color(0, 0, 0));
		btn_ChangeQuantity.setFont(new Font("Tahoma", Font.PLAIN, 15));
		btn_ChangeQuantity.setBounds(651, 482, 160, 28);
		add(btn_ChangeQuantity);
		
		JButton btn_DeleteProduct = new JButton("Delete product");
		btn_DeleteProduct.setBackground(Color.LIGHT_GRAY);
		btn_DeleteProduct.setForeground(new Color(0, 0, 0));
		btn_DeleteProduct.setFont(new Font("Tahoma", Font.PLAIN, 15));
		btn_DeleteProduct.setBounds(822, 480, 143, 28);
		add(btn_DeleteProduct);
		
		JLabel lblTotalAmount = new JLabel("Total amount:");
		lblTotalAmount.setForeground(Color.BLACK);
		lblTotalAmount.setFont(new Font("Tahoma", Font.BOLD, 22));
		lblTotalAmount.setBounds(508, 548, 181, 28);
		add(lblTotalAmount);
		
		lblQuantity_1 = new JLabel("0Đ");
		lblQuantity_1.setForeground(Color.RED);
		lblQuantity_1.setFont(new Font("Tahoma", Font.BOLD, 25));
		lblQuantity_1.setBounds(681, 539, 341, 41);
		add(lblQuantity_1);
		
		JButton btn_ImportsProduct = new JButton("Imports product");
		btn_ImportsProduct.setBackground(Color.LIGHT_GRAY);
		btn_ImportsProduct.setForeground(new Color(0, 0, 0));
		btn_ImportsProduct.setFont(new Font("Tahoma", Font.PLAIN, 15));
		btn_ImportsProduct.setBounds(824, 576, 160, 28);
		add(btn_ImportsProduct);
		
	Import_Delivery_DAO.display(table_Product);
		
		JComboBox Combo_Creator = new JComboBox();
		Combo_Creator.setBounds(651, 111, 349, 28);
		add(Combo_Creator);
		
		// lấy dữ liệu từ bảng supplier trong database để hiện thị trong Jcombobox
		ImportDAO importDAO = new ImportDAO();
		List<String> supplierNames = importDAO.getSupplierNames();
		for (String supplierName : supplierNames) {
		    Combo_Supplier.addItem(supplierName);
		}

		// lấy dữ liệu từ bảng account trong database để hiện thị trong Jcombobox
		List<String> userName = importDAO.getUserName();
		for (String userNames : userName) {
		    Combo_Creator.addItem(userNames);
		}
	}

}
