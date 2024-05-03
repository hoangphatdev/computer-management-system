
package ite.computer_management.model;

import java.sql.Timestamp;
import java.util.ArrayList;



public class ImportsForm extends Form{
	private String supplier;
	
	public ImportsForm() {
		
	}

	public ImportsForm(String supplier) {
		super();
		this.supplier = supplier;
	}

	 public ImportsForm(String supplier, String form_Code, Timestamp time_start, String creator, ArrayList<Details_Form> Details_Form, double total_Amount) {
	      super(form_Code, time_start, Details_Form, creator, total_Amount);
	      this.supplier = supplier;
	   }

	   private ImportsForm(String maPhieu, Timestamp thoiGianTao, String nguoiTao, ArrayList<Details_Form> Details_Form, double tongTien) {
	      throw new UnsupportedOperationException("Not supported yet.");
	   }
	
	public String getSupplier() {
		return supplier;
	}

	public void setSupplier(String supplier) {
		this.supplier = supplier;
	}
	
	
}

