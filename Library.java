package com.project.demo.entities;
import jakarta.persistence.*;
import java.util.List;

@Entity
public class Library {

	    @Id
	    private int id;
	    private String name;
	    private String location;

	    @OneToMany(cascade = CascadeType.ALL, fetch = FetchType.EAGER)
	    @JoinColumn(name = "library_id") 
	    private List<Book> books;
	    
	    public Library() {
	        super();
	    }

	   
	    public Library(int id, String name, String location, List<Book> books) {
	        super();
	        this.id = id;
	        this.name = name;
	        this.location = location;
	        this.books = books;
	    }
	    public int getId() {
	        return id;
	    }

	    public void setId(int id) {
	        this.id = id;
	    }

	    public String getName() {
	        return name;
	    }

	    public void setName(String name) {
	        this.name = name;
	    }

	    public String getLocation() {
	        return location;
	    }

	    public void setLocation(String location) {
	        this.location = location;
	    }

	    public List<Book> getBooks() {
	        return books;
	    }

	    public void setBooks(List<Book> books) {
	        this.books = books;
	    }
	}


