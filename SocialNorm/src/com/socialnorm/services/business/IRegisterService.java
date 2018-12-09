package com.socialnorm.services.business;

import com.socialnorm.model.RegisterModel;

/**
 * Trevor Moore
 * CST-341
 * 10/10/2018
 * This assignment was completed in collaboration with Aaron Ross
 * This is our own work.
 * 
 * IRegisterService interface for the RegisterService
 * @author Trevor
 *
 */
public interface IRegisterService
{
	/**
	 * Method for inserting a user's credentials into the database
	 * 
	 * @param user of type RegisterModel
	 * @return String object type
	 */
	public int register(RegisterModel user);
}
