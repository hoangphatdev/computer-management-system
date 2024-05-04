
package ite.computer_management.view;

import java.awt.Color;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;
import javax.swing.border.EmptyBorder;

import ite.computer_management.controller.EditAccountController;
import ite.computer_management.dao.AccountDAO;
import ite.computer_management.model.Account; 
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

	public EditAccountView(AccountView accountView, Dashboard dashboard) {
		this.accountView = accountView;
		init();
		this.setLocationRelativeTo(null);
		this.setVisible(true);
	}
	public void init() {
		EditAccountController editAccountController = new EditAccountController(this);
		
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 938, 590);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));

		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JLabel fullNameLbl = new JLabel("Full Name");
		fullNameLbl.setBounds(71, 52, 131, 24);
		contentPane.add(fullNameLbl);
		
		JLabel userNameLbl = new JLabel("User Name");
		userNameLbl.setBounds(232, 52, 131, 24);
		contentPane.add(userNameLbl);
		
		JLabel passwordLbl = new JLabel("Password");
		passwordLbl.setBounds(415, 52, 131, 24);
		contentPane.add(passwordLbl);
		
		JLabel roleLbl = new JLabel("Role");
		roleLbl.setBounds(606, 52, 131, 24);
		contentPane.add(roleLbl);
		
		fullNameTxt = new JTextField();
		fullNameTxt.setBounds(65, 86, 147, 24);
		contentPane.add(fullNameTxt);
		fullNameTxt.setColumns(10);
		
		userNameTxt = new JTextField();
		userNameTxt.setColumns(10);
		userNameTxt.setBounds(216, 86, 147, 24);
		contentPane.add(userNameTxt);
		
		passwordTxt = new JTextField();
		passwordTxt.setColumns(10);
		passwordTxt.setBounds(373, 86, 147, 24);
		contentPane.add(passwordTxt);
		
		roleTxt = new JTextField();
		roleTxt.setColumns(10);
		roleTxt.setBounds(541, 86, 147, 24);
		contentPane.add(roleTxt);
		
		updateBtn = new JButton("UPDATE");
		updateBtn.setBounds(71, 390, 110, 30);
		updateBtn.addMouseListener(editAccountController);
		contentPane.add(updateBtn);
		
		cancelBtn = new JButton("CANCEL");
		cancelBtn.setBounds(246, 395, 110, 30);
		cancelBtn.addMouseListener(editAccountController);
		contentPane.add(cancelBtn);
		
		refreshBtn = new JButton("REFRESH");
		refreshBtn.setBounds(436, 390, 110, 30);
		refreshBtn.addMouseListener(editAccountController);
		contentPane.add(refreshBtn);
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

