package com.socialnorm.services.data;

import java.util.ArrayList;
import java.util.List;
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
 * TopicDAO extending DataAccessInterface abstract class and therefore inheriting all its methods. For talking with the database concerning all things "topics"
 * @author Trevor
 *
 */
public class TopicDAO extends DataAccessInterface<RegisterModel,CredentialModel,TopicModel,CommentModel,ChatModel,MessageModel>
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
	 * Overridden method for inserting a new post into the posts table
	 * 
	 * @param topic type TopicModel
	 * @param user type CredentialModel (to get the users ID who posted it)
	 * @return TopicModel
	 */
	@Override
	public TopicModel createPost(TopicModel topic, CredentialModel user) 
	{
		// defining all our queries
		// n1euzrfjibaye0bl
		// first query for grabbing the ID of the user who is posting the topic from the users table
		String query1 = "SELECT ID FROM n1euzrfjibaye0bl.users WHERE USERNAME = ? AND PASSWORD = ?";
		// second query for inserting the topic into the posts table
		String query2 = "INSERT INTO n1euzrfjibaye0bl.posts(USERID, TITLE, CATEGORY, BODY, CREATIONDATE) VALUES(?, ?, ?, ?, ?)";
		// third query for grabbing the newly inserted post from posts table
		String query3 = "SELECT * FROM n1euzrfjibaye0bl.posts WHERE USERID = ? AND TITLE = ? AND CATEGORY = ? AND BODY = ? AND CREATIONDATE = ?";
		
		// execute first query to grab user id
		SqlRowSet srs1 = jdbcTemplate.queryForRowSet(query1, user.getUsername(), user.getPassword());
		
		// store user id
		srs1.next();
		String userID = srs1.getString("ID");

		// execute second query to insert post using user id
		jdbcTemplate.update(query2, userID, topic.getTitle(), topic.getCategory(), topic.getBody(), topic.getDate());
		
		// execute third query for grabbing the newly inserted post
		SqlRowSet srs2 = jdbcTemplate.queryForRowSet(query3, userID, topic.getTitle(), topic.getCategory(), topic.getBody(), topic.getDate() + ".0");
		
		// storing the post
		srs2.next();
		TopicModel tp = new TopicModel(srs2.getString("CREATIONDATE"), srs2.getString("TITLE"), srs2.getString("CATEGORY"), srs2.getString("BODY"), srs2.getString("ID"), srs2.getString("USERID"));
		
        // returning the newly inserted post
        return tp;
	}
	/**
	 * Overridden method for getting posts by their category from the posts table
	 * 
	 * @param category type String
	 * @return ListTopicModel
	 */
	@Override
	public List<TopicModel> getPostByCategory(String category) 
	{
		// defining our query
		// query for grabbing all post from particular category
		String query = "SELECT * FROM n1euzrfjibaye0bl.posts WHERE CATEGORY = ?";
		
		// execute the query
		SqlRowSet srs = jdbcTemplate.queryForRowSet(query, category);
        
		// instantiate list of topic models
		List<TopicModel> topics = new ArrayList<TopicModel>();
				
        // while the rowset has a next add the row to the list
        while(srs.next())
        	topics.add(new TopicModel(srs.getString("CREATIONDATE"), srs.getString("TITLE"), srs.getString("CATEGORY"), srs.getString("BODY"), srs.getString("ID"), srs.getString("USERID")));

        // return the list
        return topics;
	}
	/**
	 * Overridden method for getting all topics posted by logged in user
	 * 
	 * @param userid type String
	 * @return ListTopicModel
	 */
	@Override
	public List<TopicModel> getTopicByUser(String userid)
	{
		// defining our query
		// grab all posts from particular user id
		String query = "SELECT * FROM n1euzrfjibaye0bl.posts WHERE USERID = ?";
		
		// execute query
		SqlRowSet srs = jdbcTemplate.queryForRowSet(query, userid);
        
		// instantiate list of topic models
		List<TopicModel> topics = new ArrayList<TopicModel>();
				
		// while the rowset has a next add the row to the list
        while(srs.next())
        	topics.add(new TopicModel(srs.getString("CREATIONDATE"), srs.getString("TITLE"), srs.getString("CATEGORY"), srs.getString("BODY"), srs.getString("ID"), srs.getString("USERID")));

        // return the list
        return topics;
	}
	/**
	 * Overridden method for getting all posts from the posts table
	 * 
	 * @return ListTopicModel
	 */
	@Override
	public List<TopicModel> getAllPosts() 
	{
		// defining our query
		// grabbing everything from the posts table
		String query = "SELECT * FROM n1euzrfjibaye0bl.posts";

		// execute query
		SqlRowSet srs = jdbcTemplate.queryForRowSet(query);

		// instantiate list of topic models
		List<TopicModel> topics = new ArrayList<TopicModel>();
				
		// while the rowset has a next add the row to the list
        while(srs.next())
        	topics.add(new TopicModel(srs.getString("CREATIONDATE"), srs.getString("TITLE"), srs.getString("CATEGORY"), srs.getString("BODY"), srs.getString("ID"), srs.getString("USERID")));

        // return the list
        return topics;
	}
	/**
	 * Overridden method for getting most recent posts from the posts table
	 * 
	 * @return ListTopicModel
	 */
	@Override
	public List<TopicModel> getMostRecentPosts() 
	{
		// defining our query
		// grabbing the topic with the most recent date from each category
		String query = "SELECT i1.* FROM n1euzrfjibaye0bl.posts AS i1 LEFT JOIN n1euzrfjibaye0bl.posts AS i2 ON (i1.CATEGORY = i2.CATEGORY AND i1.CREATIONDATE < i2.CREATIONDATE) WHERE i2.CREATIONDATE IS NULL";

		// execute query
		SqlRowSet srs = jdbcTemplate.queryForRowSet(query);

		// instantiate list of topic models
		List<TopicModel> topics = new ArrayList<TopicModel>();
				
		// while the rowset has a next add the row to the list
        while(srs.next())
        	topics.add(new TopicModel(srs.getString("CREATIONDATE"), srs.getString("TITLE"), srs.getString("CATEGORY"), srs.getString("BODY"), srs.getString("ID"), srs.getString("USERID")));

        // return the list
        return topics;
	}
	/**
	 * Overridden method for getting the selected post from the posts table
	 * 
	 * @param id type String
	 * @return TopicModel
	 */
	@Override
	public TopicModel getTopic(String id) 
	{
		// defining our query
		// grabbing the post of the specific id
		String query = "SELECT * FROM n1euzrfjibaye0bl.posts WHERE ID = ?";

		// execute query
		SqlRowSet srs = jdbcTemplate.queryForRowSet(query, id);

		// instantiate topic model
		TopicModel topic = new TopicModel();
				
        // if the rowset has a next row set all the topic's properties
        if(srs.next())
        {
        	topic.setDate(srs.getString("CREATIONDATE"));
        	topic.setTitle(srs.getString("TITLE"));
        	topic.setCategory(srs.getString("CATEGORY"));
        	topic.setBody(srs.getString("BODY"));
        	topic.setId(srs.getString("ID"));
        	topic.setUserid(srs.getString("USERID"));
        }

        // return the post
        return topic;
	}
	/**
	 * Overridden method for updating the selected post in the posts table
	 * 
	 * @param topic type String
	 * @return TopicModel
	 */
	@Override
	public TopicModel updateTopic(TopicModel topic) 
	{
		// defining our first query
		// updating the row where the id equals the passed in id
		String query1 = "UPDATE n1euzrfjibaye0bl.posts SET TITLE = ?, BODY = ? WHERE ID = ?";
		
		// execute the update
		jdbcTemplate.update(query1, topic.getTitle(), 
				topic.getBody(), 
				topic.getId());
		
		// defining our second query
		// grab the newly updated row based off of the id
		String query2 = "SELECT * FROM n1euzrfjibaye0bl.posts WHERE ID = ?";

		// execute the second query
		SqlRowSet srs = jdbcTemplate.queryForRowSet(query2, topic.getId());

		// instantiate topic model
		TopicModel returnTopic = new TopicModel();
				
        // if the rowset has a next row set the properties of the model
        if(srs.next())
        {
        	returnTopic.setDate(srs.getString("CREATIONDATE"));
        	returnTopic.setTitle(srs.getString("TITLE"));
        	returnTopic.setCategory(srs.getString("CATEGORY"));
        	returnTopic.setBody(srs.getString("BODY"));
        	returnTopic.setId(srs.getString("ID"));
        	returnTopic.setUserid(srs.getString("USERID"));
        }

        // return the model
        return returnTopic;
	}
	/**
	 * Overridden method for deleting the selected post from the posts table
	 * 
	 * @param topic type TopicModel
	 */
	@Override
	public void deleteTopic(TopicModel topic) 
	{
		// defining our query
		// delete the posts table based off passed in id
		String query = "DELETE FROM n1euzrfjibaye0bl.posts WHERE ID = ?";

		// execute the delete
		jdbcTemplate.update(query, topic.getId());
	}
	/**
	 * Method for adding a comment to a post
	 * 
	 * @param comment type CommentModel
	 * @param date type String
	 * @param postid type String
	 * @param userid type String
	 */
	@Override
	public void addComment(CommentModel comment, String date, String postid, String userid)
	{
		// query for inserting a new comment
		String query1 = "INSERT INTO n1euzrfjibaye0bl.comments(UID, PID, COMMENTBODY, CREATIONDATE) VALUES(?, ?, ?, ?)";
		
		// execute first query to insert comment
		jdbcTemplate.update(query1, userid, postid, comment.getComment(), date);
	}
	/**
	 * Method for getting all comments for a particular post
	 * 
	 * @param postid type String
	 * @return ListCommentModel
	 */
	@Override
	public List<CommentModel> getComments(String postid)
	{
		// query for grabbing all comments for a particular post
		String query = "SELECT n1euzrfjibaye0bl.comments.ID, n1euzrfjibaye0bl.comments.UID, n1euzrfjibaye0bl.comments.PID, n1euzrfjibaye0bl.comments.COMMENTBODY, n1euzrfjibaye0bl.comments.CREATIONDATE, n1euzrfjibaye0bl.users.USERNAME " + 
		"FROM n1euzrfjibaye0bl.comments INNER JOIN n1euzrfjibaye0bl.users " +
		"ON n1euzrfjibaye0bl.comments.UID = n1euzrfjibaye0bl.users.ID " + 
		"WHERE n1euzrfjibaye0bl.comments.PID = ? " +
		"ORDER BY CREATIONDATE DESC";
		
		// executing the query
		SqlRowSet srs = jdbcTemplate.queryForRowSet(query, postid);

		// instantiate list of comment models
		List<CommentModel> comments = new ArrayList<CommentModel>();
				
		// while the rowset has a next add the row to the list
        while(srs.next())
        	comments.add(new CommentModel(srs.getString("COMMENTBODY"), srs.getString("CREATIONDATE"), srs.getString("ID"), srs.getString("UID"), srs.getString("PID"), srs.getString("USERNAME")));

        // return the list
        return comments;
	}
	/**
	 * Method for getting all a users info for their posts
	 * 
	 * @param userid type String
	 * @return RegisterModel
	 */
	@Override
	public RegisterModel getUserInfo(String userid)
	{
		// query for getting a users information from the userinfo table
		String query = "SELECT n1euzrfjibaye0bl.userinfo.FIRSTNAME, n1euzrfjibaye0bl.userinfo.LASTNAME, n1euzrfjibaye0bl.userinfo.EMAIL, n1euzrfjibaye0bl.userinfo.PHONE, n1euzrfjibaye0bl.userinfo.BIO, n1euzrfjibaye0bl.userinfo.USERSID, n1euzrfjibaye0bl.users.USERNAME " + 
		"FROM n1euzrfjibaye0bl.userinfo INNER JOIN n1euzrfjibaye0bl.users " +
		"ON n1euzrfjibaye0bl.userinfo.USERSID = n1euzrfjibaye0bl.users.ID " +
		"WHERE USERSID = ?";

		// execute the query
		SqlRowSet srs = jdbcTemplate.queryForRowSet(query, userid);

		// storing the users information in a RegisterModel
		srs.next();
		RegisterModel tp = new RegisterModel();
		tp.setFirstName(srs.getString("FIRSTNAME"));
		tp.setLastName(srs.getString("LASTNAME"));
		tp.setEmail(srs.getString("EMAIL"));
		tp.setPhone(srs.getString("PHONE"));
		tp.setBio(srs.getString("BIO"));
		tp.setId(srs.getString("USERSID"));
		tp.setUsername(srs.getString("USERNAME"));
		
        // return the model
        return tp;
	}
	/**
	 * Method for updating a users account
	 * 
	 * @param user type RegisterModel
	 */
	@Override
	public void updateAccount(RegisterModel user)
	{
		// query for updating a users account information in the userinfo and users tables
		String query = "UPDATE n1euzrfjibaye0bl.userinfo, n1euzrfjibaye0bl.users " + 
				"SET n1euzrfjibaye0bl.userinfo.FIRSTNAME = ?, " + 
				"n1euzrfjibaye0bl.userinfo.LASTNAME = ?, " + 
				"n1euzrfjibaye0bl.userinfo.EMAIL = ?, " + 
				"n1euzrfjibaye0bl.userinfo.PHONE = ?, " + 
				"n1euzrfjibaye0bl.userinfo.BIO = ?, " + 
				"n1euzrfjibaye0bl.users.USERNAME = ? " + 
				"WHERE n1euzrfjibaye0bl.userinfo.USERSID=n1euzrfjibaye0bl.users.ID " + 
				"AND n1euzrfjibaye0bl.userinfo.USERSID = ?";
		
		// execute the update
		jdbcTemplate.update(query,
				user.getFirstName(), 
				user.getLastName(), 
				user.getEmail(),
				user.getPhone(),
				user.getBio(),
				user.getUsername(),
				user.getId());
	}
	/**
	 * Method to grab all the chats (usernames of who they have messages with) for the logged in user
	 * 
	 * @param userid type String
	 * @return ListChatModel
	 */
	@Override
	public List<ChatModel> getChats(String userid)
	{
		// query for grabbing all chats and their information that the logged in user is involved with
		String query = "SELECT " + 
				"n1euzrfjibaye0bl.snchats.ID, " + 
				"n1euzrfjibaye0bl.snchats.CHATUSERID1, " + 
				"n1euzrfjibaye0bl.snchats.CHATUSERID2, " + 
				"n1euzrfjibaye0bl.users.USERNAME, " + 
				"n1euzrfjibaye0bl.snmessages.MESSAGEBODY, " + 
				"n1euzrfjibaye0bl.snmessages.CREATIONDATE " + 
				"FROM n1euzrfjibaye0bl.users " + 
				"INNER JOIN n1euzrfjibaye0bl.snchats " + 
				"ON n1euzrfjibaye0bl.users.ID <> ? " + 
				"AND (n1euzrfjibaye0bl.snchats.CHATUSERID1 = n1euzrfjibaye0bl.users.ID " + 
				"OR n1euzrfjibaye0bl.snchats.CHATUSERID2 = n1euzrfjibaye0bl.users.ID) " + 
				"AND (n1euzrfjibaye0bl.snchats.CHATUSERID1 = ? " + 
				"OR n1euzrfjibaye0bl.snchats.CHATUSERID2 = ?) " + 
				"INNER JOIN n1euzrfjibaye0bl.snmessages " + 
				"ON n1euzrfjibaye0bl.snchats.ID = n1euzrfjibaye0bl.snmessages.CHATID " + 
				"AND n1euzrfjibaye0bl.snmessages.CREATIONDATE = (" + 
				"SELECT MAX(n1euzrfjibaye0bl.snmessages.CREATIONDATE) " + 
				"FROM n1euzrfjibaye0bl.snmessages " + 
				"WHERE n1euzrfjibaye0bl.snchats.ID = n1euzrfjibaye0bl.snmessages.CHATID) " +
				"ORDER BY n1euzrfjibaye0bl.snmessages.CREATIONDATE DESC";
		
		// execute query
		SqlRowSet srs = jdbcTemplate.queryForRowSet(query, userid, userid, userid);

		// instantiate list of chat models
		List<ChatModel> chats = new ArrayList<ChatModel>();
				
		// while the rowset has a next add the row to the list
        while(srs.next())
        {
        	if(srs.getString("CHATUSERID1").equals(userid))
        		chats.add(new ChatModel(srs.getString("ID"), srs.getString("CHATUSERID2"), srs.getString("USERNAME"), srs.getString("MESSAGEBODY"), srs.getString("CREATIONDATE")));
        	else
        		chats.add(new ChatModel(srs.getString("ID"), srs.getString("CHATUSERID1"), srs.getString("USERNAME"), srs.getString("MESSAGEBODY"), srs.getString("CREATIONDATE")));
        }

        // return the list
        return chats;
	}
	/**
	 * Method for getting all the messages to a particular chat
	 * 
	 * @param chatid type String
	 * @return ListMessageModel
	 */
	@Override
	public List<MessageModel> getMessages(String chatid)
	{
		// query for grabbing all message for a particular chat
		String query = "SELECT * " + 
				"FROM n1euzrfjibaye0bl.snmessages " + 
				"WHERE n1euzrfjibaye0bl.snmessages.CHATID = ? " +
				"ORDER BY n1euzrfjibaye0bl.snmessages.CREATIONDATE";
		
		// execute query
		SqlRowSet srs = jdbcTemplate.queryForRowSet(query, chatid);

		// instantiate list of message models
		List<MessageModel> messages = new ArrayList<MessageModel>();
				
		// while the rowset has a next add the row to the list
        while(srs.next())
        	messages.add(new MessageModel(srs.getString("ID"), srs.getString("CHATID"), srs.getString("SENDERID"), srs.getString("MESSAGEBODY"), srs.getString("CREATIONDATE")));

        // return the list
        return messages;
	}
	/**
	 * Method for checking users have a chat already
	 * 
	 * @param sender type String
	 * @param receiver type String
	 * @return String
	 */
	@Override
	public String getChatId(String sender, String receiver)
	{
		// query for grabbing a particular chats id based on the sender and receiver of the chat
		String query = "SELECT n1euzrfjibaye0bl.snchats.ID " + 
				"FROM n1euzrfjibaye0bl.snchats " + 
				"WHERE (n1euzrfjibaye0bl.snchats.CHATUSERID1 = ? " + 
				"AND n1euzrfjibaye0bl.snchats.CHATUSERID2 = ?) " + 
				"OR (n1euzrfjibaye0bl.snchats.CHATUSERID1 = ? " + 
				"AND n1euzrfjibaye0bl.snchats.CHATUSERID2 = ?)";
		
		// execute query
		SqlRowSet srs = jdbcTemplate.queryForRowSet(query, sender, receiver, receiver, sender);

		// declare string for the chatid
		String chatid;
				
		// while the rowset has a next add the row to the list
        if(srs.next())
        	chatid = srs.getString("ID");
        else
        	chatid = "0";

        // return the id
        return chatid;
	}
	/**
	 * Method for creating a chat
	 * 
	 * @param sender type String
	 * @param receiver type String
	 * @return String
	 */
	@Override
	public String createChat(String sender, String receiver)
	{
		// query for creating a new chat in the snchats table
		String query1 = "INSERT INTO n1euzrfjibaye0bl.snchats (CHATUSERID1, CHATUSERID2) VALUES(?, ?)";
		
		// execute the update
		jdbcTemplate.update(query1, sender, receiver);

		// get the newly created chat's id
		String chatid = getChatId(sender, receiver);

        // return the list
        return chatid;
	}
	/**
	 * Method for sending a direct message
	 * 
	 * @param chatid type String
	 * @param mm type MessageModel
	 * @param date type String
	 */
	@Override
	public void sendMessage(String chatid, MessageModel mm, String date)
	{
		// query for inserting a message into the snmessages table
		String query1 = "INSERT INTO n1euzrfjibaye0bl.snmessages "
				+ "(CHATID, SENDERID, MESSAGEBODY, CREATIONDATE) "
				+ "VALUES(?, ?, ?, ?)";
		
		// exeucting the query
		jdbcTemplate.update(query1, 
				chatid, 
				mm.getSenderid(),
				mm.getMessagebody(),
				date);
	}
	/**
	 * Method for getting all the topics that a user has commented on
	 * 
	 * @param userid type String
	 * @return ListTopicModel
	 */
	@Override
	public List<TopicModel> getTopicByUserComments(String userid)
	{
		// query for getting all the topics that a user has commented on
		String query = "SELECT n1euzrfjibaye0bl.posts.ID, " +
				"n1euzrfjibaye0bl.posts.USERID, " +
				"n1euzrfjibaye0bl.posts.CREATIONDATE, " +
				"n1euzrfjibaye0bl.posts.TITLE, n1euzrfjibaye0bl.posts.CATEGORY, " +
				"n1euzrfjibaye0bl.posts.BODY " + 
				"FROM n1euzrfjibaye0bl.posts " + 
				"LEFT JOIN n1euzrfjibaye0bl.comments " + 
				"ON n1euzrfjibaye0bl.comments.PID = n1euzrfjibaye0bl.posts.ID " + 
				"WHERE n1euzrfjibaye0bl.comments.UID = ? " + 
				"GROUP BY n1euzrfjibaye0bl.posts.ID " + 
				"ORDER BY 1";
		
		// execute query
		SqlRowSet srs = jdbcTemplate.queryForRowSet(query, userid);
        
		// instantiate and initialize a list of topic models
		List<TopicModel> topics = new ArrayList<TopicModel>();
				
		// while the rowset has a next add the row to the list
        while(srs.next())
        	topics.add(new TopicModel(srs.getString("CREATIONDATE"), srs.getString("TITLE"), srs.getString("CATEGORY"), srs.getString("BODY"), srs.getString("ID"), srs.getString("USERID")));

        // return the list
        return topics;
	}
	/**
	 * Method for getting all the topics that a user searches for
	 * 
	 * @param search type String
	 * @return ListTopicModel
	 */
	@Override
	public List<TopicModel> getSearchTopics(String search)
	{
		// query for returning everything in the posts table that matches a search
		String query = "SELECT * FROM n1euzrfjibaye0bl.posts " + 
				"WHERE UPPER(n1euzrfjibaye0bl.posts.TITLE) LIKE ? " + 
				"OR UPPER(n1euzrfjibaye0bl.posts.CATEGORY) LIKE ? " + 
				"OR UPPER(n1euzrfjibaye0bl.posts.BODY) LIKE ?";
		
		// initialize and instantiate a string surrounded by % to be used in the query for searching using LIKE
		String findit = "%" + search.toUpperCase() + "%";
		
		// execute query with the search passed in
		SqlRowSet srs = jdbcTemplate.queryForRowSet(query, findit, findit, findit);
        
		// instantiate and instantiate a list of topic models
		List<TopicModel> topics = new ArrayList<TopicModel>();
				
		// while the rowset has a next add the row to the list
        while(srs.next())
        	topics.add(new TopicModel(srs.getString("CREATIONDATE"), srs.getString("TITLE"), srs.getString("CATEGORY"), srs.getString("BODY"), srs.getString("ID"), srs.getString("USERID")));

        // return the list
        return topics;
	}
}
