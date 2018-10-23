package com.socialnorm.services.data;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import org.springframework.beans.factory.annotation.Autowired;
import com.socialnorm.model.CredentialModel;
import com.socialnorm.model.TopicModel;

/**
 * Trevor Moore
 * CST-341
 * 10/10/2018
 * This assignment was completed in collaboration with Aaron Ross
 * This is our own work.
 * 
 * TopicDAO concrete implementation class of ITopicDAO
 * @author Trevor
 *
 */
public class TopicDAO implements ITopicDAO
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
	 * Overridden method for inserting a new post into the posts table
	 * 
	 * @param model type TopicModel
	 * @param user type CredentialModel (to get the users ID who posted it)
	 * @return boolean object type
	 */
	@Override
	public boolean createPost(TopicModel topic, CredentialModel user) 
	{
		// try catch for catching exceptions
		try 
		{
			// defining all our queries
			// n1euzrfjibaye0bl
			// first query for grabbing the ID of the user who is posting the topic from the users table
			String query1 = "SELECT ID FROM SOCIALNORM.USERS WHERE USERNAME = ? AND PASSWORD = ?";
			// second query for inserting the topic into the posts table
			String query2 = "INSERT INTO SOCIALNORM.POSTS(USERID, CREATIONDATE, TITLE, CATEGORY, BODY) VALUES(?, ?, ?, ?, ?)";
			
			// prepared statements for each query, using injected dbconnection to connect to db
			PreparedStatement pt1 = dbconn.dbConnect().prepareStatement(query1);
			PreparedStatement pt2 = dbconn.dbConnect().prepareStatement(query2);
			
			// setting the parameters for the 1st prepared statement
			pt1.setString(1, user.getUsername());
			pt1.setString(2, user.getPassword());
			
			// executing the first prepared statement, getting the resultset and grabbing the ID column returned and storing it in a string
			pt1.execute();
			ResultSet rs = pt1.getResultSet();
			rs.next();
			String userID = rs.getString("ID");
        	System.out.println(userID);
        	// closing the 1st prepared statement
        	pt1.close();

        	// setting the parameters for the 2nd prepared statement
			pt2.setString(1, userID);
			pt2.setString(2, topic.getDate());
			pt2.setString(3, topic.getTitle());
			pt2.setString(4, topic.getCategory());
			pt2.setString(5, topic.getBody());
            
			// executing the 2nd prepared statement and storing the number of affected rows
            int result = pt2.executeUpdate();

            // closing the 2nd prepared statement
            pt2.close();
            
            // returning true if the result is greater than 0 (successful insert into posts table) else false (insert failure)
            return (result > 0);
		}
		//catching exceptions and printing failure
		catch(Exception e) 
		{
			e.printStackTrace();
			System.out.println("Database Exception. Caught in TopicDAO.");
			return false;
		}
	}
}
