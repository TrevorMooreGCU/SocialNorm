package com.socialnorm.model;

import javax.validation.constraints.NotNull;
import javax.validation.constraints.Pattern;
import javax.validation.constraints.Size;

/**
 * Trevor Moore
 * CST-341
 * 10/10/2018
 * This assignment was completed in collaboration with Aaron Ross
 * This is our own work.
 * 
 * We used source code from the following:
 * https://docs.oracle.com/javaee/6/tutorial/doc/gircz.html
 * https://www.mkyong.com/regular-expressions/how-to-validate-password-with-regular-expression/
 * 
 * For bean validation/password regex
 * 
 * CredentialModel Class for holding the parameters for the login form in the header and on the login page. Is also parent of RegisterModel.
 * @author Trevor
 * 
 */
public class CredentialModel
{
	@NotNull(message="Username cannot be left blank.")
	@Size(min=8, max=25, message="Must be between 8 and 25 characters.")
	protected String username;
	
	@NotNull(message="Password cannot be left blank.")
	@Size(min=8, max=25, message="Must be between 8 and 25 characters.")
	@Pattern(regexp="((?=.*\\d)(?=.*[a-z])(?=.*[A-Z])(?=.*[@#$%!&]).{8,25})", message="Must contain at least 8 characters, 1 letter, 1 number and 1 special character.")
	protected String password;

	/**
	 * Default constructor
	 */
	public CredentialModel()
	{
		this.username = "";
		this.password = "";
	}
	
	/**
	 * Non-default constructor
	 * @param username type String
	 * @param password type String
	 */
	public CredentialModel(String username, String password) 
	{
		super();
		this.username = username;
		this.password = password;
	}

	// GETTERS AND SETTERS
	public String getUsername() {
		return username;
	}
	public void setUsername(String username) {
		this.username = username;
	}
	public String getPassword() {
		return password;
	}
	public void setPassword(String password) {
		this.password = password;
	}
	
}
