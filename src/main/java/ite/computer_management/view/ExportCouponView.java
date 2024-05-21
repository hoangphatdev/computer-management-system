
package ite.computer_management.view;

import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

import javax.swing.JPanel; 

import java.awt.Color;
import java.awt.Desktop;

import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.SwingConstants;
import javax.swing.RowFilter.Entry;
import javax.swing.border.BevelBorder;
import javax.swing.filechooser.FileNameExtensionFilter;
import javax.swing.table.DefaultTableModel;
import javax.swing.table.TableRowSorter;

import ite.computer_management.controller.ExportsCouponController;

import ite.computer_management.dao.AccountDAO;
import ite.computer_management.dao.Details_ExportDAO;

import ite.computer_management.dao.ExportCouponDAO;
import ite.computer_management.dao.ExportsDAO;


import ite.computer_management.model.Details_Form;
import ite.computer_management.model.ExportForm;

import javax.swing.JScrollPane;
import javax.swing.JTable;

import javax.swing.JTextField;
import javax.swing.RowFilter;
import javax.swing.JButton;
import javax.swing.JFileChooser;

import java.awt.Font;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.text.DecimalFormat;
import java.text.SimpleDateFormat;
import java.util.ArrayList;

import javax.swing.BorderFactory;
import javax.swing.Box;
import javax.swing.ImageIcon;

public class ExportCouponView extends JPanel {
	public static DefaultTableModel model;
	private static final long serialVersionUID = 1L;
	public static JTable table;
	public JTextField searchTxt;
	public Dashboard dashboard;

	public JButton btnExcel;
	public JButton btnUpdate;
	public JButton btndelete;
	DecimalFormat formatter = new DecimalFormat("###,###,###");
    SimpleDateFormat formatDate = new SimpleDateFormat("dd/MM/YYYY HH:mm");
    public JButton btnshowdetail;
    public JButton btnRefresh;
    private ExportCouponView ICF;
    private ArrayList<Details_Form> Details_Form;
    
    
    
    
    public DecimalFormat getFormatter() {
        return formatter;
    }
    public ArrayList<Details_Form> getDetails_Form() {
        return Details_Form;
    }
    public ExportCouponView getICF() {
        return ICF;
    }
    public SimpleDateFormat getFormatDate() {
        return formatDate;
    }
    public String getSelectedFormCode() {
        int selectedRow = table.getSelectedRow();
        if (selectedRow >= 0) {
     
            return table.getValueAt(selectedRow, 1).toString(); 
        } else {
            return null;
        }
    }
    public ExportCouponView() {
    	
    	init();
    	displayTable();
    	this.ICF = ICF;
    }
    
