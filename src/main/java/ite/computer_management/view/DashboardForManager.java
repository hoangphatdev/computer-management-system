package ite.computer_management.view;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

import ite.computer_management.controller.DashboardForManagerController;
import ite.computer_management.model.Account;
import main.Login;

import java.awt.Color;
import java.awt.Dimension;
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

public class DashboardForManager extends JFrame {

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
	public JLabel statisticalNavLbl;
	public JLabel supplierNavLbl;
	public JPanel navPanel;
	public JLabel ChatNavLbl_1;
	private Account accountReturn;

	public DashboardForManager(Account accountReturn) {
		this.accountReturn = accountReturn;
		init();
		this.setLocationRelativeTo(null);
		this.setVisible(true);
	}

	public void init() {
		DashboardForManagerController dashboardForManagerController = new DashboardForManagerController(this);
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

SupplierView supplierView = new SupplierView(this);
		tabbedPane.addTab("Supplier manegement", supplierView);
		
		

		ImportsProductView ImportsProductView = new ImportsProductView();
		tabbedPane.addTab("Imports Product", ImportsProductView);
		
		ImportCouponView importCouponView = new ImportCouponView();
		tabbedPane.addTab("Import coupon", importCouponView);

		ExportProductView ExportProductView = new ExportProductView();
		tabbedPane.addTab("Export Product", ExportProductView);

		ExportCouponView exportCouponView = new ExportCouponView();
		tabbedPane.addTab("Export coupon", exportCouponView);

		navPanel = new JPanel();
		navPanel.setForeground(new Color(0, 0, 0));
		navPanel.setLayout(null);
		navPanel.setBounds(0, 0, 250, 800);
		navPanel.setBackground(new Color(0, 0, 51));
		contentPane.add(navPanel);

		JLabel greetingLbl = new JLabel("");
		greetingLbl.setIcon(new ImageIcon(
				"D:\\JAVA_project\\computer-management-system\\src\\main\\java\\ite\\computer_management\\img\\lgo.png"));
		greetingLbl.setHorizontalAlignment(SwingConstants.CENTER);
		greetingLbl.setBounds(1, 0, 250, 158);
		greetingLbl.setBackground(new Color(0, 0, 51));
		greetingLbl.setOpaque(true);
		greetingLbl.setForeground(Color.black);
		navPanel.add(greetingLbl);

		productNavLbl = new JLabel("Product");
		productNavLbl.setFont(new Font("Lato", Font.BOLD, 15));
		productNavLbl.setIcon(new ImageIcon(
				"C:\\Users\\latru\\Desktop\\computer_management\\src\\main\\java\\ite\\computer_management\\img\\icons8-product-color\\icons8-product-30.png"));
		productNavLbl.setBounds(1, 157, 250, 45);
		productNavLbl.setBackground(new Color(220, 242, 227));
		productNavLbl.setForeground(new Color(0, 125, 40));
		productNavLbl.setOpaque(true);
		productNavLbl.addMouseListener(dashboardForManagerController);
		navPanel.add(productNavLbl);

		supplierNavLbl = new JLabel("Supplier");
		supplierNavLbl.setIcon(new ImageIcon(
				"C:\\Users\\latru\\Desktop\\computer_management\\src\\main\\java\\ite\\computer_management\\img\\icons8-supplier-color\\icons8-supplier-30.png"));
		supplierNavLbl.setOpaque(true);
		supplierNavLbl.setFont(new Font("Lato", Font.BOLD, 15));
		supplierNavLbl.setBounds(1, 201, 250, 45);
		supplierNavLbl.addMouseListener(dashboardForManagerController);
		supplierNavLbl.setBackground(new Color(51, 51, 102));
		supplierNavLbl.setForeground(new Color(242, 230, 87));
		navPanel.add(supplierNavLbl);

		statisticalNavLbl = new JLabel("Statistical");
		statisticalNavLbl.setIcon(new ImageIcon(
				"C:\\Users\\latru\\Desktop\\computer_management\\src\\main\\java\\ite\\computer_management\\img\\icons8-analytics-30.png"));
		statisticalNavLbl.setOpaque(true);
		statisticalNavLbl.setFont(new Font("Lato", Font.BOLD, 15));
		statisticalNavLbl.setBackground(new Color(51, 51, 102));
		statisticalNavLbl.setBounds(1, 625, 250, 45);
		statisticalNavLbl.addMouseListener(dashboardForManagerController);
		statisticalNavLbl.setForeground(new Color(242, 230, 87));
		navPanel.add(statisticalNavLbl);

		importProductNavLbl = new JLabel("Import Product");
		importProductNavLbl.setIcon(new ImageIcon(
				"C:\\Users\\latru\\Desktop\\computer_management\\src\\main\\java\\ite\\computer_management\\img\\icons8-import-goods-filled-outline\\icons8-import-goods-32.png"));
		importProductNavLbl.setOpaque(true);
		importProductNavLbl.setFont(new Font("Lato", Font.BOLD, 15));
		importProductNavLbl.setBackground(new Color(51, 51, 102));
		importProductNavLbl.setBounds(1, 244, 250, 45);
		importProductNavLbl.addMouseListener(dashboardForManagerController);
		importProductNavLbl.setForeground(new Color(242, 230, 87));
		navPanel.add(importProductNavLbl);

		exportProductNavLbl = new JLabel("Export Product");
		exportProductNavLbl.setIcon(new ImageIcon(
				"C:\\Users\\latru\\Desktop\\computer_management\\src\\main\\java\\ite\\computer_management\\img\\icons8-import-goods-filled-outline\\icons8-import-goods-32.png"));
		exportProductNavLbl.setOpaque(true);
		exportProductNavLbl.setFont(new Font("Lato", Font.BOLD, 15));
		exportProductNavLbl.setBackground(new Color(51, 51, 102));
		exportProductNavLbl.setBounds(1, 330, 250, 45);
		exportProductNavLbl.addMouseListener(dashboardForManagerController);
		exportProductNavLbl.setForeground(new Color(242, 230, 87));
		navPanel.add(exportProductNavLbl);

		importCouponNavLbl = new JLabel("Import Coupon");
		importCouponNavLbl.setIcon(new ImageIcon(
				"C:\\Users\\latru\\Desktop\\computer_management\\src\\main\\java\\ite\\computer_management\\img\\icons8-note-30.png"));
		importCouponNavLbl.setOpaque(true);
		importCouponNavLbl.setFont(new Font("Lato", Font.BOLD, 15));
		importCouponNavLbl.setBackground(new Color(51, 51, 102));
		importCouponNavLbl.setBounds(1, 287, 250, 45);
		importCouponNavLbl.addMouseListener(dashboardForManagerController);
		importCouponNavLbl.setForeground(new Color(242, 230, 87));
		navPanel.add(importCouponNavLbl);

		exportCouponNavLbl = new JLabel("Export Coupon");
		exportCouponNavLbl.setIcon(new ImageIcon(
				"C:\\Users\\latru\\Desktop\\computer_management\\src\\main\\java\\ite\\computer_management\\img\\icons8-note-30.png"));
		exportCouponNavLbl.setOpaque(true);
		exportCouponNavLbl.setFont(new Font("Lato", Font.BOLD, 15));
		exportCouponNavLbl.setBackground(new Color(51, 51, 102));
		exportCouponNavLbl.setBounds(1, 374, 250, 50);
		exportCouponNavLbl.addMouseListener(dashboardForManagerController);
		exportCouponNavLbl.setForeground(new Color(242, 230, 87));
		navPanel.add(exportCouponNavLbl);

		myInformationLbl = new JLabel("My Information");
		myInformationLbl.setIcon(new ImageIcon(
				"C:\\Users\\latru\\Desktop\\computer_management\\src\\main\\java\\ite\\computer_management\\img\\icons8-user-office-m\\icons8-user-30.png"));
		myInformationLbl.setOpaque(true);
		myInformationLbl.setFont(new Font("Lato", Font.BOLD, 15));
		myInformationLbl.setBackground(new Color(51, 51, 102));
		myInformationLbl.setBounds(0, 668, 250, 45);
		myInformationLbl.addMouseListener(dashboardForManagerController);
		myInformationLbl.setForeground(new Color(242, 230, 87));
		navPanel.add(myInformationLbl);

		logOutNavLbl = new JLabel("Log out");
		logOutNavLbl.setIcon(new ImageIcon(
				"C:\\Users\\latru\\Desktop\\computer_management\\src\\main\\java\\ite\\computer_management\\img\\log out\\icons8-log-out-32.png"));
		logOutNavLbl.setOpaque(true);
		logOutNavLbl.setFont(new Font("Lato", Font.BOLD, 15));
		logOutNavLbl.setBackground(new Color(51, 51, 102));
		logOutNavLbl.setBounds(0, 712, 250, 50);
		logOutNavLbl.addMouseListener(dashboardForManagerController);
		logOutNavLbl.setForeground(new Color(242, 230, 87));
		navPanel.add(logOutNavLbl);
		
		ChatNavLbl_1 = new JLabel("Chat");
		ChatNavLbl_1.setOpaque(true);
		ChatNavLbl_1.setForeground(new Color(242, 230, 87));
		ChatNavLbl_1.setFont(new Font("Dialog", Font.BOLD, 15));
		ChatNavLbl_1.setBackground(new Color(51, 51, 102));
		ChatNavLbl_1.setBounds(1, 422, 250, 50);
		navPanel.add(ChatNavLbl_1);
		ChatNavLbl_1.addMouseListener(dashboardForManagerController);
	}

