package com.socialnorm.services.data;

import java.sql.Connection;
import java.sql.DriverManager;

/**
 * Trevor Moore
 * CST-341
 * 10/8/2018
 * This assignment was completed in collaboration with Aaron Ross
 * This is our own work.
 * 
 * We referenced Jordan Riley's database connection class to create a connection.
 * 
 * DBConnection Class for creating a connection to the database. Concrete implementation of IDBConnection Class
 * @author Trevor
 * 
 */
public class DBConnection implements IDBConnection
{
	// database url with our username and password
    private static final String server = "jdbc:derby:C:/Users/Trevor/SocialNormDB;user=user;password=derby";

    // database connection that will be returned
    private Connection connection;

    /**
     * Method for returning db connection
     */
    public Connection dbConnect() 
    {
        //try catch for catching exceptions
    	try 
    	{
    		// registering the JDBC Embedded Driver
        	// Class.forName("com.mysql.jdbc.Driver");
    		Class.forName("org.apache.derby.jdbc.EmbeddedDriver").newInstance();

        	// opening a connection using the database url
    		// "jdbc:mysql://localhost:4306/activity2","root","root"
    		// "jdbc:mysql://aucxibl2dxeo01wa:hytrxvvxgrfx6e02@l9dwvv6j64hlhpul.cbetxkdyhwsb.us-east-1.rds.amazonaws.com:3306/n1euzrfjibaye0bl","aucxibl2dxeo01wa","hytrxvvxgrfx6e02"
        	connection = DriverManager.getConnection(server);

        	// returning the database connection
        	return connection;
    	}
    	// catching exceptions
        catch (Exception e) 
        {
        	e.printStackTrace();
        	return connection;
        }
    }

}
