package com.socialnorm.services.business;

import java.util.List;

import com.socialnorm.model.ChatModel;
import com.socialnorm.model.CommentModel;
import com.socialnorm.model.CredentialModel;
import com.socialnorm.model.MessageModel;
import com.socialnorm.model.RegisterModel;
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
public interface ITopicService 
{
	/**
	 * Method for inserting a user's topic into the database
	 * 
	 * @param topic of type TopicModel
	 * @param user of type CredentialModel
	 * @return TopicModel object type
	 */
	public TopicModel addPost(TopicModel topic, CredentialModel user);
	/**
	 * Method for getting all topics from a specific category
	 * 
	 * @param category type String
	 * @return type ListTopicModel
	 */
	public List<TopicModel> getTopicByCategory(String category);
	/**
	 * Method for getting all topics from a specific user
	 * 
	 * @param userid type String
	 * @return type ListTopicModel
	 */
	public List<TopicModel> getTopicByUser(String userid);
	/**
	 * Method for getting all topics
	 * 
	 * @return type ListTopicModel
	 */
	public List<TopicModel> getAllPosts();
	/**
	 * Method for getting most recent topics of each category
	 * 
	 * @return type ListTopicModel
	 */
	public List<TopicModel> getMostRecentPosts();
	/**
	 * Method for getting the selected Post
	 * 
	 * @param id type String
	 * @return type TopicModel
	 */
	public TopicModel getTopic(String id);
	/**
	 * Method for updating post
	 * 
	 * @param topic type String
	 * @return type TopicModel
	 */
	public TopicModel updateTopic(TopicModel topic);
	/**
	 * Method for deleting the selected topic
	 * 
	 * @param topic type TopicModel
	 */
	public void deleteTopic(TopicModel topic);
	/**
	 * Method for adding a comment to a post
	 * 
	 * @param comment type CommentModel
	 * @param date type String
	 * @param postid type String
	 * @param userid type String
	 */
	public void addComment(CommentModel comment, String date, String postid, String userid);
	/**
	 * Method for getting all comments for a particular post
	 * 
	 * @param postid type String
	 * @return ListCommentModel
	 */
	public List<CommentModel> getComments(String postid);
	/**
	 * Method for getting all a users info for their posts
	 * 
	 * @param userid type String
	 * @return RegisterModel
	 */
	public RegisterModel getUserInfo(String userid);
	/**
	 * Method for updating a users account
	 * 
	 * @param user type RegisterModel
	 */
	public void updateAccount(RegisterModel user);
	/**
	 * Method to grab all the chats (usernames of who they have messages with) for the logged in user
	 * 
	 * @param userid type String
	 * @return ListChatModel
	 */
	public List<ChatModel> getChats(String userid);
	/**
	 * Method for getting all the messages to a particular chat
	 * 
	 * @param chatid type String
	 * @return ListMessageModel
	 */
	public List<MessageModel> getMessages(String chatid);
	/**
	 * Method for checking users have a chat already
	 * 
	 * @param sender type String
	 * @param receiver type String
	 * @return String
	 */
	public String getChatId(String sender, String receiver);
	/**
	 * Method for creating a chat
	 * 
	 * @param sender type String
	 * @param receiver type String
	 * @return String
	 */
	public String createChat(String sender, String receiver);
	/**
	 * Method for sending a direct message
	 * 
	 * @param chatid type String
	 * @param mm type MessageModel
	 * @param date type String
	 */
	public void sendMessage(String chatid, MessageModel mm, String date);
	/**
	 * Method for getting all the topics that a user has commented on
	 * 
	 * @param userid type String
	 * @return ListTopicModel
	 */
	public List<TopicModel> getTopicByUserComments(String userid);
	/**
	 * Method for getting all the topics that a user searches for
	 * 
	 * @param search type String
	 * @return ListTopicModel
	 */
	public List<TopicModel> getSearchTopics(String search);
}
