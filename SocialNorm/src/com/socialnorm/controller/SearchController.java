package com.socialnorm.controller;

import javax.validation.Valid;
import org.springframework.stereotype.Controller;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.ModelAttribute;
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
 * SearchController Class for searching content on SocialNorm.
 * @author Trevor
 * 
 */
@Controller
@RequestMapping("/search")
public class SearchController 
{
	/**
	 * This method at "/search/usersearch" will allow users to search the site when they are NOT logged in.
	 * 
	 * @param search Model of a user of type Search.
	 * @param result of type BindingResult.
	 * @return ModelAndView to display errors on error page or return the home page if no errors occur.
	 */
	@RequestMapping(path="/usersearch", method=RequestMethod.POST)
	public ModelAndView search(@Valid @ModelAttribute("search") SearchModel search, BindingResult result)
	{
		// check if the model has data validation errors
		if(result.hasErrors())
		{
			// if it has errors:
			// instantiating ModelAndView object and specifying to return the "searchError" view
			ModelAndView mav = new ModelAndView("searchError");
			
			// adding a Login, Register, and Search model (using model passed in) objects to the ModelAndView to resolve the form modelAttributes in the header (search form and login form both need models)
			mav.addObject("login", new CredentialModel());
			mav.addObject("search", search);

			// returning ModelAndView object with all models needed attached
			return mav;
		}
		
		// if it does not have errors:
		// instantiating ModelAndView object and specifying to return the "home" view
		ModelAndView mav = new ModelAndView("home");
		
		// adding a Login, Register, and Search model (using model passed in) objects to the ModelAndView to resolve the form modelAttributes in the header (search form and login form both need models)
		mav.addObject("login", new CredentialModel());
		mav.addObject("search", search);
		
		// returning ModelAndView object with all models needed attached
		return mav;
		
	}
	
	/**
	 * This method at "/search/securesearch" will allow users to search the site when they ARE logged in.
	 * 
	 * @param search Model of a user of type Search.
	 * @param result of type BindingResult.
	 * @return ModelAndView to display errors on secure error page or return the secure home page if no errors occur.
	 */
	@RequestMapping(path="/securesearch", method=RequestMethod.POST)
	public ModelAndView secureSearch(@Valid @ModelAttribute("search") SearchModel search, BindingResult result)
	{
		// check if the model has data validation errors
		if(result.hasErrors())
		{
			// if it has errors:
			// instantiating ModelAndView object and specifying to return the "secureSearchError" view
			ModelAndView mav = new ModelAndView("secureSearchError");
			
			// adding a Search model (using model passed in)
			mav.addObject("search", search);
			
			// returning ModelAndView object with all models needed attached
			return mav;
		}
		
		// if it does not have errors:
		// instantiating ModelAndView object and specifying to return the "secureHome" view
		ModelAndView mav = new ModelAndView("secureHome");
		
		// adding a Search model (using model passed in)
		mav.addObject("search", search);
		
		// returning ModelAndView object with all models needed attached
		return mav;
		
	}
}
