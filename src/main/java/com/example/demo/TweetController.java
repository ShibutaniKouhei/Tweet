package com.example.demo;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class TweetController {

	@Autowired
	TweetService tweetService;
	@RequestMapping("/")
	public String index(ModelMap modelMap) {
		List<Tweet> tweets = tweetService.findAll();
		modelMap.addAttribute("tweets", tweets);
		return "tweet";
	}

//	@RequestMapping(value="/", method = RequestMethod.POST)
//	public String create(@ModelAttribute MessageForm messageForm, ModelMap modelMap) {
//		Message message = new Message();
//		List<Tweet> tweets = tweetService.findAll();
//		modelMap.addAttribute("tweets", tweets);
//		return "tweet";
//	}

}
