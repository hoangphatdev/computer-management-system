
package ite.computer_management.view;

import java.awt.EventQueue;

import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JTextField;
import javax.swing.SwingConstants;
import javax.swing.JLabel;
import javax.swing.JOptionPane;

import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.sql.Connection;
import java.util.List;
import java.util.Random;

import javax.swing.JButton;
import javax.swing.Box;
import java.awt.Component;
import javax.swing.border.BevelBorder;
import javax.swing.JTable;
import javax.swing.JScrollPane;
import javax.swing.table.DefaultTableModel;

import ite.computer_management.controller.Imports_productController;
import ite.computer_management.dao.ImportDAO;
import ite.computer_management.database.ConnectDatabase;

import javax.swing.JComboBox;
import java.awt.Color;

public class ImportsProductView extends JPanel {

	private static final long serialVersionUID = 1L;
	public JTextField TF_Sreach;
	public JTextField TF_Form;
	public JTable table_Product;
	public JTable table_Imports;
	public JTextField TF_Quantity;
	private JLabel lblQuantity_1;
	public JButton btn_DeleteProduct;
	private ImportDAO Imports_DAO;
	public static JButton btn_accept;

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
//
//	/**
//	 * Create the frame.
//	 */
	
	
	public ImportsProductView() {
		init();
		this.setVisible(true);
	}
	public void init() {
		Imports_DAO = new ImportDAO(this);
		Imports_productController Imports_productController = new Imports_productController(this);
		
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
		btn_accept.addMouseListener(Imports_productController);
		
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
		
		 btn_DeleteProduct = new JButton("Delete product");
		btn_DeleteProduct.setBackground(Color.LIGHT_GRAY);
		btn_DeleteProduct.setForeground(new Color(0, 0, 0));
		btn_DeleteProduct.setFont(new Font("Tahoma", Font.PLAIN, 15));
		btn_DeleteProduct.setBounds(822, 480, 143, 28);
		add(btn_DeleteProduct);
		btn_DeleteProduct.addMouseListener(Imports_productController);
		
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
		
		Imports_DAO.display(table_Product);
		
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
		
		setRandomFormValue();
	}
	public void addProductActionPerformed(Imports_productController imports_productController) {
	    int row = table_Product.getSelectedRow();
	    if (row == -1) {
	        JOptionPane.showMessageDialog(this, "Please choose the row you need!");
	    } else {
	        try {
	            int quantity = Integer.parseInt(TF_Quantity.getText().trim());
	            if (quantity > 0) {
	                String productCode = table_Product.getValueAt(row, 1).toString();
	                String productName = table_Product.getValueAt(row, 2).toString();
	                // Thực hiện truy vấn để lấy thông tin còn lại từ cơ sở dữ liệu
	                String[] productInfo = Imports_DAO.getProductInfo(productCode);
	                if (productInfo != null) {
	                    int currentQuantity = Integer.parseInt(productInfo[1]); // Số lượng hiện có của sản phẩm
	                    if (quantity == currentQuantity) {
	                        DefaultTableModel tableModelImports = (DefaultTableModel) table_Imports.getModel();
	                        tableModelImports.addRow(new Object[] { productInfo[0], productCode, productName, quantity, productInfo[1], productInfo[2] });
	                        // Xóa hàng đã chọn khỏi bảng table_Product
	                        DefaultTableModel tableModelProduct = (DefaultTableModel) table_Product.getModel();
	                        tableModelProduct.removeRow(row);
	                        // Cập nhật lại tổng số tiền
	                        updateTotalAmount();
	                    } else if (quantity < currentQuantity) {
	                        DefaultTableModel tableModelProduct = (DefaultTableModel) table_Product.getModel();
	                        // Cập nhật số lượng của sản phẩm trong bảng table_Product
	                        table_Product.setValueAt(currentQuantity - quantity, row, 3);
	                        // Thêm sản phẩm vào bảng table_Imports với số lượng nhập
	                        DefaultTableModel tableModelImports = (DefaultTableModel) table_Imports.getModel();
	                        tableModelImports.addRow(new Object[] { productInfo[0], productCode, productName, quantity, productInfo[1], productInfo[2] });
	                        // Cập nhật lại tổng số tiền
	                        updateTotalAmount();
	                    } else {
	                        JOptionPane.showMessageDialog(this, "Not enough quantity available for this product!");
	                    }
	                } else {
	                    JOptionPane.showMessageDialog(this, "No product information found in the database!");
	                }
	            } else {
	                JOptionPane.showMessageDialog(this, "Please enter a quantity greater than 0");
	            }
	        } catch (NumberFormatException e) {
	            JOptionPane.showMessageDialog(this, "Please enter the quantity as an integer!");
	        }
	    }
	}



