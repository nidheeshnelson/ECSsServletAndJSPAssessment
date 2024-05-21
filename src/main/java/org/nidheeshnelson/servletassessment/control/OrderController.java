package org.nidheeshnelson.servletassessment.control;

import java.io.IOException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.nidheeshnelson.servletassessment.configuration.Configurations;
import org.nidheeshnelson.servletassessment.model.OrderModel;
import org.nidheeshnelson.servletassessment.model.ProductModel;

@WebServlet("/order")
public class OrderController extends HttpServlet 
{
	private static final long serialVersionUID = 1L;
	private Configurations configuration = new Configurations();
	public OrderController() 
	{
    }

	protected void doGet(HttpServletRequest request, HttpServletResponse response) 
			throws ServletException, IOException 
	{
		String username= request.getParameter("username");
		System.out.println("in order doget "+username);
		List<OrderModel> listOfOrderModel = configuration.orderServiceConfig().getOrder(username);
		System.out.println("listOfOrderModel :"+listOfOrderModel);
		request.setAttribute("username", username);
		request.setAttribute("orderList", listOfOrderModel);
		request.getRequestDispatcher("order.jsp").forward(request, response);
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) 
			throws ServletException, IOException 
	{
		OrderModel orderModel = new OrderModel();
		orderModel.setUsername(request.getParameter("username"));
		orderModel.setProductID(Long.parseLong(request.getParameter("productID")));
		orderModel.setProductName(request.getParameter("productName"));
		orderModel.setNetPrice(Double.parseDouble(request.getParameter("netPrice")));
		orderModel.setQuantity(Integer.parseInt(request.getParameter("quantity")));
		orderModel.setTotalAmount(Double.parseDouble(request.getParameter("totalAmount")));
		String addOrder = configuration.orderServiceConfig().addOrder(orderModel);
		System.out.println(addOrder);
		List<ProductModel> cartProducts = configuration.cartServiceConfig().cartService(orderModel.getUsername());
		System.out.println("cartProducts: "+cartProducts);
		request.setAttribute("productList", cartProducts);
		request.setAttribute("username", orderModel.getUsername());
		request.setAttribute("message1", orderModel.getUsername()+".. You successfully Buy the product in the product "
											+orderModel.getProductName()+" with total amount "+orderModel.getTotalAmount());
		request.getRequestDispatcher("cart.jsp").forward(request, response);
	}

}
