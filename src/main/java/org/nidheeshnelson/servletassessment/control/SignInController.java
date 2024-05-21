package org.nidheeshnelson.servletassessment.control;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.nidheeshnelson.servletassessment.configuration.Configurations;

@WebServlet("/signin")
public class SignInController extends HttpServlet 
{
	private static final long serialVersionUID = 1L;
	Configurations configuration = new Configurations();
	public SignInController() 
	{
        super();
    }
	
	protected void doGet(HttpServletRequest request, HttpServletResponse response) 
			throws ServletException, IOException 
	{
		request.getSession().setAttribute("username", request.getParameter("username"));
		response.sendRedirect("page.jsp");
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) 
			throws ServletException, IOException 
	{
		if(configuration.signInServiceConfig()
						.signInService(configuration.signUpModelConfig(
    												request.getParameter("username"), 
    												request.getParameter(null),
    												request.getParameter("password")
    																	)
										)
				) 
					{
					request.getSession().setAttribute("message2", "Hi "+request.getParameter("username")+".. You login successfully");
					request.getSession().setAttribute("username", request.getParameter("username"));
					response.sendRedirect("page.jsp");
					}
		else 
		{
			request.getSession().setAttribute("message", "The email id or username you entered not exists... Please sign up");
			response.sendRedirect("signup.jsp");
		}
	}

}
