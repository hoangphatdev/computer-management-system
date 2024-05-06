package ite.computer_management.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.ResultSetMetaData;
import java.sql.SQLException;
import java.sql.Statement;
import java.sql.Timestamp;
import java.util.ArrayList;

import javax.swing.JOptionPane;

import ite.computer_management.database.ConnectDatabase;
import ite.computer_management.model.Form;
import ite.computer_management.model.ImportsForm;
import ite.computer_management.view.ImportCouponView;

public class ImportCouponDAO implements DAOInterface<ImportsForm>{
	private ImportCouponView importCouponView;
	
	
	public static ImportCouponDAO getInstance() {
		return new ImportCouponDAO();
	}
	public ImportCouponDAO() {
		
	};
	public ImportCouponDAO(ImportCouponView ICV) {
		importCouponView = ICV;
	}
	
	@Override
	public int insert(ImportsForm t) {
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public int delete(ImportsForm t) {
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public int update(ImportsForm t) {
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public ArrayList<ImportsForm> selectAll() {
	
		return null;
	}

	@Override
	public ImportsForm selectById(ImportsForm t) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public ArrayList<ImportsForm> selectByCondition(String condition) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public int update(ImportsForm t, String condition) {
		// TODO Auto-generated method stub
		return 0;
	}
	public ArrayList<Form> selectAllP() {
        ArrayList<Form> ketQua = new ArrayList<Form>();
        try {
        	Connection con = ConnectDatabase.getInstance().getConnection();
            String sql = "SELECT maPhieu,thoiGianTao,nguoiTao,tongTien FROM PhieuNhap UNION SELECT * FROM PhieuXuat ORDER BY thoiGianTao DESC";
            PreparedStatement pst = con.prepareStatement(sql);
            ResultSet rs = pst.executeQuery();
            while (rs.next()) {
                String maPhieu = rs.getString("maPhieu");
                Timestamp thoiGianTao = rs.getTimestamp("thoiGianTao");
                String nguoiTao = rs.getString("nguoiTao");
                double tongTien = rs.getDouble("tongTien");
                Form p = new Form(maPhieu, thoiGianTao, Details_ImportDAO.getInstance().selectAll(maPhieu), nguoiTao, tongTien);
                ketQua.add(p);
            }
        } catch (Exception e) {
            // TODO: handle exception
            e.printStackTrace();
        }
        return ketQua;
    }
}
