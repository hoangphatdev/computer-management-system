
package ite.computer_management.view;

import java.awt.Color;

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
		setBounds(100, 100, 567, 495);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));

		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JLabel fullNameLbl = new JLabel("Full Name");
		fullNameLbl.setBounds(65, 27, 102, 36);
		fullNameLbl.setOpaque(true);
		fullNameLbl.setBackground(new Color(70, 163, 100));
		fullNameLbl.setForeground(new Color(219, 219, 219));
		contentPane.add(fullNameLbl);
		
		JLabel userNameLbl = new JLabel("User Name");
		userNameLbl.setBounds(65, 113, 102, 36);
		userNameLbl.setOpaque(true);
		userNameLbl.setBackground(new Color(70, 163, 100));
		userNameLbl.setForeground(new Color(219, 219, 219));
		contentPane.add(userNameLbl);
		
		JLabel passwordLbl = new JLabel("Password");
		passwordLbl.setBounds(65, 194,102, 36);
		passwordLbl.setOpaque(true);
		passwordLbl.setBackground(new Color(70, 163, 100));
		passwordLbl.setForeground(new Color(219, 219, 219));
		contentPane.add(passwordLbl);
		
		JLabel roleLbl = new JLabel("Role");
		roleLbl.setBounds(65, 277,102, 36);
		roleLbl.setOpaque(true);
		roleLbl.setBackground(new Color(70, 163, 100));
		roleLbl.setForeground(new Color(219, 219, 219));
		contentPane.add(roleLbl);
		
		fullNameTxt = new JTextField();
		fullNameTxt.setBounds(168, 29, 336, 36);
		contentPane.add(fullNameTxt);
		fullNameTxt.setColumns(10);
		
		userNameTxt = new JTextField();
		userNameTxt.setColumns(10);
		userNameTxt.setBounds(168, 114, 336, 36);
		contentPane.add(userNameTxt);
		
		passwordTxt = new JTextField();
		passwordTxt.setColumns(10);
		passwordTxt.setBounds(168, 194, 336, 36);
		contentPane.add(passwordTxt);
		
		roleTxt = new JTextField();
		roleTxt.setColumns(10);
		roleTxt.setBounds(168, 277, 336, 36);
		contentPane.add(roleTxt);
		
		updateBtn = new JButton("UPDATE");
		updateBtn.setBounds(65, 354, 110, 30);
		updateBtn.setOpaque(true);
		updateBtn.setBackground(new Color(219, 219, 219));
		updateBtn.setForeground(new Color(70, 163, 100));
		updateBtn.addMouseListener(editAccountController);
		contentPane.add(updateBtn);
		
		cancelBtn = new JButton("CANCEL");
		cancelBtn.setBounds(227, 354, 110, 30);
		cancelBtn.setOpaque(true);
		cancelBtn.setBackground(new Color(219, 219, 219));
		cancelBtn.setForeground(new Color(70, 163, 100));
		cancelBtn.addMouseListener(editAccountController);
		contentPane.add(cancelBtn);
		
		refreshBtn = new JButton("REFRESH");
		refreshBtn.setBounds(390, 354, 110, 30);
		refreshBtn.setOpaque(true);
		refreshBtn.setBackground(new Color(219, 219, 219));
		refreshBtn.setForeground(new Color(70, 163, 100));
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

