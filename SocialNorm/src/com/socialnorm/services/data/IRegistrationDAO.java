package com.socialnorm.services.data;

import com.socialnorm.model.RegisterModel;

/**
 * Trevor Moore
 * CST-341
 * 10/10/2018
 * This assignment was completed in collaboration with Aaron Ross
 * This is our own work.
 * 
 * IRegistrationDAO interface for the RegistrationDAO
 * @author Trevor
 *
 */
public interface IRegistrationDAO 
{
	/**
	 * Method for registering a user into the database
	 * 
	 * @param user of type RegisterModel
	 * @return type String
	 */
	public String registerUser(RegisterModel user);
}
