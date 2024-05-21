package org.nidheeshnelson.servletassessment.service;

import java.sql.Connection;
import java.util.List;

import org.nidheeshnelson.servletassessment.configuration.Configurations;
import org.nidheeshnelson.servletassessment.database.DataBaseInitializer;
import org.nidheeshnelson.servletassessment.model.OrderModel;

public class OrderService 
{
	private Configurations configuration = new Configurations();
	
	public String addOrder(OrderModel orderModel) 
	{
		System.out.println("In addOrder()");
		Connection connection = DataBaseInitializer.initializeDatabase();
		String orderTable = DataBaseInitializer.initializeOrderTable(connection);
		System.out.println(orderTable);
		String insertTable = configuration.orderDaoConfig(connection)
										.insertOrderTable(orderModel);
		System.out.println(insertTable);
		String deleteCartTable = configuration.cartDaoConfig(connection)
												.deleteCartTable(orderModel.getProductID(), 
																	orderModel.getUsername()
																);
		System.out.println(deleteCartTable);
		return "addOrder() completed";
	}
	
	public List<OrderModel> getOrder(String username) 
	{
		Connection connection = DataBaseInitializer.initializeDatabase();
		String orderTable = DataBaseInitializer.initializeOrderTable(connection);
		System.out.println(orderTable);
		return configuration.orderDaoConfig(connection).getOrderTable(username);
	}
}
