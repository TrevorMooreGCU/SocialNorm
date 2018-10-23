package com.socialnorm.model;

import javax.validation.constraints.NotNull;

/**
 * Reference for bean validation:
 * https://docs.oracle.com/javaee/6/tutorial/doc/gircz.html
 * @author Trevor
 *
 */

import javax.validation.constraints.Size;

/**
 * Trevor Moore
 * CST-341
 * 09/22/2018
 * This assignment was completed in collaboration with Aaron Ross
 * This is our own work.
 * 
 * Search Class for holding the parameter for the search form in the header.
 * @author Trevor
 * 
 */
public class SearchModel
{
	@NotNull(message="Search cannot be left blank.")
	@Size(min=1, max=20, message="Search input must be between 1 and 20 characters.")
	private String search;
	
	/**
	 * Default constructor
	 */
	public SearchModel()
	{
		this.search = "";
	}
	
	/**
	 * Non-default constructor
	 * @param search type String
	 */
	public SearchModel(String search) 
	{
		super();
		this.search = search;
	}
	
	// GETTER AND SETTER
	public String getSearch() {
		return search;
	}
	public void setSearch(String search) {
		this.search = search;
	}
}
