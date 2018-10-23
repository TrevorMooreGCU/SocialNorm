package com.socialnorm.services.data;

import java.sql.PreparedStatement;
import java.sql.ResultSet;

import org.springframework.beans.factory.annotation.Autowired;

import com.socialnorm.model.RegisterModel;

/**
 * Trevor Moore
 * CST-341
 * 10/10/2018
 * This assignment was completed in collaboration with Aaron Ross
 * This is our own work.
 * 
 * RegistrationDAO concrete implementation class of IRegistrationDAO
 * @author Trevor
 *
 */
public class RegistrationDAO implements IRegistrationDAO
{
	// IDBConnection for injecting our database connection class
	IDBConnection dbconn;

	/**
	 * Autowired method for setting the injected DBConnection
	 * @param dbconn type IDBConnection
	 */
	@Autowired
	public void setDBConnection(IDBConnection dbconn)
	{
		this.dbconn = dbconn;
	}
	
	/**
	 * Overridden method for registering a user into the database
	 * 
	 * @param user of type RegisterModel
	 * @return type String
	 */
	@Override
	public String registerUser(RegisterModel user) 
	{
		// try catch for catching exceptions
		try 
		{
			// define all of our queries
			// n1euzrfjibaye0bl
			// for checking if a username is already in the database
			String query = "SELECT * FROM SOCIALNORM.USERS WHERE USERNAME = ?";
			// for inserting the new username and password into the users table
			String query1 = "INSERT INTO SOCIALNORM.USERS (USERNAME, PASSWORD) VALUES(?, ?)";
			// for getting the freshly created ID of the new user in the users table
			String query2 = "SELECT ID FROM SOCIALNORM.USERS WHERE USERNAME = ? AND PASSWORD = ?";
			// for inserting the rest of the user info into the userinfo table
			String query3 = "INSERT INTO SOCIALNORM.USERINFO (USERSID, FIRSTNAME, LASTNAME, PHONE, EMAIL) VALUES(?, ?, ?, ?, ?)";
			
			// prepared statements for each query, using injected dbconnection to connect to db
			PreparedStatement pt1 = dbconn.dbConnect().prepareStatement(query);
			PreparedStatement pt2 = dbconn.dbConnect().prepareStatement(query1);
			PreparedStatement pt3 = dbconn.dbConnect().prepareStatement(query2);
			PreparedStatement pt4 = dbconn.dbConnect().prepareStatement(query3);
			
			// setting the parameters for each prepared statement
			pt1.setString(1, user.getUsername());
			
			pt2.setString(1, user.getUsername());
			pt2.setString(2, user.getPassword());
			
			pt3.setString(1, user.getUsername());
			pt3.setString(2, user.getPassword());
			
			// executing the username check query
			pt1.execute();
			// grabbing the resultset from the query
            ResultSet rs1 = pt1.getResultSet();
            
            int result1;
            
            // if the query return nothing
            if(!rs1.next())
            {
            	// close 1st prepared statement, execute the insert and then close it
            	pt1.close();
            	result1 = pt2.executeUpdate();
                pt2.close();
            }
            // if the query returned something, theres a duplicate
            else
            	return "duplicate";
            
            // if the result of the 2nd prepared statement is greater than 0, the user was successfully inserted into users table
            if(result1 > 0)
            {
            	// execute the 3rd prepared statement to get the new users' ID from the users table
            	pt3.execute();
            	// get the result set and grab the ID column as a string, then close statement
            	ResultSet rs2 = pt3.getResultSet();
            	rs2.next();
            	String userID = rs2.getString("ID");
            	System.out.println(userID);
            	pt3.close();
            	
            	// setting parameters for the 4th and final prepared statement with the newly grabbed user ID
            	pt4.setString(1, userID);
    			pt4.setString(2, user.getFirstName());
    			pt4.setString(3, user.getLastName());
    			pt4.setString(4, user.getPhone());
    			pt4.setString(5, user.getEmail());
    			
    			// execute the final statement and close it
    			int result2 = pt4.executeUpdate();
    			pt4.close();
    			
    			// if the result is more than 0 it was inserted successfully into the userinfo table and registration is complete
    			if(result2 > 0)
    			{
    				System.out.println("Registration Successful.");
    				return "success";
    			}
    			// else the last query failed to insert into userinfo table
    			else
    			{
    				System.out.println("Query 3 failed.");
    				return "failure";
    			}
            }
            // else the 2nd query failed to insert into users table
            else
            {
            	System.out.println("Query 1 failed.");
            	return "failure";
            }
		}
		//catching exceptions and printing failure
		catch(Exception e) 
		{
			e.printStackTrace();
			System.out.println("Database Exception. Caught in RegistrationDAO.");
			return "failure";
		}
	}
	

}
