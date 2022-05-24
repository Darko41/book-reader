package com.darko.bookreader.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.darko.bookreader.entity.Book;
import com.darko.bookreader.repository.BookDAO;

@Controller
//@RequestMapping(path = "/books")
public class BookController {

	@Autowired
	private BookDAO bookDAO;
	
	//B O O K S:
	
	@RequestMapping("/book-list")
	public String getBookListPage(Model model) {
		model.addAttribute("books", bookDAO.getBooks());
		
		return "book-list";
	}
	
	@RequestMapping("/book-delete")
	public String deleteBook(@RequestParam int id) {
		bookDAO.deleteBook(id);
		
		return "redirect:/book-list";
	}
	
	@RequestMapping("/book-form")
	public String getBookForm(Model model) {
		model.addAttribute("book", new Book());
		model.addAttribute("books", bookDAO.getBooks());
		
		return "book-form";
	}
	
	@RequestMapping("/book-form-update")
	public String getBookUpdateForm(@RequestParam int id, Model model) {
		model.addAttribute("book", bookDAO.getBookById(id));
		model.addAttribute("books", bookDAO.getBooks());
		
		return "book-form";
	}
	
	@RequestMapping("/book-save")
	public String saveBook(@ModelAttribute Book book) {
		bookDAO.saveBook(book);
		
		return "redirect:/book-list";
	}
	
	@RequestMapping("/book-preview")
	public String getBookPage(@RequestParam int id, Model model) {
		model.addAttribute("book", bookDAO.getBookById(id));
		
		return "book-preview";
	}

}
