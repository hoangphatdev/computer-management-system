
package ite.computer_management.view;

import org.apache.poi.ss.usermodel.Cell;
import javax.swing.DefaultRowSorter;
import javax.swing.RowFilter;
import javax.swing.SortOrder;
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
import javax.swing.filechooser.FileNameExtensionFilter;

public class ProductView extends JPanel {
	public static DefaultTableModel model;
	private static final long serialVersionUID = 1L;
	public static JTable table;
	public JTextField searchTxt;
	public Dashboard dashboard;
	public DashboardForManager dashboardForManager;
	public JButton btnExcel;
	public JButton btnadd;
	public JButton btnUpdate;
	public JButton btndelete;

	/**
	 * @wbp.parser.constructor
	 */
	public ProductView(Dashboard dashboard) {
		this.dashboard = dashboard;
		init();
		this.setVisible(true);

	}

	public ProductView(DashboardForManager dashboardForManager) {
		this.dashboardForManager = dashboardForManager;
		init();
		this.setVisible(true);
	}

	public void init() {
		ProductController productController = new ProductController(this);
		this.setSize(1250, 800);
		setLayout(null);
		JScrollPane scrollPane = new JScrollPane(JScrollPane.VERTICAL_SCROLLBAR_ALWAYS,
				JScrollPane.HORIZONTAL_SCROLLBAR_ALWAYS);
		scrollPane.setBounds(-223, 243, 1163, 531);
		scrollPane.setBounds(36, 243, 1163, 466);
		add(scrollPane);
		// create table and fetch data from database
		table = new JTable();
		model = (DefaultTableModel) table.getModel();
		ProductDAO productDAO = new ProductDAO(this);
		productDAO.selectAll();
		scrollPane.setViewportView(table);

		searchTxt = new JTextField();
		searchTxt.addKeyListener(productController);
		searchTxt.setBounds(792, 73, 385, 40);
		add(searchTxt);
		searchTxt.setColumns(10);

		Box verticalBox = Box.createVerticalBox();
		verticalBox.setBorder(new BevelBorder(BevelBorder.LOWERED, null, null, null, null));
		verticalBox.setBounds(772, 39, 427, 102);
		add(verticalBox);

		JLabel searchLbl = new JLabel("Search:");
		verticalBox.add(searchLbl);
		searchLbl.setForeground(new Color(6, 191, 33));
		searchLbl.setFont(new Font("Dialog", Font.BOLD, 17));

		btnadd = new JButton("Add");
		btnadd.setForeground(new Color(6, 191, 33));
		btnadd.setIcon(new ImageIcon(
				"D:\\JAVA_project\\computer-management-system\\src\\main\\java\\ite\\computer_management\\img\\add 25.png"));
		btnadd.setFont(new Font("Tahoma", Font.BOLD, 17));
		btnadd.setBackground(new Color(171, 214, 177));
		btnadd.setBounds(36, 39, 190, 40);
		add(btnadd);
		btnadd.addMouseListener(productController);

		btndelete = new JButton("Delete");
		btndelete.setForeground(new Color(6, 191, 33));
		btndelete.setIcon(new ImageIcon(
				"D:\\JAVA_project\\computer-management-system\\src\\main\\java\\ite\\computer_management\\img\\cancel 30.png"));
		btndelete.setFont(new Font("Tahoma", Font.BOLD, 17));
		btndelete.setBackground(new Color(171, 214, 177));
		btndelete.setBounds(36, 101, 190, 40);
		add(btndelete);
		btndelete.addMouseListener(productController);

		btnUpdate = new JButton("Update");
		btnUpdate.setForeground(new Color(6, 191, 33));
		btnUpdate.setIcon(new ImageIcon(
				"D:\\JAVA_project\\computer-management-system\\src\\main\\java\\ite\\computer_management\\img\\edit 30.png"));
		btnUpdate.setFont(new Font("Tahoma", Font.BOLD, 17));
		btnUpdate.setBackground(new Color(171, 214, 177));
		btnUpdate.setBounds(36, 166, 190, 40);
		add(btnUpdate);
		btnUpdate.addMouseListener(productController);

		btnExcel = new JButton("Export excel");
		btnExcel.setForeground(new Color(6, 191, 33));
		btnExcel.setIcon(new ImageIcon(
				"D:\\JAVA_project\\computer-management-system\\src\\main\\java\\ite\\computer_management\\img\\excel 30.png"));
		btnExcel.setFont(new Font("Tahoma", Font.BOLD, 17));
		btnExcel.setBackground(new Color(171, 214, 177));
		btnExcel.setBounds(1018, 166, 181, 40);
		add(btnExcel);
		btnExcel.addMouseListener(productController);
	}

