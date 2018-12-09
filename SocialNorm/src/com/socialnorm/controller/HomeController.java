package com.socialnorm.controller;

import java.util.ArrayList;
import javax.servlet.http.HttpSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;
import com.socialnorm.model.CredentialModel;
import com.socialnorm.model.SearchModel;
import com.socialnorm.model.TopicModel;
import com.socialnorm.services.business.ITopicService;

/**
 * Trevor Moore
 * CST-341
 * 09/22/2018
 * This assignment was completed in collaboration with Aaron Ross
 * This is our own work.
 * 
 * HomeController Class for navigating to the home page. Invoke using "/"
 * @author Trevor
 * 
 */
@Controller
@RequestMapping("/")
public class HomeController 
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
	 * Simple method that returns a ModelAndView object with a Login, Search, and lists of recent topics added.
	 * This is the "logged out" method for the normal "logged out" home page.
	 * Invoke using "/" URI.
	 * @param session of type HttpSession
	 * @return ModelAndView home.jsp
	 */
	@RequestMapping(path="/", method=RequestMethod.GET)
	//@ExceptionHandler({GlobalExceptionHandler.class})
	public ModelAndView getSocialNorm(HttpSession session) 
	{
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
	/**
	 * Simple Controller that returns a ModelAndView object with a Search model, and lists of recent and all topics added.
	 * This is the "logged in" method for the secure "logged in" home page.
	 * Invoke using "/Home" URI.
	 * @return ModelAndView viewAllTopics.jsp
	 */
	@RequestMapping(path="/Home", method=RequestMethod.GET)
	//@ExceptionHandler({GlobalExceptionHandler.class})
	public ModelAndView getSecureSocialNorm() 
	{
		// instantiating ModelAndView object and specifying to return the "viewAllTopics" view
		ModelAndView mav = new ModelAndView("viewAllTopics");
		
		// adding a Search, and lists of recent and all topics objects to the ModelAndView
		mav.addObject("search", new SearchModel());
		mav.addObject("recent", new ArrayList<TopicModel>(topicService.getMostRecentPosts()));
		mav.addObject("topics", new ArrayList<TopicModel>(topicService.getAllPosts()));
		
		// returning ModelAndView object with all models needed attached
		return mav;
	}
}
