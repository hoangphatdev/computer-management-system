package ite.computer_management.view;

import java.awt.Color;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JLabel;
import javax.swing.SwingConstants;
import java.awt.Font;
import javax.swing.JTextField;
import javax.swing.JTabbedPane;
import javax.swing.JButton;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

public class MyInformationView extends JFrame {

	private static final long serialVersionUID = 1L;
	private JPanel contentPane;
	public JLabel changePasswordBtn;
	public JLabel informationBtn; 

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					MyInformationView frame = new MyInformationView();
					frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the frame.
	 */
	public MyInformationView() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 696, 563);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));

		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JLabel titleLbl = new JLabel("My Infomation");
		titleLbl.setFont(new Font("Roboto", Font.BOLD, 23));
		titleLbl.setHorizontalAlignment(SwingConstants.CENTER);
		titleLbl.setBounds(0, 0, 696, 150);
		titleLbl.setOpaque(true);
		titleLbl.setBackground(new Color(46, 42, 36));
		titleLbl.setForeground(new Color(207, 151, 68));
		contentPane.add(titleLbl);
		
		JTabbedPane tabbedPane = new JTabbedPane(JTabbedPane.TOP);
		tabbedPane.setBounds(0, 228, 696, 289);
		Sub1MyInformation sub1MyInformation = new Sub1MyInformation();
		tabbedPane.add(sub1MyInformation);
		contentPane.add(tabbedPane);
		
		Sub2MyInformation sub2MyInformation = new Sub2MyInformation();
		tabbedPane.add(sub2MyInformation);
		
		informationBtn = new JLabel("Information");
		informationBtn.setHorizontalAlignment(SwingConstants.CENTER);
		informationBtn.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				changePasswordBtn.setBackground(new Color(130, 122, 111));
				changePasswordBtn.setForeground(new Color(209, 204, 197));
				informationBtn.setBackground(new Color(51, 46, 39));
				informationBtn.setForeground(new Color(237, 170, 76));
				tabbedPane.setSelectedIndex(0);
			}
		});
		informationBtn.setFont(new Font("Roboto Medium", Font.PLAIN, 15));
		informationBtn.setBounds(0, 178, 344, 39);
		informationBtn.setOpaque(true);
		informationBtn.setBackground(new Color(51, 46, 39));
		informationBtn.setForeground(new Color(237, 170, 76));
		contentPane.add(informationBtn);
		
		changePasswordBtn = new JLabel("Change Password");
		changePasswordBtn.setHorizontalAlignment(SwingConstants.CENTER);
		changePasswordBtn.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				changePasswordBtn.setBackground(new Color(51, 46, 39));
				changePasswordBtn.setForeground(new Color(237, 170, 76));
				informationBtn.setBackground(new Color(130, 122, 111));
				informationBtn.setForeground(new Color(209, 204, 197));
				tabbedPane.setSelectedIndex(1);
			}
		});
		changePasswordBtn.setFont(new Font("Roboto Medium", Font.PLAIN, 15));
		changePasswordBtn.setBounds(346, 178, 350, 39);
		changePasswordBtn.setOpaque(true);
		changePasswordBtn.setBackground(new Color(130, 122, 111));
		changePasswordBtn.setForeground(new Color(209, 204, 197));
		contentPane.add(changePasswordBtn);
		
		JButton cancelBtn = new JButton("Cancel");
		cancelBtn.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				clickCancel();
			}
		});
		cancelBtn.setBounds(253, 522, 215, 30);
		contentPane.add(cancelBtn);
		
		this.setUndecorated(true);
		this.setLocationRelativeTo(null);
		this.setVisible(true);
	}
	public void clickCancel() {
		this.dispose();
	}
}