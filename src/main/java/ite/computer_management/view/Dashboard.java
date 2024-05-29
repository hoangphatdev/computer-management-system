
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
		
		ImportsProductView ImportsProductView = new ImportsProductView();
		tabbedPane.addTab("Imports Product", ImportsProductView);
	
		ExportProductView ExportProductView = new ExportProductView();
		tabbedPane.addTab("Export Product", ExportProductView);
	
		SupplierView supplierView = new SupplierView(this);
		tabbedPane.addTab("Supplier manegement", supplierView );
		
		ImportCouponView importCouponView = new ImportCouponView();
		tabbedPane.addTab("Import coupon", importCouponView);
		
		ExportCouponView exportCouponView = new ExportCouponView();
		tabbedPane.addTab("Export coupon", exportCouponView);
		
		Columnchart chart = new Columnchart(this);
		tabbedPane.addTab("statistical chart", chart);
		
		 
		navPanel = new JPanel();
		navPanel.setForeground(new Color(0, 0, 0));
		navPanel.setLayout(null);
		navPanel.setBounds(0, 0, 250, 800);
		navPanel.setBackground( new Color(0, 0, 51) );
		contentPane.add(navPanel);
		

		JLabel greetingLbl = new JLabel("");
		greetingLbl.setIcon(new ImageIcon("D:\\JAVA_project\\computer-management-system\\src\\main\\java\\ite\\computer_management\\img\\lgo.png"));
		greetingLbl.setHorizontalAlignment(SwingConstants.CENTER);
		greetingLbl.setBounds(1, 0, 250, 158 );
		greetingLbl.setBackground(new Color(0, 0, 51));
		greetingLbl.setOpaque(true);
		greetingLbl.setForeground(Color.black);
		navPanel.add(greetingLbl);
		
		productNavLbl = new JLabel("Product");
		productNavLbl.setFont(new Font("Lato", Font.BOLD, 15));
		productNavLbl.setIcon(new ImageIcon("C:\\Users\\latru\\Desktop\\computer_management\\src\\main\\java\\ite\\computer_management\\img\\icons8-product-color\\icons8-product-30.png"));
		productNavLbl.setBounds(1, 157, 250, 45);
		productNavLbl.setBackground(new Color(51, 51, 102));
		productNavLbl.setForeground(new Color(255, 255, 0));
		productNavLbl.setOpaque(true);
		productNavLbl.addMouseListener(dashboardController);
		navPanel.add(productNavLbl);
		
		
		supplierNavLbl = new JLabel("Supplier");
		supplierNavLbl.setIcon(new ImageIcon("C:\\Users\\latru\\Desktop\\computer_management\\src\\main\\java\\ite\\computer_management\\img\\icons8-supplier-color\\icons8-supplier-30.png"));
		supplierNavLbl.setOpaque(true);
		supplierNavLbl.setFont(new Font("Lato", Font.BOLD, 15));
		supplierNavLbl.setBounds(1, 201, 250, 45);
		supplierNavLbl.addMouseListener(dashboardController);
		supplierNavLbl.setBackground( new Color(51, 51, 102) );
		supplierNavLbl.setForeground(new Color(242, 230, 87));
		navPanel.add(supplierNavLbl);
		 
		  importProductNavLbl = new JLabel("Import Product");
		  importProductNavLbl.setIcon(new ImageIcon("C:\\Users\\latru\\Desktop\\computer_management\\src\\main\\java\\ite\\computer_management\\img\\icons8-import-goods-filled-outline\\icons8-import-goods-32.png"));
		  importProductNavLbl.setOpaque(true);
		  importProductNavLbl.setFont(new Font("Lato", Font.BOLD, 15));
		  importProductNavLbl.setBackground(new Color(51, 51, 102) );
		  importProductNavLbl.setBounds(1, 244, 250, 45);
		  importProductNavLbl.addMouseListener(dashboardController);
		  importProductNavLbl.setForeground(new Color(242, 230, 87));
		  navPanel.add(importProductNavLbl);
		  
		  exportProductNavLbl = new JLabel("Export Product");
		  exportProductNavLbl.setIcon(new ImageIcon("C:\\Users\\latru\\Desktop\\computer_management\\src\\main\\java\\ite\\computer_management\\img\\icons8-import-goods-filled-outline\\icons8-import-goods-32.png"));
		  exportProductNavLbl.setOpaque(true);
		  exportProductNavLbl.setFont(new Font("Lato", Font.BOLD, 15));
		  exportProductNavLbl.setBackground(new Color(51, 51, 102) );
		  exportProductNavLbl.setBounds(1, 330, 250, 45);
		  exportProductNavLbl.addMouseListener(dashboardController);
		  exportProductNavLbl.setForeground(new Color(242, 230, 87));
		  navPanel.add(exportProductNavLbl);
		  
		   importCouponNavLbl = new JLabel("Import Coupon");
		   importCouponNavLbl.setIcon(new ImageIcon("C:\\Users\\latru\\Desktop\\computer_management\\src\\main\\java\\ite\\computer_management\\img\\icons8-note-30.png"));
		   importCouponNavLbl.setOpaque(true);
		   importCouponNavLbl.setFont(new Font("Lato", Font.BOLD, 15));
		   importCouponNavLbl.setBackground(new Color(51, 51, 102));
		   importCouponNavLbl.setBounds(1, 287, 250, 45);
		   importCouponNavLbl.addMouseListener(dashboardController);
		   importCouponNavLbl.setForeground(new Color(242, 230, 87));
		   navPanel.add(importCouponNavLbl);
		   
		   exportCouponNavLbl = new JLabel("Export Coupon");
		   exportCouponNavLbl.setIcon(new ImageIcon("C:\\Users\\latru\\Desktop\\computer_management\\src\\main\\java\\ite\\computer_management\\img\\icons8-note-30.png"));
		   exportCouponNavLbl.setOpaque(true);
		   exportCouponNavLbl.setFont(new Font("Lato", Font.BOLD, 15));
		   exportCouponNavLbl.setBackground(new Color(51, 51, 102));
		   exportCouponNavLbl.setBounds(1, 374, 250, 50);
		   exportCouponNavLbl.addMouseListener(dashboardController);
		   exportCouponNavLbl.setForeground(new Color(242, 230, 87));
		   navPanel.add(exportCouponNavLbl);
		   
		   accountNavLbl = new JLabel("Account");
		   accountNavLbl.setIcon(new ImageIcon("C:\\Users\\latru\\Desktop\\computer_management\\src\\main\\java\\ite\\computer_management\\img\\account management orange\\icons8-management-30.png"));
		   accountNavLbl.setOpaque(true);
		   accountNavLbl.setFont(new Font("Lato", Font.BOLD, 15));
		   accountNavLbl.setBackground(new Color(51, 51, 102));
		   accountNavLbl.setBounds(1, 624, 250, 45);
		   accountNavLbl.addMouseListener(dashboardController);
		   accountNavLbl.setForeground(new Color(242, 230, 87));
		   navPanel.add(accountNavLbl);
		   
		   myInformationLbl = new JLabel("My Information");
		   myInformationLbl.setIcon(new ImageIcon("C:\\Users\\latru\\Desktop\\computer_management\\src\\main\\java\\ite\\computer_management\\img\\icons8-user-office-m\\icons8-user-30.png"));
		   myInformationLbl.setOpaque(true);
		   myInformationLbl.setFont(new Font("Lato", Font.BOLD, 15));
		   myInformationLbl.setBackground(new Color(51, 51, 102));
		   myInformationLbl.setBounds(0, 668, 250, 45);
		   myInformationLbl.addMouseListener(dashboardController);
		   myInformationLbl.setForeground(new Color(242, 230, 87));
		   navPanel.add(myInformationLbl);
		   
		   logOutNavLbl = new JLabel("Log out");
		   logOutNavLbl.setIcon(new ImageIcon("C:\\Users\\latru\\Desktop\\computer_management\\src\\main\\java\\ite\\computer_management\\img\\log out\\icons8-log-out-32.png"));
		   logOutNavLbl.setOpaque(true);
		   logOutNavLbl.setFont(new Font("Lato", Font.BOLD, 15));
		   logOutNavLbl.setBackground(new Color(51, 51, 102));
		   logOutNavLbl.setBounds(0, 712, 250, 50);
		   logOutNavLbl.addMouseListener(dashboardController);
		   logOutNavLbl.setForeground(new Color(242, 230, 87));
		   navPanel.add(logOutNavLbl);
		   
		    statisticalchart = new JLabel("Statistical chart");
		   statisticalchart.setOpaque(true);
		   statisticalchart.setForeground(new Color(242, 230, 87));
		   statisticalchart.setFont(new Font("Dialog", Font.BOLD, 15));
		   statisticalchart.setBackground(new Color(51, 51, 102));
		   statisticalchart.setBounds(1, 424, 250, 50);
		   navPanel.add(statisticalchart);
		   statisticalchart.addMouseListener(dashboardController);
		   
		    Chatlb1 = new JLabel("Chat");
		   Chatlb1.setOpaque(true);
		   Chatlb1.setForeground(new Color(242, 230, 87));
		   Chatlb1.setFont(new Font("Dialog", Font.BOLD, 15));
		   Chatlb1.setBackground(new Color(51, 51, 102));
		   Chatlb1.setBounds(1, 578, 250, 50);
		   navPanel.add(Chatlb1);
		   
		   String xinchao = "xin chao  " + accountReturn.getFullName();
		   JLabel xinchaoLbl = new JLabel(xinchao);
		   xinchaoLbl.setFont(new Font("JetBrainsMono Nerd Font", Font.BOLD, 17));
		   xinchaoLbl.setBounds(11, 474, 208, 86);
		   navPanel.add(xinchaoLbl);
		   Chatlb1.addMouseListener(dashboardController);
	}
	
	public void clickSupplierNav() {
		this.tabbedPane.setSelectedIndex(4);
		supplierNavLbl.setBackground(new Color(25, 25, 112));
		supplierNavLbl.setForeground(Color.WHITE);
		
		statisticalchart.setBackground(new Color(51, 51, 102));
		statisticalchart.setForeground(new Color(242, 230, 87));	
		productNavLbl.setBackground(new Color(51, 51, 102));
		importProductNavLbl.setBackground(new Color(51, 51, 102));
		importProductNavLbl.setForeground(new Color(242, 230, 87));		   
		importCouponNavLbl.setBackground(new Color(51, 51, 102));
		importCouponNavLbl.setForeground(new Color(242, 230, 87));		   
		exportProductNavLbl.setBackground(new Color(51, 51, 102));
		exportProductNavLbl.setForeground(new Color(242, 230, 87));		   
		exportCouponNavLbl.setBackground(new Color(51, 51, 102));
		exportCouponNavLbl.setForeground(new Color(242, 230, 87));		   
		accountNavLbl.setBackground(new Color(51, 51, 102));
		accountNavLbl.setForeground(new Color(242, 230, 87));
		Chatlb1.setBackground(new Color(51, 51, 102));
		Chatlb1.setForeground(new Color(242, 230, 87));	
	}
	public void clickProductNav() {
		this.tabbedPane.setSelectedIndex(0);  
		productNavLbl.setBackground(new Color(25, 25, 112));
		productNavLbl.setForeground(Color.WHITE);
		
		statisticalchart.setBackground(new Color(51, 51, 102));
		statisticalchart.setForeground(new Color(242, 230, 87));	
		supplierNavLbl.setBackground(new Color(51, 51, 102));
		supplierNavLbl.setForeground(new Color(242, 230, 87));
		importProductNavLbl.setBackground(new Color(51, 51, 102));
		importProductNavLbl.setForeground(new Color(242, 230, 87));		   
		importCouponNavLbl.setBackground(new Color(51, 51, 102));
		importCouponNavLbl.setForeground(new Color(242, 230, 87));		   
		exportProductNavLbl.setBackground(new Color(51, 51, 102));
		exportProductNavLbl.setForeground(new Color(242, 230, 87));		   
		exportCouponNavLbl.setBackground(new Color(51, 51, 102));
		exportCouponNavLbl.setForeground(new Color(242, 230, 87));		   
		accountNavLbl.setBackground(new Color(51, 51, 102));
		accountNavLbl.setForeground(new Color(242, 230, 87));
		Chatlb1.setBackground(new Color(51, 51, 102));
		Chatlb1.setForeground(new Color(242, 230, 87));	
	}
	public void clickImportProductNav() {
		importProductNavLbl.setBackground(new Color(25, 25, 112));
		importProductNavLbl.setForeground(Color.WHITE);
		this.tabbedPane.setSelectedIndex(2);
		
		productNavLbl.setBackground(new Color(51, 51, 102));
		productNavLbl.setForeground(new Color(242, 230, 87));	
		supplierNavLbl.setBackground(new Color(51, 51, 102));
		supplierNavLbl.setForeground(new Color(242, 230, 87));
		statisticalchart.setBackground(new Color(51, 51, 102));
		statisticalchart.setForeground(new Color(242, 230, 87));	
		importCouponNavLbl.setBackground(new Color(51, 51, 102));
		importCouponNavLbl.setForeground(new Color(242, 230, 87));		   
		exportProductNavLbl.setBackground(new Color(51, 51, 102));
		exportProductNavLbl.setForeground(new Color(242, 230, 87));		   
		exportCouponNavLbl.setBackground(new Color(51, 51, 102));
		exportCouponNavLbl.setForeground(new Color(242, 230, 87));		   
		accountNavLbl.setBackground(new Color(51, 51, 102));
		accountNavLbl.setForeground(new Color(242, 230, 87));
		Chatlb1.setBackground(new Color(51, 51, 102));
		Chatlb1.setForeground(new Color(242, 230, 87));	
	}
	public void clickImportCouponNav() {
		this.tabbedPane.setSelectedIndex(5);
		importCouponNavLbl.setBackground(new Color(25, 25, 112));
		importCouponNavLbl.setForeground(Color.WHITE);
		
		productNavLbl.setBackground(new Color(51, 51, 102));
		productNavLbl.setForeground(new Color(242, 230, 87));	
		supplierNavLbl.setBackground(new Color(51, 51, 102));
		supplierNavLbl.setForeground(new Color(242, 230, 87));
		importProductNavLbl.setBackground(new Color(51, 51, 102));
		importProductNavLbl.setForeground(new Color(242, 230, 87));		   
		statisticalchart.setBackground(new Color(51, 51, 102));
		statisticalchart.setForeground(new Color(242, 230, 87));	
		exportProductNavLbl.setBackground(new Color(51, 51, 102));
		exportProductNavLbl.setForeground(new Color(242, 230, 87));		   
		exportCouponNavLbl.setBackground(new Color(51, 51, 102));
		exportCouponNavLbl.setForeground(new Color(242, 230, 87));		   
		accountNavLbl.setBackground(new Color(51, 51, 102));
		accountNavLbl.setForeground(new Color(242, 230, 87));
		Chatlb1.setBackground(new Color(51, 51, 102));
		Chatlb1.setForeground(new Color(242, 230, 87));	
	}
	public void clickExportProductNav() {
		this.tabbedPane.setSelectedIndex(3);
		exportProductNavLbl.setBackground(new Color(25, 25, 112));
		exportProductNavLbl.setForeground(Color.WHITE);
		
		productNavLbl.setBackground(new Color(51, 51, 102));
		productNavLbl.setForeground(new Color(242, 230, 87));	
		supplierNavLbl.setBackground(new Color(51, 51, 102));
		supplierNavLbl.setForeground(new Color(242, 230, 87));
		importProductNavLbl.setBackground(new Color(51, 51, 102));
		importProductNavLbl.setForeground(new Color(242, 230, 87));		   
		importCouponNavLbl.setBackground(new Color(51, 51, 102));
		importCouponNavLbl.setForeground(new Color(242, 230, 87));		   
		statisticalchart.setBackground(new Color(51, 51, 102));
		statisticalchart.setForeground(new Color(242, 230, 87));	
		exportCouponNavLbl.setBackground(new Color(51, 51, 102));
		exportCouponNavLbl.setForeground(new Color(242, 230, 87));		   
		accountNavLbl.setBackground(new Color(51, 51, 102));
		accountNavLbl.setForeground(new Color(242, 230, 87));
		Chatlb1.setBackground(new Color(51, 51, 102));
		Chatlb1.setForeground(new Color(242, 230, 87));	
	}
	public void clickExportCouponNav() {
		this.tabbedPane.setSelectedIndex(6);
		exportCouponNavLbl.setBackground(new Color(25, 25, 112));
		exportCouponNavLbl.setForeground(Color.WHITE);
		
		productNavLbl.setBackground(new Color(51, 51, 102));
		productNavLbl.setForeground(new Color(242, 230, 87));	
		supplierNavLbl.setBackground(new Color(51, 51, 102));
		supplierNavLbl.setForeground(new Color(242, 230, 87));
		importProductNavLbl.setBackground(new Color(51, 51, 102));
		importProductNavLbl.setForeground(new Color(242, 230, 87));		   
		importCouponNavLbl.setBackground(new Color(51, 51, 102));
		importCouponNavLbl.setForeground(new Color(242, 230, 87));		   
		exportProductNavLbl.setBackground(new Color(51, 51, 102));
		exportProductNavLbl.setForeground(new Color(242, 230, 87));		   
		statisticalchart.setBackground(new Color(51, 51, 102));
		statisticalchart.setForeground(new Color(242, 230, 87));	
		accountNavLbl.setBackground(new Color(51, 51, 102));
		accountNavLbl.setForeground(new Color(242, 230, 87));
		Chatlb1.setBackground(new Color(51, 51, 102));
		Chatlb1.setForeground(new Color(242, 230, 87));	
	}
	public void clickAccountNav() {
		this.tabbedPane.setSelectedIndex(1);
		accountNavLbl.setBackground(new Color(25, 25, 112));
		accountNavLbl.setForeground(Color.WHITE);
		
		productNavLbl.setBackground(new Color(51, 51, 102));
		productNavLbl.setForeground(new Color(242, 230, 87));	
		supplierNavLbl.setBackground(new Color(51, 51, 102));
		supplierNavLbl.setForeground(new Color(242, 230, 87));
		importProductNavLbl.setBackground(new Color(51, 51, 102));
		importProductNavLbl.setForeground(new Color(242, 230, 87));		   
		importCouponNavLbl.setBackground(new Color(51, 51, 102));
		importCouponNavLbl.setForeground(new Color(242, 230, 87));		   
		exportProductNavLbl.setBackground(new Color(51, 51, 102));
		exportProductNavLbl.setForeground(new Color(242, 230, 87));		   
		exportCouponNavLbl.setBackground(new Color(51, 51, 102));
		exportCouponNavLbl.setForeground(new Color(242, 230, 87));	
		statisticalchart.setBackground(new Color(51, 51, 102));
		statisticalchart.setForeground(new Color(242, 230, 87));	
		Chatlb1.setBackground(new Color(51, 51, 102));
		Chatlb1.setForeground(new Color(242, 230, 87));	
	}
	public void clickStatisticalNav() {
		statisticalchart.setBackground(new Color(25, 25, 112));
		statisticalchart.setForeground(Color.WHITE);
		this.tabbedPane.setSelectedIndex(7);
		
		productNavLbl.setBackground(new Color(51, 51, 102));
		productNavLbl.setForeground(new Color(242, 230, 87));	
		supplierNavLbl.setBackground(new Color(51, 51, 102));
		supplierNavLbl.setForeground(new Color(242, 230, 87));
		importProductNavLbl.setBackground(new Color(51, 51, 102));
		importProductNavLbl.setForeground(new Color(242, 230, 87));		   
		importCouponNavLbl.setBackground(new Color(51, 51, 102));
		importCouponNavLbl.setForeground(new Color(242, 230, 87));		   
		exportProductNavLbl.setBackground(new Color(51, 51, 102));
		exportProductNavLbl.setForeground(new Color(242, 230, 87));		   
		exportCouponNavLbl.setBackground(new Color(51, 51, 102));
		exportCouponNavLbl.setForeground(new Color(242, 230, 87));	
		Chatlb1.setBackground(new Color(51, 51, 102));
		Chatlb1.setForeground(new Color(242, 230, 87));	

	}
	public void clickChatlb1() {
		Chatlb1.setBackground(new Color(25, 25, 112));
		Chatlb1.setForeground(Color.WHITE);
		Login view = new Login();
		view.setUserName("Admin");
		view.setVisible(true);
		
		
		productNavLbl.setBackground(new Color(51, 51, 102));
		productNavLbl.setForeground(new Color(242, 230, 87));	
		supplierNavLbl.setBackground(new Color(51, 51, 102));
		supplierNavLbl.setForeground(new Color(242, 230, 87));
		importProductNavLbl.setBackground(new Color(51, 51, 102));
		importProductNavLbl.setForeground(new Color(242, 230, 87));		   
		importCouponNavLbl.setBackground(new Color(51, 51, 102));
		importCouponNavLbl.setForeground(new Color(242, 230, 87));		   
		exportProductNavLbl.setBackground(new Color(51, 51, 102));
		exportProductNavLbl.setForeground(new Color(242, 230, 87));		   
		exportCouponNavLbl.setBackground(new Color(51, 51, 102));
		exportCouponNavLbl.setForeground(new Color(242, 230, 87));	

	}
	public void clickMyInformation() {
		new MyInformationView(accountReturn);
	}
	public void clickLogoutNav() {
		Window window = SwingUtilities.getWindowAncestor(logOutNavLbl); 
        if (window != null) {
            window.dispose();
        }
	}
}