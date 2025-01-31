package com.project.demo.dao;

import java.util.List;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.query.Query;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.project.demo.entities.Library;

import jakarta.persistence.criteria.CriteriaBuilder;
import jakarta.persistence.criteria.CriteriaQuery;

@Repository
public class LibraryDAO {

	@Autowired
	SessionFactory sf;

	public String addLibrary(Library library) {
		Session session = null;
		Transaction transaction = null;
		String message = null;
		try {
			session = sf.openSession();
			transaction = session.beginTransaction();
			session.save(library); // Save library object to the database
			transaction.commit();
			message = "Library added successfully";
		} catch (Exception e) {
			if (transaction != null) {
				transaction.rollback();
			}
			e.printStackTrace();

		} finally {
			if (session != null) {
				session.close();
			}
		}
		return message;
	}

	public String deleteLibrary(int id) {
		Session session = null;
		Transaction transaction = null;
		String message = null;
		try {
			session = sf.openSession();
			transaction = session.beginTransaction();
			Library library = session.get(Library.class, id);

			if (library != null) {
				session.delete(library);
				transaction.commit();
				message = "Library deleted successfully";
			} else {
				message = "data not found";
			}
		} catch (Exception e) {
			if (transaction != null) {
				transaction.rollback();
			}
			e.printStackTrace();

		} finally {
			if (session != null) {
				session.close();
			}
		}
		return message;
	}

	public String updateLibrary(Library library, int id) {
		Session session = null;
		Transaction transaction = null;
		String message = null;
		try {
			session = sf.openSession();
			transaction = session.beginTransaction();
			Library existingLibrary = session.get(Library.class, id);
			if (existingLibrary != null) {
				existingLibrary.setName(library.getName());
				existingLibrary.setLocation(library.getLocation());
				existingLibrary.setBooks(library.getBooks());
				session.update(existingLibrary);
				transaction.commit();
				message = "Library updated successfully";
			} else {
				message = "Library not found";
			}
		} catch (Exception e) {
			if (transaction != null) {
				transaction.rollback();
			}
			e.printStackTrace();
		} finally {
			if (session != null) {
				session.close();
			}
		}
		return message;
	}

	public Library getsingledata(int id) {
		Session session = null;
		Transaction transaction = null;
		Library library = null;
		try {
			session = sf.openSession();
			transaction = session.beginTransaction();
			library = session.get(Library.class, id);
		} catch (Exception e) {
			if (transaction != null) {
				transaction.commit();
			}
			e.printStackTrace();
		} finally {
			if (session != null) {
				session.close();
			}
		}
		return library;
	}

	public List<Library> getalldata() {
		Session session = null;
		Transaction transaction = null;
		List<Library> list = null;
		try {
			session = sf.openSession();

			Query<Library> query = session.createQuery("From Library", Library.class);
			list = query.list();
		} catch (Exception e) {
			if (transaction != null) {
				transaction.commit();
			}
			e.printStackTrace();
		} finally {

			if (session != null) {
				session.close();
			}
		}
		return list;
	}

}
