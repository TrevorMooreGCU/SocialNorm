package com.socialnorm.services.data;

import org.apache.tomcat.jdbc.pool.DataSource;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.support.rowset.SqlRowSet;

import com.socialnorm.model.ChatModel;
import com.socialnorm.model.CommentModel;
import com.socialnorm.model.CredentialModel;
import com.socialnorm.model.MessageModel;
import com.socialnorm.model.RegisterModel;
import com.socialnorm.model.TopicModel;

/**
 * Trevor Moore
 * CST-341
 * 10/10/2018
 * This assignment was completed in collaboration with Aaron Ross
 * This is our own work.
 * 
 * RegistrationDAO extending DataAccessInterface abstract class and therefore inheriting all its methods. For talking with the database concerning registering.
 * @author Trevor
 *
 */
public class RegistrationDAO extends DataAccessInterface<RegisterModel,CredentialModel,TopicModel,CommentModel,ChatModel,MessageModel>
{
	// Injecting DataSource and JdbcTemplate
	DataSource dataSource;
	JdbcTemplate jdbcTemplate;
	/**
	 * Autowired method for setting the DataSource and JdbcTemplate in order to connect to the db
	 * @param dataSource type DataSource
	 */
	@Autowired
	public void setDataSource(DataSource dataSource) 
	{
		this.dataSource = dataSource;
		this.jdbcTemplate = new JdbcTemplate(dataSource);
	}
	/**
	 * Overridden method for registering a user into the database
	 * 
	 * @param user of type RegisterModel
	 * @return int
	 */
	@Override
	public int registerUser(RegisterModel user) 
	{
		// define all of our queries
		// n1euzrfjibaye0bl
		// for checking if a username is already in the database
		String query = "SELECT * FROM n1euzrfjibaye0bl.users WHERE USERNAME = ?";
		// for inserting the new username and password into the users table
		String query1 = "INSERT INTO n1euzrfjibaye0bl.users (USERNAME, PASSWORD) VALUES(?, ?)";
		
		// execute first query
		SqlRowSet srs1 = jdbcTemplate.queryForRowSet(query, user.getUsername());
        
        // if the query doesn't return anything
        if(!srs1.next())
        {
        	// execute second query
        	jdbcTemplate.update(query1, user.getUsername(), user.getPassword());
        	return 1;
        }
        // if the query returned something, theres a duplicate
        else
        	return 0;
	}
	/**
	 * Overridden method for inserting user info into the database
	 * 
	 * @param user of type RegisterModel
	 * @return int
	 */
	@Override
	public int addUserInfo(RegisterModel user) 
	{
		// for getting the freshly created ID of the new user in the users table
		String query2 = "SELECT ID FROM n1euzrfjibaye0bl.users WHERE USERNAME = ? AND PASSWORD = ?";
		// for inserting the rest of the user info into the userinfo table
		String query3 = "INSERT INTO n1euzrfjibaye0bl.userinfo (USERSID, FIRSTNAME, LASTNAME, PHONE, EMAIL) VALUES(?, ?, ?, ?, ?)";

    	// execute the 3rd prepared statement to get the new users' ID from the users table
    	SqlRowSet srs2 = jdbcTemplate.queryForRowSet(query2, user.getUsername(), user.getPassword());
    	
    	// grab the new user's ID
    	srs2.next();
    	String userID = srs2.getString("ID");
    	
    	// setting parameters for the 4th and final prepared statement with the newly grabbed user ID
    	int result = jdbcTemplate.update(query3, userID, user.getFirstName(), user.getLastName(), user.getPhone(), user.getEmail());
		
		// if the result is more than 0 it was inserted successfully into the userinfo table and registration is complete
		if(result > 0)
		{
			System.out.println("Registration Successful.");
			return 1;
		}
		// else the last query failed to insert into userinfo table
		else
			return -1;
	}
}
