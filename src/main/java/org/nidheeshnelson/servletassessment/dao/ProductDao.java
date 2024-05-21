package org.nidheeshnelson.servletassessment.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.Random;

import org.nidheeshnelson.servletassessment.model.ProductModel;

public class ProductDao 
{
	private Connection connection;
	private static final String INSERT_PRODUCT_SQL = "INSERT INTO product (productID, productName, productDescription, productPrice, gst, offer, netPrice) " +
            "VALUES (?, ?, ?, ?, ?, ?, ?)";
	private static final String SELECT_PRODUCT_BY_ID_SQL = "SELECT * FROM product WHERE productID = ?";
	public ProductDao(Connection connection)
	{
		this.connection = connection;
	}
	public String insertProductInProductTable(long productID)
    {
    	int random = (new Random()).nextInt(10)+1;
    	try 
    	{
    		PreparedStatement preparedStatement = connection.prepareStatement(INSERT_PRODUCT_SQL);
    				preparedStatement.setLong(1, productID);
    				preparedStatement.setString(2, "Product " + productID);
    				preparedStatement.setString(3, "Description of Product " + productID);
    				preparedStatement.setDouble(4, 100.0 * random); 
    				preparedStatement.setDouble(5, 0.18); 
    				preparedStatement.setDouble(6, 0.05);
    				preparedStatement.setDouble(7, Math.round((100.0 * random * (1 + 0.18 - 0.05))*100.0)/100.0); 
    				preparedStatement.executeUpdate();
    				
    		return "Success products";
    	}
    	catch(Exception e)
    	{
    		System.out.println(e);
    		return "Error Occured products";
    	}
    	
    }
	
	public ProductModel getProductById(long productID) {
        ProductModel product = new ProductModel();
        try {
            PreparedStatement preparedStatement = connection.prepareStatement(SELECT_PRODUCT_BY_ID_SQL);
            preparedStatement.setLong(1, productID);
            ResultSet rs = preparedStatement.executeQuery();

            if (rs.next()) 
            {
            	product.setProductID(rs.getLong("productID")); 
            	product.setProductName(rs.getString("productName"));
                product.setProductDescription(rs.getString("productDescription"));
                product.setProductPrice(rs.getDouble("productPrice"));
                product.setGst(rs.getDouble("gst"));
                product.setOffer(rs.getDouble("offer"));
                product.setNetPrice(rs.getDouble("netPrice"));
             }
        } catch (Exception e) {
            System.out.println(e);
        }
        return product;
    }
}
