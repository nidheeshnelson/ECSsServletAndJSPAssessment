package org.nidheeshnelson.servletassessment.control;

import java.io.IOException;

import org.nidheeshnelson.servletassessment.configuration.Configurations;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet("/product")
public class ProductController extends HttpServlet {
	private static final long serialVersionUID = 1L;
	Configurations configuration = new Configurations();
	
    public ProductController() 
    {
        super();
    }

	protected void doGet(HttpServletRequest request, HttpServletResponse response) 
			throws ServletException, IOException 
	{
		response.getWriter().append("Served at: ").append(request.getContextPath());
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) 
			throws ServletException, IOException 
	{
		System.out.println("In product get");
		long productID = Long.parseLong(request.getParameter("productID"));
		String username = request.getParameter("username");
		System.out.println("username: "+username+" productID: "+productID);
		String cartadd = configuration.productServiceConfig().productService(productID, username);
		request.getSession().setAttribute("username", username);
		request.getSession().setAttribute("message2", username+".. You successfully added the Product "+productID+" in your cart");
		response.sendRedirect("page.jsp");
	}

}
