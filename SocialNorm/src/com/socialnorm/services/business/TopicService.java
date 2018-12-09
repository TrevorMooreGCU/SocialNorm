package com.socialnorm.services.business;

import java.util.List;
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
 * Concrete implementation class of ITopicPostService interface
 * @author Trevor
 *
 */
public class TopicService implements ITopicService
{
	// DataAccessInterface for injecting our TopicDAO
	DataAccessInterface<RegisterModel,CredentialModel,TopicModel,CommentModel,ChatModel,MessageModel> topicDAO;
	/**
	 * Autowired method for setting the injected Topic DAO
	 * @param dao type ITopicDAO
	 */
	@Autowired
	@Qualifier("topic")
	public void setTopicDAO(DataAccessInterface<RegisterModel,CredentialModel,TopicModel,CommentModel,ChatModel,MessageModel> dao)
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
	public TopicModel addPost(TopicModel topic, CredentialModel user) 
	{
		// returning the result of the create post method called on the topic dao
		return (TopicModel) topicDAO.createPost(topic, user);
	}
	/**
	 * Method to get topics by category, returning a list of type TopicModel
	 * 
	 * @param category type String
	 * @return ListTopicModel
	 */
	@Override
	public List<TopicModel> getTopicByCategory(String category)
	{
		// returning the result of grabbing all the posts from a category using topic dao
		return topicDAO.getPostByCategory(category);
	}
	/**
	 * Method to get topics by userid, returning a list of type TopicModel
	 * 
	 * @param userid type String
	 * @return ListTopicModel
	 */
	@Override
	public List<TopicModel> getTopicByUser(String userid)
	{
		// returning the result of grabbing all the posts of a user using topic dao
		return topicDAO.getTopicByUser(userid);
	}
	/**
	 * Method to get all topics, returning a list of type TopicModel
	 * 
	 * @return ListTopicModel
	 */
	@Override
	public List<TopicModel> getAllPosts()
	{
		// returning the result of grabbing all the posts using topic dao
		return topicDAO.getAllPosts();
	}
	/**
	 * Method to get most recent topics of each category, returning a list of type TopicModel
	 * 
	 * @return ListTopicModel
	 */
	@Override
	public List<TopicModel> getMostRecentPosts()
	{
		// returning the result of grabbing the most recent posts using topic dao
		return topicDAO.getMostRecentPosts();
	}
	/**
	 * Method for getting a selected topic
	 * 
	 * @param id type String
	 * @return TopicModel
	 */
	@Override
	public TopicModel getTopic(String id)
	{
		// returning the result of grabbing the post using topic dao
		return (TopicModel) topicDAO.getTopic(id);
	}
	/**
	 * Method for updating a topic
	 * 
	 * @param topic type TopicModel
	 * @return TopicModel
	 */
	@Override
	public TopicModel updateTopic(TopicModel topic)
	{
		// returning the result of updating the post using topic dao
		return (TopicModel) topicDAO.updateTopic(topic);
	}
	/**
	 * Method for deleting the selected topic
	 * 
	 * @param topic type TopicModel
	 */
	@Override
	public void deleteTopic(TopicModel topic)
	{
		// deleting the post using topic dao
		topicDAO.deleteTopic(topic);
	}
	/**
	 * Method for adding a comment to a post
	 * 
	 * @param comment type CommentModel
	 * @param date type String
	 * @param postid type String
	 * @param userid type String
	 */
	@Override
	public void addComment(CommentModel comment, String date, String postid, String userid)
	{
		topicDAO.addComment(comment, date, postid, userid);
	}
	/**
	 * Method for getting all comments for a particular post
	 * 
	 * @param postid type String
	 * @return ListCommentModel
	 */
	@Override
	public List<CommentModel> getComments(String postid)
	{
		return topicDAO.getComments(postid);
	}
	/**
	 * Method for getting all a users info for their posts
	 * 
	 * @param userid type String
	 * @return RegisterModel
	 */
	@Override
	public RegisterModel getUserInfo(String userid)
	{
		return topicDAO.getUserInfo(userid);
	}
	/**
	 * Method for updating a users account
	 * 
	 * @param user type RegisterModel
	 */
	@Override
	public void updateAccount(RegisterModel user)
	{
		topicDAO.updateAccount(user);
	}
	/**
	 * Method to grab all the chats (usernames of who they have messages with) for the logged in user
	 * 
	 * @param userid type String
	 * @return ListChatModel
	 */
	@Override
	public List<ChatModel> getChats(String userid)
	{
		return topicDAO.getChats(userid);
	}
	/**
	 * Method for getting all the messages to a particular chat
	 * 
	 * @param chatid type String
	 * @return ListMessageModel
	 */
	@Override
	public List<MessageModel> getMessages(String chatid)
	{
		return topicDAO.getMessages(chatid);
	}
	/**
	 * Method for checking users have a chat already
	 * 
	 * @param sender type String
	 * @param receiver type String
	 * @return String
	 */
	@Override
	public String getChatId(String sender, String receiver)
	{
		return topicDAO.getChatId(sender, receiver);
	}
	/**
	 * Method for creating a chat
	 * 
	 * @param sender type String
	 * @param receiver type String
	 * @return String
	 */
	@Override
	public String createChat(String sender, String receiver)
	{
		return topicDAO.createChat(sender, receiver);
	}
	/**
	 * Method for sending a direct message
	 * 
	 * @param chatid type String
	 * @param mm type MessageModel
	 * @param date type String
	 */
	@Override
	public void sendMessage(String chatid, MessageModel mm, String date)
	{
		topicDAO.sendMessage(chatid, mm, date);
	}
	/**
	 * Method for getting all the topics that a user has commented on
	 * 
	 * @param userid type String
	 * @return ListTopicModel
	 */
	@Override
	public List<TopicModel> getTopicByUserComments(String userid)
	{
		return topicDAO.getTopicByUserComments(userid);
	}
	/**
	 * Method for getting all the topics that a user searches for
	 * 
	 * @param search type String
	 * @return ListTopicModel
	 */
	@Override
	public List<TopicModel> getSearchTopics(String search)
	{
		return topicDAO.getSearchTopics(search);
	}
}
