package com.example.demo;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class TweetService {

	@Autowired
	private TweetRepository tweetRepository;

	public List<Tweet> findAll(){
		return tweetRepository.findAll();
	}

	public Tweet findOne(Integer id) {
		return tweetRepository.getOne(id);
	}

	public Tweet save(Tweet tweet) {
		return tweetRepository.save(tweet);
	}

	public void delete(Integer id) {
		tweetRepository.deleteById(id);
	}

}