	public void init() {
		ExportsCouponController exportsCouponController = new ExportsCouponController(this);
		this.setSize(1250,800);
		setLayout(null);
		setBackground(new Color(72, 61, 139));
		JScrollPane scrollPane = new JScrollPane(JScrollPane.VERTICAL_SCROLLBAR_ALWAYS, JScrollPane.HORIZONTAL_SCROLLBAR_ALWAYS);
		scrollPane.setBounds(36, 243, 1163, 466);
		add(scrollPane);
		//create table and fetch data from database
		table = new JTable();
		table.setModel(new DefaultTableModel(
			new Object[][] {
			},
			new String[] {
				"Number", "Form code", "Creator", "Time", "Total amount"
			}
		));

		ExportCouponDAO exportCouponDAO = new ExportCouponDAO(this);
		exportCouponDAO.selectAll();
		scrollPane.setViewportView(table);

		scrollPane.setViewportView(table);
		searchTxt = new JTextField();
		searchTxt.addKeyListener(exportsCouponController);
		searchTxt.setBounds(792, 54, 385, 40);
		add(searchTxt);
		searchTxt.setColumns(10);
		
		JLabel searchLbl = new JLabel("Search:");
		searchLbl.setForeground(new Color(255, 255, 255));
		searchLbl.setFont(new Font("Dialog", Font.BOLD, 17));
		searchLbl.setBounds(793, 10, 134, 48);
		add(searchLbl);
		
		Box verticalBox = Box.createVerticalBox();
		verticalBox.setBorder(new BevelBorder(BevelBorder.LOWERED, null, null, null, null));
		verticalBox.setBounds(772, 20, 427, 102);
		add(verticalBox);
		
		 btndelete = new JButton("Delete");
		 btndelete.setForeground(Color.WHITE);
		 btndelete.setIcon(new ImageIcon("D:\\JAVA_project\\computer-management-system\\src\\main\\java\\ite\\computer_management\\img\\cancel 30.png"));
		 btndelete.setFont(new Font("Tahoma", Font.BOLD, 17));
		btndelete.setBackground(new Color(51, 0, 102));
		btndelete.setBounds(36, 86, 159, 40);
		add(btndelete);
		btndelete.addMouseListener(exportsCouponController);
		
		 btnUpdate = new JButton("Update");
		 btnUpdate.setForeground(Color.WHITE);
		 btnUpdate.setIcon(new ImageIcon("D:\\JAVA_project\\computer-management-system\\src\\main\\java\\ite\\computer_management\\img\\edit 30.png"));
		 btnUpdate.setFont(new Font("Tahoma", Font.BOLD, 17));
		btnUpdate.setBackground(new Color(51, 0, 102));
		btnUpdate.setBounds(36, 136, 190, 40);
		add(btnUpdate);
		btnUpdate.addMouseListener(exportsCouponController);
		
		btnExcel = new JButton("Export excel");
		btnExcel.setForeground(Color.WHITE);
		btnExcel.setIcon(new ImageIcon("D:\\JAVA_project\\computer-management-system\\src\\main\\java\\ite\\computer_management\\img\\excel 30.png"));
		btnExcel.setFont(new Font("Tahoma", Font.BOLD, 17));
		btnExcel.setBackground(new Color(51, 0, 102));
		btnExcel.setBounds(1018, 193, 181, 40);
		add(btnExcel);
		btnExcel.addMouseListener(exportsCouponController);
		
		JLabel searchLbl_1 = new JLabel("");
		searchLbl_1.setIcon(new ImageIcon("D:\\JAVA_project\\computer-management-system\\src\\main\\java\\ite\\computer_management\\img\\logo2.png"));
		searchLbl_1.setForeground(Color.WHITE);
		searchLbl_1.setFont(new Font("Dialog", Font.BOLD, 17));
		searchLbl_1.setBounds(179, 20, 673, 424);
		add(searchLbl_1);
		
		btnshowdetail = new JButton("display detail");
		btnshowdetail.setIcon(new ImageIcon("D:\\JAVA_project\\computer-management-system\\src\\main\\java\\ite\\computer_management\\img\\detail 20.png"));
		btnshowdetail.setForeground(Color.WHITE);
		btnshowdetail.setFont(new Font("Tahoma", Font.BOLD, 17));
		btnshowdetail.setBackground(new Color(51, 0, 102));
		btnshowdetail.setBounds(36, 186, 223, 40);
		add(btnshowdetail);
		btnshowdetail.addMouseListener(exportsCouponController);
		
		btnRefresh = new JButton("Refresh");
		btnRefresh.setIcon(new ImageIcon("D:\\JAVA_project\\computer-management-system\\src\\main\\java\\ite\\computer_management\\img\\reload 30.png"));
		btnRefresh.setForeground(Color.WHITE);
		btnRefresh.setFont(new Font("Tahoma", Font.BOLD, 17));
		btnRefresh.setBackground(new Color(51, 0, 102));
		btnRefresh.setBounds(837, 193, 159, 40);
		add(btnRefresh);
		btnRefresh.addMouseListener(exportsCouponController);


		
	}
	public void clickDeleteLbl() {
		 if (table.getSelectedRow() == -1) {
	            JOptionPane.showMessageDialog(this, "Please select the row to delete");
	        } else {
	            deletePhieuNhap(getPhieuNhapSelect());
	        }
	}
	public void deletePhieuNhap(ExportForm exportForm) {
	    int result = JOptionPane.showConfirmDialog(this, "are you sure to delete " + exportForm.getForm_Code(), "yes", JOptionPane.YES_NO_OPTION);
	    if (result == JOptionPane.YES_OPTION) {
	        try {  
	            ArrayList<Details_Form> detailsForms = Details_ExportDAO.getInstance().selectAll(exportForm.getForm_Code());
	      
	            for (Details_Form detail : detailsForms) {
	               Details_ExportDAO.getInstance().delete(detail);
	            }     
	            ExportCouponDAO.getInstance().delete(exportForm);       
	            JOptionPane.showMessageDialog(this, "form successfully deleted" + exportForm.getForm_Code());  
	            displayTable();
	        } catch (Exception e) {
	            JOptionPane.showMessageDialog(this, "fail" + e.getMessage());
	            e.printStackTrace();
	        }
	    }
	}


