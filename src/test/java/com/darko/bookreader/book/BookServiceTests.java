package com.darko.bookreader.book;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import com.darko.bookreader.service.BookDAOImpl;

class BookServiceTests {
	
	private BookDAOImpl bookDAOImpl;

	@BeforeEach
	void setUp() throws Exception {
		
		bookDAOImpl = new BookDAOImpl();
		
	}

	@AfterEach
	void tearDown() throws Exception {
	}

	@Test
	void testGetBooks() {
		fail("Not yet implemented");
	}

	@Test
	void testSaveBook() {
		fail("Not yet implemented");
	}

	@Test
	void testDeleteBook() {
		fail("Not yet implemented");
	}

	@Test
	void testGetBookById() {
		fail("Not yet implemented");
	}

	@Test
	void testGetBookByTitle() {
		fail("Not yet implemented");
	}

}
