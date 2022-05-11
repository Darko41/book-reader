package com.darko.bookreader;

import static org.assertj.core.api.Assertions.assertThat;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import com.darko.bookreader.controller.UserController;
import com.darko.bookreader.repository.UserDAO;

@SpringBootTest
class BookReaderApplicationTests {

	@Autowired
	private UserController userController;
	
	@Autowired
	private UserDAO userDAO;
	
	@Test
	void contextLoads() throws Exception {
		assertThat(userController).isNotNull();
		assertThat(userDAO).isNotNull();
	}

}
