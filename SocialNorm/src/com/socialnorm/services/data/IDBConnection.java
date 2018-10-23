package com.socialnorm.services.data;

import java.sql.Connection;

/**
 * Trevor Moore
 * CST-341
 * 10/8/2018
 * This assignment was completed in collaboration with Aaron Ross
 * This is our own work.
 * 
 * IDBConnection interface for creating a connection to the database.
 * @author Trevor
 * 
 */
public interface IDBConnection 
{
	/**
     * Method for returning db connection
     */
	public Connection dbConnect();
}
