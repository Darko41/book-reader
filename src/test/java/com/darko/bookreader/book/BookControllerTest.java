package com.darko.bookreader.book;

import static org.mockito.Mockito.when;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.model;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.view;
import static org.hamcrest.Matchers.*;

import java.util.ArrayList;
import java.util.List;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;
import org.springframework.test.context.junit.jupiter.SpringExtension;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.setup.MockMvcBuilders;

import com.darko.bookreader.controller.BookController;
import com.darko.bookreader.entity.Book;
import com.darko.bookreader.service.BookDAO;

@ExtendWith(SpringExtension.class)
public class BookControllerTest {
	
	@Mock
	private BookDAO bookDAO;
	
	@InjectMocks
	private BookController bookController;

	private MockMvc mockMvc;
	
	@SuppressWarnings("deprecation")
	@BeforeEach
	public void setUp() {
		MockitoAnnotations.initMocks(this);
		
		mockMvc = MockMvcBuilders.standaloneSetup(bookController).build();
	}
	
	@SuppressWarnings("unchecked")
	@Test
	public void testListOfBooks() throws Exception {
		List<Book> books = new ArrayList<>();
		books.add(new Book());
		books.add(new Book());
		
		when(bookDAO.getBooks()).thenReturn((List) books);
		
		mockMvc.perform(get("/book-listed"))
		.andExpect(status().isOk())
		.andExpect(view().name("book-list"))
		.andExpect(model().attribute("books", hasSize(2)));
	}
	
	@Test
	public void testPreviewBook() throws Exception{
		Integer id = 1;
		
		when(bookDAO.getBookById(id)).thenReturn(new Book());
		
		mockMvc.perform(get("/single-book-preview?id=1"))
		.andExpect(status().isOk())
		.andExpect(view().name("book-preview"))
		.andExpect(model().attribute("book", instanceOf(Book.class)));
		
	}

}
