package com.project.demo.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;

import com.project.demo.dao.LibraryDAO;
import com.project.demo.entities.Library;

@Service
public class LibraryService {
	@Autowired
	LibraryDAO LibraryDAO;
	
	 public String addLibrary(Library library) {
	        return LibraryDAO.addLibrary(library); 
	    }
	 
	 public String deleteLibrary(int id) {
	        return LibraryDAO.deleteLibrary(id); 
	    }

	 public String updateLibrary(Library library, int id) {
	        return LibraryDAO.updateLibrary(library,id); 
	    }

	 public Library getsingledata(int id) {
	        return LibraryDAO.getsingledata(id); 
	    }
	 

	 public List<Library> getalldatadata() {
	        return LibraryDAO.getalldata(); 
	    }


}