	public void clickSupplierNav() {
		this.tabbedPane.setSelectedIndex(1);
		supplierNavLbl.setBackground(new Color(25, 25, 112));
		supplierNavLbl.setForeground(Color.WHITE);

		productNavLbl.setBackground(new Color(51, 51, 102));
		ChatNavLbl_1.setBackground(new Color(51, 51, 102));
		ChatNavLbl_1.setForeground(new Color(242, 230, 87));	
		importProductNavLbl.setBackground(new Color(51, 51, 102));
		importProductNavLbl.setForeground(new Color(242, 230, 87));
		importCouponNavLbl.setBackground(new Color(51, 51, 102));
		importCouponNavLbl.setForeground(new Color(242, 230, 87));
		exportProductNavLbl.setBackground(new Color(51, 51, 102));
		exportProductNavLbl.setForeground(new Color(242, 230, 87));
		exportCouponNavLbl.setBackground(new Color(51, 51, 102));
		exportCouponNavLbl.setForeground(new Color(242, 230, 87));
	}

	public void clickProductNav() {
		this.tabbedPane.setSelectedIndex(0);
		productNavLbl.setBackground(new Color(25, 25, 112));
		productNavLbl.setForeground(Color.WHITE);

		statisticalNavLbl.setBackground(new Color(70, 163, 100));
		statisticalNavLbl.setForeground(new Color(219, 219, 219));
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
		ChatNavLbl_1.setBackground(new Color(70, 163, 100));
		ChatNavLbl_1.setForeground(new Color(219, 219, 219));
		myInformationLbl.setBackground( new Color(70, 163, 100));
		myInformationLbl.setForeground(new Color(219, 219, 219));
	}

