package org.nidheeshnelson.servletassessment.service;

import java.sql.Connection;

import org.nidheeshnelson.servletassessment.configuration.Configurations;
import org.nidheeshnelson.servletassessment.database.DataBaseInitializer;

public class ProductService 
{
	Configurations configuration = new Configurations();
	public String productService(long productID, String username) 
	{
		System.out.println("In product service");
		Connection connection = DataBaseInitializer.initializeDatabase();
		String createProductTable = DataBaseInitializer.initializeProductTable(connection);
		System.out.println(createProductTable);
		String insertProduct = configuration.productDaoConfig(connection).insertProductInProductTable(productID);
		System.out.println(insertProduct);
		String createCartTable = DataBaseInitializer.initializeCartTable(connection);
		String insertCart = configuration.cartDaoConfig(connection).insertCartTable(productID, username);
		System.out.println(insertCart);
		return "Insert cart successfully";
	}
}
