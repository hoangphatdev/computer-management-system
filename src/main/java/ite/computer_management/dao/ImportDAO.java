
package ite.computer_management.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;

import ite.computer_management.database.ConnectDatabase;
import ite.computer_management.model.Computer;
import ite.computer_management.view.ExportProductView;
import ite.computer_management.view.ImportsProductView;

public class ImportDAO implements DAOInterface<Computer> {
	 private ImportsProductView ImportsView;
	 private ExportProductView DeliveryView;
	 public ImportDAO(ImportsProductView IPV) {
		 ImportsView = IPV;
	   }

	   public static ImportDAO getInstance() {
	      return new ImportDAO();
	   }
	   
	   public ImportDAO() {};
	public ImportDAO(ExportProductView DPV) {
		DeliveryView = DPV;
	}

	@Override
	public int insert(Computer t) {
		
		return 0;
	}

	@Override
	public int delete(Computer t) {
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public int update(Computer t) {
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public ArrayList<Computer> selectAll() {
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
	public int update(Computer t, String condition) {
		
		return 0;
	}
	
	public void display(JTable table) {
		 try {
		        ConnectDatabase.getInstance();
				Connection connection = ConnectDatabase.getConnection();

		        String sql = "SELECT computer_Code, computer_Name, quantity, price FROM computer";
		        try (PreparedStatement p = connection.prepareStatement(sql)) {
		            try (ResultSet re = p.executeQuery()) {
		                DefaultTableModel model_table = (DefaultTableModel) table.getModel();
		                model_table.setRowCount(0);	
		                int stt =1;
		                while (re.next()) {
		                    Object[] row = new Object[]{
		                    		stt++,
		                            re.getString("computer_Code"),
		                            re.getString("computer_Name"),                     
		                            re.getString("quantity"),
		                            re.getString("price"),                   
		                    };
		                    model_table.addRow(row);
		                }
		            }
		        }
		    } catch (SQLException ex) {
		        ex.printStackTrace();
		    } 	
	}
	 public List<String> getSupplierNames() {
	        List<String> supplierNames = new ArrayList<>();
	        try {
	        	ConnectDatabase.getInstance();
	            Connection connection = ConnectDatabase.getConnection();
	            String sql = "SELECT supplier_Name FROM supplier";
	            try (PreparedStatement statement = connection.prepareStatement(sql)) {
	                try (ResultSet resultSet = statement.executeQuery()) {
	                    while (resultSet.next()) {
	                        String name = resultSet.getString("supplier_Name");
	                        supplierNames.add(name);
	                    }
	                }
	            }
	        } catch (SQLException e) {
	            e.printStackTrace();
	        }
	        return supplierNames;
	    }
	 public List<String> getUserName() {
	        List<String> getUserName = new ArrayList<>();
	        try {
	        	ConnectDatabase.getInstance();
	            Connection connection = ConnectDatabase.getConnection();
	            String sql = "SELECT userName FROM account";
	            try (PreparedStatement statement = connection.prepareStatement(sql)) {
	                try (ResultSet resultSet = statement.executeQuery()) {
	                    while (resultSet.next()) {
	                        String name = resultSet.getString("userName");
	                        getUserName.add(name);
	                    }
	                }
	            }
	        } catch (SQLException e) {
	            e.printStackTrace();
	        }
	        return getUserName;
	    }
	 public String[] getProductInfo(String productCode) {
		    String[] productInfo = new String[3]; 
		    try {
		        ConnectDatabase.getInstance();
		        Connection connection = ConnectDatabase.getConnection();
		        String sql = "SELECT computer_Name, quantity, price FROM computer WHERE computer_Code = ?";
		        try (PreparedStatement statement = connection.prepareStatement(sql)) {
		            statement.setString(1, productCode);
		            try (ResultSet resultSet = statement.executeQuery()) {
		                if (resultSet.next()) {
		                    productInfo[0] = resultSet.getString("computer_Name");
		                    productInfo[1] = String.valueOf(resultSet.getInt("quantity"));
		                    productInfo[2] = String.valueOf(resultSet.getDouble("price"));
		                }
		            }
		        }
		    } catch (SQLException e) {
		        e.printStackTrace();
		    }
		    return productInfo;
		}
	 public int updateProductQuantity(String productCode, int newQuantity) {
		    int rowsAffected = 0;
		    try {
		        ConnectDatabase.getInstance();
		        Connection connection = ConnectDatabase.getConnection();
		        String sql = "UPDATE computer SET quantity = ? WHERE computer_Code = ?";
		        try (PreparedStatement statement = connection.prepareStatement(sql)) {
		            statement.setInt(1, newQuantity);
		            statement.setString(2, productCode);
		            rowsAffected = statement.executeUpdate();
		        }
		    } catch (SQLException e) {
		        e.printStackTrace();
		    }
		    return rowsAffected;
		}

}
