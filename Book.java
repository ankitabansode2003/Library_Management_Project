package com.project.demo.entities;

import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;

@Entity
public class Book {
	@Id
	private int id;
	private String title;
	private String author;
	private int publishedYear;
	private int availableQuantity;
	private String language;
	
	 @ManyToOne
	    @JoinColumn(name = "library_id")  
	    private Library library;

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getTitle() {
		return title;
	}

	public void setTitle(String title) {
		this.title = title;
	}

	public String getAuthor() {
		return author;
	}

	public void setAuthor(String author) {
		this.author = author;
	}

	public int getPublishedYear() {
		return publishedYear;
	}

	public void setPublishedYear(int publishedYear) {
		this.publishedYear = publishedYear;
	}

	public int getAvailableQuantity() {
		return availableQuantity;
	}

	public void setAvailableQuantity(int availableQuantity) {
		this.availableQuantity = availableQuantity;
	}

	public String getLanguage() {
		return language;
	}

	public void setLanguage(String language) {
		this.language = language;
	}

	public Book() {
		super();
		// TODO Auto-generated constructor stub
	}

	public Book(int id, String title, String author, int publishedYear, int availableQuantity, String language) {
		super();
		this.id = id;
		this.title = title;
		this.author = author;
		this.publishedYear = publishedYear;
		this.availableQuantity = availableQuantity;
		this.language = language;
	}

}
