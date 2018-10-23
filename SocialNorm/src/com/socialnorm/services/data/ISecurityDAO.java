package com.socialnorm.services.data;

import com.socialnorm.model.CredentialModel;

/**
 * Trevor Moore
 * CST-341
 * 10/10/2018
 * This assignment was completed in collaboration with Aaron Ross
 * This is our own work.
 * 
 * ISecurityDAO interface for the SecurityDAO
 * @author Trevor
 *
 */
public interface ISecurityDAO 
{
	/**
	 * Method for checking if a user is in the users table
	 * 
	 * @param user type CredentialModel
	 * @return boolean object type
	 */
	public boolean checkUser(CredentialModel user);
}
