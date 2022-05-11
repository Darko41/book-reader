package com.darko.bookreader.controller;

import static org.mockito.Mockito.when;

import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;

import com.darko.bookreader.entity.Book;
import com.darko.bookreader.repository.BookDAO;


public class MainControllerTests {
	
	@InjectMocks
	private MainController mainController;
	
	@Mock
	private BookDAO bookDAO;
	
	@Test
	public void testGetBookById() {
		Book b = new Book();
		b.setId(1);
		when(bookDAO.getBookById(1)).thenReturn(b);
		
		Book book = mainController.get
	}

}
