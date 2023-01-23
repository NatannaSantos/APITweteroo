package com.tweteroo.api.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.tweteroo.api.dto.TweetsDTO;
import com.tweteroo.api.model.Tweets;
import com.tweteroo.api.service.TweetService;

@RestController
@RequestMapping("/tweets")
public class TweetControler {
    
    @Autowired
    private TweetService service;

    @PostMapping
    public void createTweet(@RequestBody TweetsDTO req){
        service.create(req);
    }

    @GetMapping
    public List<Tweets> listAll(){
        return service.findAll();
    }
}
