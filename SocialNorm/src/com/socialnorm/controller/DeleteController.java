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
 * DeleteController Class for deleting products. Invoke with "/delete"
 * @author Trevor
 * 
 */
@Controller
@RequestMapping("/delete")
public class DeleteController 
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
	 * Simple method that returns a ModelAndView object with a Search and Topic model added.
	 * Only available for logged in users.
	 * Invoke using "/delete/topic" URI.
	 * @param id type String
	 * @param response type HttpServletResponse
	 * @return ModelAndView deleteTopic.jsp
	 * @throws IOException type ioexception
	 */
	@RequestMapping(path="/topic", method=RequestMethod.GET)
	public ModelAndView getDeleteTopicView(@RequestParam(value = "id", required = false) String id, HttpServletResponse response) throws IOException 
	{
		// instantiating ModelAndView object and specifying to return the "deleteTopic" view
		ModelAndView mav = new ModelAndView("deleteTopic");
		
		// adding a Search and Topic model objects to the ModelAndView
		mav.addObject("search", new SearchModel());
		mav.addObject("topic", topicService.getTopic(id));
		
		// returning ModelAndView object with all models needed attached
		return mav;
	}
	/**
	 * Simple method that deletes the topic and returns a ModelAndView object with a Search and the Topic model added.
	 * Only available for logged in users.
	 * Invoke using "/delete/deletetopic" URI.
	 * @param topic type TopicModel
	 * @param session type HttpSession
	 * @return ModelAndView searchviewAllTopics.jsp
	 */
	@RequestMapping(path="/deletetopic", method=RequestMethod.POST)
	public ModelAndView deleteTopic(TopicModel topic, HttpSession session)
	{
		// instantiating ModelAndView object and specifying to return the "viewAllTopics" view
		ModelAndView mav = new ModelAndView("viewAllTopics");
		
		// deleting post from the db using the injected service
		topicService.deleteTopic(topic);
		
		// adding a Search, recent topics, and all topics list of TopicModels to the ModelAndView
		mav.addObject("search", new SearchModel());
		mav.addObject("recent", new ArrayList<TopicModel>(topicService.getMostRecentPosts()));
		mav.addObject("topics", new ArrayList<TopicModel>(topicService.getAllPosts()));
		
		// returning ModelAndView object with all models needed attached
		return mav;
	}
}
