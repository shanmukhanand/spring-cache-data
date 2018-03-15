package com.gsit.scd.repository;

import java.util.List;

import org.springframework.cache.annotation.Cacheable;
import org.springframework.data.repository.CrudRepository;

import com.gsit.scd.domain.Book;

public interface BookRepository extends CrudRepository<Book, Long> ,BookRepositoryCustom {
	
	@Cacheable("findByIsbn")
	List<Book> findByIsbn(String isbn);
	
	@Override
	List<Book> findAll();
}
