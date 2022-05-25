package com.darko.bookreader.book;

import static org.assertj.core.api.Assertions.assertThat;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;

import com.darko.bookreader.entity.Book;
import com.darko.bookreader.repository.BookRepository;


@DataJpaTest
class BookRepositoryTests {
	
	@Autowired
	private BookRepository bookRepository;

	@Test
	void itShouldCheckIfBookTitleExists() {
		// given
		String title = "Na Drini Cuprija";
		Book book = new Book(title, "Ivo Andric", "Desavanja na mostu");
		
		bookRepository.save(book);
		
		// when
		boolean expectedToExist = bookRepository.selectIfTitleExists(title);
		
		// then
		assertThat(expectedToExist).isTrue();
	}

}
