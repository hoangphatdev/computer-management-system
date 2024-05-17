
package ite.computer_management.view;



import javax.swing.JPanel;

import javax.swing.JTextField;

import javax.swing.JLabel;
import javax.swing.JOptionPane;

import java.awt.Font;

import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

import java.text.DecimalFormat;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.List;


import javax.swing.JButton;
import javax.swing.Box;

import javax.swing.border.BevelBorder;
import javax.swing.JTable;
import javax.swing.JScrollPane;
import javax.swing.table.DefaultTableModel;

import java.sql.Timestamp;


import ite.computer_management.controller.Imports_productController;
import ite.computer_management.controller.WirtePDF_File;
import ite.computer_management.dao.Details_ImportDAO;
import ite.computer_management.dao.ImportDAO;
import ite.computer_management.dao.SupplierDAO;
import ite.computer_management.dao.computerDAO;

import ite.computer_management.model.Details_Form;
import ite.computer_management.model.ImportsForm;
import ite.computer_management.model.Supplier;


import javax.swing.JComboBox;
import java.awt.Color;
import java.awt.SystemColor;
import javax.swing.ImageIcon;

public class ImportsProductView extends JPanel {

	private static final long serialVersionUID = 1L;
	public JTextField TF_Sreach;
	public JTextField TF_Form;
	public JTable table_Product;
	public JTable table_Imports;
	public JTextField TF_Quantity;
	private JLabel text_totalAmount;
	public JButton btn_DeleteProduct;
	private ImportDAO Imports_DAO;
	public JButton btn_accept;
	
	DecimalFormat formatter = new DecimalFormat("###,###,###");
	SimpleDateFormat formatDate = new SimpleDateFormat("dd/MM/YYYY HH:mm");
	private JComboBox Combo_Supplier;
	private String form_Code;
	private JComboBox Combo_Creator;
	private static final ArrayList<Supplier> arrNcc = SupplierDAO.getInstance().selectAll();
	private ArrayList<Details_Form> Details_Form;
	public JButton btn_ImportsProduct;
	public JButton btn_Refresh;

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
	  public DecimalFormat getFormatter() {
	        return formatter;
	    }

	    public SimpleDateFormat getFormatDate() {
	        return formatDate;
	    }
	
