package ite.computer_management.view;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

import ite.computer_management.controller.DashboardForExportStaffController;

import java.awt.Color;
import javax.swing.JLabel;

import javax.swing.SwingConstants;
import javax.swing.JTabbedPane;
import javax.swing.ImageIcon;
import java.awt.Font;

public class DashboardForExportStaff extends JFrame {

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
	public JPanel navPanel;

	public DashboardForExportStaff() {
		init();
		this.setLocationRelativeTo(null);
		this.setVisible(true);
	}

	public void init() {
		DashboardForExportStaffController dashboardForExportStaffController = new DashboardForExportStaffController(
				this);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		this.setSize(1500, 800);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);

		tabbedPane = new JTabbedPane(JTabbedPane.TOP);
		tabbedPane.setBounds(254, -20, 1250, 800);
		contentPane.add(tabbedPane);

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

		exportProductNavLbl = new JLabel("Export Product");
		exportProductNavLbl.setIcon(new ImageIcon(
				"C:\\Users\\latru\\Desktop\\computer_management\\src\\main\\java\\ite\\computer_management\\img\\icons8-import-goods-filled-outline\\icons8-import-goods-32.png"));
		exportProductNavLbl.setOpaque(true);
		exportProductNavLbl.setFont(new Font("Lato", Font.BOLD, 15));
		exportProductNavLbl.setBackground(new Color(51, 51, 102));
		exportProductNavLbl.setBounds(1, 330, 250, 45);
		exportProductNavLbl.addMouseListener(dashboardForExportStaffController);
		exportProductNavLbl.setForeground(new Color(242, 230, 87));
		navPanel.add(exportProductNavLbl);

		exportCouponNavLbl = new JLabel("Export Coupon");
		exportCouponNavLbl.setIcon(new ImageIcon(
				"C:\\Users\\latru\\Desktop\\computer_management\\src\\main\\java\\ite\\computer_management\\img\\icons8-note-30.png"));
		exportCouponNavLbl.setOpaque(true);
		exportCouponNavLbl.setFont(new Font("Lato", Font.BOLD, 15));
		exportCouponNavLbl.setBackground(new Color(51, 51, 102));
		exportCouponNavLbl.setBounds(1, 374, 250, 50);
		exportCouponNavLbl.addMouseListener(dashboardForExportStaffController);
		exportCouponNavLbl.setForeground(new Color(242, 230, 87));
		navPanel.add(exportCouponNavLbl);

		userNavLbl = new JLabel("User");
		userNavLbl.setIcon(new ImageIcon(
				"C:\\Users\\latru\\Desktop\\computer_management\\src\\main\\java\\ite\\computer_management\\img\\icons8-user-office-m\\icons8-user-30.png"));
		userNavLbl.setOpaque(true);
		userNavLbl.setFont(new Font("Lato", Font.BOLD, 15));
		userNavLbl.setBackground(new Color(51, 51, 102));
		userNavLbl.setBounds(0, 668, 250, 45);
		userNavLbl.addMouseListener(dashboardForExportStaffController);
		userNavLbl.setForeground(new Color(242, 230, 87));
		navPanel.add(userNavLbl);

		logOutNavLbl = new JLabel("Log out");
		logOutNavLbl.setIcon(new ImageIcon(
				"C:\\Users\\latru\\Desktop\\computer_management\\src\\main\\java\\ite\\computer_management\\img\\log out\\icons8-log-out-32.png"));
		logOutNavLbl.setOpaque(true);
		logOutNavLbl.setFont(new Font("Lato", Font.BOLD, 15));
		logOutNavLbl.setBackground(new Color(51, 51, 102));
		logOutNavLbl.setBounds(0, 712, 250, 50);
		logOutNavLbl.addMouseListener(dashboardForExportStaffController);
		logOutNavLbl.setForeground(new Color(242, 230, 87));
		navPanel.add(logOutNavLbl);

	}

	public void clickExportProductNav() {
		this.tabbedPane.setSelectedIndex(0);
		exportProductNavLbl.setBackground(new Color(25, 25, 112));
		exportProductNavLbl.setForeground(Color.WHITE);

		exportCouponNavLbl.setBackground(new Color(51, 51, 102));
		exportCouponNavLbl.setForeground(new Color(242, 230, 87));
	}

	public void clickExportCouponNav() {
		this.tabbedPane.setSelectedIndex(1);
		exportCouponNavLbl.setBackground(new Color(25, 25, 112));
		exportCouponNavLbl.setForeground(Color.WHITE);

		exportProductNavLbl.setBackground(new Color(51, 51, 102));
		exportProductNavLbl.setForeground(new Color(242, 230, 87));
		
	}

	public void clickUserNav() {
		this.setVisible(false);
	}

	public void clickLogoutNav() {

	}
}