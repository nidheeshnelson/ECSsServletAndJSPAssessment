package org.nidheeshnelson.servletassessment.configuration;

import java.sql.Connection;

import org.nidheeshnelson.servletassessment.dao.CartDao;
import org.nidheeshnelson.servletassessment.dao.OrderDao;
import org.nidheeshnelson.servletassessment.dao.ProductDao;
import org.nidheeshnelson.servletassessment.dao.SignInDao;
import org.nidheeshnelson.servletassessment.dao.SignUpDao;
import org.nidheeshnelson.servletassessment.model.OrderModel;
import org.nidheeshnelson.servletassessment.model.ProductModel;
import org.nidheeshnelson.servletassessment.model.SignUpModel;
import org.nidheeshnelson.servletassessment.service.CartService;
import org.nidheeshnelson.servletassessment.service.OrderService;
import org.nidheeshnelson.servletassessment.service.ProductService;
import org.nidheeshnelson.servletassessment.service.SignInService;
import org.nidheeshnelson.servletassessment.service.SignUpService;

public class Configurations 
{
	public SignUpService signUpServiceConfig()
	{
		return new SignUpService();
	}
	
	public SignInService signInServiceConfig()
	{
		return new SignInService();
	}
	
	public ProductService productServiceConfig()
	{
		return new ProductService();
	}
	
	public CartService cartServiceConfig()
	{
		return new CartService();
	}
	
	public OrderService orderServiceConfig()
	{
		return new OrderService();
	}
	
	public SignUpModel signUpModelConfig(String username, String email, String password)
	{
		return new SignUpModel(username, email, password);
	}
	
	public ProductModel productModelConfig()
	{
		return new ProductModel();
	}
	
	public OrderModel orderModelConfig()
	{
		return new OrderModel();
	}
	
	public SignUpDao signUpDaoConfig(Connection connection)
	{
		return new SignUpDao(connection);
	}
	
	public SignInDao signInDaoConfig(Connection connection)
	{
		return new SignInDao(connection);
	}
	
	public ProductDao productDaoConfig(Connection connection)
	{
		return new ProductDao(connection);
	}
	
	public CartDao cartDaoConfig(Connection connection)
	{
		return new CartDao(connection);
	}
	
	public OrderDao orderDaoConfig(Connection connection)
	{
		return new OrderDao(connection);
	}
	
}
