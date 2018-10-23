package com.socialnorm.controller;

import javax.servlet.http.HttpSession;
import javax.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

import com.socialnorm.model.CredentialModel;
import com.socialnorm.model.SearchModel;
import com.socialnorm.model.TopicModel;
import com.socialnorm.services.business.ITopicPostService;

/**
 * Trevor Moore
 * CST-341
 * 10/8/2018
 * This assignment was completed in collaboration with Aaron Ross
 * This is our own work.
 * 
 * CreateController Class for creating our product module.
 * @author Trevor
 * 
 */
@Controller
@RequestMapping("/create")
public class CreateController 
{
	// Topic Service that is being injected and used to insert new topics into the database
	ITopicPostService topicService;

	/**
	 * Autowired method for setting the injected Topic Post Service
	 * @param service type ITopicPostService
	 */
	@Autowired
	public void setTopicPostService(ITopicPostService service)
	{
		this.topicService = service;
	}
	/**
	 * Simple method that returns a ModelAndView object with a Search and Topic model added.
	 * Only available for logged in users.
	 * Invoke using "/create/socialize" URI.
	 * 
	 * @return ModelAndView object type ModelAndView
	 */
	@RequestMapping(path="/socialize", method=RequestMethod.GET)
	public ModelAndView getCreateTopicView() 
	{
		// instantiating ModelAndView object and specifying to return the "createTopic" view
		ModelAndView mav = new ModelAndView("createTopic");
		
		// adding a Search and Topic model objects to the ModelAndView
		mav.addObject("search", new SearchModel());
		mav.addObject("topic", new TopicModel());
		
		// returning ModelAndView object with all models needed attached
		return mav;
	}
	
	/**
	 * Simple method that returns a ModelAndView object with a Search and Topic model added.
	 * Only available for logged in users.
	 * Invoke using "/create/posttopic" URI.
	 * 
	 * @param topic of type TopicModel
	 * @param result of type BindingResult
	 * @param session of type HttpSession
	 * @return ModelAndView object type ModelAndView
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
		
		// Try Catch block for catching db exceptions
		try
		{
			// if what is returned is true (meaning the post was successfully inserted)
			if(topicService.addPost(topic, (CredentialModel) session.getAttribute("user")))
			{
				// instantiating ModelAndView object and specifying to return the "topicCreationSuccess" view
				ModelAndView mav = new ModelAndView("topicCreationSuccess");
				
				// adding a Search model objects to the ModelAndView
				mav.addObject("search", new SearchModel());

				// returning ModelAndView object with all models needed attached
				return mav;
			}
			// if false, meaning the post was not inserted
			else
			{
				// instantiating ModelAndView object and specifying to return the "secureError" view for logged in errors
				ModelAndView mav = new ModelAndView("secureError");
				
				// adding a Search model objects to the ModelAndView
				mav.addObject("search", new SearchModel());

				// returning ModelAndView object with all models needed attached
				return mav;
			}
			
		}
		// catching any exceptions so that the user will always see a nice error page
		catch(Exception e)
		{
			System.out.println("Database Exception. Caught in Create Controller.");
			
			// instantiating ModelAndView object and specifying to return the "secureError" view
			ModelAndView mav = new ModelAndView("secureError");
			
			// adding a Search model objects to the ModelAndView
			mav.addObject("search", new SearchModel());
			
			// returning ModelAndView object with all models needed attached
			return mav;
		}
	}
	
}
