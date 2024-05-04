package ite.computer_management.dao;

import java.util.ArrayList;

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
		// TODO Auto-generated method stub
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

}
