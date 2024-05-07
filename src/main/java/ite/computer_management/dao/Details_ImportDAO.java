package ite.computer_management.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;

import ite.computer_management.database.ConnectDatabase;
import ite.computer_management.model.Details_Form;

public class Details_ImportDAO implements DAOInterface<Details_Form>{

	 public static Details_ImportDAO getInstance() {
	        return new Details_ImportDAO();
	    }
	
	
	@Override
	public int insert(Details_Form t) {
		// TODO Auto-generated method stub
		return 0;
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
	            String sql = "SELECT * FROM Details_imports_coupon";
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
            String sql = "SELECT * FROM Details_imports_coupon WHERE form_Code=?";
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