	public ImportsProductView() {
		setBackground(new Color(72, 61, 139));
	
		init();
		this.setVisible(true);
		Details_Form = new ArrayList<Details_Form>();
		form_Code = createId(Imports_DAO.getInstance().selectAll());
		TF_Form.setText(form_Code);
		
		Box verticalBox = Box.createVerticalBox();
		verticalBox.setBorder(new BevelBorder(BevelBorder.LOWERED, null, null, null, null));
		verticalBox.setBounds(22, 10, 446, 78);
		add(verticalBox);
		
		Box verticalBox_1 = Box.createVerticalBox();
		verticalBox_1.setBorder(new BevelBorder(BevelBorder.LOWERED, null, null, null, null));
		verticalBox_1.setBounds(503, 10, 722, 146);
		add(verticalBox_1);
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
		
		btn_Refresh = new JButton("");
		btn_Refresh.setIcon(new ImageIcon("D:\\JAVA_project\\computer-management-system\\src\\main\\java\\ite\\computer_management\\img\\reload 30.png"));
		btn_Refresh.setBounds(348, 46, 85, 28);
		btn_Refresh.setForeground(Color.WHITE);
		btn_Refresh.setFont(new Font("Tahoma", Font.PLAIN, 15));
		btn_Refresh.setBackground(new Color(0, 0, 51));
		add(btn_Refresh);
		btn_Refresh.addMouseListener(Imports_productController);
		
		JLabel lblNewLabel = new JLabel("Sreach:");
		lblNewLabel.setBounds(37, 26, 90, 13);
		lblNewLabel.setForeground(Color.WHITE);
		lblNewLabel.setFont(new Font("Tahoma", Font.BOLD, 16));
		add(lblNewLabel);
		
		JLabel lblFrom = new JLabel("Form:");
		lblFrom.setBounds(518, 26, 90, 13);
		lblFrom.setForeground(Color.WHITE);
		lblFrom.setFont(new Font("Tahoma", Font.BOLD, 14));
		add(lblFrom);
		
		JLabel lblSupplier = new JLabel("Supplier:");
		lblSupplier.setBounds(518, 75, 90, 13);
		lblSupplier.setForeground(Color.WHITE);
		lblSupplier.setFont(new Font("Tahoma", Font.BOLD, 14));
		add(lblSupplier);
		
		JLabel lblCreator = new JLabel("Creator:");
		lblCreator.setBounds(518, 114, 90, 13);
		lblCreator.setForeground(Color.WHITE);
		lblCreator.setFont(new Font("Tahoma", Font.BOLD, 14));
		add(lblCreator);
		
		TF_Form = new JTextField();
		TF_Form.setBounds(600, 26, 349, 28);
		TF_Form.setColumns(10);
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
		scrollPane.setBounds(22, 107, 452, 571);
		add(scrollPane);
		
		table_Imports = new JTable();
		table_Imports.setBounds(1, 25, 698, 0);
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
		add(table_Imports);
		
		JScrollPane scrollPane_1 = new JScrollPane(table_Imports);
		scrollPane_1.setBounds(503, 176, 722, 478);
		add(scrollPane_1);
		
		 Combo_Supplier = new JComboBox();
		 Combo_Supplier.setBounds(600, 69, 349, 28);
		add(Combo_Supplier);
		
		JLabel lblQuantity = new JLabel("Quantity:");
		lblQuantity.setBounds(26, 710, 90, 13);
		lblQuantity.setForeground(Color.WHITE);
		lblQuantity.setFont(new Font("Tahoma", Font.BOLD, 16));
		add(lblQuantity);
		
		TF_Quantity = new JTextField();
		TF_Quantity.setBounds(111, 705, 125, 28);
		TF_Quantity.setColumns(10);
		add(TF_Quantity);
		
		btn_accept = new JButton("Accept");
		btn_accept.setBounds(246, 705, 85, 28);
		btn_accept.setBackground(Color.LIGHT_GRAY);
		btn_accept.setForeground(new Color(0, 0, 0));
		btn_accept.setFont(new Font("Tahoma", Font.PLAIN, 15));
		add(btn_accept);
		btn_accept.addMouseListener(Imports_productController);
		
		JButton btn_Excel = new JButton("Excel");
		btn_Excel.setBounds(1024, 26, 188, 28);
		btn_Excel.setIcon(new ImageIcon("D:\\JAVA_project\\computer-management-system\\src\\main\\java\\ite\\computer_management\\img\\excel 30.png"));
		btn_Excel.setBackground(new Color(0, 0, 51));
		btn_Excel.setForeground(Color.WHITE);
		btn_Excel.setFont(new Font("Tahoma", Font.PLAIN, 15));
		add(btn_Excel);
		
		JButton btn_ChangeQuantity = new JButton("Change quantity");
		btn_ChangeQuantity.setBounds(1024, 67, 188, 28);
		btn_ChangeQuantity.setIcon(new ImageIcon("D:\\JAVA_project\\computer-management-system\\src\\main\\java\\ite\\computer_management\\img\\edit 30.png"));
		btn_ChangeQuantity.setBackground(new Color(0, 0, 51));
		btn_ChangeQuantity.setForeground(Color.WHITE);
		btn_ChangeQuantity.setFont(new Font("Tahoma", Font.PLAIN, 15));
		add(btn_ChangeQuantity);
		
		 btn_DeleteProduct = new JButton("Delete product");
		 btn_DeleteProduct.setBounds(1024, 106, 188, 28);
		 btn_DeleteProduct.setIcon(new ImageIcon("D:\\JAVA_project\\computer-management-system\\src\\main\\java\\ite\\computer_management\\img\\delete 30.png"));
		btn_DeleteProduct.setBackground(new Color(0, 0, 51));
		btn_DeleteProduct.setForeground(Color.WHITE);
		btn_DeleteProduct.setFont(new Font("Tahoma", Font.PLAIN, 15));
		add(btn_DeleteProduct);
		btn_DeleteProduct.addMouseListener(Imports_productController);
		
		JLabel lblTotalAmount = new JLabel("Total amount:");
		lblTotalAmount.setBounds(503, 670, 181, 28);
		lblTotalAmount.setForeground(Color.WHITE);
		lblTotalAmount.setFont(new Font("Tahoma", Font.BOLD, 22));
		add(lblTotalAmount);
		
		text_totalAmount = new JLabel("0Đ");
		text_totalAmount.setBounds(671, 663, 341, 41);
		text_totalAmount.setForeground(Color.RED);
		text_totalAmount.setFont(new Font("Tahoma", Font.BOLD, 25));
		add(text_totalAmount);
		
		btn_ImportsProduct = new JButton("Imports product");
		btn_ImportsProduct.setBounds(1052, 682, 160, 41);
		btn_ImportsProduct.setBackground(new Color(0, 0, 51));
		btn_ImportsProduct.setForeground(Color.WHITE);
		btn_ImportsProduct.setFont(new Font("Tahoma", Font.PLAIN, 15));
		add(btn_ImportsProduct);
		btn_ImportsProduct.addMouseListener(Imports_productController);
		
		Imports_DAO.display(table_Product);
		
		Combo_Creator = new JComboBox();
		Combo_Creator.setBounds(600, 108, 349, 28);
		add(Combo_Creator);
		
		// lấy dữ liệu từ bảng supplier trong database để hiện thị trong Jcombobox
		ImportDAO importDAO = new ImportDAO();
		List<String> supplierNames = importDAO.getSupplierNames();
		for (String supplierName : supplierNames) {
		    Combo_Supplier.addItem(supplierName);
		}

		// lấy dữ liệu từ bảng account trong database để hiện thị trong Jcombobox
		List<String> fullname = importDAO.getFullName();
		for (String FullName : fullname) {
		    Combo_Creator.addItem(FullName);
		}
	
	}
	public void addProductActionPerformed() {
	    Imports_productController imports_productController;
	    int row = table_Product.getSelectedRow();
	    if (row == -1) {
	        JOptionPane.showMessageDialog(this, "Please choose the row you need!");
	    } else {
	        try {
	            int quantity = Integer.parseInt(TF_Quantity.getText().trim());
	            if (quantity > 0) {
	            	double price = Double.parseDouble(table_Product.getValueAt(row, 4).toString());
	                String productCode = table_Product.getValueAt(row, 1).toString();
	                String productName = table_Product.getValueAt(row, 2).toString();
	                // Thực hiện truy vấn để lấy thông tin còn lại từ cơ sở dữ liệu
	                String[] productInfo = Imports_DAO.getProductInfo(productCode);
	                if (productInfo != null) {
	                    int currentQuantity = Integer.parseInt(productInfo[1]); // Số lượng hiện có của sản phẩm
	                    if (quantity == currentQuantity) {
	                        DefaultTableModel tableModelImports = (DefaultTableModel) table_Imports.getModel();
	                        // Kiểm tra xem sản phẩm đã tồn tại trong bảng nhập hàng hay chưa
	                        boolean productExists = false;
	                        for (int i = 0; i < tableModelImports.getRowCount(); i++) {
	                            if (productCode.equals(tableModelImports.getValueAt(i, 1))) {
	                                int existingQuantity = (int) tableModelImports.getValueAt(i, 3);
	                                tableModelImports.setValueAt(existingQuantity + quantity, i, 3);
	                                productExists = true;
	                                break;
	                            }
	                        }
	                        if (!productExists) {
	                            tableModelImports.addRow(new Object[] { productInfo[0], productCode, productName, quantity, price});
	                        }
	                        // Xóa hàng đã chọn khỏi bảng table_Product
	                        DefaultTableModel tableModelProduct = (DefaultTableModel) table_Product.getModel();
	                        tableModelProduct.removeRow(row);
	                        // Cập nhật lại tổng số tiền
	                        updateTotalAmount();

	                        // Cập nhật số lượng trong cơ sở dữ liệu
	                        int newQuantity = currentQuantity - quantity;
	                        Imports_DAO.updateProductQuantity(productCode, newQuantity);
	                    } else if (quantity < currentQuantity) {
	                        DefaultTableModel tableModelProduct = (DefaultTableModel) table_Product.getModel();
	                        // Cập nhật số lượng của sản phẩm trong bảng table_Product
	                        int quantityNow = currentQuantity - quantity;
	                        table_Product.setValueAt(quantityNow, row, 3);
	                        // Thêm sản phẩm vào bảng table_Imports với số lượng nhập
	                        DefaultTableModel tableModelImports = (DefaultTableModel) table_Imports.getModel();
	                        boolean productExists = false;
	                        for (int i = 0; i < tableModelImports.getRowCount(); i++) {
	                            if (productCode.equals(tableModelImports.getValueAt(i, 1))) {
	                                int existingQuantity = (int) tableModelImports.getValueAt(i, 3);
	                                tableModelImports.setValueAt(existingQuantity + quantity, i, 3);
	                                productExists = true;
	                                break;
	                            }
	                        }
	                        int number =0;
	                        if (!productExists) {
	                            tableModelImports.addRow(new Object[] { number+1, productCode, productName, quantity, price});
	                        }
	                        // Cập nhật lại tổng số tiền
	                        updateTotalAmount();

	                        // Cập nhật số lượng trong cơ sở dữ liệu
	                        int newQuantity = currentQuantity - quantity;
	                        Imports_DAO.updateProductQuantity(productCode, newQuantity);
	                        form_Code = TF_Form.getText();
	                        Details_Form.add(new ite.computer_management.model.Details_Form(form_Code, productCode, quantity, price));
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
	    text_totalAmount.setText(String.valueOf(totalAmount) + "Đ");
	}
	public String createId(ArrayList<ImportsForm> arr) {
        int id = arr.size() + 1;
        String check = "";
        for (ImportsForm form : arr) {
            if (form.getForm_Code().equals("IF" + id)) {
                check = form.getForm_Code();
            }
        }
        while (check.length() != 0) {
            String c = check;
            id++;
            for (int i = 0; i < arr.size(); i++) {
                if (arr.get(i).getForm_Code().equals("IF" + id)) {
                    check = arr.get(i).getForm_Code();
                }
            }
            if (check.equals(c)) {
                check = "";
            }
        }
        return "IF" + id;
    }
	    
	    public void delete_toTableImport() {
	        int row = table_Imports.getSelectedRow();
	        if (row == -1) {
	            JOptionPane.showMessageDialog(this, "Please choose the row you need!");
	        } else {
	            try {
	            	DefaultTableModel tableModelProduct = (DefaultTableModel) table_Product.getModel();
	            	DefaultTableModel tableModelImports = (DefaultTableModel) table_Imports.getModel(); 	
	            	int quantity = Integer.parseInt(tableModelImports.getValueAt(row, 3).toString());
	                String productCode = table_Imports.getValueAt(row, 1).toString();
	                String productName = table_Imports.getValueAt(row, 2).toString();
	                double price = Double.parseDouble(table_Imports.getValueAt(row, 4).toString());
	                // Thực hiện truy vấn để lấy thông tin còn lại từ cơ sở dữ liệu
	                String[] productInfo = Imports_DAO.getProductInfo(productCode);
	                // Kiểm tra xem sản phẩm đã tồn tại trong bảng table_Product hay chưa
	                boolean productExists = false;
	                for (int i = 0; i < tableModelProduct.getRowCount(); i++) {
	                    if (productCode.equals(tableModelProduct.getValueAt(i, 1).toString())) {
	                        // Nếu sản phẩm đã tồn tại, cộng số lượng	
	                        int currentQuantity = Integer.parseInt(tableModelProduct.getValueAt(i, 3).toString());
	                        int quantity_now = currentQuantity + quantity;
	                        tableModelProduct.setValueAt(quantity_now, i, 3);
	                        productExists = true;
	                        break;
	                    }
	                }
	                // Nếu sản phẩm không tồn tại, thêm sản phẩm mới vào bảng table_Product
	                if (!productExists) {
	                    tableModelProduct.addRow(new Object[] { productInfo[0], productCode, productName, quantity, price});
	                }
	                // Xóa hàng đã chọn khỏi bảng table_Imports
	                tableModelImports.removeRow(row);
	                // Cập nhật lại tổng số tiền
	                updateTotalAmount();
	                // Cập nhật số lượng trong cơ sở dữ liệu
	                int newQuantity = Integer.parseInt(productInfo[1]) + quantity;
	                Imports_DAO.updateProductQuantity(productCode, newQuantity);
	                form_Code = TF_Form.getText();
	                Details_Form.remove(new ite.computer_management.model.Details_Form(form_Code, productCode, quantity, price));
	            } catch (NumberFormatException e) {
	                JOptionPane.showMessageDialog(this, "Please enter the quantity as an integer!");
	            }
	        }
	    }
	    public void btn_ImportProduct() {
	    	DefaultTableModel model_table = (DefaultTableModel) table_Imports.getModel();
	    	if(model_table == null) {
	    		JOptionPane.showMessageDialog(this, "There are no products in the table");
	    	} else {
	    		int check = JOptionPane.showConfirmDialog(this, "are you sure??", "yes", JOptionPane.YES_NO_OPTION);
	    		if(check == JOptionPane.YES_NO_OPTION) {
	    			long now = System.currentTimeMillis();
	    			Timestamp sqlTimeTamp = new Timestamp(now);
	    			String Creator = (String) Combo_Creator.getSelectedItem();
	    			ImportsForm IM = new ImportsForm(arrNcc.get(Combo_Supplier.getSelectedIndex()).getSupplier_Code(), form_Code, sqlTimeTamp, Creator, Details_Form, total_Amount());
	    			try {
	    				ImportDAO.getInstance().insert(IM);
	    				computerDAO CPTD = computerDAO.getInstance();
	    				for(ite.computer_management.model.Details_Form i : Details_Form) {
	    					Details_ImportDAO.getInstance().insert(i);
	    					CPTD.updateQuantity(i.getComputer_Code(),CPTD.selectById(i.getComputer_Code()).getQuantity() + i.getQuantity());
	    				}
	    				JOptionPane.showMessageDialog(this, "Imports product success");
	    				int res = JOptionPane.showConfirmDialog(this, "do you want export file pdf?", "", JOptionPane.YES_NO_OPTION);
	    					if(res == JOptionPane.YES_OPTION) {
	    						  WirtePDF_File writepdf = new WirtePDF_File();
	    	                      writepdf.writePhieuNhap(form_Code);
	    					}
         					DefaultTableModel r = (DefaultTableModel) table_Imports.getModel();
	    	                r.setRowCount(0);
	    	                text_totalAmount.setText("0");
	    	                this.form_Code = createId(ImportDAO.getInstance().selectAll());
	    	                TF_Form.setText(this.form_Code);
	    	                ImportCouponView view = new ImportCouponView();
	    	                view.displayTable();
	    			} catch (Exception e) {
					
					}    		
	    		}
	    	}
	    }
	    public double total_Amount() {
			  double tt = 0;
		        for (ite.computer_management.model.Details_Form i : Details_Form) {
		            tt += i.getUnit_Price() * i.getQuantity();
		        }
		        return tt;
		}
	    public void displayTable() {
	    	ImportDAO view = new ImportDAO();
	    	view.display(table_Product);
	    }
}