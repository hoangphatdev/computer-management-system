package ite.computer_management.dao;

import java.sql.Statement;
import java.math.BigDecimal;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.ResultSetMetaData;
import java.sql.SQLException;
import java.util.ArrayList;

import javax.swing.JOptionPane;
import javax.swing.table.DefaultTableModel;

import ite.computer_management.database.ConnectDatabase;
import ite.computer_management.model.Computer;
import ite.computer_management.view.ProductView;



public class ProductDAO implements DAOInterface<Computer> {
	private ProductView productView;
	public ProductDAO() {};
	public ProductDAO(ProductView productView) {
		this.productView = productView;
	}
	public static ProductDAO getInstance() {
		return new ProductDAO();
	}
	
	@Override
	public int insert(Computer com) {
		int check = 0;
		Connection connect = ConnectDatabase.getInstance().getConnection();
		try {
			String sql = "INSERT INTO computer(computer_Code, computer_Name, quantity, cpu_Name, ram, screen_Card, price, source_Capacity, "
					+ "machine_Type, rom, screen_Size, battery_Capacity, origin)" + " VALUE"		
					+ "(?,?,?,?,?,?,?,?,?,?,?,?,?)";
			PreparedStatement ps = connect.prepareStatement(sql);
			ps.setString(1, com.getComputerCode());    // setString--> first Parameter is 1
			ps.setString(2, com.getComputerName());
			ps.setInt(3, com.getQuantity());
			ps.setString(4, com.getCpuName());
			ps.setString(5, com.getRam());
			ps.setString(6, com.getScreenCard());
			ps.setBigDecimal(7, com.getPrice());
			ps.setString(8, com.getSourceCapacity());
			ps.setString(9, com.getMachineType());
			ps.setString(10, com.getRom());
			ps.setDouble(11, com.getScreenSize());
			ps.setString(12, com.getBatteryCapacity());
			ps.setString(13, com.getOrigin());
			
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
	public int delete(Computer t) {
		int check = 0;
		Connection connect = ConnectDatabase.getInstance().getConnection();
		String sql = "DELETE FROM computer WHERE computer_code=?";
		try {
			PreparedStatement ps = connect.prepareStatement(sql);
			ps.setString(1, t.getComputerCode());
			check = ps.executeUpdate();
			connect.close();
			System.out.println("----------\n"+ sql + t.getComputerCode());
			JOptionPane.showMessageDialog(null, "Delete successfully ");
			
		} catch (SQLException e) {
			JOptionPane.showMessageDialog(null, "Error: " +e);
		}
		
		return check;
	}

	@Override
	public int update(Computer com, String condition) {
		int check = 0;
		Connection connect = ConnectDatabase.getInstance().getConnection();
		String sql = "UPDATE computer SET computer_Code=?, computer_Name=?, quantity=?, cpu_Name=?, ram=?, screen_Card=?, price=?,"
				+ "source_Capacity=?, machine_Type=?, rom=?, screen_Size=?, battery_Capacity=?, origin=?" + " WHERE computer_Code=?";
		try {
			PreparedStatement ps = connect.prepareStatement(sql);
			ps.setString(1, com.getComputerCode());
			ps.setString(2, com.getComputerName());
			ps.setInt(3, com.getQuantity());
			ps.setString(4, com.getCpuName());
			ps.setString(5, com.getRam());
			ps.setString(6, com.getScreenCard());
			ps.setBigDecimal(7, com.getPrice());
			ps.setString(8, com.getSourceCapacity());
			ps.setString(9, com.getMachineType());
			ps.setString(10, com.getRom());
			ps.setDouble(11, com.getScreenSize());
			ps.setString(12, com.getBatteryCapacity());
			ps.setString(13, com.getOrigin());
			ps.setString(14, condition);
			check = ps.executeUpdate();
			connect.close();
			JOptionPane.showMessageDialog(null, "Edit successfully ><");
			
		} catch (SQLException e) {
			JOptionPane.showMessageDialog(null,"Error: " + e);
		}
		
		return 0;
	}

	@Override
	public ArrayList<Computer> selectAll() {
		Connection connect = ConnectDatabase.getInstance().getConnection();
		
		try {
			Statement st = connect.createStatement();
			String sql = "SELECT * FROM computer";
			ResultSet rs = st.executeQuery(sql);
			ResultSetMetaData rsmd = rs.getMetaData();
		
			int cols = rsmd.getColumnCount();

			String[] colName = {"Computer Name", "Computer Code" , "Quantity" , "CPU" ,"RAM", "Screen Card" , "Price" ,"Source Capacity" , "Machine Type",
									 "ROM" , "Screen Size" ,"Battery Capacity" ,"Origin"}; 
//			String[] colName = new String[cols];
//			for(int i=0; i<cols; i++) {
//				colName[i] = rsmd.getColumnClassName(i+1); //thu tu cot bat dau tu 1
//			}
			productView.model.setColumnIdentifiers(colName);
			String computerName, computerCode, cpu, screenCard, machineType, origin, ram, sourceCapacity, rom, batteryCapacity;
			int quantity;
			Double price, screenSize;
			while(rs.next()) {
				computerCode = rs.getString(1);  // FIRST PARAMETER: 1	
				computerName = rs.getString(2);
				quantity = rs.getInt(3);
				cpu = rs.getString(4);
				ram = rs.getString(5);
				screenCard = rs.getString(6);
				price = rs.getDouble(7);
				sourceCapacity = rs.getString(8);
				machineType = rs.getString(9);
				rom = rs.getString(10);
				screenSize = rs.getDouble(11);
				batteryCapacity = rs.getString(12);
				origin = rs.getString(13);
				String[] row = { computerName, computerCode, String.valueOf(quantity), cpu, ram, screenCard, String.valueOf(price), sourceCapacity, machineType,
						rom, String.valueOf(screenSize), batteryCapacity, origin};
				productView.model.addRow(row);
			}
			connect.close();
		} catch (SQLException e) {
			JOptionPane.showMessageDialog(null, e);
		}
		return null;
	}

	@Override
	public Computer selectById(Computer t) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public ArrayList<Computer> selectByCondition(String condition) {
		// TODO Auto-generated method stub
		return null;
	}
	@Override
	public int update(Computer t) {
		// TODO Auto-generated method stub
		return 0;
	}
	
	
}
