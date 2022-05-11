package com.darko.bookreader.repository;

import java.util.List;

import com.darko.bookreader.entity.User;

public interface UserDAO {
	
	public User getUserById(int id);
	
	public void saveUser(User user);
	
	public List<User> getAllUsers();
	
}
