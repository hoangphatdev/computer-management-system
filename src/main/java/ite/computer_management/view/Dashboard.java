
package ite.computer_management.view;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

import chart.Columnchart;
import ite.computer_management.controller.DashboardController;
import ite.computer_management.controller.ProductController;
import ite.computer_management.dao.ImportDAO;
import ite.computer_management.model.Account;
import main.Login;

import java.awt.Color;
import java.awt.Dimension;
import java.awt.EventQueue;
import javax.swing.JLabel;
import javax.swing.JOptionPane;

import java.awt.Window.Type;
import javax.swing.SwingConstants;
import javax.swing.SwingUtilities;

import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import javax.swing.JTabbedPane;
import javax.swing.JTable;
import javax.swing.ImageIcon;
import java.awt.Font;
import java.awt.SystemColor;
import java.awt.Window;
import java.awt.Toolkit;

public class Dashboard extends JFrame {

	private static final long serialVersionUID = 1L;
	private JPanel contentPane;
	public JLabel productNavLbl;
	public JTabbedPane tabbedPane;
	public JLabel accountNavLbl;
	public JLabel myInformationLbl;
	public JLabel logOutNavLbl;
	public JLabel exportCouponNavLbl;
	public JLabel importCouponNavLbl;
	public JLabel exportProductNavLbl;
	public JLabel importProductNavLbl;
	public JLabel supplierNavLbl;

	public JLabel Imports_ProductNavLbl;
	public JLabel Export_ProductNavLbl;
	public JPanel navPanel;
	public JLabel statisticalchart;
	public JLabel Chatlb1;
	public LogInView loginview;
	Account accountReturn;

	public Dashboard(Account accountReturn) {
		setIconImage(Toolkit.getDefaultToolkit().getImage("D:\\JAVA_project\\computer-management-system\\src\\main\\java\\ite\\computer_management\\img\\lgo.png"));
		this.accountReturn = accountReturn;
		init();
		this.setLocationRelativeTo(null);
		this.setVisible(true);
	}

	public void init() {
		Account account = accountReturn;
		DashboardController dashboardController = new DashboardController(this);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		this.setSize(1500, 800);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);

		tabbedPane = new JTabbedPane(JTabbedPane.TOP);
		tabbedPane.setBounds(254, -20, 1250, 800);
		contentPane.add(tabbedPane);

		ProductView productView = new ProductView(this);
		tabbedPane.addTab("Product Management", productView);

		AccountView accountView = new AccountView(this);
		tabbedPane.addTab("Account Mangement", accountView);

		ImportsProductView ImportsProductView = new ImportsProductView(accountReturn);
		ImportsProductView.creator_txt.setText(accountReturn.getFullName());
		tabbedPane.addTab("Imports Product", ImportsProductView);

		ExportProductView ExportProductView = new ExportProductView(accountReturn);
		ExportProductView.creator_txt.setText(accountReturn.getFullName());
		tabbedPane.addTab("Export Product", ExportProductView);
		
		SupplierView supplierView = new SupplierView(this);
		tabbedPane.addTab("Supplier manegement", supplierView);

		ImportCouponView importCouponView = new ImportCouponView();
		tabbedPane.addTab("Import coupon", importCouponView);

		ExportCouponView exportCouponView = new ExportCouponView();
		tabbedPane.addTab("Export coupon", exportCouponView);

		Columnchart chart = new Columnchart(this);
		tabbedPane.addTab("statistical chart", chart);

		navPanel = new JPanel();
		navPanel.setLayout(null);
		navPanel.setBounds(0, 0, 250, 767);
		navPanel.setBackground(new Color(70, 163, 100));
		navPanel.setForeground(new Color(0, 0, 0));
		contentPane.add(navPanel);
		
		String xinchao = "Hello  " + accountReturn.getFullName() +" <3";
		JLabel greetingLbl = new JLabel(xinchao);
		greetingLbl.setFont(new Font("Serif", Font.BOLD | Font.ITALIC, 19));
//		greetingLbl.setIcon(new ImageIcon(
//				"D:\\JAVA_project\\computer-management-system\\src\\main\\java\\ite\\computer_management\\img\\lgo.png"));
		greetingLbl.setHorizontalAlignment(SwingConstants.CENTER);
		greetingLbl.setBounds(0, 0, 250, 158);
		greetingLbl.setOpaque(true);
		greetingLbl.setBackground(new Color(70, 163, 100));
		greetingLbl.setForeground(new Color(219, 219, 219));
		navPanel.add(greetingLbl);

