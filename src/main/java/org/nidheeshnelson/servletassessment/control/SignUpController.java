package org.nidheeshnelson.servletassessment.control;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.nidheeshnelson.servletassessment.configuration.Configurations;

@WebServlet("/")
public class SignUpController extends HttpServlet {
	private static final long serialVersionUID = 1L;
    Configurations configuration = new Configurations();
    	public SignUpController() 
    	{
    		super();
        }
    	
    	protected void doGet(HttpServletRequest request, HttpServletResponse response) 
    			throws ServletException, IOException 
    	{
    		System.out.println("in signup controller get");
    		response.sendRedirect("signup.jsp");
    	}

    	protected void doPost(HttpServletRequest request, HttpServletResponse response) 
    			throws ServletException, IOException 
    	{
    		System.out.println("in signup post");
    		String resp = configuration.signUpServiceConfig()
    								.signUpService(
    										configuration.signUpModelConfig(
    												request.getParameter("username"), 
    												request.getParameter("email"),
    												request.getParameter("password")
    																		)
    												);
    		System.out.println(resp);
    		if(resp.equals("SUCCESS")) 
    		{
    			request.getSession().setAttribute("message5", "You successfully signed up... Please sign in");
    			response.sendRedirect("signin.jsp");
    		}
    		else if(resp.equals("FAILED"))
    		{
    			request.getSession().setAttribute("message5", "The email id or username you entered already exists... Please enter another");
    			response.sendRedirect("signup.jsp");
    		}
    		else 
    		{
    			request.getSession().setAttribute("message5", "An error occured");
    			response.sendRedirect("signup.jsp");
    		}
    	}

}
