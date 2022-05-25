package com.darko.bookreader.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import com.darko.bookreader.entity.Book;

@Repository
public interface BookRepository extends JpaRepository<Book, Integer>{
	
	@Query("" +
			"SELECT CASE WHEN COUNT(s) > 0 THEN " +
			"TRUE ELSE FALSE END " +
			"FROM Book b " +
			"WHERE b.title = ?1"
			)
	Boolean selectIfTitleExists(String title);

}
