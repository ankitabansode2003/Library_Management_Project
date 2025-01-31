package com.project.demo.entities;

import jakarta.persistence.Entity;
import jakarta.persistence.Id;

@Entity
public class Staff {
	@Id
	private int id;
	private String name;
	private String role;
	private String email;
	private long phoneno;
	private int salary;
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
	public String getRole() {
		return role;
	}
	public void setRole(String role) {
		this.role = role;
	}
	public String getEmail() {
		return email;
	}
	public void setEmail(String email) {
		this.email = email;
	}
	public long getPhoneno() {
		return phoneno;
	}
	public void setPhoneno(long phoneno) {
		this.phoneno = phoneno;
	}
	public int getSalary() {
		return salary;
	}
	public void setSalary(int salary) {
		this.salary = salary;
	}
	public Staff() {
		super();
		// TODO Auto-generated constructor stub
	}
	public Staff(int id, String name, String role, String email, long phoneno, int salary) {
		super();
		this.id = id;
		this.name = name;
		this.role = role;
		this.email = email;
		this.phoneno = phoneno;
		this.salary = salary;
	}

}