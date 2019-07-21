package com.example.demo;

import java.util.List;

import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class TweetController {

	TweetService tweetService;
	@RequestMapping("/")
	public String index(ModelMap modelMap) {
		List<Tweet> tweet = tweetService.findAll();
		modelMap.addAttribute("tweet", tweet);
		return "tweet";
	}

}
