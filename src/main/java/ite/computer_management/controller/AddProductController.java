package ite.computer_management.controller;

import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;

import ite.computer_management.view.AddProductView;


public class AddProductController implements MouseListener {
	AddProductView addProductView;
	public AddProductController(AddProductView apv) {
		addProductView = apv;
	}
	@Override
	public void mouseClicked(MouseEvent e) {
		if(e.getSource() == addProductView.addLbl) {
			addProductView.clickAddLbl();
		}else if(e.getSource() == addProductView.cancelLbl) {
			addProductView.clickCancelLbl();
		}else if(e.getSource() == addProductView.refreshLbl) {
			addProductView.clickRefreshLbl();
		}
	}

	@Override
	public void mousePressed(MouseEvent e) {
	}

	@Override
	public void mouseReleased(MouseEvent e) {
	}

	@Override
	public void mouseEntered(MouseEvent e) {		
	}

	@Override
	public void mouseExited(MouseEvent e) {
	}

}
