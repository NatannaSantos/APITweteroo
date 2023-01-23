package com.tweteroo.api.model;

import com.tweteroo.api.dto.TweetsDTO;

import jakarta.persistence.Column;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;

public class Tweets {
    public Tweets(TweetsDTO data){
        this.username = data.username();
        this.tweet = data.tweet();
    }
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;

    @Column(length = 200, nullable = false)
    private String username;

    @Column(length = 10000, nullable = false)
    private String tweet;
}
