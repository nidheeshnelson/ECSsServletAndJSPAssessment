package org.nidheeshnelson.servletassessment.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import org.nidheeshnelson.servletassessment.model.SignUpModel;

public class SignUpDao {
	private Connection connection;
	public SignUpDao(Connection connection) 
	{
        this.connection = connection;
    }

    public int addUser(SignUpModel signUpModel) 
    		throws SQLException 
    {
    	System.out.println("in addUser()");
        String query = "INSERT INTO signup (username, password, email) VALUES (?, ?, ?)";
        try (PreparedStatement statement = connection.prepareStatement(query)) 
        {
        	System.out.println("in addUser() try");
            statement.setString(1, signUpModel.getUsername());
            statement.setString(2, signUpModel.getPassword());
            statement.setString(3, signUpModel.getEmail());
            return statement.executeUpdate();
        }
    }

    public boolean checkUsernameExists(String username) 
    		throws SQLException 
    {
    	System.out.println("in checkUsernameExists()");
        String query = "SELECT * FROM signup WHERE username = ?";
        try (PreparedStatement statement = connection.prepareStatement(query)) 
        {
        	System.out.println("in checkUsernameExists() try");
            statement.setString(1, username);
            try (ResultSet resultSet = statement.executeQuery()) 
            {
            	System.out.println("in checkUsernameExists() try try");
                return resultSet.next();
            }
        }
    }

    public boolean checkEmailExists(String email) 
    		throws SQLException 
    {
    	System.out.println("in checkEmailExists()");
        String query = "SELECT * FROM signup WHERE email = ?";
        try (PreparedStatement statement = connection.prepareStatement(query)) 
        {
        	System.out.println("in checkEmailExists() try");
            statement.setString(1, email);
            try (ResultSet resultSet = statement.executeQuery()) 
            {
            	System.out.println("in checkEmailExists() try try");
                return resultSet.next();
            }
        }
    }
}
