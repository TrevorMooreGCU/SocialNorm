package com.socialnorm.services.business;

import com.socialnorm.model.CredentialModel;

/**
 * Trevor Moore
 * CST-341
 * 10/10/2018
 * This assignment was completed in collaboration with Aaron Ross
 * This is our own work.
 * 
 * ILoginService interface for the LoginService
 * @author Trevor
 *
 */
public interface ILoginService
{
	/**
	 * Method for checking if a user's credentials are in the database
	 * 
	 * @param user of type CredentialModel
	 * @return boolean object type
	 */
	public String loginCheck(CredentialModel user);
}
