package org.nidheeshnelson.servletassessment.database;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.Random;

public class DataBaseInitializer 
{
	 // JDBC URL, username, and password for the database
    private static final String JDBC_URL = "jdbc:mysql://localhost:3306/";
    private static final String USERNAME = "root";
    private static final String PASSWORD = "nidheesh";

    // SQL statements for creating database and table
    private static final String CREATE_DATABASE_SQL = "CREATE DATABASE IF NOT EXISTS my_database";
    private static final String CREATE_TABLE_SQL = "CREATE TABLE IF NOT EXISTS signup (id INT AUTO_INCREMENT PRIMARY KEY, " +
                                                    "username VARCHAR(255), " +
                                                    "password VARCHAR(255), " +
                                                    "email VARCHAR(255))";
    private static final String CREATE_PRODUCT_TABLE_SQL = "CREATE TABLE IF NOT EXISTS product (" +
            "productID BIGINT PRIMARY KEY, " +
            "productName VARCHAR(255), " +
            "productDescription VARCHAR(255), " +
            "productPrice DOUBLE, " +
            "gst DOUBLE, " +
            "offer DOUBLE, " +
            "netPrice DOUBLE)";
    private static final String CREATE_TABLE_CART = "CREATE TABLE IF NOT EXISTS cart (id INT AUTO_INCREMENT PRIMARY KEY, " +
    		"productID BIGINT, " +
            "username VARCHAR(255), " +
            "quantity INT)";
    private static final String CREATE_TABLE_ORDER = "CREATE TABLE IF NOT EXISTS `order` (" +
    	    "id INT AUTO_INCREMENT PRIMARY KEY, " +
    	    "productID BIGINT, " +
    	    "username VARCHAR(255), " +
    	    "productName VARCHAR(255), " +
    	    "netPrice DOUBLE, " +
    	    "quantity INT, " +
    	    "totalAmount DOUBLE)";
    
    public static Connection initializeDatabase() 
    {
    	System.out.println("in initializeDatabase()");
        try 
        {
        	Class.forName("com.mysql.cj.jdbc.Driver");
    		Connection connection = DriverManager.getConnection(JDBC_URL, USERNAME, PASSWORD);
    		Statement statement = connection.createStatement();
        	System.out.println("in initializeDatabase() try");
            // Create database if not exists
            statement.executeUpdate(CREATE_DATABASE_SQL);
            // Use the database
            statement.executeUpdate("USE my_database");
            // Create table if not exists
            statement.executeUpdate(CREATE_TABLE_SQL);
            System.out.println("Database and table initialized successfully.");
            return connection;
        } catch (Exception e) {
            e.printStackTrace();
            System.err.println("Error initializing database and table.");
        }
		return null;
    }
    
    public static String initializeProductTable(Connection connection) 
    {
    	Statement statement;
		try 
		{
			statement = connection.createStatement();
			statement.executeUpdate(CREATE_PRODUCT_TABLE_SQL);
	    	System.out.println("Product table initialized successfully.");
	    	return "Success product table";
		} 
		catch (SQLException e) 
		{
			return "Error occured product table";
		}
    	
    }
    
    public static String initializeCartTable(Connection connection) 
    {
    	Statement statement;
		try 
		{
			statement = connection.createStatement();
			statement.executeUpdate(CREATE_TABLE_CART);
	    	System.out.println("Cart table initialized successfully.");
	    	return "Success cart table";
		} 
		catch (SQLException e) 
		{
			return "Error occured cart table";
		}
    	
    }
    
    public static String initializeOrderTable(Connection connection) 
    {
    	Statement statement;
		try 
		{
			statement = connection.createStatement();
			statement.executeUpdate(CREATE_TABLE_ORDER);
	    	System.out.println("Order table initialized successfully.");
	    	return "Success order table";
		} 
		catch (SQLException e) 
		{
			return "Error occured order table";
		}
    	
    }

}
