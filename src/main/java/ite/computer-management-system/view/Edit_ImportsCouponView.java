package ite.computer_management.view;

import java.awt.Color;
import java.awt.EventQueue;
import java.awt.Font;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

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

import ite.computer_management.controller.Edit_ImportsCoupon_Controller;
import ite.computer_management.dao.ImportDAO;

public class Edit_ImportsCouponView extends JFrame {

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
					Edit_ImportsCouponView frame = new Edit_ImportsCouponView(null, null);
					frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the frame.
	 * @param dashboard 
	 * @param imporCouponView 
	 */
	public Edit_ImportsCouponView(ImportCouponView imporCouponView, Dashboard dashboard) {
		Edit_ImportsCoupon_Controller edit_ImportsCoupon_Controller = new Edit_ImportsCoupon_Controller(this);
		
		
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 967, 600);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));

		setContentPane(contentPane);
		contentPane.setLayout(null);
		TF_Sreach = new JTextField();
		TF_Sreach.setBounds(27, 43, 158, 27);
		getContentPane().add(TF_Sreach);
		TF_Sreach.setColumns(10);
		
		JLabel lblNewLabel = new JLabel("Sreach:");
		lblNewLabel.setForeground(Color.BLACK);
		lblNewLabel.setFont(new Font("Tahoma", Font.BOLD, 16));
		lblNewLabel.setBounds(27, 13, 62, 20);
		getContentPane().add(lblNewLabel);
		
		Box verticalBox = Box.createVerticalBox();
		verticalBox.setBackground(Color.WHITE);
		verticalBox.setBorder(new BevelBorder(BevelBorder.LOWERED, null, null, null, null));
		verticalBox.setBounds(205, 221, 4, 4);
		getContentPane().add(verticalBox);
		
		JLabel lblFrom = new JLabel("Form:");
		lblFrom.setForeground(Color.BLACK);
		lblFrom.setFont(new Font("Tahoma", Font.BOLD, 14));
		lblFrom.setBounds(505, 15, 42, 17);
		getContentPane().add(lblFrom);
		
		JLabel lblSupplier = new JLabel("Supplier:");
		lblSupplier.setForeground(Color.BLACK);
		lblSupplier.setFont(new Font("Tahoma", Font.BOLD, 14));
		lblSupplier.setBounds(505, 63, 65, 17);
		getContentPane().add(lblSupplier);
		
		JLabel lblCreator = new JLabel("Creator:");
		lblCreator.setForeground(Color.BLACK);
		lblCreator.setFont(new Font("Tahoma", Font.BOLD, 14));
		lblCreator.setBounds(505, 103, 60, 17);
		getContentPane().add(lblCreator);
		
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
		table_Imports.setBounds(1, 25, 450, 0);
		getContentPane().add(table_Imports);
		
		JScrollPane scrollPane_1 = new JScrollPane(table_Imports);
		scrollPane_1.setBounds(505, 137, 433, 278);
		getContentPane().add(scrollPane_1);
		
		TF_Form = new JTextField();
		TF_Form.setColumns(10);
		TF_Form.setBounds(580, 12, 350, 27);
		TF_Form.setEditable(false);
		getContentPane().add(TF_Form);
		
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
		scrollPane.setBounds(25, 77, 431, 426);
		getContentPane().add(scrollPane);
		
		JComboBox Combo_Supplier = new JComboBox();
		Combo_Supplier.setBounds(580, 60, 350, 27);
		getContentPane().add(Combo_Supplier);
		
		JLabel lblQuantity = new JLabel("Quantity:");
		lblQuantity.setForeground(Color.RED);
		lblQuantity.setFont(new Font("Tahoma", Font.BOLD, 16));
		lblQuantity.setBounds(27, 521, 75, 20);
		getContentPane().add(lblQuantity);
		
		TF_Quantity = new JTextField();
		TF_Quantity.setColumns(10);
		TF_Quantity.setBounds(112, 520, 96, 27);
		getContentPane().add(TF_Quantity);
		
		btn_accept = new JButton("Accept");
		btn_accept.setBackground(Color.LIGHT_GRAY);
		btn_accept.setForeground(new Color(0, 0, 0));
		btn_accept.setFont(new Font("Tahoma", Font.PLAIN, 15));
		btn_accept.setBounds(218, 519, 89, 24);
		getContentPane().add(btn_accept);
		btn_accept.addMouseListener(edit_ImportsCoupon_Controller);
		
		JButton btn_Excel = new JButton("Excel");
		btn_Excel.setBackground(Color.LIGHT_GRAY);
		btn_Excel.setForeground(new Color(0, 0, 0));
		btn_Excel.setFont(new Font("Tahoma", Font.PLAIN, 15));
		btn_Excel.setBounds(515, 427, 80, 27);
		getContentPane().add(btn_Excel);
		
		JButton btn_ChangeQuantity = new JButton("Change quantity");
		btn_ChangeQuantity.setBackground(Color.LIGHT_GRAY);
		btn_ChangeQuantity.setForeground(new Color(0, 0, 0));
		btn_ChangeQuantity.setFont(new Font("Tahoma", Font.PLAIN, 15));
		btn_ChangeQuantity.setBounds(603, 427, 158, 27);
		getContentPane().add(btn_ChangeQuantity);

		JLabel lblTotalAmount = new JLabel("Total amount:");
		lblTotalAmount.setForeground(Color.BLACK);
		lblTotalAmount.setFont(new Font("Tahoma", Font.BOLD, 22));
		lblTotalAmount.setBounds(372, 874, 158, 27);
		getContentPane().add(lblTotalAmount);
		
		lblQuantity_1 = new JLabel("0Đ");
		lblQuantity_1.setForeground(Color.RED);
		lblQuantity_1.setFont(new Font("Tahoma", Font.BOLD, 25));
		lblQuantity_1.setBounds(535, 872, 35, 31);
		getContentPane().add(lblQuantity_1);
		
		JButton btn_ImportsProduct = new JButton("SAVE");
		btn_ImportsProduct.setBackground(Color.LIGHT_GRAY);
		btn_ImportsProduct.setForeground(new Color(0, 0, 0));
		btn_ImportsProduct.setFont(new Font("Tahoma", Font.PLAIN, 15));
		btn_ImportsProduct.setBounds(779, 517, 160, 28);
		getContentPane().add(btn_ImportsProduct);
	
		JComboBox Combo_Creator = new JComboBox();
		Combo_Creator.setBounds(580, 99, 350, 28);
		getContentPane().add(Combo_Creator);
		
		JButton btn_DeleteProduct = new JButton("Delete product");
		btn_DeleteProduct.setBackground(Color.LIGHT_GRAY);
		btn_DeleteProduct.setForeground(new Color(0, 0, 0));
		btn_DeleteProduct.setFont(new Font("Tahoma", Font.PLAIN, 15));
		btn_DeleteProduct.setBounds(767, 426, 158, 28);
		getContentPane().add(btn_DeleteProduct);
	}

}
