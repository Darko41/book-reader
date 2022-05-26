package com.darko.bookreader.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import com.darko.bookreader.entity.Book;
import com.darko.bookreader.service.BookDAO;

@Controller
//@RequestMapping(path = "/")
public class BookController {

	@Autowired
	private BookDAO bookDAO;
	
	@RequestMapping("/book-listed")
	public String getBookListPage(Model model) {
		model.addAttribute("books", bookDAO.getBooks());
		
		return "book-list";
	}
	
	@RequestMapping("/book-delete")
	public String deleteBook(@RequestParam int id) {
		bookDAO.deleteBook(id);
		
		return "redirect:/book-listed";
	}
	
	@RequestMapping("/book-new")
	public String getBookForm(Model model) {
		model.addAttribute("book", new Book());
		model.addAttribute("books", bookDAO.getBooks());
		
		return "book-form";
	}
	
	@RequestMapping("/edit-book")
	public String getBookUpdateForm(@RequestParam int id, Model model) {
		model.addAttribute("book", bookDAO.getBookById(id));
		model.addAttribute("books", bookDAO.getBooks());
		
		return "book-form";
	}
	
	@RequestMapping("/book-save")
	public String saveBook(@ModelAttribute Book book) {
		bookDAO.saveBook(book);
		
		return "redirect:/book-listed";
	}
	
	@RequestMapping("/single-book-preview")
	public String getBookPage(@RequestParam int id, Model model) {
		model.addAttribute("book", bookDAO.getBookById(id));
		
		return "book-preview";
	}

}
