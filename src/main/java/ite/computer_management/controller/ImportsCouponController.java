package ite.computer_management.controller;

import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;

import ite.computer_management.view.ImportCouponView;

public class ImportsCouponController implements MouseListener, KeyListener{
	ImportCouponView imporCouponView;
	
	public ImportsCouponController(ImportCouponView ICV) {
		imporCouponView = ICV;
	}
	
	@Override
	public void mouseClicked(MouseEvent e) {
		if(e.getSource() == imporCouponView.deleteLbl) {
			imporCouponView.clickDeleteLbl();
		}else if(e.getSource() == imporCouponView.editLbl) {
			imporCouponView.clickEditBtn();
		}else if(e.getSource() == imporCouponView.seeDetailLbl) {
			
		}else if(e.getSource() == imporCouponView.excelBtn) {
			imporCouponView.clickExportExcel();
		} else if(e.getSource() == imporCouponView.btn_refresh) {
			imporCouponView.displayTable();
		} 		
	}

	
	
	@Override
	public void keyTyped(KeyEvent e) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void keyPressed(KeyEvent e) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void keyReleased(KeyEvent e) {
		// TODO Auto-generated method stub
		
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
