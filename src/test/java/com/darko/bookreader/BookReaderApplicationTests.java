package com.darko.bookreader;

import static org.assertj.core.api.Assertions.assertThat;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.ActiveProfiles;

import com.darko.bookreader.controller.BookController;
import com.darko.bookreader.controller.UserController;
import com.darko.bookreader.service.BookDAO;
import com.darko.bookreader.service.UserDAO;

@SpringBootTest(webEnvironment = SpringBootTest.WebEnvironment.RANDOM_PORT)
@ActiveProfiles("test")
class BookReaderApplicationTests {
	
	@Autowired
	private UserController userController;
	@Autowired
	private UserDAO userDAO;
	@Autowired
	private BookController bookController;
	@Autowired
	private BookDAO bookDAO;
	
	@Test
	void contextLoads() throws Exception {
		assertThat(userController).isNotNull();
		assertThat(bookController).isNotNull();
		assertThat(userDAO).isNotNull();
		assertThat(bookDAO).isNotNull();
	}

}
