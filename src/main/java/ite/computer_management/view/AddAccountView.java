
package ite.computer_management.view;

import java.awt.Color;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

import ite.computer_management.controller.AddAccountController;
import ite.computer_management.dao.AccountDAO;
import ite.computer_management.model.Account;

import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.SwingConstants;
import javax.swing.JTextField;
import java.awt.Font;
import javax.swing.ImageIcon;
import javax.swing.JPasswordField;

public class AddAccountView extends JFrame {

	private static final long serialVersionUID = 1L;
	private JPanel contentPane;
	private JTextField fullNameTxt;
	private JTextField userNameTxt;
	private JTextField roleTxt;
	public JButton addBtn;
	public JButton cancelBtn;
	public JButton refreshBtn;
	public AccountView accountView;
	public Dashboard dashboard;
	private JPasswordField passwordTxt;

	public AddAccountView(AccountView accountView, Dashboard dashboard) {
		this.accountView = accountView;
		this.dashboard = dashboard;
		init();
		this.setLocationRelativeTo(null);
		this.setUndecorated(true);
		this.setVisible(true);
		
	}
	public void init() {
		AddAccountController addAccountController = new AddAccountController(this);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 619, 532);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));

		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		addBtn = new JButton("ADD");
		addBtn.setIcon(new ImageIcon("C:\\Users\\latru\\Desktop\\computer_management\\src\\main\\java\\ite\\computer_management\\img\\add 20.png"));
		addBtn.setBounds(241, 389, 121, 37);
		addBtn.addMouseListener(addAccountController);
		contentPane.add(addBtn);
		
		cancelBtn = new JButton("CANCEL");
		cancelBtn.setIcon(new ImageIcon("C:\\Users\\latru\\Desktop\\computer_management\\src\\main\\java\\ite\\computer_management\\img\\cancel 20.png"));
		cancelBtn.setBounds(463, 389, 121, 37);
		cancelBtn.addMouseListener(addAccountController);
		contentPane.add(cancelBtn);
		
		refreshBtn = new JButton("REFRESH");
		refreshBtn.setIcon(new ImageIcon("C:\\Users\\latru\\Desktop\\computer_management\\src\\main\\java\\ite\\computer_management\\img\\reload 20.png"));
		refreshBtn.setBounds(22, 389, 121, 37);
		refreshBtn.addMouseListener(addAccountController);
		contentPane.add(refreshBtn);
		
		JLabel fullNameLbl = new JLabel("Full Name");
		fullNameLbl.setFont(new Font("Inter", Font.BOLD, 13));
		fullNameLbl.setHorizontalAlignment(SwingConstants.CENTER);
		fullNameLbl.setBounds(105, 141, 138, 35);
		fullNameLbl.setBackground(new Color(70, 163, 100));
		fullNameLbl.setForeground(new Color(219, 219, 219));
		fullNameLbl.setOpaque(true);
		contentPane.add(fullNameLbl);
		
		JLabel userNameLbl = new JLabel("User Name");
		userNameLbl.setFont(new Font("Inter", Font.BOLD, 13));
		userNameLbl.setHorizontalAlignment(SwingConstants.CENTER);
		userNameLbl.setBounds(105, 194, 138, 35);
		userNameLbl.setBackground(new Color(70, 163, 100));
		userNameLbl.setForeground(new Color(219, 219, 219));
		userNameLbl.setOpaque(true);
		contentPane.add(userNameLbl);
		
		JLabel passwordLbl = new JLabel("Password");
		passwordLbl.setFont(new Font("Inter", Font.BOLD, 13));
		passwordLbl.setHorizontalAlignment(SwingConstants.CENTER);
		passwordLbl.setBounds(105, 251, 138, 35);
		passwordLbl.setBackground(new Color(70, 163, 100));
		passwordLbl.setForeground(new Color(219, 219, 219));
		passwordLbl.setOpaque(true);
		contentPane.add(passwordLbl);
		
		JLabel roleLbl = new JLabel("Role");
		roleLbl.setFont(new Font("Inter", Font.BOLD, 13));
		roleLbl.setHorizontalAlignment(SwingConstants.CENTER);
		roleLbl.setBounds(105, 306, 138, 35);
		roleLbl.setBackground(new Color(70, 163, 100));
		roleLbl.setForeground(new Color(219, 219, 219));
		roleLbl.setOpaque(true);
		contentPane.add(roleLbl);
		
		fullNameTxt = new JTextField();
		fullNameTxt.setFont(new Font("Roboto", Font.PLAIN, 15));
		fullNameTxt.setBounds(242, 141, 258, 35);
		contentPane.add(fullNameTxt);
		fullNameTxt.setColumns(10);
		
		userNameTxt = new JTextField();
		userNameTxt.setFont(new Font("Roboto", Font.PLAIN, 15));
		userNameTxt.setColumns(10);
		userNameTxt.setBounds(242, 194, 258, 35);
		contentPane.add(userNameTxt);
		
		roleTxt = new JTextField();
		roleTxt.setFont(new Font("Roboto", Font.PLAIN, 15));
		roleTxt.setColumns(10);
		roleTxt.setBounds(242, 306, 258, 35);
		contentPane.add(roleTxt);
		
		JLabel titleLbl = new JLabel("ADD ACCOUNT");
		titleLbl.setFont(new Font("Bakery", Font.PLAIN, 28));
		titleLbl.setHorizontalAlignment(SwingConstants.CENTER);
		titleLbl.setBounds(0, 0, 621, 109);
		titleLbl.setBackground(new Color(70, 163, 100));
		titleLbl.setForeground(new Color(219, 219, 219));
		titleLbl.setOpaque(true);
		contentPane.add(titleLbl);
		
		passwordTxt = new JPasswordField();
		passwordTxt.setBounds(241, 251, 259, 35);
		contentPane.add(passwordTxt);
	}
	public void clickAddBtn() {
		String fullName = fullNameTxt.getText();
		String userName = userNameTxt.getText();
		char[] passwordChars = passwordTxt.getPassword();
	    String password = new String(passwordChars); 
		String role = roleTxt.getText();
		  if (!isValidPassword(password)) {
		        JOptionPane.showMessageDialog(this,"Mật khẩu phải có ít nhất 1 chữ hoa, 1 ký tự đặc biệt và tối đa 20 ký tự!");
		        return;	
		    }

		Account account = new Account(fullName, userName, password, role);
		int check = AccountDAO.getInstance().insert(account);
		
		if(check ==1) {
			String data[] = {fullName, userName, password, role};
			accountView.model.addRow(data);
		}
	}
	private boolean isValidPassword(String password) {
	    if (password.length() > 20) {
	        return false;
	    }
	    boolean hasUpperCase = false;
	    boolean hasSpecialChar = false;
	    for (char c : password.toCharArray()) {
	        if (Character.isUpperCase(c)) {
	            hasUpperCase = true;
	        } else if (!Character.isLetterOrDigit(c)) {
	            hasSpecialChar = true;
	        }
	    }
	    return hasUpperCase && hasSpecialChar;
	}
	public void clickCancelBtn() {
		this.dispose();
		dashboard.setVisible(true);
	}
	public void clickRefreshBtn() {
		fullNameTxt.setText(null);
		userNameTxt.setText(null);
		passwordTxt.setText(null);
		roleTxt.setText(null);
	}
}