package com.gsit.scd.repository;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

import org.springframework.cache.annotation.CacheEvict;
import org.springframework.stereotype.Component;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import com.gsit.scd.domain.Book;

@Component
@Transactional()
public class BookRepositoryImpl implements BookRepositoryCustom {
	
	@PersistenceContext private EntityManager em;

	
	public void setEntityManager(EntityManager em) {
		this.em = em;
	}
	
	@CacheEvict("findByIsbn")
	public Book saveForCache(Book entity){
		this.em.persist(entity);
		return entity;
		
	}
	
	@CacheEvict("findByIsbn")
	public Book updateForCache(Book entity){
		this.em.merge(entity);
		return entity;
		
	}


}
