package com.socialnorm.model;

import javax.validation.constraints.Digits;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Pattern;
import javax.validation.constraints.Size;

/**
 * Trevor Moore
 * CST-341
 * 09/22/2018
 * This assignment was completed in collaboration with Aaron Ross
 * This is our own work.
 * 
 * We used source code from the following:
 * https://docs.oracle.com/javaee/6/tutorial/doc/gircz.html
 * http://regexlib.com/Search.aspx?k=email&AspxAutoDetectCookieSupport=1
 * 
 * For bean validation/regex
 * 
 * RegisterModel Class for holding the parameters for the register form on the register page. Also IS-A CredentialModel
 * @author Trevor
 * 
 */
public class RegisterModel extends CredentialModel
{
	@NotNull(message="First Name cannot be left blank.")
	@Size(min=2, max=25, message="Must be between 2 and 25 characters.")
	private String firstName;
	
	@NotNull(message="Last Name cannot be left blank.")
	@Size(min=2, max=25, message="Must be between 2 and 25 characters.")
	private String lastName;
	
	@NotNull(message="Email cannot be left blank.")
	@Size(min=7, max=40, message="Must be between 7 and 40 characters.")
	@Pattern(regexp="^[\\w-\\.]+@([\\w-]+\\.)+[\\w-]{2,4}$", message="Must be a real email.")
	private String email;
	
	@NotNull(message="Phone cannot be left blank.")
	@Digits(integer=10, fraction=0, message="Must be a real phone number.")
	private String phone;
	
	@Size(max=500, message="Cannot exceed 500 characters.")
	private String bio;
	
	private String id;

	/**
	 * Default constructor
	 */
	public RegisterModel()
	{
		this.firstName = "";
		this.lastName = "";
		this.email = "";
		this.phone = "";
		this.username = "";
		this.password = "";
		this.bio = "";
		this.id = "";
	}
	
	/**
	 * Non-default constructor
	 * @param firstName type String
	 * @param lastName type String
	 * @param email type String
	 * @param phone type String
	 * @param username type String
	 * @param password type String
	 */
	public RegisterModel(String firstName, String lastName, String email, String phone, String username, String password) 
	{
		super();
		this.firstName = firstName;
		this.lastName = lastName;
		this.email = email;
		this.phone = phone;
		this.username = username;
		this.password = password;
	}

	// GETTERS AND SETTERS
	public String getFirstName() 
	{
		return firstName;
	}
	public void setFirstName(String firstName) 
	{
		this.firstName = firstName;
	}
	public String getLastName() 
	{
		return lastName;
	}
	public void setLastName(String lastName) 
	{
		this.lastName = lastName;
	}
	public String getEmail() {
		return email;
	}
	public void setEmail(String email) {
		this.email = email;
	}
	public String getPhone() {
		return phone;
	}
	public void setPhone(String phone) {
		this.phone = phone;
	}
	public String getBio() {
		return bio;
	}
	public void setBio(String bio) {
		this.bio = bio;
	}
	public String getId() {
		return id;
	}
	public void setId(String id) {
		this.id = id;
	}
}