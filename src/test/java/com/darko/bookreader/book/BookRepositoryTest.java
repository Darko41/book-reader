package com.darko.bookreader.book;

import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.jupiter.api.Assertions.assertEquals;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureWebMvc;

import com.darko.bookreader.entity.Book;
import com.darko.bookreader.repository.BookDAO;

@ExtendWith(MockitoExtension.class)
@AutoConfigureWebMvc
public class BookRepositoryTest {
	
	@Mock
	private BookDAO bookDAO;
	
	// CRUD Testing:
	
//	@Test
//	void itShouldCreateNewBook() {		// C – Create Functionality
//		
//		// given
//		Book book1 = new Book("Hobiti", "Tolkin", "Opis4");
//		Book book2 = new Book("Lovac na zmajeve	", "Haled Hoseini", "Opis3");
//		
//		bookDAO.saveBook(book1);
//		bookDAO.saveBook(book2);
//		
//		// when
//		Book b1 = bookDAO.getBookByName("DaVincijev kod");
//		
//
//		// then
////		assertThat(book.equals(b));
//		assertThat(null);
//	}
	
	@Test
	void itShouldGetBookByTitle() {		// R – Read Functionality
		
		// given
		Book book = new Book("Hobiti", "Tolkin", "Opis4");
		
		// when
		String actual = book.getTitle();
		String expected = "Hobiti";
		
		// then
		assertEquals(actual, expected);
	}

}
