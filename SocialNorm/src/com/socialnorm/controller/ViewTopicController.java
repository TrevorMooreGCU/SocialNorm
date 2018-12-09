package com.socialnorm.controller;

import java.io.IOException;
import java.util.ArrayList;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import com.socialnorm.model.ChatModel;
import com.socialnorm.model.CommentModel;
import com.socialnorm.model.CredentialModel;
import com.socialnorm.model.MessageModel;
import com.socialnorm.model.RegisterModel;
import com.socialnorm.model.SearchModel;
import com.socialnorm.model.TopicModel;
import com.socialnorm.services.business.ITopicService;

/**
 * Aaron Ross
 * CST-341
 * 12/06/2018
 * This assignment was completed in collaboration with Trevor Moore
 * This is our own work.
 * 
 * ViewTopicController Class for viewing topic modules. Invoke using "/view"
 * @author Aaron
 * 
 */
@Controller
@RequestMapping("/view")
public class ViewTopicController {

	// Topic Service that is being injected and used to insert new topics into the database
	ITopicService topicService;
	/**
	 * Autowired method for setting the injected Topic Service
	 * @param service type ITopicPostService
	 */
	@Autowired
	public void setTopicService(ITopicService service)
	{
		this.topicService = service;
	}
	/**
	 * Simple method for getting all topics that returns a ModelAndView object with a Search and Topic models added.
	 * Only available for logged in users.
	 * Invoke using "/view/all" URI.
	 * 
	 * @return ModelAndView viewAllTopics.jsp
	 */
	@RequestMapping(path="/all", method=RequestMethod.GET)
	public ModelAndView getViewAllTopicsView() 
	{
		// instantiating ModelAndView object and specifying to return the "viewAllTopics" view
		ModelAndView mav = new ModelAndView("viewAllTopics");
		
		// adding a Search and Topic model arraylists to the model and view object
		mav.addObject("search", new SearchModel());
		mav.addObject("recent", new ArrayList<TopicModel>(topicService.getMostRecentPosts()));
		mav.addObject("topics", new ArrayList<TopicModel>(topicService.getAllPosts()));
		
		// returning ModelAndView object with all models needed attached
		return mav;
	}
	/**
	 * Simple method that gets the selected topic and returns a ModelAndView object with a Search and the Topic model added.
	 * Only available for logged in users.
	 * Invoke using "/view/topic" URI.
	 * 
	 * @param id type String
	 * @param response type HttpServletResponse
	 * @param session HttpSession
	 * @return ModelAndView viewTopic.jsp
	 * @throws IOException type ioexception
	 */
	@RequestMapping(path="/topic", method=RequestMethod.GET)
	public ModelAndView getViewTopicView(@RequestParam(value = "id", required = false) String id, HttpServletResponse response, HttpSession session) throws IOException 
	{
		// instantiating ModelAndView object and specifying to return the "viewTopic" view
		ModelAndView mav = new ModelAndView("viewTopic");
		
		// adding a Search model, Topic model selected, current users id, Comment model arraylist for the topic, and Comment model
		mav.addObject("search", new SearchModel());
		mav.addObject("topic", topicService.getTopic(id));
		mav.addObject("userid", session.getAttribute("userid"));
		mav.addObject("comments", topicService.getComments(id));
		mav.addObject("thecomment", new CommentModel());
		
		// returning ModelAndView object with all models needed attached
		return mav;
	}
	/**
	 * Simple method for getting a category of posts that returns a ModelAndView object with a Search and Topic models added.
	 * Only available for logged in users.
	 * Invoke using "/view/category" URI.
	 * 
	 * @param id type String
	 * @param response type HttpServletResponse
	 * @param session type HttpSession
	 * @return ModelAndView categoryView.jsp
	 * @throws IOException type ioexception
	 */
	@RequestMapping(path="/category", method=RequestMethod.GET)
	public ModelAndView getCategoryView(@RequestParam(value = "id", required = false) String id, HttpServletResponse response, HttpSession session) throws IOException 
	{
		// instantiating ModelAndView object and specifying to return the "categoryView" view
		ModelAndView mav = new ModelAndView("categoryView");
		
		// adding a SearchModel, category name, and TopicModel array list of the topics in that category
		mav.addObject("search", new SearchModel());
		mav.addObject("category", id);
		mav.addObject("topics", topicService.getTopicByCategory(id));
		
		// returning ModelAndView object with all models needed attached
		return mav;
	}
	/**
	 * Simple method that gets all topics posted by logged in user and returns a ModelAndView object with a Search and Topic models added.
	 * Only available for logged in users.
	 * Invoke using "/view/mytopics" URI.
	 * 
	 * @param session type HttpSession
	 * @return ModelAndView userTopics.jsp
	 */
	@RequestMapping(path="/mytopics", method=RequestMethod.GET)
	public ModelAndView getUserTopicsView(HttpSession session)
	{
		// instantiating ModelAndView object and specifying to return the "userTopics" view
		ModelAndView mav = new ModelAndView("userTopics");
		
		// getting the credential model and user id from the session
		CredentialModel cm = (CredentialModel) session.getAttribute("user");
		String id = (String) session.getAttribute("userid");
		
		// adding a SearchModel, username of current user, TopicModel array list full of users topics posted, and RegisterModel of user info
		mav.addObject("search", new SearchModel());
		mav.addObject("username", cm.getUsername());
		mav.addObject("topics", topicService.getTopicByUser(id));
		mav.addObject("user", topicService.getUserInfo(id));
		
		// returning ModelAndView object with all models needed attached
		return mav;
	}
	/**
	 * Method for viewing someone's user account/to get to their page so you can direct message them
	 * Only available for logged in users.
	 * Invoke using "/view/account" URI.
	 * 
	 * @param id type String
	 * @param response type HttpServletResponse
	 * @param session HttpSession
	 * @return ModelAndView viewAccount.jsp
	 * @throws IOException type ioexception
	 */
	@RequestMapping(path="/account", method=RequestMethod.GET)
	public ModelAndView getViewAccountView(@RequestParam(value = "id", required = false) String id, HttpServletResponse response, HttpSession session) throws IOException 
	{
		// instantiating ModelAndView object and specifying to return the "viewAccount" view
		ModelAndView mav = new ModelAndView("viewAccount");
		
		// adding a SearchModel, TopicModel array list filled with posts the user commented on, and RegisterModel with the users info
		mav.addObject("search", new SearchModel());
		mav.addObject("topics", topicService.getTopicByUserComments(id));
		mav.addObject("user", topicService.getUserInfo(id));
		
		// returning ModelAndView object with all models needed attached
		return mav;
	}
	/**
	 * Method for getting all the chats and messages the logged in user has.
	 * Only available for logged in users.
	 * Invoke using "/view/messages" URI.
	 * 
	 * @param session type HttpSession
	 * @return ModelAndView message.jsp
	 */
	@RequestMapping(path="/mymessages", method=RequestMethod.GET)
	public ModelAndView getMyMessagesView(HttpSession session)
	{
		// instantiating ModelAndView object and specifying to return the "message" view
		ModelAndView mav = new ModelAndView("message");
		
		// store the logged in users id
		String userid = (String) session.getAttribute("userid");
		
		// fill ChatModel array list with all the chats that the logged in user is involved in
		ArrayList<ChatModel> cma = new ArrayList<ChatModel>(topicService.getChats(userid));
		
		// store the most recent users id that the logged in user has chatted with
		String mostRecentUserId = cma.get(0).getUserid();
		
		// store the most recent chat id that the user has chatted in
		String mostRecentChatId = cma.get(0).getId();
		
		// get the info of the most recent chatter and put in Register model
		RegisterModel rm = topicService.getUserInfo(mostRecentUserId);
		
		// set MessageModel with the id of the sender and the id of the receiver
		MessageModel mm = new MessageModel();
		mm.setSenderid(userid);
		mm.setReceiverid(mostRecentUserId);
		
		// Adding a SearchModel, RegisterModel with most recent chatters info, MessageModel with sender and receiver id's,
		// ChatModel array list with all chats the logged in user is involved in, and a MessageModel array list with all
		// the messages in the most recent chat.
		mav.addObject("search", new SearchModel());
		mav.addObject("usersender", rm);
		mav.addObject("message", mm);
		mav.addObject("chats", cma);
		mav.addObject("messages", topicService.getMessages(mostRecentChatId));
		
		// returning ModelAndView object with all models needed attached
		return mav;
	}
}


