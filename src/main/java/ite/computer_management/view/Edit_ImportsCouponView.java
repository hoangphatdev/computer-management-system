
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
import java.math.BigDecimal;
import java.sql.Connection;
import java.text.DecimalFormat;
import java.util.ArrayList;
import java.util.List;
import java.util.Random;

import javax.swing.JButton;
import javax.swing.Box;
import java.awt.Component;
import javax.swing.border.BevelBorder;
import javax.swing.JTable;
import javax.swing.JScrollPane;
import javax.swing.table.DefaultTableModel;

import java.sql.Timestamp;

import ite.computer_management.controller.Edit_ImportsCoupon_Controller;
import ite.computer_management.controller.Imports_productController;
import ite.computer_management.controller.WirtePDF_File;
import ite.computer_management.dao.Details_ImportDAO;
import ite.computer_management.dao.ImportCouponDAO;
import ite.computer_management.dao.ImportDAO;
import ite.computer_management.dao.SupplierDAO;
import ite.computer_management.dao.computerDAO;
import ite.computer_management.database.ConnectDatabase;
import ite.computer_management.model.Computer;
import ite.computer_management.model.Details_Form;
import ite.computer_management.model.ImportsForm;
import ite.computer_management.model.Supplier;
import lombok.var;

import javax.swing.JComboBox;
import javax.swing.JFrame;

import java.awt.Color;
import java.awt.SystemColor;
import javax.swing.ImageIcon;

public class Edit_ImportsCouponView extends JFrame {

	private static final long serialVersionUID = 1L;
	public JTextField TF_Sreach;
	public JTextField TF_Form;
	public JTable table_Product;
	public JTable table_Imports;
	public JTextField TF_Quantity;
	private JLabel text_totalAmount;
	public JButton btn_DeleteProduct;
	private ImportCouponDAO ImportCouponDAO;
	private ImportDAO Imports_DAO;
	private JLabel bgLbl;
	public JButton btn_accept;
	
	DecimalFormat formatter = new DecimalFormat("###,###,###");
	private JComboBox Combo_Supplier;
	private String form_Code;
	private JComboBox Combo_Creator;
	private static final ArrayList<Supplier> arrNcc = SupplierDAO.getInstance().selectAll();
	private ArrayList<Details_Form> Details_Form;
	public JButton btn_ImportsProduct;
	private ImportCouponView ICF;
	public JButton btn_back;

