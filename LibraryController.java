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

import com.project.demo.entities.Library;
import com.project.demo.service.LibraryService;

@RestController
@RequestMapping("/library")
public class LibraryController {
	
	@Autowired
	LibraryService libraryService;
	
	@PostMapping("/addlibrarydata")
	public String addLibrary(@RequestBody Library library) {
		return libraryService.addLibrary(library);
	}
	
	@DeleteMapping("/deletelibrarydata/{id}")
	public String deleteLibrary(@PathVariable int id) {
		return libraryService.deleteLibrary(id);
	}
	
	@PutMapping("updatelibrarydata/{id}")
	public String updateLibrary(@RequestBody Library library,@PathVariable int id) {
		return libraryService.updateLibrary(library,id);
	}
	
	@GetMapping("getsinglelibrarydata/{id}")
	public Library getsingleLibrary(@PathVariable int id) {
		return libraryService.getsingledata(id);
	}
	
	@GetMapping("/getalllibrary")
	public List<Library> getallLibrary() {
		return libraryService.getalldatadata();
	}

}
