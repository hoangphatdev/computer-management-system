package ite.computer_management.view;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

import ite.computer_management.controller.LogInController;
import ite.computer_management.dao.AccountDAO;
import ite.computer_management.model.Account;

import javax.swing.JLabel;
import javax.swing.JOptionPane;

import java.awt.Font;
import java.awt.Color;
import javax.swing.JTextField;
import javax.swing.JRadioButton;
import javax.swing.JPasswordField;
import javax.swing.JButton;
import javax.swing.Box;
import javax.swing.border.BevelBorder;
import java.awt.event.ActionListener;
import java.beans.Statement;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.awt.event.ActionEvent;
import javax.swing.JToggleButton;
import java.awt.SystemColor;
import java.awt.Toolkit;
import javax.swing.ImageIcon;

public class LogInView extends JFrame {

	private static final long serialVersionUID = 1L;
	private JPanel contentPane;
	public JTextField userNameTxt;
	public JPasswordField passwordTxt;
	public JButton logInBtn;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					LogInView frame = new LogInView();
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
	public String getUserName() {
		return userNameTxt.getText();
    }
	public LogInView() {
		LogInController logInController = new LogInController(this);
		setTitle("Computer manegement");
		setIconImage(Toolkit.getDefaultToolkit().getImage(
				"D:\\JAVA_project\\computer-management-system\\src\\main\\java\\ite\\computer_management\\img\\lgo - Copy - Copy.png"));
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 935, 568);
		contentPane = new JPanel();
		contentPane.setBackground(new Color(152, 251, 152));
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setLocationRelativeTo(null);
		setContentPane(contentPane);
		contentPane.setLayout(null);

		JLabel taikhoan = new JLabel("User name:");
		taikhoan.setForeground(SystemColor.window);
		taikhoan.setFont(new Font("Arial", Font.BOLD, 17));
		taikhoan.setBounds(331, 159, 115, 29);
		contentPane.add(taikhoan);

		userNameTxt = new JTextField();
		userNameTxt.setBounds(331, 194, 232, 29);
		contentPane.add(userNameTxt);
		userNameTxt.setColumns(10);

		JLabel mk = new JLabel("Password:");
		mk.setForeground(SystemColor.window);
		mk.setFont(new Font("Arial", Font.BOLD, 17));
		mk.setBounds(331, 233, 115, 29);
		contentPane.add(mk);

		passwordTxt = new JPasswordField();
		passwordTxt.setBounds(331, 265, 232, 27);
		contentPane.add(passwordTxt);

		JButton btn_changepass = new JButton("CHANGE PASS");
		btn_changepass.setBackground(SystemColor.activeCaptionBorder);

