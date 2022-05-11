package com.darko.bookreader.controller;

import static org.junit.jupiter.api.Assertions.assertEquals;

import java.util.HashMap;
import java.util.Map;

import org.junit.jupiter.api.Test;

public class WelcomeControllerTests {
	
	@Test
	public void testWelcomeController() {
		WelcomeController welcomeController = new WelcomeController();
		Map<String, Object> map = new HashMap<>();
		String result = welcomeController.welcome(map);
		assertEquals(result, "welcome");
	}

}
