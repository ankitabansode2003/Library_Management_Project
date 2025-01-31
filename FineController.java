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
import com.project.demo.entities.Fine;
import com.project.demo.service.FineService;

@RestController
@RequestMapping("/fine")
public class FineController {
	@Autowired
	FineService fs;
	
	@PostMapping("/addfine")
	public String addfine(@RequestBody Fine fine) {
		return fs.addfine(fine);
	}
	
	@PutMapping("/updatefine")
	public Fine updateFine(@RequestBody Fine fine) {
		return fs.updateFine(fine);
	}
	
	@DeleteMapping("/deletefine/{id}")
	public String deleteFine(@PathVariable int id ) {
		return fs.deleteFine(id);
	}
	@GetMapping("/getallfine")
   public List<Fine> getAllFine() {	
		return fs.getAllFine();
	}
	
	@GetMapping("/singlefine/{id}")
	public Fine getSingleFine(@PathVariable int id) {
		return fs.getSingleFine(id);
	}
	

}
