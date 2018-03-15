package com.gsit.scd.repository;

import org.springframework.cache.annotation.CacheEvict;

import com.gsit.scd.domain.Book;

public interface BookRepositoryCustom {
	
	@CacheEvict("findByIsbn")
	Book saveForCache(Book entity);
	
	@CacheEvict("findByIsbn")
	Book updateForCache(Book entity);
	
	

}
