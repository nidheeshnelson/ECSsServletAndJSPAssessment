package org.nidheeshnelson.servletassessment.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import org.nidheeshnelson.servletassessment.model.SignUpModel;

public class SignInDao {
	private Connection connection;
	public SignInDao(Connection connection) 
	{
        this.connection = connection;
    }
	
	public boolean authenticateUser(SignUpModel signUpModel) 
    		throws SQLException 
    {
    	System.out.println("in authenticateUser()");
        String query = "SELECT * FROM signup WHERE username = ? AND password = ?";
        try (PreparedStatement statement = connection.prepareStatement(query)) 
        {
        	System.out.println("in authenticateUser() try");
            statement.setString(1, signUpModel.getUsername());
            statement.setString(2, signUpModel.getPassword());
            try (ResultSet resultSet = statement.executeQuery()) 
            {
            	System.out.println("in authenticateUser() try");
                return resultSet.next();
            }
        }
    }
}
