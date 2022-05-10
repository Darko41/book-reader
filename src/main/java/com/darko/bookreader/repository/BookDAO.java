package com.darko.bookreader.repository;

import java.util.List;

import com.darko.bookreader.entity.Book;

public interface BookDAO {
	
	public List<Book> getBooks();
	
	public void saveBook(Book book);
	
	public void deleteBook(Book book);
	
	public Book getBookById(int id);

}
