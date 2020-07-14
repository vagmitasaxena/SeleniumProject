package com.training.bean;

public class FilterProductBean {
	private String ProductName;
	private String Price;
	private String Status;
	private String Model;
	private String Quantity;
	private String Image;

	public FilterProductBean() {
	}

	public FilterProductBean(String ProductName, String Price, String Status, String Model, String Quantity, String Image) {
		super();
		this.ProductName = ProductName;
		this.Price = Price;
		this.Status = Status;
		this.Model = Model;
		this.Quantity = Quantity;
		this.Image = Image;
	}

	public String getProductName() {
		return ProductName;
	}

	public void setProductName(String ProductName) {
		this.ProductName = ProductName;
	}
	
	public String getImage() {
		return Image;
	}

	public void setImage(String Image) {
		this.Image = Image;
	}

	public String getPrice() {
		return Price;
	}

	public void setPrice(String Price) {
		this.Price = Price;
	}
	
	public String getStatus() {
		return Status;
	}

	public void setStatus(String Status) {
		this.Status = Status;
	}
	
	public String getQuantity() {
		return Quantity;
	}

	public void setQuantity(String Quantity) {
		this.Quantity = Quantity;
	}
	
	public String getModel() {
		return Model;
	}

	public void setModel(String Model) {
		this.Model = Model;
	}

	@Override
	public String toString() {
		return "FilterProductBean [ProductName=" + ProductName + ", Price=" + Price + ", Status=" + Status + ", Model=" + Model + ", Quantity=" + Quantity + ", Image=" + Image + "]";
	}
}
