package com.socialnorm.controller;

import java.util.ArrayList;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;
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
 * SearchController Class for searching content on SocialNorm. Invoke using "/search"
 * @author Trevor
 * 
 */
@Controller
@RequestMapping("/search")
public class SearchController 
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
	 * Method used for searching for topics and returning the search results view.
	 * Only available for logged in users.
	 * Invoke using "/search/go" URI.
	 * 
	 * @param search type string
	 * @return ModelAndView searchResults.jsp
	 */
	@RequestMapping(path="/go", method=RequestMethod.POST)
	public ModelAndView find(@RequestParam("search") String search)
	{
		// instantiating ModelAndView object and specifying to return the "searchResults" view
		ModelAndView mav = new ModelAndView("searchResults");
		
		// getting all the posts that match the search
		ArrayList<TopicModel> tml = new ArrayList<TopicModel>(topicService.getSearchTopics(search));
		
		// if the search results are empty then add an appropriate error message, else add a "Here's Your Search Results" message
		if(tml.isEmpty())
			mav.addObject("message", "Sorry, but your search rendered no results.");
		else
			mav.addObject("message", "Search Results");

		// adding SearchModel, TopicModel ArrayList of recent posts, and TopicModel ArrayList of the search results
		mav.addObject("search", new SearchModel());
		mav.addObject("recent", new ArrayList<TopicModel>(topicService.getMostRecentPosts()));
		mav.addObject("results", tml);
		
		// returning ModelAndView object with all models needed attached
		return mav;
	}
}
