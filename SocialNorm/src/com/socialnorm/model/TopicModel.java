package com.socialnorm.model;

import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

/**
 * Trevor Moore
 * CST-341
 * 10/8/2018
 * This assignment was completed in collaboration with Aaron Ross
 * This is our own work.
 * 
 * We used source code from the following:
 * https://docs.oracle.com/javaee/6/tutorial/doc/gircz.html
 * 
 * For bean validation
 * 
 * TopicModel Class for holding the parameters for our "Product"
 * @author Trevor
 * 
 */
public class TopicModel
{
	@NotNull(message="Date cannot be left blank.")
	@Size(min=23, max=25, message="Must be in DATETIME format: YYYY-MM-DD HH:MI:SS")
	private String date;

	@NotNull(message="Title cannot be left blank.")
	@Size(min=2, max=100, message="Cannot be empty and cannot exceed 100 characters.")
	private String title;
	
	@NotNull(message="Category cannot be left blank.")
	@Size(min=8, max=13, message="Must be between 8 and 13 characters.")
	private String category;
	
	@NotNull(message="Body cannot be left blank.")
	@Size(min=1, max=300, message="Cannot be empty and cannot exceed 300 characters.")
	private String body;
	
	/**
	 * Default constructor
	 */
	public TopicModel()
	{
		this.date = "";
		this.title = "";
		this.category = "";
		this.body = "";
	}
	
	/**
	 * Non-default constructor
	 * @param date type String
	 * @param title type String
	 * @param category type String
	 * @param body type String
	 */
	public TopicModel(String date, String title, String category, String body) 
	{
		super();
		this.date = date;
		this.title = title;
		this.category = category;
		this.body = body;
	}

	// GETTERS AND SETTERS
	public String getDate() {
		return date;
	}
	public void setDate(String date) {
		this.date = date;
	}
	public String getTitle() {
		return title;
	}
	public void setTitle(String title) {
		this.title = title;
	}
	public String getCategory() {
		return category;
	}
	public void setCategory(String category) {
		this.category = category;
	}
	public String getBody() {
		return body;
	}
	public void setBody(String body) {
		this.body = body;
	}
}
