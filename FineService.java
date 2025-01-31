package com.project.demo.service;

import java.util.List;

import org.hibernate.Session;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.project.demo.dao.FineDAO;
import com.project.demo.entities.Fine;




@Service
public class FineService {
	@Autowired
	FineDAO fd;
	
	public String addfine(Fine fine) {
		return fd.addfine(fine);
	}
	
	public Fine updateFine (Fine fine) {
		return fd.updateFine(fine);
	 }
	
	public String deleteFine (int id) {
		return fd.deleteFine(id);
	 }
	
   public List<Fine> getAllFine() {
		return fd.getAllFine();
	}
   
   public Fine getSingleFine(int id) {
	   return fd.getSingleFine(id);
   }
}
