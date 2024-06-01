package ite.computer_management.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.ResultSetMetaData;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;

import javax.swing.JOptionPane;

import ite.computer_management.database.ConnectDatabase;
import ite.computer_management.model.Account;
import ite.computer_management.model.Computer;
import ite.computer_management.view.AccountView;
import ite.computer_management.view.AddAccountView;
import ite.computer_management.view.EditAccountView;

public class AccountDAO implements DAOInterface<Account> {
	private AccountView accountView;
	
	public AccountDAO(AccountView av) {
		accountView = av;
	}
	public static AccountDAO getInstance() {
		return new AccountDAO();
	}
	
	public AccountDAO() {};
	@Override
	public int insert(Account account) {
		int check = 0;
		Connection connect = ConnectDatabase.getConnection();
		String sql = "INSERT INTO account VALUE(?,?,?,?)";
		try {
			PreparedStatement ps = connect.prepareStatement(sql);
			ps.setString(1, account.getFullName());   
			ps.setString(2, account.getUserName());
			ps.setString(3, account.getPassword());
			ps.setString(4, account.getRole());
			
			check = ps.executeUpdate();
			JOptionPane.showMessageDialog(null, "Insert successfully ><");
			connect.close();
		} catch (SQLException e) {
			JOptionPane.showMessageDialog(null, "Error: " + e);
		}
		return check;
	}

	@Override
	public int delete(Account account) {
		int check = 0;
		Connection connect = ConnectDatabase.getConnection();
		String sql = "DELETE FROM account WHERE userName=?";
		try {
			PreparedStatement ps = connect.prepareStatement(sql);
			ps.setString(1, account.getUserName());
			check = ps.executeUpdate();
			JOptionPane.showMessageDialog(null, "Delete account: " + account.getUserName() + " successfully ><");
			connect.close();
		} catch (SQLException e) {
			JOptionPane.showMessageDialog(null,"Error: " + e);
		}
		
		return check;
	}
	@Override
	public int update(Account account, String condition) {
		int check = 0;
		Connection connect = ConnectDatabase.getConnection();
		String sql = "UPDATE account SET fullName=?, userName=?, password=?, role=? WHERE userName=?";
		try {
			PreparedStatement ps = connect.prepareStatement(sql);
			ps.setString(1, account.getFullName());
			ps.setString(2, account.getUserName());
			ps.setString(3, account.getPassword());
			ps.setString(4, account.getRole());
			ps.setString(5, condition);
			check = ps.executeUpdate();
			JOptionPane.showMessageDialog(null, "Update successfully >>");
			connect.close();
		} catch (SQLException e) {
			JOptionPane.showMessageDialog(null,"Error: " + e);
		}
		return check;
	}
	@Override
	public int update(Account account) {
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public ArrayList selectAll() {
		Connection connect = ConnectDatabase.getConnection();
		String sql = "SELECT * FROM account";
		try {
			Statement state = connect.createStatement();
			ResultSet rs =  state.executeQuery(sql);
			ResultSetMetaData rsmd = rs.getMetaData();
			
			int colCount = rsmd.getColumnCount();
			String [] rowName = {"Full Name", "User Name", "Password", "Role"};
			accountView.model.setColumnIdentifiers(rowName);
			String fullName, userName, password, role;
			while(rs.next()) {
				fullName = rs.getString(1);
				userName = rs.getString(2);
				password = rs.getString(3);
				role = rs.getString(4);
				
				String rowData[] = { fullName, userName, password, role};
				accountView.model.addRow(rowData);
			}
			connect.close();
			
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return null;
	}



	@Override
	public ArrayList selectByCondition(String condition) {
		// TODO Auto-generated method stub
		return null;
	}
	@Override
	public Account selectById(String t) {
		 Account acc = null;
	        try {
	        	Connection connect = ConnectDatabase.getConnection();
	            String sql = "SELECT * FROM account WHERE fullName=?";
	            PreparedStatement pst = connect.prepareStatement(sql);
	            pst.setString(1, t);
	            ResultSet rs = pst.executeQuery();
	            while (rs.next()) {
	                String fullName = rs.getString("fullName");
	                String userName = rs.getString("userName");
	                String password = rs.getString("password");
	                String role = rs.getString("role");
	                acc = new Account(fullName, userName, password, role);
	            }
	            connect.close();
	        } catch (Exception e) {
	            // TODO: handle exception           
	        }
	        return acc;
	}
	public Account select1AccountAndReturnRole(Account t) {
		Account accountReturn = new Account();
		
		String userNameForSearch = t.getUserName();
		String passwordForSearch = t.getPassword();

		try {
			Connection connect = ConnectDatabase.getConnection();
			String sql = "select * from account where userName=? AND password=?";
			PreparedStatement ps = connect.prepareStatement(sql);
			ps.setString(1, userNameForSearch);
			ps.setString(2, passwordForSearch);
			ps.executeQuery();
			ResultSet rs = ps.getResultSet();

			while(rs.next()) {
				accountReturn.setFullName(rs.getString("fullName")); 
				accountReturn.setUserName(rs.getString("userName")); 
				accountReturn.setPassword(rs.getString("password")); 
				accountReturn.setRole(rs.getString("role")); 
			}
		
		}catch(Exception e) {
			e.printStackTrace();
		}
		return accountReturn;
		 
	}
	
	public void updatePassword(String currentPassword, String newPassword, String userName ) {
		try {
			Connection connect = ConnectDatabase.getConnection();
			String sql = "UPDATE account SET password=? WHERE password=? AND userName=?";
			PreparedStatement ps = connect.prepareStatement(sql);
			ps.setString(1, newPassword);
			ps.setString(2,currentPassword);
			ps.setString(3,userName );
			
			int result = ps.executeUpdate();
		}catch(Exception e) {
			JOptionPane.showMessageDialog(null, e);
			e.printStackTrace();
		}
	}
	

	

}
