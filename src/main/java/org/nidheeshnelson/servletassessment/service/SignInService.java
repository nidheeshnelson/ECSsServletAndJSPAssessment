package org.nidheeshnelson.servletassessment.service;

import java.sql.Connection;

import org.nidheeshnelson.servletassessment.configuration.Configurations;
import org.nidheeshnelson.servletassessment.database.DataBaseInitializer;
import org.nidheeshnelson.servletassessment.model.SignUpModel;

public class SignInService 
{
	Configurations configuration = new Configurations();
	public boolean signInService(SignUpModel signUpModel) 
	{
		System.out.println("in signInService()");
		try 
			{
				System.out.println("in signInService() try()");
				Connection connection = DataBaseInitializer.initializeDatabase();
				if(configuration.signInDaoConfig(connection).authenticateUser(signUpModel)) 
					{
						System.out.println("authentication Successfully compleated");
						return true;
					}
				else 
				{
					return false;
				}
			} 
		catch (Exception e) 
			{
				return false;
			}
	}
}
