package com.darko.bookreader.repository;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.transaction.Transactional;

import org.hibernate.Session;
import org.hibernate.query.Query;
import org.springframework.stereotype.Repository;

import com.darko.bookreader.entity.User;

@Repository
public class UserDAOImpl implements UserDAO {
	
	@PersistenceContext
	private EntityManager entityManager;

	@Transactional
	@Override
	public User getUserById(int id) {
		Session session = entityManager.unwrap(Session.class);
		User user = session.get(User.class, id);
		return user;
	}

	@Transactional
	@Override
	public void saveUser(User user) {
		Session session = entityManager.unwrap(Session.class);
		session.saveOrUpdate(user);
	}

	@Transactional
	@Override
	public List<User> getAllUsers() {
		Session session = entityManager.unwrap(Session.class);
		Query<User> query = session.createQuery("from User", User.class);
		List<User> users = query.getResultList();
		return users;
	}

}
