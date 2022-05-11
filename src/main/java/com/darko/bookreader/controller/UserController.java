package com.darko.bookreader.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import com.darko.bookreader.entity.User;
import com.darko.bookreader.repository.UserDAO;

@Controller
public class UserController {
	
	@Autowired
	private UserDAO userDAO;
	
	@RequestMapping(value = "user/{id}", method = RequestMethod.GET)
	public User get(@PathVariable int id) {
		return userDAO.getUserById(id);
	}

	@PostMapping(path = "/add")
	public @ResponseBody String addNewUser(@RequestParam String name, @RequestParam String email) {
		User user = new User();
		user.setName(name);
		user.setEmail(email);
		/*
		 * To simplify, we will not create password encryption here,
		 * because user credentials are manually predefined
		 * in SecurityConfig class
		 */
		userDAO.saveUser(user);
		return "Saved";
	}
	
	@GetMapping(path = "/all")
	public @ResponseBody List<User> getAllUsers() {
		return userDAO.getAllUsers();
	}
}
