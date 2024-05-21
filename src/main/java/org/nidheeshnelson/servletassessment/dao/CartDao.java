package org.nidheeshnelson.servletassessment.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

public class CartDao 
{
	private Connection connection;
	private static final String INSERT_CART_SQL = "INSERT INTO cart (productID, username, quantity) " +
            "VALUES (?, ?, ?)";
	private static final String DELETE_CART_SQL = "DELETE FROM cart WHERE productID = ? AND username = ?";
	private static final String COUNT_CART = "SELECT COUNT(*) FROM cart WHERE productID = ? AND username = ?";
	
	public CartDao(Connection connection)
	{
		this.connection = connection;
	}
	
	public String insertCartTable(long productID, String username)
    {
    	try 
    	{
    		PreparedStatement preparedStatement = connection.prepareStatement(INSERT_CART_SQL);
    				preparedStatement.setLong(1, productID);
    				preparedStatement.setString(2, username);
    				preparedStatement.setInt(3, 1); 
    				preparedStatement.executeUpdate();
    		return "Success Cart";
    	}
    	catch(Exception e)
    	{
    		System.out.println(e);
    		return "Error Occured Cart";
    	}
    }
	
	public String deleteCartTable(long productID, String username)
    {
    	try 
    	{
    		PreparedStatement preparedStatement = connection.prepareStatement(DELETE_CART_SQL);
    				preparedStatement.setLong(1, productID);
    				preparedStatement.setString(2, username);
    				preparedStatement.executeUpdate();
    		return "Success delete Cart";
    	}
    	catch(Exception e)
    	{
    		System.out.println(e);
    		return "Error Occured delete Cart";
    	}
    }
	public int getCartCount(long productId, String username) 
	{
        int count = 0;
        try {
             PreparedStatement preparedStatement = connection.prepareStatement(COUNT_CART);
             preparedStatement.setLong(1, productId);
             preparedStatement.setString(2, username);
             
             try (ResultSet resultSet = preparedStatement.executeQuery()) 
             {
                if (resultSet.next()) 
                {
                    count = resultSet.getInt(1); // Get the count from the result set
                }
            }
        } catch (Exception e) {
            e.printStackTrace();
        }

        return count;
    }
}
