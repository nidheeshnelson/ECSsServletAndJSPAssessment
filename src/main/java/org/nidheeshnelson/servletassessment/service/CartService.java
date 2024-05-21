package org.nidheeshnelson.servletassessment.service;

import java.sql.Connection;
import java.util.ArrayList;
import java.util.List;

import org.nidheeshnelson.servletassessment.configuration.Configurations;
import org.nidheeshnelson.servletassessment.database.DataBaseInitializer;
import org.nidheeshnelson.servletassessment.model.ProductModel;

public class CartService 
{
	Configurations configuration = new Configurations();
	public List<ProductModel> cartService(String username)
	{
		List<ProductModel> cartProducts = new ArrayList<>();
		long[] productIDs = {1001, 1002, 1003, 1004, 1005};
		Connection connection = DataBaseInitializer.initializeDatabase();
		for(long productID :productIDs)
		{
			int count = configuration.cartDaoConfig(connection)
									.getCartCount(productID, username);
			if(count>0)
			{
				ProductModel product = configuration.productDaoConfig(connection)
													.getProductById(productID);
				product.setCount(count);
				cartProducts.add(product);
			}
		}
		return cartProducts;
	}
}
