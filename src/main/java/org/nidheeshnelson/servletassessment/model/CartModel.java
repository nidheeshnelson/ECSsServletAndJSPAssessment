package org.nidheeshnelson.servletassessment.model;

public class CartModel 
{
	private long productID;
	private String username;
	private int quantity;
	public long getProductID() {
		return productID;
	}
	public void setProductID(long productID) {
		this.productID = productID;
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
	@Override
	public String toString() {
		return "CartModel [productID=" + productID + ", username=" + username + ", quantity=" + quantity + "]";
	}
	
}
