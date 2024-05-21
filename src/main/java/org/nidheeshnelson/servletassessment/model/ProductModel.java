package org.nidheeshnelson.servletassessment.model;

public class ProductModel 
{
private long productID;
private String productName;
private String productDescription;
private double productPrice;
private double gst;
private double offer;
private double netPrice;
private int count;

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
public String getProductDescription() {
	return productDescription;
}
public void setProductDescription(String productDescription) {
	this.productDescription = productDescription;
}
public double getProductPrice() {
	return productPrice;
}
public void setProductPrice(double productPrice) {
	this.productPrice = productPrice;
}
public double getGst() {
	return gst;
}
public void setGst(double gst) {
	this.gst = gst;
}
public double getOffer() {
	return offer;
}
public void setOffer(double offer) {
	this.offer = offer;
}
public double getNetPrice() {
	return netPrice;
}
public void setNetPrice(double netPrice) {
	this.netPrice = netPrice;
}
public int getCount() {
	return count;
}
public void setCount(int count) {
	this.count = count;
}
@Override
public String toString() {
	return "ProductModel [productID=" + productID + ", productName=" + productName + ", productDescription="
			+ productDescription + ", productPrice=" + productPrice + ", gst=" + gst + ", offer=" + offer
			+ ", netPrice=" + netPrice + ", count=" + count + "]";
}

}
