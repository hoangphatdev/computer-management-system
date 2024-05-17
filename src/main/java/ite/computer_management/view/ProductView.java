
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
import javax.swing.table.DefaultTableModel;
import javax.swing.table.TableRowSorter;
import ite.computer_management.controller.ProductController;
import ite.computer_management.dao.ImportDAO;
import ite.computer_management.dao.ProductDAO;
import ite.computer_management.model.Computer;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.RowFilter;
import javax.swing.JTextField;
import javax.swing.JButton;
import javax.swing.JComponent;
import javax.swing.JFileChooser;
import java.awt.Font;
import java.awt.print.PageFormat;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import javax.swing.BorderFactory;
import javax.swing.ImageIcon;
import java.awt.Component;
import javax.swing.Box;
import javax.swing.border.BevelBorder;
public class ProductView extends JPanel {
	public static DefaultTableModel model;
	private static final long serialVersionUID = 1L;
	public static JTable table;
	public JTextField searchTxt;
	public Dashboard dashboard;
	public JButton btnExcel;
	public JButton btnadd;
	public JButton btnUpdate;
	public JButton btndelete;
	
	public ProductView(Dashboard dashboard) {
		setBackground(new Color(72, 61, 139));
		this.dashboard = dashboard;
		ProductController productController = new ProductController(this);
		this.setSize(1250,800);
		setLayout(null);


		JScrollPane scrollPane = new JScrollPane(JScrollPane.VERTICAL_SCROLLBAR_ALWAYS, JScrollPane.HORIZONTAL_SCROLLBAR_ALWAYS);
		scrollPane.setBounds(-223, 243, 1163, 531);
		scrollPane.setBounds(36, 243, 1163, 466);
		add(scrollPane);
		//create table and fetch data from database
		table = new JTable();
		model = (DefaultTableModel) table.getModel();
		ProductDAO productDAO = new ProductDAO(this);
		productDAO.selectAll();
		scrollPane.setViewportView(table);
		
		searchTxt = new JTextField();
		searchTxt.addKeyListener(productController);
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
		
		btnadd = new JButton("Add");
		btnadd.setForeground(Color.WHITE);
		btnadd.setIcon(new ImageIcon("D:\\JAVA_project\\computer-management-system\\src\\main\\java\\ite\\computer_management\\img\\add 25.png"));
		btnadd.setFont(new Font("Tahoma", Font.BOLD, 17));
		btnadd.setBackground(new Color(51, 0, 102));
		btnadd.setBounds(36, 50, 120, 40);
		add(btnadd);
		btnadd.addMouseListener(productController);
		
		 btndelete = new JButton("Delete");
		 btndelete.setForeground(Color.WHITE);
		 btndelete.setIcon(new ImageIcon("D:\\JAVA_project\\computer-management-system\\src\\main\\java\\ite\\computer_management\\img\\cancel 30.png"));
		 btndelete.setFont(new Font("Tahoma", Font.BOLD, 17));
		btndelete.setBackground(new Color(51, 0, 102));
		btndelete.setBounds(36, 100, 159, 40);
		add(btndelete);
		btndelete.addMouseListener(productController);
		
		 btnUpdate = new JButton("Update");
		 btnUpdate.setForeground(Color.WHITE);
		 btnUpdate.setIcon(new ImageIcon("D:\\JAVA_project\\computer-management-system\\src\\main\\java\\ite\\computer_management\\img\\edit 30.png"));
		 btnUpdate.setFont(new Font("Tahoma", Font.BOLD, 17));
		btnUpdate.setBackground(new Color(51, 0, 102));
		btnUpdate.setBounds(36, 153, 190, 40);
		add(btnUpdate);
		btnUpdate.addMouseListener(productController);
		
		btnExcel = new JButton("Export excel");
		btnExcel.setForeground(Color.WHITE);
		btnExcel.setIcon(new ImageIcon("D:\\JAVA_project\\computer-management-system\\src\\main\\java\\ite\\computer_management\\img\\excel 30.png"));
		btnExcel.setFont(new Font("Tahoma", Font.BOLD, 17));
		btnExcel.setBackground(new Color(51, 0, 102));
		btnExcel.setBounds(1018, 193, 181, 40);
		add(btnExcel);
		
		JLabel searchLbl_1 = new JLabel("");
		searchLbl_1.setIcon(new ImageIcon("D:\\JAVA_project\\computer-management-system\\src\\main\\java\\ite\\computer_management\\img\\logo2.png"));
		searchLbl_1.setForeground(Color.WHITE);
		searchLbl_1.setFont(new Font("Dialog", Font.BOLD, 17));
		searchLbl_1.setBounds(373, 10, 673, 424);
		add(searchLbl_1);
		btnExcel.addMouseListener(productController);

	}
	public void clickAddLbl() {
		new AddProductView(this, dashboard);
		ImportDAO view = new ImportDAO();
	}
	public void clickDeleteLbl() {
		int check = table.getSelectedRowCount();
		int selectedRow = table.getSelectedRow();
		
		if(check <1) {
			JOptionPane.showMessageDialog(null, "Please select row to delete.");
		}else {
			int confirm = JOptionPane.showConfirmDialog(null, "Are you sure?"); // yes:0, no:1
			if(confirm == 0) {
				String computerCode =  model.getValueAt(selectedRow, 1).toString(); // index cua gelValuAt bat dau tu 0
				String computerName = model.getValueAt(selectedRow,0).toString();
				Computer deleteProduct = new Computer();
				deleteProduct.setComputerCode(computerCode);
				int result = ProductDAO.getInstance().delete(deleteProduct);
				System.out.println(result);
				if(result == 1) {
					model.removeRow(selectedRow);
				}
			}
			
		}
	}
	public void clickSearchBtn() {
		DefaultTableModel demo = (DefaultTableModel) table.getModel();
		TableRowSorter<DefaultTableModel> trs = new TableRowSorter<>(demo);
		table.setRowSorter(trs);
		trs.setRowFilter(RowFilter.regexFilter(searchTxt.getText()));
	}
//	public void openFile(String file) {
//		try {
//			File path = new File(file);
//			Desktop.getDesktop().open(path);
//		} catch (IOException e) {
//			JOptionPane.showMessageDialog(null,"Error: " + e);
//		}
//		
//	}
	public void clickExportExcel() {
			try {
				JFileChooser jFileChooser = new JFileChooser();
				jFileChooser.showSaveDialog(this);
				File saveFile = jFileChooser.getSelectedFile();
				
				if(saveFile != null) {
					saveFile = new File(saveFile.toString() + ".xlsx");
					Workbook wb = new XSSFWorkbook();
					Sheet sheet = wb.createSheet("product");
					
					Row rowCol = sheet.createRow(0);
					for(int i=0; i<table.getColumnCount(); i++) {
						Cell cell = rowCol.createCell(i);
						cell.setCellValue(table.getColumnName(i));
					}
					for(int j=0; j<table.getRowCount(); j++) {
						Row row = sheet.createRow(j);
						for(int k=0; k<table.getColumnCount(); k++) {
							Cell cell = row.createCell(k);
							if(table.getValueAt(j, k) != null) {
								cell.setCellValue(table.getValueAt(j, k).toString());
							}
						}
					}
					FileOutputStream out = new FileOutputStream(new File(saveFile.toString()));
					wb.write(out);
					wb.close();
					out.close();
					}
				JOptionPane.showMessageDialog(null, "Export successfully ><");
//				JOptionPane.showMessageDialog(null, "Export successfully ><");
				}catch(FileNotFoundException e) {
					JOptionPane.showMessageDialog(null, e);
				}catch(IOException e) {
					JOptionPane.showMessageDialog(null, e);
				}
    }
	public void clickEditBtn() {
		int check = table.getSelectedRowCount();
		int selectedRowIndex = table.getSelectedRow();
		if(check <1) { 
			JOptionPane.showMessageDialog(null, "Please select row to edit >< ");
		}else {
			EditProductView editProductView = new EditProductView(this, dashboard);
			editProductView.computerNameTxt.setText( (String)model.getValueAt(selectedRowIndex,0) );
			editProductView.computerCodeTxt.setText( (String)model.getValueAt(selectedRowIndex, 1) );
			editProductView.quantityTxt.setText( (String)model.getValueAt(selectedRowIndex, 2) );
			editProductView.cpuTxt.setText( (String)model.getValueAt(selectedRowIndex, 3) );
			editProductView.ramTxt.setText( (String)model.getValueAt(selectedRowIndex, 4) );
			editProductView.screenCardTxt.setText( (String)model.getValueAt(selectedRowIndex, 5) );
			editProductView.priceTxt.setText( (String)model.getValueAt(selectedRowIndex, 6) );
			editProductView.sourceCapacityTxt.setText( (String)model.getValueAt(selectedRowIndex, 7) );
			editProductView.machineTypeTxt.setText( (String)model.getValueAt(selectedRowIndex, 8) );
			editProductView.romTxt.setText( (String)model.getValueAt(selectedRowIndex, 9) );
			editProductView.screenSizeTxt.setText( (String)model.getValueAt(selectedRowIndex, 10) );
			editProductView.batteryCapacityTxt.setText( (String)model.getValueAt( selectedRowIndex, 11 ) );
			editProductView.originTxt.setText( (String)model.getValueAt(selectedRowIndex, 12) );
			
		}
		
	}
}