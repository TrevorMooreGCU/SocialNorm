package com.socialnorm.controller;

import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import javax.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.ModelAttribute;
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
 * Trevor Moore
 * CST-341
 * 10/8/2018
 * This assignment was completed in collaboration with Aaron Ross
 * This is our own work.
 * 
 * CreateController Class for creating our product module. Invoke with /create
 * @author Trevor
 * 
 */
@Controller
@RequestMapping("/create")
public class CreateController 
{
	// Topic Service that is being injected and used to insert new topics into the database
	ITopicService topicService;
	/**
	 * Autowired method for setting the injected Topic Post Service
	 * @param service type ITopicPostService
	 */
	@Autowired
	public void setTopicService(ITopicService service)
	{
		this.topicService = service;
	}
	/**
	 * Simple method that returns a ModelAndView object with a Search and Topic model, and string of dattime format added for returning the create topic view.
	 * Only available for logged in users.
	 * Invoke using "/create/socialize" URI.
	 * 
	 * @return ModelAndView createTopic.jsp
	 */
	@RequestMapping(path="/socialize", method=RequestMethod.GET)
	public ModelAndView getCreateTopicView() 
	{
		// instantiating ModelAndView object and specifying to return the "createTopic" view
		ModelAndView mav = new ModelAndView("createTopic");
		
		// getting the current time and setting it 
		SimpleDateFormat sdfDate = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
	    Date now = new Date();
	    String date = sdfDate.format(now);
		
		// adding a Search and Topic model objects to the ModelAndView
		mav.addObject("search", new SearchModel());
		mav.addObject("topic", new TopicModel());
		mav.addObject("date", date);
		
		// returning ModelAndView object with all models needed attached
		return mav;
	}
	/**
	 * Simple method that posts the new topic and returns a ModelAndView object with a Search and the Topic model added.
	 * Only available for logged in users.
	 * Invoke using "/create/posttopic" URI.
	 * 
	 * @param topic of type TopicModel
	 * @param result of type BindingResult
	 * @param session of type HttpSession
	 * @return ModelAndView viewTopic.jsp
	 */
	@RequestMapping(path="/posttopic", method=RequestMethod.POST)
	public ModelAndView postTopic(@Valid @ModelAttribute("topic") TopicModel topic, BindingResult result, HttpSession session)
	{
		// check if the model has data validation errors
		if(result.hasErrors())
		{
			// if it has errors:
			// instantiating ModelAndView object and specifying to return the "createTopic" view
			ModelAndView mav = new ModelAndView("createTopic");
			
			// adding a Search and Topic model object to the ModelAndView
			mav.addObject("search", new SearchModel());
			mav.addObject("topic", topic);
			
			// returning ModelAndView object with all models needed attached
			return mav;
		}
		
		// inserting the new post into the db using injected service
		TopicModel tp = topicService.addPost(topic, (CredentialModel) session.getAttribute("user"));
		
		// instantiating view to view the newly posted topic
		ModelAndView mav = new ModelAndView("viewTopic");
		
		// adding the needed models for the view
		mav.addObject("search", new SearchModel());
		mav.addObject("topic", tp);
		mav.addObject("userid", session.getAttribute("userid"));
		mav.addObject("comments", topicService.getComments(tp.getId()));
		mav.addObject("thecomment", new CommentModel());
		
		// returning ModelAndView object with all models needed attached
		return mav;
	}
	/**
	 * Method for posting a new comment to a topic.
	 * Only available for logged in users.
	 * Invoke using "/create/addComment" URI.
	 * 
	 * @param id type String
	 * @param comment type CommentModel
	 * @param result type BindingResult
	 * @param session type HttpSession
	 * @return ModelAndView viewTopic.jsp
	 */
	@RequestMapping(path="/addcomment", method=RequestMethod.POST)
	public ModelAndView addComment(@RequestParam(value = "id", required = false) String id, @Valid @ModelAttribute("thecomment") CommentModel comment, BindingResult result, HttpSession session)
	{
		// check if the model has data validation errors
		if(result.hasErrors())
		{
			// instantiating ModelAndView object and specifying to return the "viewTopic" view
			ModelAndView mav = new ModelAndView("viewTopic");
			
			// adding a SearchModel, TopicModel, the CommenttModel, the users id, all comments for the topic
			mav.addObject("search", new SearchModel());
			mav.addObject("topic", topicService.getTopic(id));
			mav.addObject("userid", session.getAttribute("userid"));
			mav.addObject("comments", topicService.getComments(id));
			mav.addObject("thecomment", comment);
			
			// returning ModelAndView object with all models needed attached
			return mav;
		}
		
		// getting the current time and setting it 
		SimpleDateFormat sdfDate = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
	    Date now = new Date();
	    String date = sdfDate.format(now);
		
		// inserting the new comment on the post into the db using injected service
		topicService.addComment(comment, date, id, (String) session.getAttribute("userid"));
		
		// instantiating ModelAndView object and specifying to return the "viewTopic" view
		ModelAndView mav = new ModelAndView("viewTopic");
		
		// adding a SearchModel, TopicModel, CommenttModel, the users id, all comments for the topic
		mav.addObject("search", new SearchModel());
		mav.addObject("topic", topicService.getTopic(id));
		mav.addObject("userid", session.getAttribute("userid"));
		mav.addObject("comments", topicService.getComments(id));
		mav.addObject("thecomment", new CommentModel());
		
		// returning ModelAndView object with all models needed attached
		return mav;
	}
	/**
	 * Method for getting the messages/conversation view.
	 * Only available for logged in users.
	 * Invoke using "/create/message" URI.
	 * 
	 * @param id type String
	 * @param response type HttpServletResponse
	 * @param session type HttpSession
	 * @return ModelAndView message.jsp
	 */
	@RequestMapping(path="/message", method=RequestMethod.GET)
	public ModelAndView getMessageView(@RequestParam(value = "id", required = false) String id, HttpServletResponse response, HttpSession session) 
	{
		// instantiating ModelAndView object and specifying to return the "message" view
		ModelAndView mav = new ModelAndView("message");
		
		// getting the user wishing to be messaged and putting info in RegisterModel
		RegisterModel rm = topicService.getUserInfo(id);
		
		// storing the current users id
		String userid = (String) session.getAttribute("userid");
		
		// get all the other chats that the current user has
		ArrayList<ChatModel> cma = new ArrayList<ChatModel>(topicService.getChats(userid));
		
		// getting the current chat id
		String messageid = topicService.getChatId(userid, id);
		
		// instantiate message model and set the sender and receiver ids for the message
		MessageModel mm = new MessageModel();
		mm.setSenderid(userid);
		mm.setReceiverid(id);
		
		// adding a SearchModel, RegisterModel, MessageModel, ChatModel ArrayList, and MessageModel ArrayList of current chat
		mav.addObject("search", new SearchModel());
		mav.addObject("usersender", rm);
		mav.addObject("message", mm);
		mav.addObject("chats", cma);
		mav.addObject("messages", topicService.getMessages(messageid));
		
		// returning ModelAndView object with all models needed attached
		return mav;
	}
	/**
	 * Method for posting a message in a chat
	 * Only available for logged in users.
	 * Invoke using "/create/sendmessage" URI.
	 * 
	 * @param id type String
	 * @param message type MessageModel
	 * @param result type BindingResult
	 * @param session type HttpSession
	 * @return ModelAndView message.jsp
	 */
	@RequestMapping(path="/sendmessage", method=RequestMethod.POST)
	public ModelAndView addMessage(@RequestParam(value = "id", required = false) String id, @Valid @ModelAttribute("message") MessageModel message, BindingResult result, HttpSession session)
	{
		// check if the model has data validation errors
		if(result.hasErrors())
		{
			// if it has errors:
			// instantiating ModelAndView object and specifying to return the "message" view
			ModelAndView mav = new ModelAndView("message");
			
			// getting the user wishing to be messaged and putting info in RegisterModel
			RegisterModel rm = topicService.getUserInfo(id);
			
			// storing the current users id
			String userid = (String) session.getAttribute("userid");
			
			// get all the other chats that the current user has
			ArrayList<ChatModel> cma = new ArrayList<ChatModel>(topicService.getChats(userid));
			
			// getting the current chat id
			String messageid = topicService.getChatId(userid, id);
			
			// adding a SearchModel, RegisterModel, the MessageModel, ChatModel ArrayList, and MessageModel ArrayList of current chat
			mav.addObject("search", new SearchModel());
			mav.addObject("usersender", rm);
			mav.addObject("message", message);
			mav.addObject("chats", cma);
			mav.addObject("messages", topicService.getMessages(messageid));
			
			// returning ModelAndView object with all models needed attached
			return mav;
		}
		
		// if it doesn't have errors:
		// getting the current time and setting it 
		SimpleDateFormat sdfDate = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
	    Date now = new Date();
	    String date = sdfDate.format(now);
	    
	    // storing the current users id
	    String userid = (String) session.getAttribute("userid");
	    
	    // getting the current chat id
	    String messageid = topicService.getChatId(userid, id);
	    
	    // if the chat does not exist yet, create a new chat
	    if(messageid.equals("0"))
	    	messageid = topicService.createChat(userid, id);
	    
		// posting the new message on the chat using injected service
		topicService.sendMessage(messageid, message, date);
		
		// instantiating ModelAndView object and specifying to return the "message" view
		ModelAndView mav = new ModelAndView("message");
		
		// getting the user wishing to be messaged and putting info in RegisterModel
		RegisterModel rm = topicService.getUserInfo(id);
		
		// get all the other chats that the current user has
		ArrayList<ChatModel> cma = new ArrayList<ChatModel>(topicService.getChats(userid));
		
		// instantiate message model and set the sender and receiver ids for the message
		MessageModel mm = new MessageModel();
		mm.setSenderid(userid);
		mm.setReceiverid(id);
		
		// adding a SearchModel, RegisterModel, MessageModel, ChatModel ArrayList, and MessageModel ArrayList of current chat
		mav.addObject("search", new SearchModel());
		mav.addObject("usersender", rm);
		mav.addObject("message", mm);
		mav.addObject("chats", cma);
		mav.addObject("messages", topicService.getMessages(messageid));
		
		// returning ModelAndView object with all models needed attached
		return mav;
	}
}