		productNavLbl = new JLabel("Product");
		productNavLbl.setFont(new Font("Lato", Font.BOLD, 15));
		productNavLbl.setIcon(new ImageIcon(Dashboard.class.getResource("/ite/computer_management/img/icons8-product-30.png")));
		productNavLbl.setBounds(1, 157, 250, 45);
		productNavLbl.setBackground(new Color(220, 242, 227));
		productNavLbl.setForeground(new Color(0, 125, 40));
		productNavLbl.setOpaque(true);
		productNavLbl.addMouseListener(dashboardController);
		navPanel.add(productNavLbl);

		supplierNavLbl = new JLabel("Supplier");
		supplierNavLbl.setIcon(new ImageIcon(Dashboard.class.getResource("/ite/computer_management/img/icons8-supplier-30.png")));
		supplierNavLbl.setOpaque(true);
		supplierNavLbl.setFont(new Font("Lato", Font.BOLD, 15));
		supplierNavLbl.setBounds(1, 201, 250, 45);
		supplierNavLbl.addMouseListener(dashboardController);
		supplierNavLbl.setBackground(new Color(70, 163, 100));
		supplierNavLbl.setForeground(new Color(219, 219, 219));
		navPanel.add(supplierNavLbl);
 
		importProductNavLbl = new JLabel("Import Product");
		importProductNavLbl.setIcon(new ImageIcon(Dashboard.class.getResource("/ite/computer_management/img/importProduct-30.png")));
		importProductNavLbl.setOpaque(true);
		importProductNavLbl.setFont(new Font("Lato", Font.BOLD, 15));
		importProductNavLbl.setBounds(1, 244, 250, 45);
		importProductNavLbl.addMouseListener(dashboardController);
		importProductNavLbl.setBackground(new Color(70, 163, 100));
		importProductNavLbl.setForeground(new Color(219, 219, 219));
		navPanel.add(importProductNavLbl);

		exportProductNavLbl = new JLabel("Export Product");
		exportProductNavLbl.setIcon(new ImageIcon(Dashboard.class.getResource("/ite/computer_management/img/exportProductt-30.png")));
		exportProductNavLbl.setOpaque(true);
		exportProductNavLbl.setFont(new Font("Lato", Font.BOLD, 15));
		exportProductNavLbl.setBounds(1, 330, 250, 45);
		exportProductNavLbl.addMouseListener(dashboardController);
		exportProductNavLbl.setBackground(new Color(70, 163, 100));
		exportProductNavLbl.setForeground(new Color(219, 219, 219));
		navPanel.add(exportProductNavLbl);

		importCouponNavLbl = new JLabel("Import Coupon");
		importCouponNavLbl.setIcon(new ImageIcon(Dashboard.class.getResource("/ite/computer_management/img/bill-30.png")));
		importCouponNavLbl.setOpaque(true);
		importCouponNavLbl.setFont(new Font("Lato", Font.BOLD, 15));
		importCouponNavLbl.setBounds(1, 287, 250, 45);
		importCouponNavLbl.addMouseListener(dashboardController);
		importCouponNavLbl.setBackground(new Color(70, 163, 100));
		importCouponNavLbl.setForeground(new Color(219, 219, 219));
		navPanel.add(importCouponNavLbl);

		exportCouponNavLbl = new JLabel("Export Coupon");
		exportCouponNavLbl.setIcon(new ImageIcon(Dashboard.class.getResource("/ite/computer_management/img/bill-30.png")));
		exportCouponNavLbl.setOpaque(true);
		exportCouponNavLbl.setFont(new Font("Lato", Font.BOLD, 15));
		exportCouponNavLbl.setBounds(1, 374, 250, 50);
		exportCouponNavLbl.addMouseListener(dashboardController);
		exportCouponNavLbl.setBackground(new Color(70, 163, 100));
		exportCouponNavLbl.setForeground(new Color(219, 219, 219));
		navPanel.add(exportCouponNavLbl);

		accountNavLbl = new JLabel("Account");
		accountNavLbl.setIcon(new ImageIcon(Dashboard.class.getResource("/ite/computer_management/img/account-30.png")));
		accountNavLbl.setOpaque(true);
		accountNavLbl.setFont(new Font("Lato", Font.BOLD, 15));
		accountNavLbl.setBounds(2, 629, 250, 45);
		accountNavLbl.addMouseListener(dashboardController);
		accountNavLbl.setBackground(new Color(70, 163, 100));
		accountNavLbl.setForeground(new Color(219, 219, 219));
		navPanel.add(accountNavLbl);

