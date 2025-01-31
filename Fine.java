package com.project.demo.entities;


import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.OneToMany;

@Entity
public class Fine {
	@Id
	private int id;
	private int fine;

	@ManyToOne
	@JoinColumn(name = "bookid")
	private Book book;

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public int getFine() {
		return fine;
	}

	public void setFine(int fine) {
		this.fine = fine;
	}

	public Book getBook() {
		return book;
	}

	public void setBook(Book book) {
		this.book = book;
	}

	public Fine() {
		super();
		// TODO Auto-generated constructor stub
	}

	public Fine(int id, int fine, Book book) {
		super();
		this.id = id;
		this.fine = fine;
		this.book = book;
	}

}
