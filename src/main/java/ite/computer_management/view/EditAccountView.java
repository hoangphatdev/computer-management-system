
package ite.computer_management.view;

import java.awt.Color;
import java.awt.Font;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;
import javax.swing.border.EmptyBorder;

import org.apache.xmlbeans.impl.util.LongUTFDataInputStream;

import ite.computer_management.controller.EditAccountController;
import ite.computer_management.dao.AccountDAO;
import ite.computer_management.model.Account;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import javax.swing.SwingConstants; 
public class EditAccountView extends JFrame {

	private static final long serialVersionUID = 1L;
	private JPanel contentPane;
	public JTextField fullNameTxt;
	public JTextField userNameTxt;
	public JTextField passwordTxt;
	public JTextField roleTxt;
	public JButton updateBtn;
	public JButton refreshBtn;
	public JButton cancelBtn;
	public AccountView accountView;
	private JLabel titleLbl;

	public EditAccountView(AccountView accountView, Dashboard dashboard) {
		this.accountView = accountView;
		init();
		this.setLocationRelativeTo(null);
		this.setVisible(true);
	}
	public void init() {
		EditAccountController editAccountController = new EditAccountController(this);
		
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 638, 547);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));

		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JLabel fullNameLbl = new JLabel("Full Name");
		fullNameLbl.setHorizontalAlignment(SwingConstants.CENTER);
		fullNameLbl.setBounds(77, 122, 119, 49);
		fullNameLbl.setOpaque(true);
		fullNameLbl.setBackground(new Color(70, 163, 100));
		fullNameLbl.setForeground(new Color(219, 219, 219));
		contentPane.add(fullNameLbl);
		
		JLabel userNameLbl = new JLabel("User Name");
		userNameLbl.setHorizontalAlignment(SwingConstants.CENTER);
		userNameLbl.setBounds(77, 198, 119, 49);
		userNameLbl.setOpaque(true);
		userNameLbl.setBackground(new Color(70, 163, 100));
		userNameLbl.setForeground(new Color(219, 219, 219));
		contentPane.add(userNameLbl);
		
		JLabel passwordLbl = new JLabel("Password");
		passwordLbl.setHorizontalAlignment(SwingConstants.CENTER);
		passwordLbl.setBounds(77, 280,119, 49);
		passwordLbl.setOpaque(true);
		passwordLbl.setBackground(new Color(70, 163, 100));
		passwordLbl.setForeground(new Color(219, 219, 219));
		contentPane.add(passwordLbl);
		
		JLabel roleLbl = new JLabel("Role");
		roleLbl.setHorizontalAlignment(SwingConstants.CENTER);
		roleLbl.setBounds(77, 360,119, 48);
		roleLbl.setOpaque(true);
		roleLbl.setBackground(new Color(70, 163, 100));
		roleLbl.setForeground(new Color(219, 219, 219));
		contentPane.add(roleLbl);
		
		fullNameTxt = new JTextField();
		fullNameTxt.setBounds(197, 123, 349, 47);
		contentPane.add(fullNameTxt);
		fullNameTxt.setColumns(10);
		
		userNameTxt = new JTextField();
		userNameTxt.setColumns(10);
		userNameTxt.setBounds(197, 199, 349, 48);
		contentPane.add(userNameTxt);
		
		passwordTxt = new JTextField();
		passwordTxt.setColumns(10);
		passwordTxt.setBounds(197, 280, 349, 48);
		contentPane.add(passwordTxt);
		
		roleTxt = new JTextField();
		roleTxt.setColumns(10);
		roleTxt.setBounds(197, 360, 349, 48);
		contentPane.add(roleTxt);
		
		updateBtn = new JButton("UPDATE");
		updateBtn.setIcon(new ImageIcon(EditAccountView.class.getResource("/ite/computer_management/img/icons8-update-30.png")));
		updateBtn.setBounds(256, 441, 119, 43);
		updateBtn.setOpaque(true);
		updateBtn.setBackground(new Color(219, 219, 219));
		updateBtn.setForeground(new Color(70, 163, 100));
		updateBtn.addMouseListener(editAccountController);
		contentPane.add(updateBtn);
		
		cancelBtn = new JButton("CANCEL");
		cancelBtn.setIcon(new ImageIcon(EditAccountView.class.getResource("/ite/computer_management/img/icons8-cancel-30.png")));
		cancelBtn.setBounds(77, 441, 132, 43);
		cancelBtn.setOpaque(true);
		cancelBtn.setBackground(new Color(219, 219, 219));
		cancelBtn.setForeground(new Color(70, 163, 100));
		cancelBtn.addMouseListener(editAccountController);
		contentPane.add(cancelBtn);
		
		refreshBtn = new JButton("REFRESH");
		refreshBtn.setIcon(new ImageIcon(EditAccountView.class.getResource("/ite/computer_management/img/icons8-refresh-30.png")));
		refreshBtn.setBounds(414, 441, 132, 43);
		refreshBtn.setOpaque(true);
		refreshBtn.setBackground(new Color(219, 219, 219));
		refreshBtn.setForeground(new Color(70, 163, 100));
		refreshBtn.addMouseListener(editAccountController);
		contentPane.add(refreshBtn);
		
		titleLbl = new JLabel("EDIT ACCOUNT");
		titleLbl.setBounds(0, 0, 646, 102);
		titleLbl.setHorizontalAlignment(SwingConstants.CENTER);
		titleLbl.setFont(new Font("Hack", Font.BOLD, 24));
		titleLbl.setForeground(new Color(219, 219, 219));
		titleLbl.setBackground(new Color(70, 163, 100));
		titleLbl.setOpaque(true);
		titleLbl.setBounds(0, 0, 622, 102);
		contentPane.add(titleLbl);
	}

	public void clickUpdateBtn() {
		String fullName =fullNameTxt.getText();
		String userName = userNameTxt.getText();
		String password = passwordTxt.getText();
		String role = roleTxt.getText();
		Account account = new Account(fullName, userName, password, role);
		
		int selectedRowIndex =  accountView.table.getSelectedRow();
		String userNameCondition = (String) accountView.model.getValueAt(selectedRowIndex, 1);
		//back-end
		int check = AccountDAO.getInstance().update(account, userNameCondition);
		
			//front-end
			accountView.model.setValueAt(fullName, selectedRowIndex, 0);
			accountView.model.setValueAt(userName, selectedRowIndex, 1);
			accountView.model.setValueAt(password, selectedRowIndex, 2);
			accountView.model.setValueAt(role, selectedRowIndex, 3);
		
		
	}

	public void clickCancelBtn() {
		this.dispose();
	}

	public void clickRefreshBtn() {
		fullNameTxt.setText(null);
		userNameTxt.setText(null);
		passwordTxt.setText(null);
		roleTxt.setText(null);
		
	}

}