	public void clickImportProductNav() {
		importProductNavLbl.setBackground(new Color(25, 25, 112));
		importProductNavLbl.setForeground(Color.WHITE);
		this.tabbedPane.setSelectedIndex(2);

		productNavLbl.setBackground(new Color(70, 163, 100));
		productNavLbl.setForeground(new Color(219, 219, 219));
		supplierNavLbl.setBackground(new Color(70, 163, 100));
		supplierNavLbl.setForeground(new Color(219, 219, 219));
		statisticalNavLbl.setBackground(new Color(70, 163, 100));
		statisticalNavLbl.setForeground(new Color(219, 219, 219));
		importCouponNavLbl.setBackground(new Color(70, 163, 100));
		importCouponNavLbl.setForeground(new Color(219, 219, 219));
		exportProductNavLbl.setBackground(new Color(70, 163, 100));
		exportProductNavLbl.setForeground(new Color(219, 219, 219));
		exportCouponNavLbl.setBackground(new Color(70, 163, 100));
		exportCouponNavLbl.setForeground(new Color(219, 219, 219));
		accountNavLbl.setBackground(new Color(70, 163, 100));
		accountNavLbl.setForeground(new Color(219, 219, 219));
		ChatNavLbl_1.setBackground(new Color(70, 163, 100));
		ChatNavLbl_1.setForeground(new Color(219, 219, 219));
		myInformationLbl.setBackground( new Color(70, 163, 100));
		myInformationLbl.setForeground(new Color(219, 219, 219));
	}

