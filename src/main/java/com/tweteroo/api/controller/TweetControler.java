package com.tweteroo.api.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.autoconfigure.data.web.SpringDataWebProperties.Pageable;
import org.springframework.data.domain.Page;
import org.springframework.data.web.PageableDefault;
import org.springframework.http.HttpStatus;
import org.springframework.http.HttpStatusCode;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.tweteroo.api.dto.TweetsDTO;
import com.tweteroo.api.model.Tweets;
import com.tweteroo.api.service.TweetService;

import jakarta.validation.Valid;
import lombok.Builder;

@RestController
@CrossOrigin(origins = "*")
@RequestMapping("/tweets")
public class TweetControler {
    
    @Autowired
    private TweetService service;

    @PostMapping
    public ResponseEntity<?> createTweet(@RequestBody @Valid TweetsDTO req){
        var response = service.create(req);
        return ResponseEntity.status(HttpStatusCode.valueOf(200) ).body("OK");
    }

    @GetMapping
    public Page<Tweets> listAll(@PageableDefault(page = 0, size = 5) Pageable page){
        return service.findAll(page);
    }

    @GetMapping("/{username}")
    public List<Tweets> listByUsername(@PathVariable String username){
        return service.getTweetByUsername(username);
    }
}
