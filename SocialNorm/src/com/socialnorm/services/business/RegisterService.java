package com.socialnorm.services.business;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;

import com.socialnorm.model.ChatModel;
import com.socialnorm.model.CommentModel;
import com.socialnorm.model.CredentialModel;
import com.socialnorm.model.MessageModel;
import com.socialnorm.model.RegisterModel;
import com.socialnorm.model.TopicModel;
import com.socialnorm.services.data.DataAccessInterface;
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
	// DataAccessInterface for injecting our RegistrationDAO
	DataAccessInterface<RegisterModel,CredentialModel,TopicModel,CommentModel,ChatModel,MessageModel> registrationDAO;
	/**
	 * Autowired method for setting the injected Registration DAO
	 * @param dao type IRegistrationDAO
	 */
	@Autowired
	@Qualifier("register")
	public void setRegistrationDAO(DataAccessInterface<RegisterModel,CredentialModel,TopicModel,CommentModel,ChatModel,MessageModel> dao)
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
	public int register(RegisterModel user) 
	{
		// if attempt to register results in 1 (success), insert the user into the info table
		if(registrationDAO.registerUser(user) == 1)
		{
			// if attempt to insert user into info table results in 1 (success), return 1 (success
			if(registrationDAO.addUserInfo(user) == 1)
			{
				return 1;
			}
			// else return -1 (failure)
			else
				return -1;
		}
		// else return 0 (duplicate username)
		else
			return 0;
	}
}
