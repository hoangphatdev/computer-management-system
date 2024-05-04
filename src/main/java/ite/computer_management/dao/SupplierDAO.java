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
import ite.computer_management.model.Supplier;
import ite.computer_management.view.SupplierView;

public class SupplierDAO implements DAOInterface<Supplier>{
	private SupplierView SupplierView;
	
	public SupplierDAO() {};
	public SupplierDAO(SupplierView SV) {
		this.SupplierView = SV;
	}
	public static SupplierDAO getInstance() {
		return new SupplierDAO();
	}
	
	@Override
	public int insert(Supplier t) {
		int check = 0;
		Connection connect = ConnectDatabase.getInstance().getConnection();
		try {
			String sql = "INSERT INTO Supplier(supplier_Code, supplier_Name, phone_Number, address)" + " VALUE"		
					+ "(?,?,?,?)";
			PreparedStatement ps = connect.prepareStatement(sql);
			ps.setString(1, t.getSupplier_Code());    // setString--> first Parameter is 1
			ps.setString(2, t.getSupplier_Name());
			ps.setString(3, t.getPhone_Number());
			ps.setString(4, t.getAddress());
	
			check = ps.executeUpdate();	
			connect.close();
			System.out.println(sql);
			JOptionPane.showMessageDialog(null, "Insert successfully ><");
			
		} catch (SQLException e) {
			JOptionPane.showMessageDialog(null, "Computer code already exist");
		}
		return check;
	}

	@Override
	public int delete(Supplier t) {
		int check = 0;
		Connection connect = ConnectDatabase.getInstance().getConnection();
		String sql = "DELETE FROM supplier WHERE supplier_Code=?";
		try {
			PreparedStatement ps = connect.prepareStatement(sql);
			ps.setString(1, t.getSupplier_Code());
			check = ps.executeUpdate();
			connect.close();
			System.out.println("----------\n"+ sql + t.getSupplier_Code());
			JOptionPane.showMessageDialog(null, "Delete successfully ");
			
		} catch (SQLException e) {
			JOptionPane.showMessageDialog(null, "Error: " +e);
		}
		
		return check;
	}

	@Override
	public int update(Supplier t) {
		int check = 0;
		Connection connect = ConnectDatabase.getInstance().getConnection();
		String sql = "UPDATE supplier SET supplier_Code=?, supplier_Name=?, phone_Number=?, address=?" + " WHERE supplier_Code=?";
		try {
			PreparedStatement ps = connect.prepareStatement(sql);
			ps.setString(1, t.getSupplier_Code());
			ps.setString(2,t.getSupplier_Name());
			ps.setString(3, t.getPhone_Number());
			ps.setString(4, t.getAddress());
			check = ps.executeUpdate();
			connect.close();
			JOptionPane.showMessageDialog(null, "Edit successfully ><");
			
		} catch (SQLException e) {
			JOptionPane.showMessageDialog(null,"Error: " + e);
		}
		
		return 0;
	}

	@Override
	public ArrayList<Supplier> selectAll() {
Connection connect = ConnectDatabase.getInstance().getConnection();
		
		try {
			Statement st = connect.createStatement();
			String sql = "SELECT * FROM supplier";
			ResultSet rs = st.executeQuery(sql);
			ResultSetMetaData rsmd = rs.getMetaData();
		
			int cols = rsmd.getColumnCount();

			String[] colName = {"Supplier Code", "Computer Name" , "Phone Number" , "Address"}; 
			SupplierView.model.setColumnIdentifiers(colName);
			String supplier_Code, supplier_Name, phone_Number, address;
			int quantity;
			Double price, screenSize;
			while(rs.next()) {
				supplier_Code = rs.getString(1);  
				supplier_Name = rs.getString(2);
				phone_Number = rs.getString(3);
				address = rs.getString(4);
				String[] row = { supplier_Code, supplier_Name, phone_Number, address};
				SupplierView.model.addRow(row);
			}
			connect.close();
		} catch (SQLException e) {
			JOptionPane.showMessageDialog(null, e);
		}
		return null;
	}

	@Override
	public Supplier selectById(Supplier t) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public ArrayList<Supplier> selectByCondition(String condition) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public int update(Supplier t, String condition) {
		// TODO Auto-generated method stub
		return 0;
	}
}
