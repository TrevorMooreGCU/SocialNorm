package com.socialnorm.services.business;

import org.springframework.beans.factory.annotation.Autowired;
import com.socialnorm.model.RegisterModel;
import com.socialnorm.services.data.IRegistrationDAO;

/**
 * Trevor Moore
 * CST-341
 * 10/10/2018
 * This assignment was completed in collaboration with Aaron Ross
 * This is our own work.
 * 
 * Concrete implementation class of IRegisterService interface
 * @author Trevor
 *
 */
public class RegisterService implements IRegisterService
{
	// IRegistrationDAO for injecting our RegistrationDAO
	IRegistrationDAO registrationDAO;

	/**
	 * Autowired method for setting the injected Registration DAO
	 * @param dao type IRegistrationDAO
	 */
	@Autowired
	public void setRegistrationDAO(IRegistrationDAO dao)
	{
		this.registrationDAO = dao;
	}
	
	/**
	 * Overridden method for inserting a user's credentials into the database
	 * 
	 * @param user of type RegisterModel
	 * @return String object type
	 */
	@Override
	public String register(RegisterModel user) 
	{
		// try catch for catching database exceptions
		try
		{
			// returning the result of the registerUser called on the registration dao
			return registrationDAO.registerUser(user);
		}
		// catch exceptions
		catch(Exception e)
		{
			System.out.println("Database Exception. Caught in Register Business Service.");
			return "failure";
		}
	}
}
