package com.example.demo;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

@Controller

public class TweetController {

	@Autowired
	TweetService tweetService;
	@Autowired
	TweetRepository repository;
	@RequestMapping("/")
	public String index(ModelMap modelMap) {
		List<Tweet> tweets = tweetService.findAll();
		modelMap.addAttribute("tweets", tweets);
		return "tweet";
	}

	@RequestMapping(value = "/",method = RequestMethod.POST)
	@Transactional(readOnly=false)
	public String create(@ModelAttribute("messageForm") Tweet tweet) {
		tweetService.save(tweet);
		return "redirect:/";
	}

	@RequestMapping(value = "/", params="delete",method = RequestMethod.POST)
	@Transactional(readOnly=false)
	public String delete(@ModelAttribute("delete") Tweet tweet) {
		tweetService.delete(tweet.getId());
		return "redirect:/";
	}

//	@RequestMapping(value="/", method = RequestMethod.POST)
//	public String create(@ModelAttribute MessageForm messageForm, ModelMap modelMap) {
//		Message message = new Message();
//		List<Tweet> tweets = tweetService.findAll();
//		modelMap.addAttribute("tweets", tweets);
//		return "tweet";
//	}

}
