package com.darko.bookreader.repository;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.transaction.Transactional;

import org.hibernate.Session;
import org.hibernate.query.Query;
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

	@Transactional
	@Override
	public void saveBook(Book book) {
		Session session = entityManager.unwrap(Session.class);
		session.saveOrUpdate(book);
	}

	@Transactional
	@Override
	public void deleteBook(int id) {
		Session session = entityManager.unwrap(Session.class);
		Book book = session.get(Book.class, id);
		
		session.delete(book);		
	}

	@Transactional
	@Override
	public Book getBookById(int id) {
		Session session = entityManager.unwrap(Session.class);
		Book book = session.get(Book.class, id);
		return book;
	}

	@Transactional
	@Override
	public Book getBookByName(String name) {
		Session session = entityManager.unwrap(Session.class);
		Book book = session.get(Book.class, name);
		
		return book;
	}
	
	

}
