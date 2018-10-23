package com.socialnorm.services.business;

import org.springframework.beans.factory.annotation.Autowired;
import com.socialnorm.model.CredentialModel;
import com.socialnorm.services.data.ISecurityDAO;

/**
 * Trevor Moore
 * CST-341
 * 10/10/2018
 * This assignment was completed in collaboration with Aaron Ross
 * This is our own work.
 * 
 * Concrete implementation class of ILoginService interface
 * @author Trevor
 *
 */
public class LoginService implements ILoginService
{
	// ISecurityDAO for injecting our SecurityDAO
	ISecurityDAO securityDAO;

	/**
	 * Autowired method for setting the injected Security DAO
	 * @param dao type ISecurityDAO
	 */
	@Autowired
	public void setSecurityDAO(ISecurityDAO dao)
	{
		this.securityDAO = dao;
	}
	
	/**
	 * Overridden method for checking if a user's credentials are in the database
	 * 
	 * @param user of type CredentialModel
	 * @return boolean object type
	 */
	@Override
	public boolean loginCheck(CredentialModel user) 
	{
		// try catch for catching database exceptions
		try
		{
			// return the result of the check user method called on the security dao
			return securityDAO.checkUser(user);
		}
		// catch exceptions
		catch(Exception e)
		{
			System.out.println("Database Exception. Caught in Login Business Service.");
			return false;
		}
	}
	
}