		myInformationLbl = new JLabel("My Information");
		myInformationLbl.setIcon(new ImageIcon(DashboardForManager.class.getResource("/ite/computer_management/img/myinfor-30.png")));
		myInformationLbl.setOpaque(true);
		myInformationLbl.setFont(new Font("Lato", Font.BOLD, 15));
		myInformationLbl.setBounds(1, 673, 250, 45);
		myInformationLbl.addMouseListener(dashboardController);
		myInformationLbl.setBackground(new Color(70, 163, 100));
		myInformationLbl.setForeground(new Color(219, 219, 219));
		navPanel.add(myInformationLbl);

		logOutNavLbl = new JLabel("Log out");
		logOutNavLbl.setIcon(new ImageIcon(Dashboard.class.getResource("/ite/computer_management/img/exit30.png")));
		logOutNavLbl.setOpaque(true);
		logOutNavLbl.setFont(new Font("Lato", Font.BOLD, 15));
		logOutNavLbl.setBounds(1, 717, 250, 50);
		logOutNavLbl.addMouseListener(dashboardController);
		logOutNavLbl.setBackground(new Color(70, 163, 100));
		logOutNavLbl.setForeground(new Color(219, 219, 219));
		navPanel.add(logOutNavLbl);

		statisticalchart = new JLabel("Statistical chart");
		statisticalchart.setIcon(new ImageIcon(Dashboard.class.getResource("/ite/computer_management/img/icons8-analysis-30.png")));
		statisticalchart.setOpaque(true);
		statisticalchart.setFont(new Font("Dialog", Font.BOLD, 15));
		statisticalchart.setBounds(1, 425, 250, 50);
		statisticalchart.setBackground(new Color(70, 163, 100));
		statisticalchart.setForeground(new Color(219, 219, 219));
		navPanel.add(statisticalchart);
		statisticalchart.addMouseListener(dashboardController);

