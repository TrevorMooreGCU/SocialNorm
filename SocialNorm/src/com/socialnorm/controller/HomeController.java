package com.socialnorm.controller;

import javax.servlet.http.HttpSession;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;
import com.socialnorm.model.CredentialModel;
import com.socialnorm.model.SearchModel;

/**
 * Trevor Moore
 * CST-341
 * 09/22/2018
 * This assignment was completed in collaboration with Aaron Ross
 * This is our own work.
 * 
 * HomeController Class for navigating to the home page.
 * @author Trevor
 * 
 */
@Controller
@RequestMapping("/")
public class HomeController 
{	
	/**
	 * Simple method that returns a ModelAndView object with a Login, Register, and Search model added.
	 * This is the "logged out" method for the normal "logged out" home page.
	 * Invoke using "/" URI.
	 * 
	 * @param session of type HttpSession
	 * @return ModelAndView object type ModelAndView
	 */
	@RequestMapping(path="/", method=RequestMethod.GET)
	public ModelAndView getSocialNorm(HttpSession session) 
	{
		// removing the "user" object stored in session, because this method gets called for logging out a user
		session.removeAttribute("user");
		
		// instantiating ModelAndView object and specifying to return the "home" view
		ModelAndView mav = new ModelAndView("home");
		
		// adding a Login and Search model objects to the ModelAndView to resolve the form modelAttributes in the header (search form and login form both need models)
		mav.addObject("login", new CredentialModel());
		mav.addObject("search", new SearchModel());
		
		// returning ModelAndView object with all models needed attached
		return mav;
	}
	
	/**
	 * Simple Controller that returns a ModelAndView object with a Search model added.
	 * This is the "logged in" method for the secure "logged in" home page.
	 * Invoke using "/Home" URI.
	 * 
	 * @return ModelAndView object type ModelAndView
	 */
	@RequestMapping(path="/Home", method=RequestMethod.GET)
	public ModelAndView getSecureSocialNorm() 
	{
		// instantiating ModelAndView object and specifying to return the "secureHome" view
		ModelAndView mav = new ModelAndView("secureHome");
		
		// adding a Search model object to the ModelAndView
		mav.addObject("search", new SearchModel());

		// returning ModelAndView object with all models needed attached
		return mav;
	}
	
}
