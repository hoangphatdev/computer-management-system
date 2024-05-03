
package ite.computer_management.model;

public class Details_Form {
	private String form_Code;
	private String computer_Code;
	private int quantity;
	private double unit_Price;
	
	public Details_Form() {
		
	}

	public Details_Form(String form_Code, String computer_Code, int quantity, double unit_Price) {
		super();
		this.form_Code = form_Code;
		this.computer_Code = computer_Code;
		this.quantity = quantity;
		this.unit_Price = unit_Price;
	}

	public String getForm_Code() {
		return form_Code;
	}

	public void setForm_Code(String form_Code) {
		this.form_Code = form_Code;
	}

	public String getComputer_Code() {
		return computer_Code;
	}

	public void setComputer_Code(String computer_Code) {
		this.computer_Code = computer_Code;
	}

	public int getQuantity() {
		return quantity;
	}

	public void setQuantity(int quantity) {
		this.quantity = quantity;
	}

	public double getUnit_Price() {
		return unit_Price;
	}

	public void setUnit_Price(double unit_Price) {
		this.unit_Price = unit_Price;
	}

	@Override
	public String toString() {
		return "Details_Form [form_Code=" + form_Code + ", computer_Code=" + computer_Code + ", quantity=" + quantity
				+ ", unit_Price=" + unit_Price + "]";
	}
	
}

