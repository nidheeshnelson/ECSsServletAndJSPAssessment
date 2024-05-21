package org.nidheeshnelson.servletassessment.model;

public class SignUpModel 
{
	private String username;
	private String email;
	private String password;
	public SignUpModel(String username, String email, String password) 
	{
		this.username = username;
		this.email = email;
		this.password = password;
	}
	public String getUsername() 
	{
		return username;
	}
	public String getEmail() 
	{
		return email;
	}
	public String getPassword() 
	{
		return password;
	}
	@Override
	public String toString() 
	{
		return "SignUpModel [username=" + username + ", email=" 
				+ email + ", password=" + password + "]";
	}
	
}
