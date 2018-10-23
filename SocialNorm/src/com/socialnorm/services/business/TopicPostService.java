package com.socialnorm.services.business;

import org.springframework.beans.factory.annotation.Autowired;

import com.socialnorm.model.CredentialModel;
import com.socialnorm.model.TopicModel;
import com.socialnorm.services.data.ITopicDAO;

/**
 * Trevor Moore
 * CST-341
 * 10/10/2018
 * This assignment was completed in collaboration with Aaron Ross
 * This is our own work.
 * 
 * Concrete implementation class of ITopicPostService interface
 * @author Trevor
 *
 */
public class TopicPostService implements ITopicPostService
{
	// ITopicDAO for injecting our TopicDAO
	ITopicDAO topicDAO;

	/**
	 * Autowired method for setting the injected Topic DAO
	 * @param dao type ITopicDAO
	 */
	@Autowired
	public void setTopicDAO(ITopicDAO dao)
	{
		this.topicDAO = dao;
	}
	
	/**
	 * Overridden method for inserting a user's topic into the database
	 * 
	 * @param topic of type TopicModel
	 * @param user of type CredentialModel
	 * @return boolean object type
	 */
	@Override
	public boolean addPost(TopicModel topic, CredentialModel user) 
	{
		// try catch for catching database exceptions
		try
		{
			// returning the result of the create post method called on the topic dao
			return topicDAO.createPost(topic, user);
		}
		// catch exceptions
		catch(Exception e)
		{
			System.out.println("Database Exception. Caught in Topic Post Business Service.");
			return false;
		}
	}
}
