package org.nidheeshnelson.servletassessment.service;

import java.sql.Connection;
import java.sql.DriverManager;
import org.nidheeshnelson.servletassessment.configuration.Configurations;
import org.nidheeshnelson.servletassessment.database.DataBaseInitializer;
import org.nidheeshnelson.servletassessment.model.SignUpModel;

public class SignUpService 
{
	Configurations configuration = new Configurations();
	public String signUpService(SignUpModel signUpModel) 
	{
		try 
			{
				Connection connection = DataBaseInitializer.initializeDatabase();
				if((!configuration.signUpDaoConfig(connection).checkUsernameExists(signUpModel.getUsername()) 
						&& 
					(!configuration.signUpDaoConfig(connection).checkEmailExists(signUpModel.getEmail())))) 
					{
						int respond=configuration.signUpDaoConfig(connection)
													.addUser(signUpModel);
						System.out.println("respond "+respond);
						return "SUCCESS";
					}
				return "FAILED";
				
			} 
		catch (Exception e) 
			{
				return "Error Occured";
			}
	}
}

