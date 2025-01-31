package com.project.demo.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.project.demo.dao.BookDAO;
import com.project.demo.entities.Book;

@Service
public class BookService {
	@Autowired
	BookDAO bookdao;
	
	public String addbook(Book b) {
		return bookdao.addBook(b);
	}
	
	public String deletebook(int id) {
	   return bookdao.deletebook(id);
	}
	
	public Book getsingledata(int id) {
		   return bookdao.getsingledata(id);
	}
	
	public String updatedata(Book book,int id) {
		   return bookdao.updatedata(book,id);
	}
	public List<Book>getalldata() {
		   return bookdao.getalldata();
		}
	
}