	private void updateTotalAmount() {
	    DefaultTableModel modelImports = (DefaultTableModel) table_Imports.getModel();
	    double totalAmount = 0;
	    for (int i = 0; i < modelImports.getRowCount(); i++) {
	        double price = Double.parseDouble(modelImports.getValueAt(i, 4).toString());
	        int quantity = Integer.parseInt(modelImports.getValueAt(i, 3).toString());
	        totalAmount += price * quantity;
	    }
	    lblQuantity_1.setText(String.valueOf(totalAmount) + "Đ");
	}

	
	 public void setRandomFormValue() {
	        String randomFormValue = generateRandomCode();
	        TF_Form.setText(randomFormValue);
	    }

	    // Phương thức để sinh mã ngẫu nhiên
	    private String generateRandomCode() {
	        String chars = "ABCDEFGHIJKLMNOPQRSTUVWXYZ0123456789";
	        StringBuilder sb = new StringBuilder();
	        Random random = new Random();
	        for (int i = 0; i < 2; i++) {
	            char randomChar = chars.charAt(random.nextInt(chars.length()));
	            sb.append(randomChar);
	        }
	        for (int i = 0; i < 4; i++) {
	            int randomDigit = random.nextInt(10);
	            sb.append(randomDigit);
	        }
	        return sb.toString();
	    }
	    
	    public void delete_toTableImport() {
	        int row = table_Imports.getSelectedRow();
	        if (row == -1) {
	            JOptionPane.showMessageDialog(this, "Please choose the row you need!");
	        } else {
	            try {
	                int quantity = Integer.parseInt(TF_Quantity.getText().trim());
	                String productCode = table_Imports.getValueAt(row, 1).toString();
	                String productName = table_Imports.getValueAt(row, 2).toString();
	                
	                // Thực hiện truy vấn để lấy thông tin còn lại từ cơ sở dữ liệu
	                String[] productInfo = Imports_DAO.getProductInfo(productCode);
	                  
	                DefaultTableModel tableModelProduct = (DefaultTableModel) table_Product.getModel();
	                
	                // Kiểm tra xem sản phẩm đã tồn tại trong bảng table_Product hay chưa
	                boolean productExists = false;
	                for (int i = 0; i < tableModelProduct.getRowCount(); i++) {
	                    if (productCode.equals(tableModelProduct.getValueAt(i, 1).toString())) {
	                        // Nếu sản phẩm đã tồn tại, cộng số lượng
	                        int currentQuantity = Integer.parseInt(tableModelProduct.getValueAt(i, 3).toString());
	                        tableModelProduct.setValueAt(currentQuantity + quantity, i, 3);
	                        productExists = true;
	                        break;
	                    }
	                }
	                
	                // Nếu sản phẩm không tồn tại, thêm sản phẩm mới vào bảng table_Product
	                if (!productExists) {
	                    tableModelProduct.addRow(new Object[] { productInfo[0], productCode, productName, quantity, productInfo[1], productInfo[2] });
	                }

	                // Xóa hàng đã chọn khỏi bảng table_Imports
	                DefaultTableModel tableModelImports = (DefaultTableModel) table_Imports.getModel();
	                tableModelImports.removeRow(row);
	                
	                // Cập nhật lại tổng số tiền
	                updateTotalAmount();
	            } catch (NumberFormatException e) {
	                JOptionPane.showMessageDialog(this, "Please enter the quantity as an integer!");
	            }
	        }
	    }

}
