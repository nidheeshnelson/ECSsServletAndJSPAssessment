package org.nidheeshnelson.servletassessment.control;

import java.io.IOException;
import java.util.List;

import org.nidheeshnelson.servletassessment.configuration.Configurations;
import org.nidheeshnelson.servletassessment.model.ProductModel;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet("/cart")
public class CartController extends HttpServlet 
{
	private Configurations configuration = new Configurations();
	private static final long serialVersionUID = 1L;
	public CartController() 
	{
    }
	
	protected void doGet(HttpServletRequest request, HttpServletResponse response) 
			throws ServletException, IOException 
	{
		String username= request.getParameter("username");
		System.out.println("in cart doget "+username);
		List<ProductModel> cartProducts = configuration.cartServiceConfig().cartService(username);
		System.out.println("cartProducts: "+cartProducts);
		request.setAttribute("username", username);
		request.setAttribute("productList", cartProducts);
        request.getRequestDispatcher("cart.jsp").forward(request, response);
		
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) 
			throws ServletException, IOException 
	{
		doGet(request, response);
	}

	protected void doPut(HttpServletRequest request, HttpServletResponse response) 
			throws ServletException, IOException 
	{
		
	}

	protected void doDelete(HttpServletRequest request, HttpServletResponse response) 
			throws ServletException, IOException 
	{
		
	}
}