	public void clickSearchBtn() {
		DefaultTableModel model = (DefaultTableModel) table.getModel();

	    TableRowSorter<DefaultTableModel> sorter = new TableRowSorter<>(model);
	    table.setRowSorter(sorter);
	    String searchText = searchTxt.getText();

	    RowFilter<DefaultTableModel, Integer> rowFilter = new RowFilter<DefaultTableModel, Integer>() {
	        public boolean include(Entry<? extends DefaultTableModel, ? extends Integer> entry) {
	            String code = entry.getStringValue(1).toLowerCase(); 
	            return code.contains(searchText.toLowerCase()); 
	        }
	    };
	    sorter.setRowFilter(rowFilter);
	}
	public void clickEditBtn() {
		int check = table.getSelectedRowCount();
		if(check <1) { 
			JOptionPane.showMessageDialog(null, "Please select row to edit >< ");
		}else {
			String selectedFormCode = getSelectedFormCode(); 
			Edit_ExportCouponView view = new Edit_ExportCouponView(this, Details_Form,selectedFormCode);
			view.loadDataToTableProduct(this);
			view.setVisible(true);
		}
	}
	public void btndetail() {
		int check = table.getSelectedRowCount();
		int selectedRowIndex = table.getSelectedRow();
		if(check <1) { 
			JOptionPane.showMessageDialog(null, "Please select row to edit >< ");
		}else {
			DefaultTableModel modell = (DefaultTableModel) table.getModel();
			String selectedFormCode = getSelectedFormCode(); 
			Details_ExportCouponView vieww = new Details_ExportCouponView(this, Details_Form,selectedFormCode);
			vieww.loadDataToTableProduct(this);
			vieww.form_text.setText( (String)modell.getValueAt(selectedRowIndex,1) );
			
			vieww.creator_text.setText( (String)modell.getValueAt(selectedRowIndex,2) );
			vieww.time_text.setText( (String)modell.getValueAt(selectedRowIndex,3) );
			
		}
	}	
	public void displayTable() {
	    try {
	        DefaultTableModel table_model = (DefaultTableModel) table.getModel();
	        ArrayList<ExportForm> allPhieuNhap = ExportCouponDAO.getInstance().selectAll();
	        table_model.setRowCount(0);
	        int stt = 1;
	        Details_Form = new ArrayList<>();
	        for (int i = 0; i < allPhieuNhap.size(); i++) {
	            table_model.addRow(new Object[]{
	                stt++, allPhieuNhap.get(i).getForm_Code(), AccountDAO.getInstance().selectById(allPhieuNhap.get(i).getCreator()).getFullName(), formatDate.format(allPhieuNhap.get(i).getTime_Start()),allPhieuNhap.get(i).getTotal_Amount()
	            });
	            ExportForm selectedExportsForm = ExportsDAO.getInstance().selectById(allPhieuNhap.get(i).getForm_Code());

	      	  
		        Details_Form = Details_ExportDAO.getInstance().selectAll(selectedExportsForm.getForm_Code());
	        }
	      

	        System.out.println("Data loaded successfully!");
	    } catch (Exception e) {
	        System.out.println("Failed to load data: " + e.getMessage());
	        e.printStackTrace();
	    }
	}
    public ExportForm getPhieuNhapSelect() {
    	DefaultTableModel table_model = (DefaultTableModel) table.getModel();
        int i_row = table.getSelectedRow();
        ExportForm pn = ExportsDAO.getInstance().selectById(table_model.getValueAt(i_row, 1).toString());
        return pn;
    }
    
    public void clickExportExcel() {
	    try {
	        JFileChooser fileChooser = new JFileChooser();
	        fileChooser.setFileFilter(new FileNameExtensionFilter("Excel Files", "xlsx"));
	        int option = fileChooser.showSaveDialog(this);

	        if (option == JFileChooser.APPROVE_OPTION) {
	            File saveFile = fileChooser.getSelectedFile();
	            if (!saveFile.toString().endsWith(".xlsx")) {  
	                saveFile = new File(saveFile.toString() + ".xlsx");
	            }
	            Workbook workbook = new XSSFWorkbook();
	            Sheet sheet = workbook.createSheet("Export Coupons");    
	            Row headerRow = sheet.createRow(0);
	            for (int i = 0; i < table.getColumnCount(); i++) {
	                Cell cell = headerRow.createCell(i);
	                cell.setCellValue(table.getColumnName(i));
	            }
	            for (int j = 0; j < table.getRowCount(); j++) {
	                Row row = sheet.createRow(j + 1);
	                for (int k = 0; k < table.getColumnCount(); k++) {
	                    Cell cell = row.createCell(k);
	                    Object value = table.getValueAt(j, k);
	                    if (value != null) {
	                        if (value instanceof Number) {
	                            cell.setCellValue(((Number) value).doubleValue()); 
	                        } else {
	                            cell.setCellValue(value.toString()); 
	                        }
	                    }
	                }
	            }
	            try (FileOutputStream out = new FileOutputStream(saveFile)) {
	                workbook.write(out);
	            }
	            JOptionPane.showMessageDialog(this, "successfull", "Notification", JOptionPane.INFORMATION_MESSAGE);
	            if (Desktop.isDesktopSupported()) {
	                Desktop.getDesktop().open(saveFile);
	            }
	        }
	    } catch (FileNotFoundException e) {
	        JOptionPane.showMessageDialog(this, "not found" + e.getMessage(), "error", JOptionPane.ERROR_MESSAGE);
	    } catch (IOException e) {
	        JOptionPane.showMessageDialog(this, "fail" + e.getMessage(), "error", JOptionPane.ERROR_MESSAGE);
	    }
	}
}
