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
import com.tweteroo.api.repository.PageRepository;
import com.tweteroo.api.repository.TweetRepository;

import jakarta.validation.constraints.Size;

@Service
public class TweetService {
    
    @Autowired
    private TweetRepository repository;
    @Autowired
    private PageRepository pageRepository;
   

    public Tweets create(TweetsDTO dto){
        return repository.save(new Tweets(dto));
    }

    // public List<Tweets> findAll(Pageable pageable){
    //     int pag = Integer.parseInt(pageable.getPageParameter());
    //     int size = Integer.parseInt(pageable.getSizeParameter());
    //     PageRequest page = PageRequest.of(pag, size);
    //     List<Tweets> tweet = repository.findByPage(pageable);
    //     return tweet;
    // }
    public Page<Tweets> findAll(Pageable pageable){
       
        return pageRepository.findByPage(pageable);
        //  return new PageImpl<>(
        //     pageRepository.findByPage(pageable),
        //     pageRequest, size
        // );
     }

    public List<Tweets> getTweetByUsername(String username){
        return repository.findByUsername(username) ;
    }
}
