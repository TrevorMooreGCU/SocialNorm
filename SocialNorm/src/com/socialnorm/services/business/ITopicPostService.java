package com.socialnorm.services.business;

import com.socialnorm.model.CredentialModel;
import com.socialnorm.model.TopicModel;

/**
 * Trevor Moore
 * CST-341
 * 10/10/2018
 * This assignment was completed in collaboration with Aaron Ross
 * This is our own work.
 * 
 * ITopicPostService interface for the TopicPostService
 * @author Trevor
 *
 */
public interface ITopicPostService 
{
	/**
	 * Method for inserting a user's topic into the database
	 * 
	 * @param topic of type TopicModel
	 * @param user of type CredentialModel
	 * @return boolean object type
	 */
	public boolean addPost(TopicModel topic, CredentialModel user);
}
