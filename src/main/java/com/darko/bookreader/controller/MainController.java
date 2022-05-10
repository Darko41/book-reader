package com.darko.bookreader.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import com.darko.bookreader.entity.User;
import com.darko.bookreader.repository.BookDAO;
import com.darko.bookreader.repository.UserRepository;

@Controller
//@RequestMapping(path = "/books")
public class MainController {
	
	@Autowired
	private UserRepository userRepository;
	@Autowired
	private BookDAO bookDAO;
	
	//U S E R S:
	
	@PostMapping(path = "/add")
	public @ResponseBody String addNewUser(@RequestParam String name, @RequestParam String email) {
		
		User user = new User();
		user.setName(name);
		user.setEmail(email);
		userRepository.save(user);
		return "Saved";
		
	}
	
	@GetMapping(path = "/all")
	public @ResponseBody Iterable<User> getAllUsers() {
		return userRepository.findAll();
	}
	
	
	//B O O K S:
	
	@RequestMapping("/book-list")
	public String getBookListPage(Model model) {
		model.addAttribute("books", bookDAO.getBooks());
		
		return "book-list";
	}

}
