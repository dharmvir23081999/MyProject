package com.library.controller;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.library.entity.Book;
import com.library.service.IProductService;

@Controller
@RequestMapping("/library")
public class BookController {
	
	@Autowired
	IProductService iProductService;
	
	/*
	 * @RequestMapping("/home") public String home(Model model) {
	 * model.addAttribute("appName", "Java Training School Library"); return "home";
	 * }
	 */

	@RequestMapping("/display")
	public String displayBookInfo(Model model) {

		List<Book> allBooks = (List<Book>) iProductService.getAllProducts();
		model.addAttribute("books", allBooks);
		
		if(allBooks.isEmpty())
			model.addAttribute("msg", "Unfortunately, the library is empty now. Let's"
					+ "contribute by adding some books");
		else {
			if(model.getAttribute("msg") == null)
				model.addAttribute("msg", "Welcome to Java Traning School Library");
		}

		return "displayBook";
	}

	@GetMapping("/borrowForm/{id}")
	public String borrowForm(@PathVariable Integer id, Model model) {

		Optional<Book> book = iProductService.getoneproduct(id);
		if (book.isPresent()) {

			model.addAttribute("book", book.get());

		}

		return "borrowBook";
	}

	@PostMapping("/borrow")
	public String borrow(@RequestParam int id, Model model) {
		Optional<Book> book = iProductService.getoneproduct(id);
		if (book.isPresent()) {

			Book book1 = book.get();
			book1.setStatus("Issued");
			iProductService.saveProduct(book1);

		}

		model.addAttribute("msg", "Book Issued successfuly. Please return within a month's time");

		return displayBookInfo(model);
	}
	@GetMapping("/editDetails")
	public String EditDetails(@RequestParam int id, Model model) {
		Optional<Book> book = iProductService.getoneproduct(id);
		if (book.isPresent()) {

			model.addAttribute("edit", book.get());

		}
		return "editBook";

	}


	@GetMapping("/addBookForm")
	public String addBookForm(Model model) {
		
		model.addAttribute("book", new Book());

		return "addBook";
	}

	@PostMapping("/addBook")
	public String addBook(@ModelAttribute("book") Book book, Model model) {
        if(book.getId()==null) {
		book.setStatus("available");
        }
		iProductService.saveProduct(book);
		
		model.addAttribute("msg", "Book added successfully. Thanks");

		return displayBookInfo(model);
	}
	

}