		Chatlb1 = new JLabel("Chat");
		Chatlb1.setIcon(new ImageIcon(Dashboard.class.getResource("/ite/computer_management/img/chat.png")));
		Chatlb1.setOpaque(true);
		Chatlb1.setFont(new Font("Dialog", Font.BOLD, 15));
		Chatlb1.setBounds(2, 583, 250, 50);
		Chatlb1.setBackground(new Color(70, 163, 100));
		Chatlb1.setForeground(new Color(219, 219, 219));
		Chatlb1.addMouseListener(dashboardController);
		navPanel.add(Chatlb1);
	}

	public void clickSupplierNav() {
		this.tabbedPane.setSelectedIndex(4);
		supplierNavLbl.setBackground(new Color(220, 242, 227));
		supplierNavLbl.setForeground(new Color(59, 59, 59));

		statisticalchart.setBackground(new Color(70, 163, 100));
		statisticalchart.setForeground(new Color(219, 219, 219));
		productNavLbl.setBackground(new Color(70, 163, 100));
		productNavLbl.setForeground(new Color(219, 219, 219));
		importProductNavLbl.setBackground(new Color(70, 163, 100));
		importProductNavLbl.setForeground(new Color(219, 219, 219));
		importCouponNavLbl.setBackground(new Color(70, 163, 100));
		importCouponNavLbl.setForeground(new Color(219, 219, 219));
		exportProductNavLbl.setBackground(new Color(70, 163, 100));
		exportProductNavLbl.setForeground(new Color(219, 219, 219));
		exportCouponNavLbl.setBackground(new Color(70, 163, 100));
		exportCouponNavLbl.setForeground(new Color(219, 219, 219));
		accountNavLbl.setBackground(new Color(70, 163, 100));
		accountNavLbl.setForeground(new Color(219, 219, 219));
		Chatlb1.setBackground(new Color(70, 163, 100));
		Chatlb1.setForeground(new Color(219, 219, 219));
		myInformationLbl.setBackground( new Color(70, 163, 100));
		myInformationLbl.setForeground(new Color(219, 219, 219));
	}

	public void clickProductNav() {
		this.tabbedPane.setSelectedIndex(0);
		productNavLbl.setBackground(new Color(220, 242, 227));
		productNavLbl.setForeground(new Color(0, 125, 40));

		statisticalchart.setBackground(new Color(70, 163, 100));
		statisticalchart.setForeground(new Color(219, 219, 219));
		supplierNavLbl.setBackground(new Color(70, 163, 100));
		supplierNavLbl.setForeground(new Color(219, 219, 219));
		importProductNavLbl.setBackground(new Color(70, 163, 100));
		importProductNavLbl.setForeground(new Color(219, 219, 219));
		importCouponNavLbl.setBackground(new Color(70, 163, 100));
		importCouponNavLbl.setForeground(new Color(219, 219, 219));
		exportProductNavLbl.setBackground(new Color(70, 163, 100));
		exportProductNavLbl.setForeground(new Color(219, 219, 219));
		exportCouponNavLbl.setBackground(new Color(70, 163, 100));
		exportCouponNavLbl.setForeground(new Color(219, 219, 219));
		accountNavLbl.setBackground(new Color(70, 163, 100));
		accountNavLbl.setForeground(new Color(219, 219, 219));
		Chatlb1.setBackground(new Color(70, 163, 100));
		Chatlb1.setForeground(new Color(219, 219, 219));
		myInformationLbl.setBackground( new Color(70, 163, 100));
		myInformationLbl.setForeground(new Color(219, 219, 219));
	}

	public void clickImportProductNav() {
		importProductNavLbl.setBackground(new Color(220, 242, 227));
		importProductNavLbl.setForeground(new Color(0, 125, 40));
		this.tabbedPane.setSelectedIndex(2);
		
		
		productNavLbl.setBackground(new Color(70, 163, 100));
		productNavLbl.setForeground(new Color(219, 219, 219));
		supplierNavLbl.setBackground(new Color(70, 163, 100));
		supplierNavLbl.setForeground(new Color(219, 219, 219));
		statisticalchart.setBackground(new Color(70, 163, 100));
		statisticalchart.setForeground(new Color(219, 219, 219));
		importCouponNavLbl.setBackground(new Color(70, 163, 100));
		importCouponNavLbl.setForeground(new Color(219, 219, 219));
		exportProductNavLbl.setBackground(new Color(70, 163, 100));
		exportProductNavLbl.setForeground(new Color(219, 219, 219));
		exportCouponNavLbl.setBackground(new Color(70, 163, 100));
		exportCouponNavLbl.setForeground(new Color(219, 219, 219));
		accountNavLbl.setBackground(new Color(70, 163, 100));
		accountNavLbl.setForeground(new Color(219, 219, 219));
		Chatlb1.setBackground(new Color(70, 163, 100));
		Chatlb1.setForeground(new Color(219, 219, 219));
		myInformationLbl.setBackground( new Color(70, 163, 100));
		myInformationLbl.setForeground(new Color(219, 219, 219));
	}

	public void clickImportCouponNav() {
		this.tabbedPane.setSelectedIndex(5);
		importCouponNavLbl.setBackground(new Color(220, 242, 227));
		importCouponNavLbl.setForeground(new Color(0, 125, 40));

		productNavLbl.setBackground(new Color(70, 163, 100));
		productNavLbl.setForeground(new Color(219, 219, 219));
		supplierNavLbl.setBackground(new Color(70, 163, 100));
		supplierNavLbl.setForeground(new Color(219, 219, 219));
		importProductNavLbl.setBackground(new Color(70, 163, 100));
		importProductNavLbl.setForeground(new Color(219, 219, 219));
		statisticalchart.setBackground(new Color(70, 163, 100));
		statisticalchart.setForeground(new Color(219, 219, 219));
		exportProductNavLbl.setBackground(new Color(70, 163, 100));
		exportProductNavLbl.setForeground(new Color(219, 219, 219));
		exportCouponNavLbl.setBackground(new Color(70, 163, 100));
		exportCouponNavLbl.setForeground(new Color(219, 219, 219));
		accountNavLbl.setBackground(new Color(70, 163, 100));
		accountNavLbl.setForeground(new Color(219, 219, 219));
		Chatlb1.setBackground(new Color(70, 163, 100));
		Chatlb1.setForeground(new Color(219, 219, 219));
		myInformationLbl.setBackground( new Color(70, 163, 100));
		myInformationLbl.setForeground(new Color(219, 219, 219));
	}

	public void clickExportProductNav() {
		this.tabbedPane.setSelectedIndex(3);
		exportProductNavLbl.setBackground(new Color(220, 242, 227));
		exportProductNavLbl.setForeground(new Color(0, 125, 40));

		productNavLbl.setBackground(new Color(70, 163, 100));
		productNavLbl.setForeground(new Color(219, 219, 219));
		supplierNavLbl.setBackground(new Color(70, 163, 100));
		supplierNavLbl.setForeground(new Color(219, 219, 219));
		importProductNavLbl.setBackground(new Color(70, 163, 100));
		importProductNavLbl.setForeground(new Color(219, 219, 219));
		importCouponNavLbl.setBackground(new Color(70, 163, 100));
		importCouponNavLbl.setForeground(new Color(219, 219, 219));
		statisticalchart.setBackground(new Color(70, 163, 100));
		statisticalchart.setForeground(new Color(219, 219, 219));
		exportCouponNavLbl.setBackground(new Color(70, 163, 100));
		exportCouponNavLbl.setForeground(new Color(219, 219, 219));
		accountNavLbl.setBackground(new Color(70, 163, 100));
		accountNavLbl.setForeground(new Color(219, 219, 219));
		Chatlb1.setBackground(new Color(70, 163, 100));
		Chatlb1.setForeground(new Color(219, 219, 219));
		myInformationLbl.setBackground( new Color(70, 163, 100));
		myInformationLbl.setForeground(new Color(219, 219, 219));
	}

	public void clickExportCouponNav() {
		this.tabbedPane.setSelectedIndex(6);
		exportCouponNavLbl.setBackground(new Color(220, 242, 227));
		exportCouponNavLbl.setForeground(new Color(0, 125, 40));

		productNavLbl.setBackground(new Color(70, 163, 100));
		productNavLbl.setForeground(new Color(219, 219, 219));
		supplierNavLbl.setBackground(new Color(70, 163, 100));
		supplierNavLbl.setForeground(new Color(219, 219, 219));
		importProductNavLbl.setBackground(new Color(70, 163, 100));
		importProductNavLbl.setForeground(new Color(219, 219, 219));
		importCouponNavLbl.setBackground(new Color(70, 163, 100));
		importCouponNavLbl.setForeground(new Color(219, 219, 219));
		exportProductNavLbl.setBackground(new Color(70, 163, 100));
		exportProductNavLbl.setForeground(new Color(219, 219, 219));
		statisticalchart.setBackground(new Color(70, 163, 100));
		statisticalchart.setForeground(new Color(219, 219, 219));
		accountNavLbl.setBackground(new Color(70, 163, 100));
		accountNavLbl.setForeground(new Color(219, 219, 219));
		Chatlb1.setBackground(new Color(70, 163, 100));
		Chatlb1.setForeground(new Color(219, 219, 219));
		myInformationLbl.setBackground( new Color(70, 163, 100));
		myInformationLbl.setForeground(new Color(219, 219, 219));
	}

	public void clickAccountNav() {
		this.tabbedPane.setSelectedIndex(1);
		accountNavLbl.setBackground(new Color(220, 242, 227));
		accountNavLbl.setForeground(new Color(0, 125, 40));

		productNavLbl.setBackground(new Color(70, 163, 100));
		productNavLbl.setForeground(new Color(219, 219, 219));
		supplierNavLbl.setBackground(new Color(70, 163, 100));
		supplierNavLbl.setForeground(new Color(219, 219, 219));
		importProductNavLbl.setBackground(new Color(70, 163, 100));
		importProductNavLbl.setForeground(new Color(219, 219, 219));
		importCouponNavLbl.setBackground(new Color(70, 163, 100));
		importCouponNavLbl.setForeground(new Color(219, 219, 219));
		exportProductNavLbl.setBackground(new Color(70, 163, 100));
		exportProductNavLbl.setForeground(new Color(219, 219, 219));
		exportCouponNavLbl.setBackground(new Color(70, 163, 100));
		exportCouponNavLbl.setForeground(new Color(219, 219, 219));
		statisticalchart.setBackground(new Color(70, 163, 100));
		statisticalchart.setForeground(new Color(219, 219, 219));
		Chatlb1.setBackground(new Color(70, 163, 100));
		Chatlb1.setForeground(new Color(219, 219, 219));
		myInformationLbl.setBackground( new Color(70, 163, 100));
		myInformationLbl.setForeground(new Color(219, 219, 219));
	}

	public void clickStatisticalNav() {
		statisticalchart.setBackground(new Color(220, 242, 227));
		statisticalchart.setForeground(new Color(0, 125, 40));
		this.tabbedPane.setSelectedIndex(7);

		productNavLbl.setBackground(new Color(70, 163, 100));
		productNavLbl.setForeground(new Color(219, 219, 219));
		supplierNavLbl.setBackground(new Color(70, 163, 100));
		supplierNavLbl.setForeground(new Color(219, 219, 219));
		importProductNavLbl.setBackground(new Color(70, 163, 100));
		importProductNavLbl.setForeground(new Color(219, 219, 219));
		importCouponNavLbl.setBackground(new Color(70, 163, 100));
		importCouponNavLbl.setForeground(new Color(219, 219, 219));
		exportProductNavLbl.setBackground(new Color(70, 163, 100));
		exportProductNavLbl.setForeground(new Color(219, 219, 219));
		exportCouponNavLbl.setBackground(new Color(70, 163, 100));
		exportCouponNavLbl.setForeground(new Color(219, 219, 219));
		Chatlb1.setBackground(new Color(70, 163, 100));
		Chatlb1.setForeground(new Color(219, 219, 219));
		myInformationLbl.setBackground( new Color(70, 163, 100));
		myInformationLbl.setForeground(new Color(219, 219, 219));
		accountNavLbl.setBackground(new Color(70, 163, 100));
		accountNavLbl.setForeground(new Color(219, 219, 219));

	}
	  private boolean isLoginViewVisible = false; 
	  private Login loginView = null; 
	public void clickChatlb1() {
		Chatlb1.setBackground( new Color(220, 242, 227) );
		Chatlb1.setForeground( new Color(0, 125, 40) );
		
		productNavLbl.setBackground(new Color(70, 163, 100));
		productNavLbl.setForeground(new Color(219, 219, 219));
		statisticalchart.setBackground(new Color(70, 163, 100));
		statisticalchart.setForeground(new Color(219, 219, 219));
		supplierNavLbl.setBackground(new Color(70, 163, 100));
		supplierNavLbl.setForeground(new Color(219, 219, 219));
		importProductNavLbl.setBackground(new Color(70, 163, 100));
		importProductNavLbl.setForeground(new Color(219, 219, 219));
		importCouponNavLbl.setBackground(new Color(70, 163, 100));
		importCouponNavLbl.setForeground(new Color(219, 219, 219));
		exportProductNavLbl.setBackground(new Color(70, 163, 100));
		exportProductNavLbl.setForeground(new Color(219, 219, 219));
		exportCouponNavLbl.setBackground(new Color(70, 163, 100));
		exportCouponNavLbl.setForeground(new Color(219, 219, 219));
		myInformationLbl.setBackground( new Color(70, 163, 100));
		myInformationLbl.setForeground(new Color(219, 219, 219));
		accountNavLbl.setBackground(new Color(70, 163, 100));
		accountNavLbl.setForeground(new Color(219, 219, 219));
		myInformationLbl.setBackground( new Color(70, 163, 100));
		myInformationLbl.setForeground(new Color(219, 219, 219));
		
		
		if (loginView != null) {
	        loginView.dispose(); 
	    }
		loginView = new Login(accountReturn.getFullName());
	    loginView.setVisible(true);
	}

	public void clickMyInformation() {
		myInformationLbl.setBackground( new Color(220, 242, 227));
		myInformationLbl.setForeground(new Color(0, 125, 40));
		
		productNavLbl.setBackground(new Color(70, 163, 100));
		productNavLbl.setForeground(new Color(219, 219, 219));
		statisticalchart.setBackground(new Color(70, 163, 100));
		statisticalchart.setForeground(new Color(219, 219, 219));
		supplierNavLbl.setBackground(new Color(70, 163, 100));
		supplierNavLbl.setForeground(new Color(219, 219, 219));
		importProductNavLbl.setBackground(new Color(70, 163, 100));
		importProductNavLbl.setForeground(new Color(219, 219, 219));
		importCouponNavLbl.setBackground(new Color(70, 163, 100));
		importCouponNavLbl.setForeground(new Color(219, 219, 219));
		exportProductNavLbl.setBackground(new Color(70, 163, 100));
		exportProductNavLbl.setForeground(new Color(219, 219, 219));
		exportCouponNavLbl.setBackground(new Color(70, 163, 100));
		exportCouponNavLbl.setForeground(new Color(219, 219, 219));
		Chatlb1.setBackground(new Color(70, 163, 100));
		Chatlb1.setForeground(new Color(219, 219, 219));
		accountNavLbl.setBackground(new Color(70, 163, 100));
		accountNavLbl.setForeground(new Color(219, 219, 219));
		
		
		new MyInformationView(accountReturn);
	}

	public void clickLogoutNav() {
		LogInView view = new LogInView();
		dispose();
		view.setVisible(true);
	}
}