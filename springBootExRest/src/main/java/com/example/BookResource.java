package com.example;

//import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class BookResource {
    
	@Autowired
	BookRepository repo;
	
	@DeleteMapping("/book/{id}")
	public String deleteBook(@PathVariable int id)
	{
		  Book b = repo.getOne(id);
		  repo.delete(b);
		  return "Deleted";
		
	}
	
	@PostMapping("books")    
	public Book addBooks(@RequestBody Book book)
	{
	    repo.save(book);
		return book;
		
	}
	
	@PutMapping("books")    
	public Book saveOrUpdateBook(@RequestBody Book book)
	{
	    repo.save(book);
		return book;
		
	}
	
	@GetMapping("books")    
	public List<Book> getBooks()
	{
	
		List<Book> books = (List<Book>) repo.findAll();
		return books;
		
	}
	
	@RequestMapping("/book/{id}")
	public Optional<Book> getBook(@PathVariable("id") int id)
	{
	
		return repo.findById(id);
				
	}
	
}