	public void clickImportCouponNav() {
		this.tabbedPane.setSelectedIndex(3);
		importCouponNavLbl.setBackground(new Color(220, 242, 227));
		importCouponNavLbl.setForeground(new Color(0, 125, 40));

		productNavLbl.setBackground(new Color(70, 163, 100));
		productNavLbl.setForeground(new Color(219, 219, 219));
		supplierNavLbl.setBackground(new Color(70, 163, 100));
		supplierNavLbl.setForeground(new Color(219, 219, 219));
		importProductNavLbl.setBackground(new Color(70, 163, 100));
		importProductNavLbl.setForeground(new Color(219, 219, 219));
		statisticalNavLbl.setBackground(new Color(70, 163, 100));
		statisticalNavLbl.setForeground(new Color(219, 219, 219));
		exportProductNavLbl.setBackground(new Color(70, 163, 100));
		exportProductNavLbl.setForeground(new Color(219, 219, 219));
		exportCouponNavLbl.setBackground(new Color(70, 163, 100));
		exportCouponNavLbl.setForeground(new Color(219, 219, 219));
		accountNavLbl.setBackground(new Color(70, 163, 100));
		accountNavLbl.setForeground(new Color(219, 219, 219));
		ChatNavLbl_1.setBackground(new Color(70, 163, 100));
		ChatNavLbl_1.setForeground(new Color(219, 219, 219));
		myInformationLbl.setBackground( new Color(70, 163, 100));
		myInformationLbl.setForeground(new Color(219, 219, 219));
	}

	public void clickExportProductNav() {
		this.tabbedPane.setSelectedIndex(4);
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
		statisticalNavLbl.setBackground(new Color(70, 163, 100));
		statisticalNavLbl.setForeground(new Color(219, 219, 219));
		exportCouponNavLbl.setBackground(new Color(70, 163, 100));
		exportCouponNavLbl.setForeground(new Color(219, 219, 219));
		accountNavLbl.setBackground(new Color(70, 163, 100));
		accountNavLbl.setForeground(new Color(219, 219, 219));
		ChatNavLbl_1.setBackground(new Color(70, 163, 100));
		ChatNavLbl_1.setForeground(new Color(219, 219, 219));
		myInformationLbl.setBackground( new Color(70, 163, 100));
		myInformationLbl.setForeground(new Color(219, 219, 219));	}

	public void clickExportCouponNav() {
		this.tabbedPane.setSelectedIndex(5);
		exportCouponNavLbl.setBackground(new Color(220, 242, 227));
		exportCouponNavLbl.setForeground( new Color(0, 125, 40));

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
		statisticalNavLbl.setBackground(new Color(70, 163, 100));
		statisticalNavLbl.setForeground(new Color(219, 219, 219));
		accountNavLbl.setBackground(new Color(70, 163, 100));
		accountNavLbl.setForeground(new Color(219, 219, 219));
		ChatNavLbl_1.setBackground(new Color(70, 163, 100));
		ChatNavLbl_1.setForeground(new Color(219, 219, 219));
		myInformationLbl.setBackground( new Color(70, 163, 100));
		myInformationLbl.setForeground(new Color(219, 219, 219));

	}

	public void clickStatisticalNav() {
		statisticalNavLbl.setBackground(new Color(220, 242, 227));
		statisticalNavLbl.setForeground(new Color(0, 125, 40));

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
		ChatNavLbl_1.setBackground(new Color(70, 163, 100));
		ChatNavLbl_1.setForeground(new Color(219, 219, 219));
		myInformationLbl.setBackground( new Color(70, 163, 100));
		myInformationLbl.setForeground(new Color(219, 219, 219));
		accountNavLbl.setBackground(new Color(70, 163, 100));
		accountNavLbl.setForeground(new Color(219, 219, 219));;

	}
	public void clickChatNav() {
		ChatNavLbl_1.setBackground( new Color(220, 242, 227) );
		ChatNavLbl_1.setForeground( new Color(0, 125, 40) );
		Login view = new Login();
		view.setUserName("Manager");
		view.setVisible(true);
		
				
		
		productNavLbl.setBackground(new Color(70, 163, 100));
		productNavLbl.setForeground(new Color(219, 219, 219));
		statisticalNavLbl.setBackground(new Color(70, 163, 100));
		statisticalNavLbl.setForeground(new Color(219, 219, 219));
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

	}
	public void clickMyInformationNav() {
		new MyInformationView(accountReturn);
	}

	public void clickLogoutNav() {
		this.dispose();
	}
}