package com.tweteroo.api.repository;

import org.springframework.boot.autoconfigure.data.web.SpringDataWebProperties.Pageable;
import org.springframework.data.domain.Page;
import org.springframework.data.repository.PagingAndSortingRepository;

import com.tweteroo.api.model.Tweets;

public interface PageRepository extends PagingAndSortingRepository<Tweets,Long> {
    Page<Tweets> findByPage(Pageable pageable);
}
