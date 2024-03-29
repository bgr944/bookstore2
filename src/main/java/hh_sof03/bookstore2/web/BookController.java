package hh_sof03.bookstore2.web;

import java.util.ArrayList;
import java.util.List;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.access.prepost.PreAuthorize;

import hh_sof03.bookstore2.domain.Book;
import hh_sof03.bookstore2.domain.Category;
import hh_sof03.bookstore2.domain.BookRepository;
import hh_sof03.bookstore2.domain.CategoryRepository;
import org.springframework.web.bind.annotation.RequestParam;



@Controller
public class BookController {
	@Autowired
	private BookRepository BookRepository;

	@Autowired
	private CategoryRepository cRepository;

	
	@RequestMapping(value = "/booklist", method = RequestMethod.GET)
	public String Books(Model model) {

		model.addAttribute("Books", BookRepository.findAll());

		return "booklist";

	}

	@RequestMapping(value = "/add", method=RequestMethod.GET)
	public String addBook(Model model) {
		model.addAttribute("book", new Book());
		model.addAttribute("categories", cRepository.findAll());
		return "addBook";
	}
	
	@RequestMapping(value = "/save", method=RequestMethod.POST)
	public String saveBook(Book book) {
		BookRepository.save(book);
		return "redirect:booklist";
	}

	@RequestMapping(value = "/cancel", method=RequestMethod.POST)
	public String cancelSave(Book book) {
		return "redirect:booklist";
	}

	@RequestMapping(value = "/delete/{id}", method = RequestMethod.GET)
	@PreAuthorize("hasAuthority('ADMIN')")
	public String deleteBook(@PathVariable("id") Long bookId, Model model) {
		BookRepository.deleteById(bookId);
		return "redirect:../booklist";
	}
	
	@RequestMapping(value = "/edit/{id}", method=RequestMethod.GET)
	public String editBook(@PathVariable("id") Long bookId, Model model) {
		Book book = BookRepository.findById(bookId).get();
		model.addAttribute("book", book);
		model.addAttribute("categories", cRepository.findAll());

		return "editBook";
	}

	@RequestMapping(value = "/login")
	public String login() {
		return "login";
	}
	
}