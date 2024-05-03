package ite.computer_management.controller;

import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;

import ite.computer_management.view.Dashboard;

public class DashboardController implements MouseListener {
	Dashboard dashboard;
	public DashboardController(Dashboard db) {
		dashboard = db;
	}

	@Override
	public void mouseClicked(MouseEvent e) {
		if(e.getSource() == dashboard.productNavLbl) {
			dashboard.clickProductNav();
		}else if(e.getSource() == dashboard.accountNavLbl) {
			dashboard.clickAccountNav();
		}else if(e.getSource() == dashboard.supplierNavLbl) {
			dashboard.clickSupplierNav();
		}else if(e.getSource() == dashboard.importProductNavLbl) {
			dashboard.clickImportProductNav();
		}else if(e.getSource() == dashboard.importCouponNavLbl) {
			dashboard.clickImportCouponNav();
		}else if(e.getSource() == dashboard.exportCouponNavLbl) {
			dashboard.clickExportCouponNav();
		}else if(e.getSource() == dashboard.exportProductNavLbl) {
			dashboard.clickExportProductNav();

		}else if(e.getSource() == dashboard.accountNavLbl) {
			dashboard.clickAccountNav();
		} else if(e.getSource() == dashboard.statisticalNavLbl) {

		}else if(e.getSource() == dashboard.accountNavLbl) {
			dashboard.clickAccountNav();
		}else if(e.getSource() == dashboard.statisticalNavLbl) {

		} else if(e.getSource() == dashboard.statisticalNavLbl) {


			dashboard.clickStatisticalNav();
		}else if(e.getSource() == dashboard.userNavLbl) {
			dashboard.clickUserNav();
		}else if(e.getSource() == dashboard.logOutNavLbl) {
			dashboard.clickLogoutNav();
		}
		
	}

	@Override
	public void mousePressed(MouseEvent e) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void mouseReleased(MouseEvent e) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void mouseEntered(MouseEvent e) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void mouseExited(MouseEvent e) {
		// TODO Auto-generated method stub
		
	}
	

}
