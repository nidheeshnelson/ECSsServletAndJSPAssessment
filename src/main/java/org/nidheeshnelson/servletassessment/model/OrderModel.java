package org.nidheeshnelson.servletassessment.model;

public class OrderModel 
{
	private long productID;
	private String productName;
	private String username;
	private int quantity;
	private double netPrice;
	private double totalAmount;
	public long getProductID() {
		return productID;
	}
	public void setProductID(long productID) {
		this.productID = productID;
	}
	public String getProductName() {
		return productName;
	}
	public void setProductName(String productName) {
		this.productName = productName;
	}
	public String getUsername() {
		return username;
	}
	public void setUsername(String username) {
		this.username = username;
	}
	public int getQuantity() {
		return quantity;
	}
	public void setQuantity(int quantity) {
		this.quantity = quantity;
	}
	public double getNetPrice() {
		return netPrice;
	}
	public void setNetPrice(double netPrice) {
		this.netPrice = netPrice;
	}
	public double getTotalAmount() {
		return totalAmount;
	}
	public void setTotalAmount(double totalAmount) {
		this.totalAmount = totalAmount;
	}
	@Override
	public String toString() {
		return "OrderModel [productID=" + productID + ", productName=" + productName + ", username=" + username
				+ ", quantity=" + quantity + ", netPrice=" + netPrice + ", totalAmount=" + totalAmount + "]";
	}
	
}
