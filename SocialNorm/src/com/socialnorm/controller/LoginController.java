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
import com.socialnorm.services.business.ILoginService;

/**
 * Trevor Moore
 * CST-341
 * 09/22/2018
 * This assignment was completed in collaboration with Aaron Ross
 * This is our own work.
 * 
 * We the following for reference:
 * http://www.javaroots.com/2013/08/how-to-get-session-object-in-spring-mvc.html
 * 
 * For storing objects in the session.
 * 
 * LoginController Class for logging users in to SocialNorm.
 * @author Trevor
 * 
 */
@Controller
@RequestMapping("/login")
public class LoginController 
{
	// Login Service that is being injected and used check if users are in the database
	ILoginService loginService;

	/**
	 * Autowired method for setting the injected Login Service
	 * @param service
	 */
	@Autowired
	public void setLoginService(ILoginService service)
	{
		this.loginService = service;
	}
	/**
	 * This method at "/login/loginuser" logs a user in to the app.
	 * 
	 * @param user Model of a User of type Login.
	 * @param result of type BindingResult.
	 * @param session of type HttpSession.
	 * @return ModelAndView to display username on the welcome page.
	 */
	@RequestMapping(path="/loginuser", method=RequestMethod.POST)
	public ModelAndView loginUser(@Valid @ModelAttribute("login") CredentialModel user, BindingResult result, HttpSession session)
	{
		// check if the model has data validation errors
		if(result.hasErrors())
		{
			// if it has errors:
			// instantiating ModelAndView object and specifying to return the "loginUser" view
			ModelAndView mav = new ModelAndView("loginUser");
			
			// adding a Login (using model passed in), Register, and Search model objects to the ModelAndView to resolve the form modelAttributes in the header (search form and login form both need models)
			mav.addObject("login", user);
			mav.addObject("search", new SearchModel());

			// returning ModelAndView object with all models needed attached
			return mav;
		}
		
		// if it does not have errors:
		try
		{
			// if the loginCheck returns true (meaning there user matches a record in the database)
			if(loginService.loginCheck(user))
			{
				// instantiating ModelAndView object and specifying to return the "welcomeHome" view
				ModelAndView mav = new ModelAndView("welcomeHome");
				
				// adding a Login (using model passed in) and Search model objects to the ModelAndView to resolve the form modelAttributes in the header (search form and login form both need models)
				mav.addObject("login", user);
				mav.addObject("search", new SearchModel());
				
				// storing the user CredentialModel of the logging in user in the session
				session.setAttribute("user" , user);
				
				// returning ModelAndView object with all models needed attached
				return mav;
			}
			// if the loginCheck is false (meaning there isnt a matching record in the database)
			else
			{
				// instantiating ModelAndView object and specifying to return the "loginUser" view again
				ModelAndView mav = new ModelAndView("loginUser");
				
				// adding a Login (using model passed in) and Search model objects to the ModelAndView to resolve the form modelAttributes in the header (search form and login form both need models)
				mav.addObject("login", user);
				mav.addObject("search", new SearchModel());
				
				// adding another object of type string to be displayed on the page specifying the error
				mav.addObject("message", "Username or Password was incorrect.");
				
				// returning ModelAndView object with all models needed attached
				return mav;
			}
		}
		// catching exceptions
		catch(Exception e)
		{
			System.out.println("Database Exception. Caught in Login Controller.");
			
			// instantiating ModelAndView object and specifying to return the "error" view
			ModelAndView mav = new ModelAndView("error");
			
			// adding a Login and Search model objects to the ModelAndView to resolve the form modelAttributes in the header (search form and login form both need models)
			mav.addObject("login", new CredentialModel());
			mav.addObject("search", new SearchModel());
			
			// returning ModelAndView object with all models needed attached
			return mav;
		}
	}

}
