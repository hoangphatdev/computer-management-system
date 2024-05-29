package ite.computer_management.view;

import java.awt.Color;
import java.awt.EventQueue;
import java.awt.Font;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.math.BigDecimal;
import java.text.DecimalFormat;
import java.util.ArrayList;
import java.util.List;

import javax.swing.Box;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JComponent;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.JTextField;
import javax.swing.border.BevelBorder;
import javax.swing.border.EmptyBorder;
import javax.swing.table.DefaultTableModel;

import com.itextpdf.text.DocumentException;

import ite.computer_management.controller.Details_ExportsCouponController;
import ite.computer_management.controller.Details_ImportsCouponController;
import ite.computer_management.controller.Imports_productController;
import ite.computer_management.controller.WirtePDF_File;
import ite.computer_management.dao.Details_ExportDAO;

import ite.computer_management.dao.ImportDAO;
import ite.computer_management.dao.computerDAO;
import ite.computer_management.model.Details_Form;
import ite.computer_management.model.ExportForm;


public class Details_ExportCouponView extends JFrame {

	private static final long serialVersionUID = 1L;
	private JPanel contentPane;
	public JTable table_Exports;

	private JLabel lblQuantity_1;
	public JButton btn_cancel;
	public JButton btnExportFdf;
	private DefaultTableModel model;
	private String form_Code;
	private ArrayList<Details_Form> Details_Form;
	 private ExportCouponView ECF;
	 public ExportForm exportform;
	 public JLabel form_text;
	 public JLabel creator_text;
	public JLabel time_text;
	public ExportCouponView getECF() {
        return ECF;
    }
	   public ArrayList<Details_Form> getDetails_Form() {
	        return Details_Form;
	    }
	/**
	 * Create the frame.
	 */

	public Details_ExportCouponView(ExportCouponView ECF, ArrayList<Details_Form> Details_Form, String form_code) {
		init();
		this.form_Code = form_code;
		loadDataToTableProduct(ECF);	
		this.ECF = (ExportCouponView) ECF;
		this.exportform = this.ECF.getPhieuNhapSelect();
		this.Details_Form = Details_ExportDAO.getInstance().selectAll(exportform.getForm_Code());

	}
	public void init() {
		getContentPane().setBackground(new Color(70, 163, 100));
		Details_ExportsCouponController details_ExportsCouponController = new Details_ExportsCouponController(this);
		
		this.setSize(875,587);
		getContentPane().setLayout(null);
		
		JLabel lblFrom = new JLabel("Form code:");
		lblFrom.setForeground(Color.WHITE);
		lblFrom.setFont(new Font("Tahoma", Font.BOLD, 14));
		lblFrom.setBounds(33, 74, 90, 13);
		getContentPane().add(lblFrom);
		
		JLabel lblCreator = new JLabel("Creator:");
		lblCreator.setForeground(Color.WHITE);
		lblCreator.setFont(new Font("Tahoma", Font.BOLD, 14));
		lblCreator.setBounds(496, 74, 90, 13);
		getContentPane().add(lblCreator);
		
		table_Exports = new JTable();
		table_Exports.setModel(new DefaultTableModel(
			new Object[][] {
			},
			new String[] {
				"Number", "Code ", "Name", "Quantity", "Price"
			}
		));
		table_Exports.getColumnModel().getColumn(0).setPreferredWidth(50);
		table_Exports.getColumnModel().getColumn(1).setPreferredWidth(57);
		table_Exports.getColumnModel().getColumn(2).setPreferredWidth(185);
		table_Exports.getColumnModel().getColumn(3).setPreferredWidth(50);
		table_Exports.getColumnModel().getColumn(4).setPreferredWidth(37);
		table_Exports.setBounds(553, 203, 1, 1);
		getContentPane().add(table_Exports);
		
		JScrollPane scrollPane_1 = new JScrollPane(table_Exports);
		scrollPane_1.setBounds(23, 149, 828, 311);
		getContentPane().add(scrollPane_1);
		
		JLabel lblTotalAmount = new JLabel("Total amount:");
		lblTotalAmount.setForeground(Color.WHITE);
		lblTotalAmount.setFont(new Font("Tahoma", Font.BOLD, 22));
		lblTotalAmount.setBounds(33, 470, 181, 28);
		getContentPane().add(lblTotalAmount);
		
		lblQuantity_1 = new JLabel("0Đ");
		lblQuantity_1.setForeground(Color.RED);
		lblQuantity_1.setFont(new Font("Tahoma", Font.BOLD, 20));
		lblQuantity_1.setBounds(192, 465, 341, 41);
		getContentPane().add(lblQuantity_1);
		
		JLabel lblD = new JLabel("Detail Export coupon");
		lblD.setBackground(new Color(0, 0, 51));
		lblD.setForeground(Color.WHITE);
		lblD.setFont(new Font("Stencil", Font.BOLD, 25));
		lblD.setBounds(0, 0, 861, 65);
		getContentPane().add(lblD);
		
		JLabel lblTime = new JLabel("Time:");
		lblTime.setForeground(Color.WHITE);
		lblTime.setFont(new Font("Tahoma", Font.BOLD, 14));
		lblTime.setBounds(496, 116, 90, 13);
		getContentPane().add(lblTime);
		
		 btn_cancel = new JButton("Cancel");
		btn_cancel.setBackground(Color.RED);
		btn_cancel.setForeground(Color.BLACK);
		btn_cancel.setFont(new Font("Tahoma", Font.BOLD, 17));
		btn_cancel.setBounds(526, 482, 157, 41);
		getContentPane().add(btn_cancel);
		btn_cancel.addMouseListener(details_ExportsCouponController);
		
		 btnExportFdf = new JButton("Export PDF");
		btnExportFdf.setForeground(Color.WHITE);
		btnExportFdf.setBackground(Color.DARK_GRAY);
		btnExportFdf.setFont(new Font("Tahoma", Font.BOLD, 17));
		btnExportFdf.setBounds(694, 482, 157, 41);
		getContentPane().add(btnExportFdf);
		
		 form_text = new JLabel("3");
		form_text.setForeground(Color.YELLOW);
		form_text.setFont(new Font("Tahoma", Font.BOLD, 14));
		form_text.setBounds(124, 74, 239, 13);
		getContentPane().add(form_text);
		
		 creator_text = new JLabel("3");
		creator_text.setForeground(Color.YELLOW);
		creator_text.setFont(new Font("Tahoma", Font.BOLD, 14));
		creator_text.setBounds(565, 74, 239, 13);
		getContentPane().add(creator_text);
		
		 time_text = new JLabel("3");
		time_text.setForeground(Color.YELLOW);
		time_text.setFont(new Font("Tahoma", Font.BOLD, 14));
		time_text.setBounds(565, 116, 239, 13);
		getContentPane().add(time_text);
		btnExportFdf.addMouseListener(details_ExportsCouponController);
		this.setLocationRelativeTo(null);
		this.setVisible(true);
	}

