package ite.computer_management.controller;

import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;

import ite.computer_management.view.ExportProductView;
import ite.computer_management.view.ImportsProductView;

public class Imports_productController implements MouseListener, KeyListener{
	ImportsProductView Imports;
	ExportProductView DeliveryView;
	
	public Imports_productController(ImportsProductView IPV) {
		Imports = IPV;
	}
	public Imports_productController(ExportProductView DPV) {
		DeliveryView = DPV;
	}
	
	@Override
	public void mouseClicked(MouseEvent e) {
		if(e.getSource() == Imports.btn_accept) {
			Imports.addProductActionPerformed();
		} else if(e.getSource() == Imports.btn_DeleteProduct) {
			Imports.delete_toTableImport();
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