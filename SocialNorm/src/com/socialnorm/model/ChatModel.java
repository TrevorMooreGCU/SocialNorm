package com.socialnorm.model;


/**
 * Trevor Moore
 * CST-341
 * 12/06/2018
 * This assignment was completed in collaboration with Aaron Ross
 * This is our own work.

 * ChatModel Class for holding the details of Chat conversations.
 * @author Trevor
 * 
 */
public class ChatModel
{	
	private String id;
	
	private String userid;
	
	private String username;
	
	private String messagebody;
	
	private String creationdate;
	
	/**
	 * Default constructor
	 */
	public ChatModel()
	{
		this.id = "";
		this.userid = "";
		this.username = "";
		this.messagebody = "";
		this.creationdate = "";
	}
	
	/**
	 * Non-default constructor
	 * @param id type String
	 * @param userid type String
	 * @param username type String
	 * @param messagebody type String
	 * @param creationdate type String
	 */
	public ChatModel(String id, String userid, String username, String messagebody, String creationdate) 
	{
		super();
		this.id = id;
		this.userid = userid;
		this.username = username;
		this.messagebody = messagebody;
		this.creationdate = creationdate;
	}

	/// GETTERS AND SETTERS ///
	public String getId() {
		return id;
	}
	public String getCreationdate() {
		return creationdate;
	}
	public void setCreationdate(String creationdate) {
		this.creationdate = creationdate;
	}
	public String getMessagebody() {
		return messagebody;
	}
	public void setMessagebody(String messagebody) {
		this.messagebody = messagebody;
	}
	public void setId(String id) {
		this.id = id;
	}
	public String getUserid() {
		return userid;
	}
	public void setUserid(String userid) {
		this.userid = userid;
	}
	public String getUsername() {
		return username;
	}
	public void setUsername(String username) {
		this.username = username;
	}
}


