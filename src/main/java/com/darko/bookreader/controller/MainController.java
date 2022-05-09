package com.darko.bookreader.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import com.darko.bookreader.entity.User;
import com.darko.bookreader.repository.UserRepository;

@Controller
@RequestMapping(path = "/books")
public class MainController {
	
	@Autowired
	private UserRepository userRepository;
	
	public @ResponseBody String addNewUser(@RequestParam String name, @RequestParam String email) {
		
		User user = new User();
		user.setName(name);
		user.setEmail(email);
		userRepository.save(user);
		return "Saved";
		
	}

}
