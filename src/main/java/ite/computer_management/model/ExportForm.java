
package ite.computer_management.model;

import java.sql.Timestamp;
import java.util.ArrayList;

public class ExportForm extends Form{
	private String supplier;
	public ExportForm() {
	   }

	 public ExportForm(String supplier, String form_Code, Timestamp time_start, String creator, ArrayList<Details_Form> Details_Form, double total_Amount) {
	      super(form_Code, time_start, Details_Form, creator, total_Amount);
	      this.supplier = supplier;
	   }
}

