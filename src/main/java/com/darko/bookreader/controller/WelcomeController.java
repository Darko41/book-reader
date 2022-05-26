package com.darko.bookreader.controller;

import java.util.Map;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/")
public class WelcomeController {
	
	@Value("${application.message:The books are here!!}")
	private String helloMessage;
	
	@GetMapping("/")
	public String welcome(Map<String, Object> model) {
		model.put("message", helloMessage);
		
		return "welcome";
	}

}
