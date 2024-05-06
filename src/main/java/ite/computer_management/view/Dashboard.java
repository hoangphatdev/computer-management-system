
package ite.computer_management.view;

import java.awt.EventQueue;  

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

import ite.computer_management.controller.DashboardController;
import ite.computer_management.controller.ProductController;

import java.awt.Color;
import java.awt.Dimension;
import java.awt.EventQueue;
import javax.swing.JLabel;
import java.awt.Window.Type;
import javax.swing.SwingConstants;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import javax.swing.JTabbedPane;
import javax.swing.ImageIcon;
import java.awt.Font;


public class Dashboard extends JFrame {
	
	private static final long serialVersionUID = 1L;
	private JPanel contentPane;
	public JLabel productNavLbl;
	public JTabbedPane tabbedPane;
	public JLabel accountNavLbl;
	public JLabel userNavLbl;
	public JLabel logOutNavLbl;
	public JLabel exportCouponNavLbl;
	public JLabel importCouponNavLbl;
	public JLabel exportProductNavLbl;
	public JLabel importProductNavLbl;
	public JLabel statisticalNavLbl;
	public JLabel supplierNavLbl;

	public JLabel Imports_ProductNavLbl;
	public JLabel Export_ProductNavLbl;
	public JPanel navPanel;

	public Dashboard() {
		init();
		this.setLocationRelativeTo(null);
		this.setVisible(true);
	}
	public void init() {
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
		
		ImportsProductView ImportsProductView = new ImportsProductView();
		tabbedPane.addTab("Imports Product", ImportsProductView);
	
		ExportProductView ExportProductView = new ExportProductView();
		tabbedPane.addTab("Export Product", ExportProductView);
	
		SupplierView supplierView = new SupplierView(this);
		tabbedPane.addTab("Supplier manegement", supplierView );
		
		ImportCouponView importCouponView = new ImportCouponView(this);
		tabbedPane.addTab("Import coupon", importCouponView);
		
		
		navPanel = new JPanel();
		navPanel.setLayout(null);
		navPanel.setBounds(0, 0, 250, 800);
		navPanel.setBackground( new Color(54, 51, 46) );
		contentPane.add(navPanel);
		
		
		productNavLbl = new JLabel("Product");
		productNavLbl.setFont(new Font("Lato", Font.BOLD, 15));
		productNavLbl.setIcon(new ImageIcon("C:\\Users\\latru\\Desktop\\computer_management\\src\\main\\java\\ite\\computer_management\\img\\icons8-product-color\\icons8-product-30.png"));
		productNavLbl.setBounds(0, 120, 249, 30);
		productNavLbl.setBackground(new Color(214, 205, 188) );
		productNavLbl.setOpaque(true);
		productNavLbl.addMouseListener(dashboardController);
		navPanel.add(productNavLbl);
		

		JLabel greetingLbl = new JLabel("Hello ......");
		greetingLbl.setHorizontalAlignment(SwingConstants.CENTER);
		greetingLbl.setBounds(0, 0, 250, 110 );
		greetingLbl.setBackground(Color.white);
		greetingLbl.setOpaque(true);
		greetingLbl.setForeground(Color.black);
		navPanel.add(greetingLbl);
		
		productNavLbl = new JLabel("Product");
		productNavLbl.setFont(new Font("Lato", Font.BOLD, 15));
		productNavLbl.setIcon(new ImageIcon("C:\\Users\\latru\\Desktop\\computer_management\\src\\main\\java\\ite\\computer_management\\img\\icons8-product-color\\icons8-product-30.png"));
		productNavLbl.setBounds(0, 109, 250, 45);
		productNavLbl.setBackground(new Color(236, 237, 221));
		productNavLbl.setForeground(new Color(222, 180, 95));
		productNavLbl.setOpaque(true);
		productNavLbl.addMouseListener(dashboardController);
		navPanel.add(productNavLbl);
		
		
		supplierNavLbl = new JLabel("Supplier");
		supplierNavLbl.setIcon(new ImageIcon("C:\\Users\\latru\\Desktop\\computer_management\\src\\main\\java\\ite\\computer_management\\img\\icons8-supplier-color\\icons8-supplier-30.png"));
		supplierNavLbl.setOpaque(true);
		supplierNavLbl.setFont(new Font("Lato", Font.BOLD, 15));
		supplierNavLbl.setBounds(0, 150, 250, 45);
		supplierNavLbl.addMouseListener(dashboardController);
		supplierNavLbl.setBackground( new Color(97, 96, 83) );
		supplierNavLbl.setForeground(new Color(242, 230, 87));
		navPanel.add(supplierNavLbl);
		
		 statisticalNavLbl = new JLabel("Statistical");
		 statisticalNavLbl.setIcon(new ImageIcon("C:\\Users\\latru\\Desktop\\computer_management\\src\\main\\java\\ite\\computer_management\\img\\icons8-analytics-30.png"));
		 statisticalNavLbl.setOpaque(true);
		 statisticalNavLbl.setFont(new Font("Lato", Font.BOLD, 15));
		 statisticalNavLbl.setBackground(new Color(97, 96, 83) );
		 statisticalNavLbl.setBounds(0, 417, 250, 45);
		 statisticalNavLbl.addMouseListener(dashboardController);
		 statisticalNavLbl.setForeground(new Color(242, 230, 87));
		 navPanel.add(statisticalNavLbl);
		 
		  importProductNavLbl = new JLabel("Import Product");
		  importProductNavLbl.setIcon(new ImageIcon("C:\\Users\\latru\\Desktop\\computer_management\\src\\main\\java\\ite\\computer_management\\img\\icons8-import-goods-filled-outline\\icons8-import-goods-32.png"));
		  importProductNavLbl.setOpaque(true);
		  importProductNavLbl.setFont(new Font("Lato", Font.BOLD, 15));
		  importProductNavLbl.setBackground(new Color(97, 96, 83) );
		  importProductNavLbl.setBounds(0, 195, 250, 45);
		  importProductNavLbl.addMouseListener(dashboardController);
		  importProductNavLbl.setForeground(new Color(242, 230, 87));
		  navPanel.add(importProductNavLbl);
		  
		  exportProductNavLbl = new JLabel("Export Product");
		  exportProductNavLbl.setIcon(new ImageIcon("C:\\Users\\latru\\Desktop\\computer_management\\src\\main\\java\\ite\\computer_management\\img\\icons8-import-goods-filled-outline\\icons8-import-goods-32.png"));
		  exportProductNavLbl.setOpaque(true);
		  exportProductNavLbl.setFont(new Font("Lato", Font.BOLD, 15));
		  exportProductNavLbl.setBackground(new Color(97, 96, 83) );
		  exportProductNavLbl.setBounds(-1, 280, 250, 45);
		  exportProductNavLbl.addMouseListener(dashboardController);
		  exportProductNavLbl.setForeground(new Color(242, 230, 87));
		  navPanel.add(exportProductNavLbl);
		  
		   importCouponNavLbl = new JLabel("Import Coupon");
		   importCouponNavLbl.setIcon(new ImageIcon("C:\\Users\\latru\\Desktop\\computer_management\\src\\main\\java\\ite\\computer_management\\img\\icons8-note-30.png"));
		   importCouponNavLbl.setOpaque(true);
		   importCouponNavLbl.setFont(new Font("Lato", Font.BOLD, 15));
		   importCouponNavLbl.setBackground(new Color(97, 96, 83));
		   importCouponNavLbl.setBounds(0, 238, 250, 45);
		   importCouponNavLbl.addMouseListener(dashboardController);
		   importCouponNavLbl.setForeground(new Color(242, 230, 87));
		   navPanel.add(importCouponNavLbl);
		   
		   exportCouponNavLbl = new JLabel("Export Coupon");
		   exportCouponNavLbl.setIcon(new ImageIcon("C:\\Users\\latru\\Desktop\\computer_management\\src\\main\\java\\ite\\computer_management\\img\\icons8-note-30.png"));
		   exportCouponNavLbl.setOpaque(true);
		   exportCouponNavLbl.setFont(new Font("Lato", Font.BOLD, 15));
		   exportCouponNavLbl.setBackground(new Color(97, 96, 83));
		   exportCouponNavLbl.setBounds(0, 325, 250, 50);
		   exportCouponNavLbl.addMouseListener(dashboardController);
		   exportCouponNavLbl.setForeground(new Color(242, 230, 87));
		   navPanel.add(exportCouponNavLbl);
		   
		   accountNavLbl = new JLabel("Account");
		   accountNavLbl.setIcon(new ImageIcon("C:\\Users\\latru\\Desktop\\computer_management\\src\\main\\java\\ite\\computer_management\\img\\account management orange\\icons8-management-30.png"));
		   accountNavLbl.setOpaque(true);
		   accountNavLbl.setFont(new Font("Lato", Font.BOLD, 15));
		   accountNavLbl.setBackground(new Color(97, 96, 83));
		   accountNavLbl.setBounds(0, 374, 250, 45);
		   accountNavLbl.addMouseListener(dashboardController);
		   accountNavLbl.setForeground(new Color(242, 230, 87));
		   navPanel.add(accountNavLbl);
		   
		   userNavLbl = new JLabel("User");
		   userNavLbl.setIcon(new ImageIcon("C:\\Users\\latru\\Desktop\\computer_management\\src\\main\\java\\ite\\computer_management\\img\\icons8-user-office-m\\icons8-user-30.png"));
		   userNavLbl.setOpaque(true);
		   userNavLbl.setFont(new Font("Lato", Font.BOLD, 15));
		   userNavLbl.setBackground(new Color(97, 96, 83));
		   userNavLbl.setBounds(0, 668, 250, 45);
		   userNavLbl.addMouseListener(dashboardController);
		   userNavLbl.setForeground(new Color(242, 230, 87));
		   navPanel.add(userNavLbl);
		   
		   logOutNavLbl = new JLabel("Log out");
		   logOutNavLbl.setIcon(new ImageIcon("C:\\Users\\latru\\Desktop\\computer_management\\src\\main\\java\\ite\\computer_management\\img\\log out\\icons8-log-out-32.png"));
		   logOutNavLbl.setOpaque(true);
		   logOutNavLbl.setFont(new Font("Lato", Font.BOLD, 15));
		   logOutNavLbl.setBackground(new Color(97, 96, 83));
		   logOutNavLbl.setBounds(0, 712, 250, 50);
		   logOutNavLbl.addMouseListener(dashboardController);
		   logOutNavLbl.setForeground(new Color(242, 230, 87));
		   navPanel.add(logOutNavLbl);
		
	}
	
