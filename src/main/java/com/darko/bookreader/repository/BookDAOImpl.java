package com.darko.bookreader.repository;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.transaction.Transactional;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.query.Query;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.darko.bookreader.entity.Book;

@Repository
public class BookDAOImpl implements BookDAO{
	
//	@Autowired
//	private SessionFactory sessionFactory;
	
	@PersistenceContext
	private EntityManager entityManager;

	@Transactional
	@Override
	public List<Book> getBooks() {
//		Session session = sessionFactory.getCurrentSession();
//		Query<Book> query = session.createQuery("from Book", Book.class);
//		
//		List<Book> books = query.getResultList();
//		return books;
		
		Session session = entityManager.unwrap(Session.class);
		Query<Book> query = session.createQuery("from Book", Book.class);
		List<Book> books = query.getResultList();
		return books;
	}

	@Override
	public void saveBook(Book book) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void deleteBook(Book book) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public Book getBookById(int id) {
		// TODO Auto-generated method stub
		return null;
	}

}
