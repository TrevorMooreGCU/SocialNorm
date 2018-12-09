package com.socialnorm.controller;

import java.util.ArrayList;

import javax.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;
import com.socialnorm.model.CredentialModel;
import com.socialnorm.model.RegisterModel;
import com.socialnorm.model.SearchModel;
import com.socialnorm.model.TopicModel;
import com.socialnorm.services.business.IRegisterService;
import com.socialnorm.services.business.ITopicService;
import com.socialnorm.services.utility.GlobalExceptionHandler;

/**
 * Trevor Moore
 * CST-341
 * 09/22/2018
 * This assignment was completed in collaboration with Aaron Ross
 * This is our own work.
 * 
 * RegisterController Class for registering users to SocialNorm and returning the register page.
 * @author Trevor
 * 
 */
@Controller
@RequestMapping("/register")
public class RegisterController 
{
	// Register Service and Topic Service that is being injected and used check if users are in the database
	IRegisterService registerService;
	ITopicService topicService;
	/**
	 * Autowired method for setting the injected Register Service
	 * @param service type IRegistrationService
	 */
	@Autowired
	public void setRegisterService(IRegisterService service)
	{
		this.registerService = service;
	}
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
	 * Simple method that returns a ModelAndView object with a Login, Register, and Search model added.
	 * This will take the user to the register page (href in header uses this method)
	 * Invoke using "/register/" URI.
	 * 
	 * @return ModelAndView registerUser.jsp
	 */
	@RequestMapping(path="/", method=RequestMethod.GET)
	public ModelAndView displayRegisterForm()
	{
		// instantiating ModelAndView object and specifying to return the "registerUser" view
		ModelAndView mav = new ModelAndView("registerUser");
		
		// adding a Login, Register, and Search model objects to the ModelAndView to resolve the form modelAttributes in the header (search form and login form both need models)
		mav.addObject("login", new CredentialModel());
		mav.addObject("register", new RegisterModel());
		mav.addObject("search", new SearchModel());
		
		// returning ModelAndView object with all models needed attached
		return mav;
	}
	/**
	 * This method at "/register/registeruser" will add a user to the database.
	 * 
	 * @param user Model of a User that got posted of type Register.
	 * @param result of type BindingResult.
	 * @return ModelAndView registerSuccess.jsp
	 */
	@RequestMapping(path="/registeruser", method=RequestMethod.POST)
	@ExceptionHandler({GlobalExceptionHandler.class})
	public ModelAndView registerUser(@Valid @ModelAttribute("register") RegisterModel user, BindingResult result)
	{
		// check if the model has data validation errors
		if(result.hasErrors())
		{
			// if it has errors:
			// instantiating ModelAndView object and specifying to return the "registerUser" view
			ModelAndView mav = new ModelAndView("registerUser");
			
			// adding a Login, Register (using model passed in), and Search model objects to the ModelAndView to resolve the form modelAttributes in the header (search form and login form both need models)
			mav.addObject("login", new CredentialModel());
			mav.addObject("register", user);
			mav.addObject("search", new SearchModel());
			
			// returning ModelAndView object with all models needed attached
			return mav;
		}

		// attempt to register the user
		int results = registerService.register(user);
		
		// if the register returns "success" (meaning the user was successfully inserted into the database)
		if(results == 1)
		{
			// instantiating ModelAndView object and specifying to return the "registerSuccess" view
			ModelAndView mav = new ModelAndView("registerSuccess");
			
			// adding a Login, Register (using model passed in), and Search model objects to the ModelAndView to resolve the form modelAttributes in the header (search form and login form both need models)
			mav.addObject("login", new CredentialModel());
			mav.addObject("register", user);
			mav.addObject("recent", new ArrayList<TopicModel>(topicService.getMostRecentPosts()));
			mav.addObject("search", new SearchModel());
			
			// returning ModelAndView object with all models needed attached
			return mav;
		}
		// if the register returns "failure" (meaning the user was not inserted into the database)
		else if(results == -1)
		{
			// instantiating ModelAndView object and specifying to return the "error" view
			ModelAndView mav = new ModelAndView("error");
			
			// adding a Login and Search model objects to the ModelAndView to resolve the form modelAttributes in the header (search form and login form both need models)
			mav.addObject("login", new CredentialModel());
			mav.addObject("search", new SearchModel());
			
			// returning ModelAndView object with all models needed attached
			return mav;
		}
		// if the register returns "duplicate" (meaning the username is already in the database)
		else
		{
			// instantiating ModelAndView object and specifying to return the "registerUser" view
			ModelAndView mav = new ModelAndView("registerUser");
			
			// adding a Login, Register, and Search model objects to the ModelAndView to resolve the form modelAttributes in the header (search form and login form both need models)
			mav.addObject("login", new CredentialModel());
			mav.addObject("register", user);
			mav.addObject("search", new SearchModel());
			
			// adding another object of type string to be displayed on the page specifying the error
			mav.addObject("message", "Username is already taken, please choose another one.");
			
			// returning ModelAndView object with all models needed attached
			return mav;
		}
	}
}