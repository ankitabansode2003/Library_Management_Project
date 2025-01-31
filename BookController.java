package com.project.demo.controller;


import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.project.demo.entities.Book;
import com.project.demo.service.BookService;

@RestController
@RequestMapping("/library")
public class BookController {
	@Autowired
	BookService bookservice;
	
	@PostMapping("/addbook")
	public String addBook(@RequestBody Book b) {
		return bookservice.addbook(b);
		
	}
	
	@DeleteMapping("/deletebook/{id}")
	public String deleteBook(@PathVariable int id) {
		return bookservice.deletebook(id);
		 
	}
	
	@GetMapping("/getsingledata/{id}")
	public Book getsingledata(@PathVariable int id) {
		return bookservice.getsingledata(id);
	}
	
	@PutMapping("/updatedata/{id}")
	public String updatedata(@RequestBody Book book,@PathVariable int id) {
		return bookservice.updatedata(book,id);
	}
	
	@GetMapping("/getalldata")
	public List<Book>getalldata() {
		return bookservice.getalldata();
	}
}
