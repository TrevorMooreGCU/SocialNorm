package com.socialnorm.controller;

import java.io.IOException;
import java.util.ArrayList;
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
import com.socialnorm.model.CommentModel;
import com.socialnorm.model.CredentialModel;
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
 * UpdateController Class for updating products. Invoke with "/update"
 * @author Trevor
 * 
 */
@Controller
@RequestMapping("/update")
public class UpdateController 
{
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
	 * Simple method that returns a ModelAndView object with a Search and Topic model selected to update added.
	 * Only available for logged in users.
	 * Invoke using "/update/topic" URI.
	 * @param id type String
	 * @param response HttpServletResponse
	 * @return ModelAndView updateTopic.jsp
	 * @throws IOException type ioexception
	 */
	@RequestMapping(path="/topic", method=RequestMethod.GET)
	public ModelAndView getUpdateTopicView(@RequestParam(value = "id", required = false) String id, HttpServletResponse response) throws IOException 
	{
		// instantiating ModelAndView object and specifying to return the "updateTopic" view
		ModelAndView mav = new ModelAndView("updateTopic");
		
		// adding a Search and Topic model objects to the ModelAndView
		mav.addObject("search", new SearchModel());
		mav.addObject("topic", topicService.getTopic(id));
		
		// returning ModelAndView object with all models needed attached
		return mav;
	}
	/**
	 * Simple method for updating posts that returns a ModelAndView object with a Search and Topic model added.
	 * Only available for logged in users.
	 * Invoke using "/update/updatetopic" URI.
	 * @param topic type TopicModel
	 * @param result type BindingResult
	 * @param session type HttpSession
	 * @return ModelAndView viewTopic.jsp
	 */
	@RequestMapping(path="/updatetopic", method=RequestMethod.POST)
	public ModelAndView updateTopic(@Valid @ModelAttribute("topic") TopicModel topic, BindingResult result, HttpSession session)
	{
		// check if the model has data validation errors
		if(result.hasErrors())
		{
			// if it has errors:
			// instantiating ModelAndView object and specifying to return the "updateTopic" view
			ModelAndView mav = new ModelAndView("updateTopic");
			
			// adding a Search and Topic model object to the ModelAndView
			mav.addObject("search", new SearchModel());
			mav.addObject("topic", topic);
			
			// returning ModelAndView object with all models needed attached
			return mav;
		}

		// instantiating ModelAndView object and specifying to return the "viewTopic" view
		ModelAndView mav = new ModelAndView("viewTopic");
		
		// adding a Search and Topic model objects to the ModelAndView
		mav.addObject("search", new SearchModel());
		mav.addObject("topic", topicService.updateTopic(topic));
		mav.addObject("userid", session.getAttribute("userid"));
		mav.addObject("comments", topicService.getComments(topic.getId()));
		mav.addObject("thecomment", new CommentModel());
		
		// returning ModelAndView object with all models needed attached
		return mav;
	}
	/**
	 * Method for getting the update account view for the current user.
	 * Only available for logged in users.
	 * Invoke using "/update/account" URI.
	 * 
	 * @param session type HttpSession
	 * @return ModelAndView updateAccount.jsp
	 */
	@RequestMapping(path="/account", method=RequestMethod.GET)
	public ModelAndView getUpdateAccountView(HttpSession session)
	{
		// instantiating ModelAndView object and specifying to return the "updateAccount" view
		ModelAndView mav = new ModelAndView("updateAccount");
		
		// getting and storing the current users id
		String id = (String) session.getAttribute("userid");
		
		// adding a SearchModel and RegisterModel with the users info in it
		mav.addObject("search", new SearchModel());
		mav.addObject("user", topicService.getUserInfo(id));
		
		// returning ModelAndView object with all models needed attached
		return mav;
	}
	/**
	 * Method for posting an update to the current user's account.
	 * Only available for logged in users.
	 * Invoke using "/update/updateaccount" URI.
	 * 
	 * @param user type RegisterModel
	 * @param result type BindingResult
	 * @param session type HttpSession
	 * @return ModelAndView userTopics.jsp
	 */
	@RequestMapping(path="/updateaccount", method=RequestMethod.POST)
	public ModelAndView updateAccount(@Valid @ModelAttribute("user") RegisterModel user, BindingResult result, HttpSession session)
	{
		// check if the model has data validation errors
		if(result.hasErrors())
			 if (result.getErrorCount() == 2 && result.hasFieldErrors("password")) 
			 {
				 //if it doesnt have errors (check for if it has specifically 2 errors, for lack of a password field, which shouldnt be updated or displayed):
				 topicService.updateAccount(user);

				// instantiating ModelAndView object and specifying to return the "userTopics" view
				ModelAndView mav = new ModelAndView("userTopics");
				
				// getting the credential model and user id from the session
				CredentialModel cm = (CredentialModel) session.getAttribute("user");
				String id = (String) session.getAttribute("userid");
				
				// adding a SearchModel, TopicModel ArrayList of users topics, RegisterModel with users info, and the username of the user
				mav.addObject("search", new SearchModel());
				mav.addObject("username", cm.getUsername());
				mav.addObject("topics", topicService.getTopicByUser(id));
				mav.addObject("user", topicService.getUserInfo(id));
				
				// returning ModelAndView object with all models needed attached
				return mav;
		     }
			 else
			 {
				// if it has errors:
				// instantiating ModelAndView object and specifying to return the "updateAccount" view
				ModelAndView mav = new ModelAndView("updateAccount");
				
				// adding a SearchModel and pass back the RegisterModel with errors
				mav.addObject("search", new SearchModel());
				mav.addObject("user", user);
				
				// returning ModelAndView object with all models needed attached
				return mav;
			 }
		// the following will never be reached, unless someone messes with the browser and tries to set a value for the password,
		// in which case the code below will run and the user will be logged out because they are causing trouble.
		// removing the "user" and "userid" objects stored in session, because this method gets called for logging out a user
		session.removeAttribute("user");
		session.removeAttribute("userid");

		// instantiating ModelAndView object and specifying to return the "home" view
		ModelAndView mav = new ModelAndView("home");
		
		// adding a Login, Search, and lists of recent topics to the ModelAndView to resolve the form modelAttributes in the header (search form and login form both need models)
		mav.addObject("login", new CredentialModel());
		mav.addObject("search", new SearchModel());
		mav.addObject("recent", new ArrayList<TopicModel>(topicService.getMostRecentPosts()));
		
		// returning ModelAndView object with all models needed attached
		return mav;
	}
}

