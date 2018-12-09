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
 * Concrete implementation class of ILoginService interface
 * @author Trevor
 *
 */
public class LoginService implements ILoginService
{
	// DataAccessInterface for injecting our SecurityDAO
	DataAccessInterface<RegisterModel,CredentialModel,TopicModel,CommentModel,ChatModel,MessageModel> securityDAO;
	/**
	 * Autowired method for setting the injected Security DAO
	 * @param dao type ISecurityDAO
	 */
	@Autowired
	@Qualifier("security")
	public void setSecurityDAO(DataAccessInterface<RegisterModel,CredentialModel,TopicModel,CommentModel,ChatModel,MessageModel> dao)
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
	public String loginCheck(CredentialModel user) 
	{
		// return the result of the check user method called on the security dao
		return securityDAO.checkUser(user);
	}
}
