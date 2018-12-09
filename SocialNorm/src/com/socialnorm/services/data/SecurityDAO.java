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
 * SecurityDAO extending DataAccessInterface abstract class and therefore inheriting all its methods. For talking with the database concerning logging in
 * @author Trevor
 *
 */
public class SecurityDAO extends DataAccessInterface<RegisterModel,CredentialModel,TopicModel,CommentModel,ChatModel,MessageModel>
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
	 * Overridden method for checking if a user is in the users table
	 * 
	 * @param user type CredentialModel
	 * @return String
	 */
	@Override
	public String checkUser(CredentialModel user) 
	{
		// n1euzrfjibaye0bl
		// grabbing everything where the credentials match
		String query = "SELECT * FROM n1euzrfjibaye0bl.users WHERE BINARY USERNAME = ? AND BINARY PASSWORD = ?";
		
		// execute the query
		SqlRowSet srs = jdbcTemplate.queryForRowSet(query, user.getUsername(), user.getPassword());

		// if theres a row returned, return the id else return fail
        if(srs.next())
        	return srs.getString("ID");
        else
        	return "fail";
	}
}