	public void clickAddLbl() {
		new AddProductView(this, dashboard);
		ImportDAO view = new ImportDAO();
	}

	public void clickDeleteLbl() {
		int check = table.getSelectedRowCount();
		int selectedRow = table.getSelectedRow();

		if (check < 1) {
			JOptionPane.showMessageDialog(null, "Please select row to delete.");
		} else {
			int confirm = JOptionPane.showConfirmDialog(null, "Are you sure?");
			if (confirm == 0) {
				String computerCode = model.getValueAt(selectedRow, 1).toString();
				String computerName = model.getValueAt(selectedRow, 0).toString();
				Computer deleteProduct = new Computer();
				deleteProduct.setComputerCode(computerCode);
				int result = ProductDAO.getInstance().delete(deleteProduct);
				System.out.println(result);
				if (result == 1) {
					model.removeRow(selectedRow);
				}
			}

		}
	}

	public void clickSearchBtn() {
		DefaultTableModel model = (DefaultTableModel) table.getModel();

		TableRowSorter<DefaultTableModel> sorter = new TableRowSorter<>(model);
		table.setRowSorter(sorter);

		String search = searchTxt.getText();

		RowFilter<DefaultTableModel, Integer> rowfilter = new RowFilter<DefaultTableModel, Integer>() {

			@Override
			public boolean include(Entry<? extends DefaultTableModel, ? extends Integer> entry) {
				String code = entry.getStringValue(1).toLowerCase();

				return code.contains(search.toLowerCase());
			}

		};
		sorter.setRowFilter(rowfilter);
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
				Sheet sheet = workbook.createSheet("Product");
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

	public void clickEditBtn() {
		int check = table.getSelectedRowCount();
		int selectedRowIndex = table.getSelectedRow();
		if (check < 1) {
			JOptionPane.showMessageDialog(null, "Please select row to edit >< ");
		} else {
			EditProductView editProductView = new EditProductView(this, dashboard);
			editProductView.computerNameTxt.setText((String) model.getValueAt(selectedRowIndex, 0));
			editProductView.computerCodeTxt.setText((String) model.getValueAt(selectedRowIndex, 1));
			editProductView.quantityTxt.setText((String) model.getValueAt(selectedRowIndex, 2));
			editProductView.cpuTxt.setText((String) model.getValueAt(selectedRowIndex, 3));
			editProductView.ramTxt.setText((String) model.getValueAt(selectedRowIndex, 4));
			editProductView.screenCardTxt.setText((String) model.getValueAt(selectedRowIndex, 5));
			editProductView.priceTxt.setText((String) model.getValueAt(selectedRowIndex, 6));
			editProductView.sourceCapacityTxt.setText((String) model.getValueAt(selectedRowIndex, 7));
			editProductView.machineTypeTxt.setText((String) model.getValueAt(selectedRowIndex, 8));
			editProductView.romTxt.setText((String) model.getValueAt(selectedRowIndex, 9));
			editProductView.screenSizeTxt.setText((String) model.getValueAt(selectedRowIndex, 10));
			editProductView.batteryCapacityTxt.setText((String) model.getValueAt(selectedRowIndex, 11));
			editProductView.originTxt.setText((String) model.getValueAt(selectedRowIndex, 12));

		}

	}
}