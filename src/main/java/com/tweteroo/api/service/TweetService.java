package com.tweteroo.api.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.autoconfigure.data.web.SpringDataWebProperties.Pageable;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageImpl;
import org.springframework.data.domain.PageRequest;
import org.springframework.stereotype.Service;

import com.tweteroo.api.dto.TweetsDTO;
import com.tweteroo.api.model.Tweets;
import com.tweteroo.api.repository.TweetRepository;


@Service
public class TweetService {
    
    @Autowired
    private TweetRepository repository;
    

    public Tweets create(TweetsDTO dto){
        return repository.save(new Tweets(dto));
    }

    public Page<Tweets> findAll(Pageable pageable){
        int page = Integer.parseInt(pageable.getPageParameter());
        int size = 5;
        
        PageRequest pageRequest = PageRequest.of(page,size);         

         return new PageImpl<>(
            repository.findAll(),
            pageRequest, size
        );
     }

    public List<Tweets> getTweetByUsername(String username){
        return repository.findByUsername(username) ;
    }
}