	public void clickSupplierNav() {
		supplierNavLbl.setBackground(new Color(236, 237, 221));
		supplierNavLbl.setForeground(new Color(50, 148, 209));
		this.tabbedPane.setSelectedIndex(4);
		
		productNavLbl.setBackground(new Color(97, 96, 83) );
		productNavLbl.setForeground(new Color(242, 230, 87));
		importProductNavLbl.setBackground(new Color(97, 96, 83) );
		importProductNavLbl.setForeground(new Color(242, 230, 87));
		importCouponNavLbl.setBackground( new Color(97, 96, 83) );
		importCouponNavLbl.setForeground( new Color(242, 230, 87) );
		exportCouponNavLbl.setBackground( new Color(97, 96, 83) );
		exportCouponNavLbl.setForeground( new Color(242, 230, 87) );
		accountNavLbl.setBackground( new Color(97, 96, 83) );
		accountNavLbl.setForeground(new Color(242, 230, 87) );
		statisticalNavLbl.setBackground( new Color(97, 96, 83) );
		statisticalNavLbl.setForeground(new Color(242, 230, 87) );
		
	}
	public void clickProductNav() {
		productNavLbl.setBackground(new Color(236, 237, 221) );
		productNavLbl.setForeground(new Color(222, 180, 95));
		this.tabbedPane.setSelectedIndex(0);  // SetSelectedIndex bat dau tu para 0;
		
		supplierNavLbl.setBackground(new Color(97, 96, 83));
		supplierNavLbl.setForeground(new Color(242, 230, 87));
		importProductNavLbl.setBackground(new Color(97, 96, 83));
		importProductNavLbl.setForeground(new Color(242, 230, 87));
		importCouponNavLbl.setBackground( new Color(97, 96, 83) );
		importCouponNavLbl.setForeground( new Color(242, 230, 87) );
		exportProductNavLbl.setBackground( new Color(97, 96, 83) );
		exportProductNavLbl.setForeground( new Color(242, 230, 87) );
		exportCouponNavLbl.setBackground( new Color(97, 96, 83) );
		exportCouponNavLbl.setForeground( new Color(242, 230, 87) );
		accountNavLbl.setBackground( new Color(97, 96, 83) );
		accountNavLbl.setForeground(new Color(242, 230, 87) );
		statisticalNavLbl.setBackground( new Color(97, 96, 83) );
		statisticalNavLbl.setForeground(new Color(242, 230, 87) );
		
	}
	public void clickImportProductNav() {
		importProductNavLbl.setBackground(new Color(236, 237, 221));
		importProductNavLbl.setForeground(new Color(201, 111, 130));
		this.tabbedPane.setSelectedIndex(2);
	
		productNavLbl.setBackground(new Color(97, 96, 83) );
		productNavLbl.setForeground(new Color(242, 230, 87));
		supplierNavLbl.setBackground(new Color(97, 96, 83));
		supplierNavLbl.setForeground(new Color(242, 230, 87));
		exportProductNavLbl.setBackground( new Color(97, 96, 83) );
		exportProductNavLbl.setForeground( new Color(242, 230, 87) );
		importCouponNavLbl.setBackground( new Color(97, 96, 83) );
		importCouponNavLbl.setForeground( new Color(242, 230, 87) );
		exportCouponNavLbl.setBackground( new Color(97, 96, 83) );
		exportCouponNavLbl.setForeground( new Color(242, 230, 87) );
		accountNavLbl.setBackground( new Color(97, 96, 83) );
		accountNavLbl.setForeground(new Color(242, 230, 87) );
		statisticalNavLbl.setBackground( new Color(97, 96, 83) );
		statisticalNavLbl.setForeground(new Color(242, 230, 87) );
		
	}
	public void clickImportCouponNav() {
		importCouponNavLbl.setBackground( new Color(236, 237, 221) );
		importCouponNavLbl.setForeground( new Color(112, 230, 94) );
		this.tabbedPane.setSelectedIndex(5);
		
		productNavLbl.setBackground(new Color(97, 96, 83) );
		productNavLbl.setForeground(new Color(242, 230, 87));
		supplierNavLbl.setBackground(new Color(97, 96, 83));
		supplierNavLbl.setForeground(new Color(242, 230, 87));
		importProductNavLbl.setBackground( new Color(97, 96, 83) );
		importProductNavLbl.setForeground( new Color(242, 230, 87) );
		exportProductNavLbl.setBackground( new Color(97, 96, 83) );
		exportProductNavLbl.setForeground( new Color(242, 230, 87) );
		exportCouponNavLbl.setBackground( new Color(97, 96, 83) );
		exportCouponNavLbl.setForeground( new Color(242, 230, 87) );
		accountNavLbl.setBackground( new Color(97, 96, 83) );
		accountNavLbl.setForeground(new Color(242, 230, 87) );
		statisticalNavLbl.setBackground( new Color(97, 96, 83) );
		statisticalNavLbl.setForeground(new Color(242, 230, 87) );
	}
	public void clickExportProductNav() {
		exportProductNavLbl.setBackground( new Color(236, 237, 221) );
		exportProductNavLbl.setForeground( new Color(75, 154, 214) );
		this.tabbedPane.setSelectedIndex(3);
		
		productNavLbl.setBackground(new Color(97, 96, 83) );
		productNavLbl.setForeground(new Color(242, 230, 87));
		supplierNavLbl.setBackground(new Color(97, 96, 83));
		supplierNavLbl.setForeground(new Color(242, 230, 87));
		importProductNavLbl.setBackground( new Color(97, 96, 83) );
		importProductNavLbl.setForeground( new Color(242, 230, 87) );
		importCouponNavLbl.setBackground( new Color(97, 96, 83) );
		importCouponNavLbl.setForeground( new Color(242, 230, 87) );
		exportCouponNavLbl.setBackground( new Color(97, 96, 83) );
		exportCouponNavLbl.setForeground( new Color(242, 230, 87) );
		accountNavLbl.setBackground( new Color(97, 96, 83) );
		accountNavLbl.setForeground(new Color(242, 230, 87) );
		statisticalNavLbl.setBackground( new Color(97, 96, 83) );
		statisticalNavLbl.setForeground(new Color(242, 230, 87) );
	}
	public void clickExportCouponNav() {
		exportCouponNavLbl.setBackground( new Color(236, 237, 221) );
		exportCouponNavLbl.setForeground( new Color(209, 78, 17) );
		
		productNavLbl.setBackground(new Color(97, 96, 83) );
		productNavLbl.setForeground(new Color(242, 230, 87));
		supplierNavLbl.setBackground(new Color(97, 96, 83));
		supplierNavLbl.setForeground(new Color(242, 230, 87));
		importProductNavLbl.setBackground( new Color(97, 96, 83) );
		importProductNavLbl.setForeground( new Color(242, 230, 87) );
		importCouponNavLbl.setBackground( new Color(97, 96, 83) );
		importCouponNavLbl.setForeground( new Color(242, 230, 87) );
		exportProductNavLbl.setBackground( new Color(97, 96, 83) );
		exportProductNavLbl.setForeground(new Color(242, 230, 87) );
		accountNavLbl.setBackground( new Color(97, 96, 83) );
		accountNavLbl.setForeground(new Color(242, 230, 87) );
		statisticalNavLbl.setBackground( new Color(97, 96, 83) );
		statisticalNavLbl.setForeground(new Color(242, 230, 87) );
	}
	public void clickAccountNav() {
		this.tabbedPane.setSelectedIndex(1);
		accountNavLbl.setBackground( new Color(236, 237, 221) );
		accountNavLbl.setForeground( new Color(222, 13, 48) );
		
		productNavLbl.setBackground(new Color(97, 96, 83) );
		productNavLbl.setForeground(new Color(242, 230, 87));
		supplierNavLbl.setBackground(new Color(97, 96, 83));
		supplierNavLbl.setForeground(new Color(242, 230, 87));
		importProductNavLbl.setBackground( new Color(97, 96, 83) );
		importProductNavLbl.setForeground( new Color(242, 230, 87) );
		importCouponNavLbl.setBackground( new Color(97, 96, 83) );
		importCouponNavLbl.setForeground( new Color(242, 230, 87) );
		exportProductNavLbl.setBackground( new Color(97, 96, 83) );
		exportProductNavLbl.setForeground(new Color(242, 230, 87) );
		statisticalNavLbl.setBackground( new Color(97, 96, 83) );
		statisticalNavLbl.setForeground(new Color(242, 230, 87) );
		exportCouponNavLbl.setBackground( new Color(97, 96, 83) );
		exportCouponNavLbl.setForeground(new Color(242, 230, 87) );
	}
	public void clickStatisticalNav() {
		statisticalNavLbl.setBackground( new Color(236, 237, 221) );
		statisticalNavLbl.setForeground( new Color(217, 209, 72));
		
		productNavLbl.setBackground(new Color(97, 96, 83) );
		productNavLbl.setForeground(new Color(242, 230, 87));
		supplierNavLbl.setBackground(new Color(97, 96, 83));
		supplierNavLbl.setForeground(new Color(242, 230, 87));
		importProductNavLbl.setBackground( new Color(97, 96, 83) );
		importProductNavLbl.setForeground( new Color(242, 230, 87) );
		importCouponNavLbl.setBackground( new Color(97, 96, 83) );
		importCouponNavLbl.setForeground( new Color(242, 230, 87) );
		exportProductNavLbl.setBackground( new Color(97, 96, 83) );
		exportProductNavLbl.setForeground(new Color(242, 230, 87) );
		exportCouponNavLbl.setBackground( new Color(97, 96, 83) );
		exportCouponNavLbl.setForeground(new Color(242, 230, 87) );
		accountNavLbl.setBackground( new Color(97, 96, 83) );
		accountNavLbl.setForeground(new Color(242, 230, 87) );
	}
	public void clickUserNav() {
		this.setVisible(false);
	}
	public void clickLogoutNav() {
		
	}
}