		btn_changepass.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				ChangepassView view = new ChangepassView();
				view.setVisible(true);
				dispose();

			}
		});

		btn_changepass.setFont(new Font("Arial", Font.BOLD, 14));
		btn_changepass.setBounds(331, 346, 143, 29);
		contentPane.add(btn_changepass);

		logInBtn = new JButton("LOG IN");
		logInBtn.setBackground(SystemColor.activeCaptionBorder);
		logInBtn.setFont(new Font("Arial", Font.BOLD, 14));
		logInBtn.setBounds(435, 308, 128, 29);
		logInBtn.addMouseListener(logInController);
		contentPane.add(logInBtn);

		JButton Nut_thoat = new JButton("Cancel");
		Nut_thoat.setIcon(new ImageIcon("C:\\Users\\LENOVO\\Desktop\\anhhhhhhhhh\\Screenshot 2023-12-23 152951.png"));
		Nut_thoat.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				System.exit(0);
			}
		});
		Nut_thoat.setBackground(SystemColor.activeCaptionBorder);
		Nut_thoat.setFont(new Font("Arial", Font.BOLD, 12));
		Nut_thoat.setBounds(484, 347, 79, 29);
		contentPane.add(Nut_thoat);

		JToggleButton Nut_hienMK = new JToggleButton("");
		Nut_hienMK.setIcon(new ImageIcon("C:\\Users\\LENOVO\\Desktop\\anhhhhhhhhh\\Screenshot 2023-12-23 194914.png"));
		Nut_hienMK.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				if (Nut_hienMK.isSelected()) {
					passwordTxt.setEchoChar('\0');
				} else {
					passwordTxt.setEchoChar('*');
				}

			}
		});
		Nut_hienMK.setFont(new Font("Arial", Font.BOLD, 18));
		Nut_hienMK.setBackground(Color.LIGHT_GRAY);
		Nut_hienMK.setForeground(Color.BLACK);
		Nut_hienMK.setBounds(510, 232, 53, 22);
		contentPane.add(Nut_hienMK);

		JLabel dangnhap_1 = new JLabel("");
		dangnhap_1.setIcon(new ImageIcon(
				"D:\\JAVA_project\\computer-management-system\\src\\main\\java\\ite\\computer_management\\img\\lgo - Copy - Copy.png"));
		dangnhap_1.setFont(new Font("Arial", Font.BOLD, 27));
		dangnhap_1.setBounds(450, 39, 154, 114);
		contentPane.add(dangnhap_1);

		JLabel dangnhap_1_1 = new JLabel("");
		dangnhap_1_1.setIcon(new ImageIcon("D:\\C++ Tren lop\\chap7\\Screenshot 2023-12-06 202316.png"));
		dangnhap_1_1.setFont(new Font("Arial", Font.BOLD, 27));
		dangnhap_1_1.setBounds(275, 39, 184, 114);
		contentPane.add(dangnhap_1_1);

		Box verticalBox = Box.createVerticalBox();
		verticalBox.setBorder(new BevelBorder(BevelBorder.LOWERED, null, null, null, null));
		verticalBox.setBounds(269, 117, 335, 303);
		contentPane.add(verticalBox);
		
				JLabel dangnhap_1_2 = new JLabel("");
				verticalBox.add(dangnhap_1_2);
				dangnhap_1_2.setIcon(new ImageIcon(
						"D:\\JAVA_project\\computer-management-system\\src\\main\\java\\ite\\computer_management\\img\\backkkkkkkê.jpg"));
				dangnhap_1_2.setFont(new Font("Arial", Font.BOLD, 27));

		JLabel lblLogIn = new JLabel("LOG IN ");
		lblLogIn.setForeground(new Color(0, 0, 0));
		lblLogIn.setFont(new Font("Freestyle Script", Font.BOLD, 74));
		lblLogIn.setBounds(32, 115, 341, 177);
		contentPane.add(lblLogIn);

		this.setLocationRelativeTo(null);
		this.setVisible(true);
	}

	public void clickLogInBtn() {
		String userNameEnter = userNameTxt.getText();
		 char[] passwordChars = passwordTxt.getPassword(); 
		    String passwordEnter = new String(passwordChars);
		Account account = new Account(userNameEnter, passwordEnter);
		System.out.print(passwordEnter);

		Account accountReturn = AccountDAO.getInstance().select1AccountAndReturnRole(account);
		
		 if (accountReturn != null && accountReturn.getPassword() != null) { 
		        if (accountReturn.getPassword().equals(passwordEnter)) {       
		            String role = accountReturn.getRole(); 
		            if (role != null && role.equalsIgnoreCase("manager")) {
		            	JOptionPane.showMessageDialog(null, "Welcome to IEC");
		                new DashboardForManager(accountReturn);
		                this.dispose();
		            } else if (role != null && role.equalsIgnoreCase("importStaff")) {
		            	JOptionPane.showMessageDialog(null, "Welcome to IEC");
		                new DashboardForImportStaff(accountReturn);
		                this.dispose();
		            } else if (role != null && role.equalsIgnoreCase("exportStaff")) {
		            	JOptionPane.showMessageDialog(null, "Welcome to IEC");
		                new DashboardForExportStaff(accountReturn);
		                this.dispose();
		            } else if (role != null && role.equalsIgnoreCase("admin")) {
		            	JOptionPane.showMessageDialog(null, "Welcome to IEC");
		                new Dashboard(accountReturn);
		                this.dispose();
		            } else {
		       
		                JOptionPane.showMessageDialog(null, "The account does not have role.");
		            }
		        } else {
		            // Mật khẩu sai
		            JOptionPane.showMessageDialog(null, "Username or password is incorrect.");
		            passwordTxt.setText("");
		            for (int i = 0; i < passwordChars.length; i++) {
		                passwordChars[i] = 0;
		            }
		        }
		    } else {
		        // Tên người dùng sai hoặc tài khoản không tồn tại
		        JOptionPane.showMessageDialog(null, "Username or password is incorrect.");
		        passwordTxt.setText("");
		    }
		
	}
}