	/**
	 * Launch the application.
	 * @param dashboard 
	 * @param importCouponView 
	 * @param ICF 
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
	
	
	public Edit_ImportsCouponView(ImportCouponView ICF) {
		init();
		this.setVisible(true);
		Details_Form = new ArrayList<Details_Form>();
		form_Code = createId(Imports_DAO.getInstance().selectAll());
		TF_Form.setText(form_Code);
		
		bgLbl = new JLabel("");
		bgLbl.setBounds(0, -13, 1250, 817);
		bgLbl.setBackground(new Color(224, 218, 218));
		bgLbl.setBackground(new Color(191, 186, 166));
		bgLbl.setOpaque(true);
		getContentPane().add(bgLbl);
		loadDataToTableProduct(ICF);
		this.ICF = ICF;
	}
	public void init() {
		ImportCouponDAO = new ImportCouponDAO();
		Edit_ImportsCoupon_Controller edit_ImportsCoupon_Controller = new Edit_ImportsCoupon_Controller(this);
		Imports_DAO = new ImportDAO();
		
		this.setSize(1250,800);
		getContentPane().setLayout(null);

		TF_Sreach = new JTextField();
		TF_Sreach.setBounds(37, 49, 282, 28);
		getContentPane().add(TF_Sreach);
		TF_Sreach.setColumns(10);
		
		btn_back = new JButton("Back");
		btn_back.setForeground(Color.BLACK);
		btn_back.setFont(new Font("Tahoma", Font.PLAIN, 15));
		btn_back.setBackground(Color.LIGHT_GRAY);
		btn_back.setBounds(882, 682, 160, 41);
		getContentPane().add(btn_back);
		btn_back.addMouseListener(edit_ImportsCoupon_Controller);
		
		JLabel lblNewLabel = new JLabel("Sreach:");
		lblNewLabel.setForeground(Color.BLACK);
		lblNewLabel.setFont(new Font("Tahoma", Font.BOLD, 16));
		lblNewLabel.setBounds(37, 26, 90, 13);
		getContentPane().add(lblNewLabel);
		
		Box verticalBox = Box.createVerticalBox();
		verticalBox.setBackground(SystemColor.inactiveCaptionText);
		verticalBox.setBorder(new BevelBorder(BevelBorder.LOWERED, null, null, null, null));
		verticalBox.setBounds(22, 10, 317, 87);
		getContentPane().add(verticalBox);
		
		JLabel lblFrom = new JLabel("Form:");
		lblFrom.setForeground(Color.BLACK);
		lblFrom.setFont(new Font("Tahoma", Font.BOLD, 14));
		lblFrom.setBounds(518, 26, 90, 13);
		getContentPane().add(lblFrom);
		
		JLabel lblSupplier = new JLabel("Supplier:");
		lblSupplier.setForeground(Color.BLACK);
		lblSupplier.setFont(new Font("Tahoma", Font.BOLD, 14));
		lblSupplier.setBounds(518, 75, 90, 13);
		getContentPane().add(lblSupplier);
		
		JLabel lblCreator = new JLabel("Creator:");
		lblCreator.setForeground(Color.BLACK);
		lblCreator.setFont(new Font("Tahoma", Font.BOLD, 14));
		lblCreator.setBounds(518, 114, 90, 13);
		getContentPane().add(lblCreator);
		
		TF_Form = new JTextField();
		TF_Form.setColumns(10);
		TF_Form.setBounds(600, 26, 349, 28);
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
		scrollPane.setBounds(22, 107, 452, 571);
		getContentPane().add(scrollPane);
		
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
		getContentPane().add(table_Imports);
		
		JScrollPane scrollPane_1 = new JScrollPane(table_Imports);
		scrollPane_1.setBounds(512, 176, 700, 478);
		getContentPane().add(scrollPane_1);
		
		 Combo_Supplier = new JComboBox();
		Combo_Supplier.setBounds(600, 69, 349, 28);
		getContentPane().add(Combo_Supplier);
		
		JLabel lblQuantity = new JLabel("Quantity:");
		lblQuantity.setForeground(SystemColor.inactiveCaptionText);
		lblQuantity.setFont(new Font("Tahoma", Font.BOLD, 16));
		lblQuantity.setBounds(26, 710, 90, 13);
		getContentPane().add(lblQuantity);
		
		TF_Quantity = new JTextField();
		TF_Quantity.setColumns(10);
		TF_Quantity.setBounds(111, 705, 125, 28);
		getContentPane().add(TF_Quantity);
		
		btn_accept = new JButton("Accept");
		btn_accept.setBackground(Color.LIGHT_GRAY);
		btn_accept.setForeground(new Color(0, 0, 0));
		btn_accept.setFont(new Font("Tahoma", Font.PLAIN, 15));
		btn_accept.setBounds(246, 702, 85, 28);
		getContentPane().add(btn_accept);
		btn_accept.addMouseListener(edit_ImportsCoupon_Controller);
		
		JButton btn_Excel = new JButton("Excel");
		btn_Excel.setIcon(new ImageIcon("D:\\JAVA_project\\computer-management-system\\src\\main\\java\\ite\\computer_management\\img\\excel 30.png"));
		btn_Excel.setBackground(Color.LIGHT_GRAY);
		btn_Excel.setForeground(new Color(0, 0, 0));
		btn_Excel.setFont(new Font("Tahoma", Font.PLAIN, 15));
		btn_Excel.setBounds(1024, 26, 188, 28);
		getContentPane().add(btn_Excel);
		
		JButton btn_ChangeQuantity = new JButton("Change quantity");
		btn_ChangeQuantity.setIcon(new ImageIcon("D:\\JAVA_project\\computer-management-system\\src\\main\\java\\ite\\computer_management\\img\\reload 20.png"));
		btn_ChangeQuantity.setBackground(Color.LIGHT_GRAY);
		btn_ChangeQuantity.setForeground(new Color(0, 0, 0));
		btn_ChangeQuantity.setFont(new Font("Tahoma", Font.PLAIN, 15));
		btn_ChangeQuantity.setBounds(1024, 67, 188, 28);
		getContentPane().add(btn_ChangeQuantity);
		
		 btn_DeleteProduct = new JButton("Delete product");
		 btn_DeleteProduct.setIcon(new ImageIcon("D:\\JAVA_project\\computer-management-system\\src\\main\\java\\ite\\computer_management\\img\\delete 30.png"));
		btn_DeleteProduct.setBackground(Color.LIGHT_GRAY);
		btn_DeleteProduct.setForeground(new Color(0, 0, 0));
		btn_DeleteProduct.setFont(new Font("Tahoma", Font.PLAIN, 15));
		btn_DeleteProduct.setBounds(1024, 106, 188, 28);
		getContentPane().add(btn_DeleteProduct);
		btn_DeleteProduct.addMouseListener(edit_ImportsCoupon_Controller);
		
		JLabel lblTotalAmount = new JLabel("Total amount:");
		lblTotalAmount.setForeground(Color.BLACK);
		lblTotalAmount.setFont(new Font("Tahoma", Font.BOLD, 22));
		lblTotalAmount.setBounds(518, 664, 181, 28);
		getContentPane().add(lblTotalAmount);
		
		text_totalAmount = new JLabel("0Đ");
		text_totalAmount.setForeground(Color.RED);
		text_totalAmount.setFont(new Font("Tahoma", Font.BOLD, 25));
		text_totalAmount.setBounds(697, 657, 341, 41);
		getContentPane().add(text_totalAmount);
		
		btn_ImportsProduct = new JButton("Imports product");
		btn_ImportsProduct.setBackground(Color.LIGHT_GRAY);
		btn_ImportsProduct.setForeground(new Color(0, 0, 0));
		btn_ImportsProduct.setFont(new Font("Tahoma", Font.PLAIN, 15));
		btn_ImportsProduct.setBounds(1052, 682, 160, 41);
		getContentPane().add(btn_ImportsProduct);
		btn_ImportsProduct.addMouseListener(edit_ImportsCoupon_Controller);
		
		Imports_DAO.display(table_Product);
		
		Combo_Creator = new JComboBox();
		Combo_Creator.setBounds(600, 108, 349, 28);
		getContentPane().add(Combo_Creator);
		
		Box verticalBox_1 = Box.createVerticalBox();
		verticalBox_1.setBorder(new BevelBorder(BevelBorder.LOWERED, null, null, null, null));
		verticalBox_1.setBackground(SystemColor.desktop);
		verticalBox_1.setBounds(512, 10, 461, 146);
		getContentPane().add(verticalBox_1);
		
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
	    BigDecimal totalAmount = BigDecimal.ZERO;
	    DecimalFormat formatter = new DecimalFormat("###,###,###");

	    for (int i = 0; i < modelImports.getRowCount(); i++) {
	        try {
	            // Lấy giá trị từ ô cột 4 (cột chứa giá)
	            String priceStr = modelImports.getValueAt(i, 4).toString().replace(",", "");
	            double price = Double.parseDouble(priceStr);
	            // Lấy giá trị từ ô cột 3 (cột chứa số lượng)
	            int quantity = Integer.parseInt(modelImports.getValueAt(i, 3).toString());
	            // Tính tổng tiền
	            BigDecimal totalPrice = BigDecimal.valueOf(price * quantity);
	            // Cộng tổng tiền vào tổng tổng tiền
	            totalAmount = totalAmount.add(totalPrice);
	        } catch (NumberFormatException e) {
	            // Xử lý ngoại lệ nếu không thể chuyển đổi chuỗi thành số
	            e.printStackTrace();
	            JOptionPane.showMessageDialog(null, "Dữ liệu không hợp lệ!");
	        }
	    }

	    // Hiển thị tổng tiền đã tính được trên giao diện
	    text_totalAmount.setText(formatter.format(totalAmount) + "Đ");
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
	    					ArrayList<Computer> product = computerDAO.getInstance().selectAllExist();
	    					
	    					DefaultTableModel r = (DefaultTableModel) table_Imports.getModel();
	    	                r.setRowCount(0);
	    	                Details_Form = new ArrayList<>();
	    	                text_totalAmount.setText("0");
	    	                this.form_Code = createId(ImportDAO.getInstance().selectAll());
	    	                TF_Form.setText(this.form_Code);
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
	    
	    public void loadDataToTableProduct(ImportCouponView ICF) {
	    	 try {
		            ArrayList<Details_Form> CTPhieu = Details_ImportDAO.getInstance().selectAll(ICF.getPhieuNhapSelect().getForm_Code().toString());
		            DefaultTableModel table_model = (DefaultTableModel) table_Imports.getModel();
		            table_model.setRowCount(0);
		            int stt=1;
		            for (int i = 0; i < CTPhieu.size(); i++) {  
		                table_model.addRow(new Object[]{
		                    stt++, 
		                    CTPhieu.get(i).getComputer_Code(),
		                    computerDAO.getInstance().selectById(CTPhieu.get(i).getComputer_Code()).getComputerName(),
		                    CTPhieu.get(i).getQuantity(),
		                    ICF.getFormatter().format(CTPhieu.get(i).getUnit_Price()),
		                });
		            }
		            updateTotalAmount();
		        } catch (Exception e) {
		        	 System.out.println("Failed to load data: " + e.getMessage());
		 	        e.printStackTrace();
		        }
	    }
	    public void back() {
	    	this.dispose();
	    }
}