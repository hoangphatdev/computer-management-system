package ite.computer_management.view;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import ite.computer_management.controller.DashboardForImportStaffController;

import java.awt.Color;
import javax.swing.JLabel;
import javax.swing.SwingConstants;
import javax.swing.JTabbedPane;
import javax.swing.ImageIcon;
import java.awt.Font;

public class DashboardForImportStaff extends JFrame {

	private static final long serialVersionUID = 1L;
	private JPanel contentPane;
	public JTabbedPane tabbedPane;
	public JLabel userNavLbl;
	public JLabel logOutNavLbl;
	public JLabel importCouponNavLbl;
	public JLabel importProductNavLbl;

	public JLabel Imports_ProductNavLbl;
	public JLabel Export_ProductNavLbl;
	public JPanel navPanel;

	public DashboardForImportStaff() {
		init();
		this.setLocationRelativeTo(null);
		this.setVisible(true);
	}

	public void init() {
		DashboardForImportStaffController dashboardController = new DashboardForImportStaffController(this);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		this.setSize(1500, 800);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);

		tabbedPane = new JTabbedPane(JTabbedPane.TOP);
		tabbedPane.setBounds(254, -20, 1250, 800);
		contentPane.add(tabbedPane);

		ImportsProductView ImportsProductView = new ImportsProductView();
		tabbedPane.addTab("Imports Product", ImportsProductView);
		ImportCouponView importCouponView = new ImportCouponView();
		tabbedPane.addTab("Import coupon", importCouponView);

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

		importProductNavLbl = new JLabel("Import Product");
		importProductNavLbl.setIcon(new ImageIcon(
				"C:\\Users\\latru\\Desktop\\computer_management\\src\\main\\java\\ite\\computer_management\\img\\icons8-import-goods-filled-outline\\icons8-import-goods-32.png"));
		importProductNavLbl.setOpaque(true);
		importProductNavLbl.setFont(new Font("Lato", Font.BOLD, 15));
		importProductNavLbl.setBackground(new Color(51, 51, 102));
		importProductNavLbl.setBounds(1, 244, 250, 45);
		importProductNavLbl.addMouseListener(dashboardController);
		importProductNavLbl.setForeground(new Color(242, 230, 87));
		navPanel.add(importProductNavLbl);

		importCouponNavLbl = new JLabel("Import Coupon");
		importCouponNavLbl.setIcon(new ImageIcon(
				"C:\\Users\\latru\\Desktop\\computer_management\\src\\main\\java\\ite\\computer_management\\img\\icons8-note-30.png"));
		importCouponNavLbl.setOpaque(true);
		importCouponNavLbl.setFont(new Font("Lato", Font.BOLD, 15));
		importCouponNavLbl.setBackground(new Color(51, 51, 102));
		importCouponNavLbl.setBounds(1, 287, 250, 45);
		importCouponNavLbl.addMouseListener(dashboardController);
		importCouponNavLbl.setForeground(new Color(242, 230, 87));
		navPanel.add(importCouponNavLbl);

		userNavLbl = new JLabel("User");
		userNavLbl.setIcon(new ImageIcon(
				"C:\\Users\\latru\\Desktop\\computer_management\\src\\main\\java\\ite\\computer_management\\img\\icons8-user-office-m\\icons8-user-30.png"));
		userNavLbl.setOpaque(true);
		userNavLbl.setFont(new Font("Lato", Font.BOLD, 15));
		userNavLbl.setBackground(new Color(51, 51, 102));
		userNavLbl.setBounds(0, 668, 250, 45);
		userNavLbl.addMouseListener(dashboardController);
		userNavLbl.setForeground(new Color(242, 230, 87));
		navPanel.add(userNavLbl);
		logOutNavLbl = new JLabel("Log out");
		logOutNavLbl.setIcon(new ImageIcon(
				"C:\\Users\\latru\\Desktop\\computer_management\\src\\main\\java\\ite\\computer_management\\img\\log out\\icons8-log-out-32.png"));
		logOutNavLbl.setOpaque(true);
		logOutNavLbl.setFont(new Font("Lato", Font.BOLD, 15));
		logOutNavLbl.setBackground(new Color(51, 51, 102));
		logOutNavLbl.setBounds(0, 712, 250, 50);
		logOutNavLbl.addMouseListener(dashboardController);
		logOutNavLbl.setForeground(new Color(242, 230, 87));
		navPanel.add(logOutNavLbl);
	}

	public void clickImportProductNav() {
		importProductNavLbl.setBackground(new Color(25, 25, 112));
		importProductNavLbl.setForeground(Color.WHITE);
		this.tabbedPane.setSelectedIndex(0);
		importCouponNavLbl.setBackground(new Color(51, 51, 102));
		importCouponNavLbl.setForeground(new Color(242, 230, 87));
	}

	public void clickImportCouponNav() {
		this.tabbedPane.setSelectedIndex(1);
		importCouponNavLbl.setBackground(new Color(25, 25, 112));
		importCouponNavLbl.setForeground(Color.WHITE);
		importProductNavLbl.setBackground(new Color(51, 51, 102));
		importProductNavLbl.setForeground(new Color(242, 230, 87));
	}

	public void clickUserNav() {
		this.setVisible(false);
	}

	public void clickLogoutNav() {

	}
}