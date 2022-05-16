package com.darko.bookreader.book;

import static org.assertj.core.api.Assertions.assertThat;
import static org.mockito.Mockito.when;

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
	
	@Test
	void itShouldGetBookByName() {
		
		// given
		Book book = new Book("Hobiti", "Tolkin", "Opis4");
//		when(bookDAO.saveBook(book)).thenReturn(book);
		
//		final Book b saveBook = bookDAO.saveBook(book);
		
		
		bookDAO.saveBook(book);
		
		// when
		Book b = bookDAO.getBookByName("DaVincijev kod");

		// then
		assertThat(book.equals(b));
	}

}
