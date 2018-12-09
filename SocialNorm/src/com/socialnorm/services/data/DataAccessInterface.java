package com.socialnorm.services.data;

import java.util.List;

/**
 * Trevor Moore
 * CST-341
 * 11/19/2018
 * This assignment was completed in collaboration with Aaron Ross
 * This is our own work.
 * 
 * DataAccessInterface abstract class to provide an interface for all DAOs
 * @author Trevor
 *
 */
public abstract class DataAccessInterface <R, C, T, M, X, Z>
{
	/**
	 * Method for registering a user into the database
	 * 
	 * @param user of type RegisterModel
	 * @return type String
	 */
	public int registerUser(R user) {
		return 0;
	};
	/**
	 * Method for inserting user info into the database
	 * 
	 * @param user of type RegisterModel
	 * @return type String
	 */
	public int addUserInfo(R user) {
		return 0;
	}
	/**
	 * Method for checking if a user is in the users table
	 * 
	 * @param user type CredentialModel
	 * @return boolean object type
	 */
	public String checkUser(C user) {
		return null;
	};
	/**
	 * Method for inserting a new post into the posts table
	 * 
	 * @param model type TopicModel
	 * @param user type CredentialModel (to get the users ID who posted it)
	 * @return model type TopicModel
	 */
	public T createPost(T model, C user) {
		return null;
	}
	/**
	 * Method for grabbing every topic from a specific category
	 * 
	 * @param category type String
	 * @return ListTopicModel type
	 */
	public List<T> getPostByCategory(String category) {
		return null;
	}
	/**
	 * Method for getting all topics from a specific user
	 * 
	 * @param userid type String
	 * @return type ListTopicModel
	 */
	public List<T> getTopicByUser(String userid) {
		return null;
	}
	/**
	 * Method for grabbing all topics
	 * 
	 * @return ListTopicModel type
	 */
	public List<T> getAllPosts() {
		return null;
	}
	/**
	 * Method for grabbing most recent topic in each category
	 * 
	 * @return ListTopicModel type
	 */
	public List<T> getMostRecentPosts() {
		return null;
	}
	/**
	 * Method for grabbing the selected Post
	 * 
	 * @param id type String
	 * @return type TopipcModel
	 */
	public T getTopic(String id) {
		return null;
	}
	/**
	 * Method for updating post
	 * 
	 * @param topic type String
	 * @return type TopicModel
	 */
	public T updateTopic(T topic) {
		return null;
	}
	/**
	 * Method for deleting the selected topic
	 * 
	 * @param topic type TopicModel
	 */
	public void deleteTopic(T topic) {
	}
	/**
	 * Method for adding a comment to a post
	 * 
	 * @param comment type CommentModel
	 * @param date type String
	 * @param postid type String
	 * @param userid type String
	 */
	public void addComment(M comment, String date, String postid, String userid){
	}
	/**
	 * Method for getting all comments for a particular post
	 * 
	 * @param postid type String
	 * @return ListCommentModel
	 */
	public List<M> getComments(String postid){
		return null;
	}
	/**
	 * Method for getting all a users info for their posts
	 * 
	 * @param userid type String
	 * @return RegisterModel
	 */
	public R getUserInfo(String userid){
		return null;
	}
	/**
	 * Method for updating a users account
	 * 
	 * @param user type RegisterModel
	 */
	public void updateAccount(R user){
	}
	/**
	 * Method to grab all the chats (usernames of who they have messages with) for the logged in user
	 * 
	 * @param userid type String
	 * @return ListChatModel
	 */
	public List<X> getChats(String userid){
		return null;
	}
	/**
	 * Method for getting all the messages to a particular chat
	 * 
	 * @param chatid type String
	 * @return ListMessageModel
	 */
	public List<Z> getMessages(String chatid){
		return null;
	}
	/**
	 * Method for checking users have a chat already
	 * 
	 * @param sender type String
	 * @param receiver type String
	 * @return String
	 */
	public String getChatId(String sender, String receiver) {
		return null;
	}
	/**
	 * Method for creating a chat
	 * 
	 * @param sender type String
	 * @param receiver type String
	 * @return String
	 */
	public String createChat(String sender, String receiver) {
		return null;
	}
	/**
	 * Method for sending a direct message
	 * 
	 * @param chatid type String
	 * @param mm type MessageModel
	 * @param date type String
	 */
	public void sendMessage(String chatid, Z mm, String date) {
	}
	/**
	 * Method for getting all the topics that a user has commented on
	 * 
	 * @param userid type String
	 * @return ListTopicModel
	 */
	public List<T> getTopicByUserComments(String userid){
		return null;
	}
	/**
	 * Method for getting all the topics that a user searches for
	 * 
	 * @param search type String
	 * @return ListTopicModel
	 */
	public List<T> getSearchTopics(String search){
		return null;
	}
}
