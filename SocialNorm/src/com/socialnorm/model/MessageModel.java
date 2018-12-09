package com.socialnorm.model;

import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

/**
 * Trevor Moore
 * CST-341
 * 12/06/2018
 * This assignment was completed in collaboration with Aaron Ross
 * This is our own work.

 * MessageModel Class for holding the details of messages in chats.
 * @author Trevor
 * 
 */
public class MessageModel
{
	private String id;
	
	private String chatid;
	
	private String senderid;
	
	private String receiverid;
	
	@NotNull(message="Message field cannot be left blank.")
	@Size(min=1, max=500, message="Message must be between 1 and 500 characters.")
	private String messagebody;
	
	private String creationdate;

	/**
	 * Default constructor
	 */
	public MessageModel()
	{
		this.id = "";
		this.chatid = "";
		this.senderid = "";
		this.messagebody = "";
		this.creationdate = "";
		this.receiverid = "";
	}

	/**
	 * Non-default constructor
	 * @param id type String
	 * @param chatid type String
	 * @param senderid type String
	 * @param messagebody type String
	 * @param creationdate type String
	 */
	public MessageModel(String id, String chatid, String senderid, String messagebody, String creationdate) 
	{
		super();
		this.id = id;
		this.chatid = chatid;
		this.senderid = senderid;
		this.messagebody = messagebody;
		this.creationdate = creationdate;
	}

	/// GETTERS AND SETTERS ///
	public String getId() {
		return id;
	}
	public void setId(String id) {
		this.id = id;
	}
	public String getChatid() {
		return chatid;
	}
	public void setChatid(String chatid) {
		this.chatid = chatid;
	}
	public String getSenderid() {
		return senderid;
	}
	public void setSenderid(String senderid) {
		this.senderid = senderid;
	}
	public String getMessagebody() {
		return messagebody;
	}
	public void setMessagebody(String messagebody) {
		this.messagebody = messagebody;
	}
	public String getCreationdate() {
		return creationdate;
	}
	public void setCreationdate(String creationdate) {
		this.creationdate = creationdate;
	}
	public String getReceiverid() {
		return receiverid;
	}
	public void setReceiverid(String receiverid) {
		this.receiverid = receiverid;
	}
}
