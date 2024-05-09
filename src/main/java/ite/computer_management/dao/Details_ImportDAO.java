package ite.computer_management.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

import javax.swing.JOptionPane;

import ite.computer_management.database.ConnectDatabase;
import ite.computer_management.model.Details_Form;

public class Details_ImportDAO implements DAOInterface<Details_Form>{

	 public static Details_ImportDAO getInstance() {
	        return new Details_ImportDAO();
	    }
	
	
	@Override
	public int insert(Details_Form t) {
	    int ketQua = 0;
	    Connection con = null;
	    try {
	        con = ConnectDatabase.getConnection();
	        // Kiểm tra xem form_Code có tồn tại trong bảng import_coupon không
	        if (isFormCodeValid(con, t.getForm_Code())) {
	            String sql = "INSERT INTO detail_imports_coupon (form_Code, computer_Code, quantity, unit_price) VALUES (?,?,?,?)";
	            PreparedStatement pst = con.prepareStatement(sql);
	            pst.setString(1, t.getForm_Code());
	            pst.setString(2, t.getComputer_Code());
	            pst.setInt(3, t.getQuantity());
	            pst.setDouble(4, t.getUnit_Price());
	            ketQua = pst.executeUpdate();
	            // In thông báo khi thêm dữ liệu thành công
	            System.out.println("Insert into detail_imports_coupon successfully.");
	        } else {
	            // In thông báo khi form_Code không tồn tại trong bảng import_coupon
	            System.out.println("Error: form_Code does not exist in import_coupon table.");
	        }
	    } catch (Exception e) {
	        e.printStackTrace();
	    } finally {
	        // Đảm bảo rằng kết nối được đóng ngay sau khi sử dụng
	        if (con != null) {
	            try {
	                con.close();
	            } catch (SQLException e) {
	                e.printStackTrace();
	            }
	        }
	    }
	    return ketQua;
	}

	// check xem form_Code có tồn tại trong bảng import_coupon k
	private boolean isFormCodeValid(Connection con, String formCode) {
	    boolean isValid = false;
	    try {
	        String sql = "SELECT form_Code FROM import_coupon WHERE form_Code = ?";
	        PreparedStatement pst = con.prepareStatement(sql);
	        pst.setString(1, formCode);
	        ResultSet rs = pst.executeQuery();
	        isValid = rs.next(); 
	    } catch (SQLException e) {
	        e.printStackTrace();
	    }
	    return isValid;
	}


	@Override
	public int delete(Details_Form t) {
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public int update(Details_Form t) {
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public ArrayList<Details_Form> selectAll() {
		  ArrayList<Details_Form> ketQua = new ArrayList<Details_Form>();
	        try {
	        	ConnectDatabase.getInstance();
	  			Connection con = ConnectDatabase.getConnection();
	            String sql = "SELECT * FROM detail_imports_coupon";
	            PreparedStatement pst = con.prepareStatement(sql);
	            ResultSet rs = pst.executeQuery();
	            while (rs.next()) {
	                String form_Code = rs.getString("form_Code");
	                String computer_Code = rs.getString("computer_Code");
	                int quantity = rs.getInt("quantity");
	                double price = rs.getDouble("price");
	                Details_Form ctp = new Details_Form(form_Code, computer_Code, quantity, price);
	                ketQua.add(ctp);
	            }
	        } catch (Exception e) {
	            // TODO: handle exception
	            e.printStackTrace();
	        }
	        return ketQua;
	}


	@Override
	public ArrayList<Details_Form> selectByCondition(String condition) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public int update(Details_Form t, String condition) {
		// TODO Auto-generated method stub
		return 0;
	}
	public ArrayList<Details_Form> selectAll(String t) {
        ArrayList<Details_Form> ketQua = new ArrayList<Details_Form>();
        try {
            ConnectDatabase.getInstance();
			Connection con = ConnectDatabase.getConnection();
            String sql = "SELECT * FROM detail_imports_coupon WHERE form_Code=?";
            PreparedStatement pst = con.prepareStatement(sql);
            pst.setString(1, t);
            ResultSet rs = pst.executeQuery();
            while (rs.next()) {
                String form_Code = rs.getString("form_Code");
                String computer_Code = rs.getString("computer_Code");
                int quantity = rs.getInt("quantity");
                double price = rs.getDouble("price");
                Details_Form ctp = new Details_Form(form_Code, computer_Code, quantity, price);
                ketQua.add(ctp);
            }
            ConnectDatabase.closeConnection(con);
        } catch (Exception e) {
            // TODO: handle exception
            e.printStackTrace();
        }
        return ketQua;
    }


	@Override
	public Details_Form selectById(String t) {
		// TODO Auto-generated method stub
		return null;
	}
}
