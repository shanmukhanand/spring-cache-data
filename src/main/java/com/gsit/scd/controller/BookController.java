package com.gsit.scd.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.gsit.scd.domain.Book;
import com.gsit.scd.repository.BookRepository;
import com.gsit.scd.repository.BookRepositoryCustom;

@RestController
@RequestMapping("/books")
@EnableAutoConfiguration
public class BookController {
	
	@Autowired
	private BookRepository bookRepository;
	
	/*@Autowired
	private BookRepositoryCustom bookRepositoryCustom;*/
	
	
	@RequestMapping("/")
    public List<Book> get() {
        return bookRepository.findAll();
    }
	
	
	@RequestMapping("/isbn/{isbn}")
    public List<Book> get(@PathVariable(value="isbn") String isbn) {
        return bookRepository.findByIsbn(isbn);
    }
	
	
	@RequestMapping("/isbn/{isbn}/title/{title}")
    public Book save(@PathVariable(value="isbn") String isbn, @PathVariable(value="title") String title) {
		return bookRepository.save(new Book(isbn, title));
    }
	
	
	@RequestMapping("/update/isbn/{isbn}/title/{title}")
    public Book update(@PathVariable(value="isbn") String isbn, @PathVariable(value="title") String title) {
		List <Book> books=  bookRepository.findByIsbn(isbn);
		Book b = null;
		if(books.size() > 0 ){
			b = books.get(0);
			b.setTitle(title);
			 bookRepository.save(b);
		}
		return b;
    }
	
	
	@RequestMapping("/update/cache/isbn/{isbn}/title/{title}")
    public Book updatecache(@PathVariable(value="isbn") String isbn, @PathVariable(value="title") String title) {
		List <Book> books=  bookRepository.findByIsbn(isbn);
		Book b = null;
		if(books.size() > 0 ){
			b = books.get(0);
			b.setTitle(title);
			 bookRepository.updateForCache(b);
		}
		return b;
    }
	
	@RequestMapping("/cache/isbn/{isbn}/title/{title}")
    public Book saveByCache(@PathVariable(value="isbn") String isbn, @PathVariable(value="title") String title) {
		return bookRepository.saveForCache(new Book(isbn, title));
    }
	
	


}