	public void cancel() {
		dispose();
	}

	public void export_PDF() throws DocumentException {
		 WirtePDF_File writepdf = new WirtePDF_File();
         writepdf.writeExportCoupon(form_Code);
	}
	public void loadDataToTableProduct(ExportCouponView ECF) {
   	 try {
	            ArrayList<Details_Form> CTPhieu = Details_ExportDAO.getInstance().selectAll(ECF.getPhieuNhapSelect().getForm_Code().toString());
	            DefaultTableModel table_model = (DefaultTableModel) table_Exports.getModel();
	            table_model.setRowCount(0);
	            int stt=1;
	            for (int i = 0; i < CTPhieu.size(); i++) {  
	                table_model.addRow(new Object[]{
	                    stt++, 
	                    CTPhieu.get(i).getComputer_Code(),
	                    computerDAO.getInstance().selectById(CTPhieu.get(i).getComputer_Code()).getComputerName(),
	                    CTPhieu.get(i).getQuantity(),
	                    ECF.getFormatter().format(CTPhieu.get(i).getUnit_Price()),
	                });
	            }
	            this.Details_Form = CTPhieu; 
	            updateTotalAmount();
	        } catch (Exception e) {
	        	 System.out.println("Failed to load data: " + e.getMessage());
	 	        e.printStackTrace();
	        }
   }
	public void updateTotalAmount() {
	    DefaultTableModel modelExports = (DefaultTableModel) table_Exports.getModel();
	    BigDecimal totalAmount = BigDecimal.ZERO;
	    DecimalFormat formatter = new DecimalFormat("###,###,###");

	    for (int i = 0; i < modelExports.getRowCount(); i++) {
	        try {
	            String priceStr = modelExports.getValueAt(i, 4).toString().replace(",", "");
	            double price = Double.parseDouble(priceStr);
	            int quantity = Integer.parseInt(modelExports.getValueAt(i, 3).toString());
	            BigDecimal totalPrice = BigDecimal.valueOf(price * quantity);    
	            totalAmount = totalAmount.add(totalPrice);
	        } catch (NumberFormatException e) {

	            e.printStackTrace();
	            JOptionPane.showMessageDialog(null, "fail");
	        }
	    }

	    lblQuantity_1.setText(formatter.format(totalAmount) + "Đ");
	}
}
