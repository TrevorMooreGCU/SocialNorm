package com.socialnorm.model;

import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

/**
 * Trevor Moore
 * CST-341
 * 12/06/2018
 * This assignment was completed in collaboration with Aaron Ross
 * This is our own work.

 * CommentModel Class for holding the details of comments on posts.
 * @author Trevor
 * 
 */
public class CommentModel 
{
	@NotNull(message="Comment field cannot be left blank.")
	@Size(min=1, max=500, message="Comment input must be between 1 and 500 characters.")
	private String comment;
	
	private String date;
	private String id;
	private String userid;
	private String postid;
	private String username;
	
	/**
	 * Default constructor
	 */
	public CommentModel()
	{
		this.comment = "";
		this.date = "";
		this.id = "";
		this.userid = "";
		this.postid = "";
		this.username = "";
	}
	
	/**
	 * Non-default constructor
	 * @param comment type String
	 * @param date type String
	 * @param id type String
	 * @param userid type String
	 * @param postid type String
	 * @param username type String
	 */
	public CommentModel(String comment, String date, String id, String userid, String postid, String username) 
	{
		super();
		this.comment = comment;
		this.date = date;
		this.id = id;
		this.userid = userid;
		this.postid = postid;
		this.username = username;
	}

	// GETTER AND SETTER
	public String getComment() {
		return comment;
	}
	public void setComment(String comment) {
		this.comment = comment;
	}
	public String getDate() {
		return date;
	}
	public void setDate(String date) {
		this.date = date;
	}
	public String getId() {
		return id;
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
	public String getPostid() {
		return postid;
	}
	public void setPostid(String postid) {
		this.postid = postid;
	}
	public String getUsername() {
		return username;
	}
	public void setUsername(String username) {
		this.username = username;
	}
}
