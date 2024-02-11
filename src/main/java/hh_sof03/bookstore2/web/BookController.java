package hh_sof03.bookstore2.web;

import java.util.ArrayList;
import java.util.List;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.beans.factory.annotation.Autowired;

import hh_sof03.bookstore2.domain.Book;
import hh_sof03.bookstore2.domain.BookRepository;
import org.springframework.web.bind.annotation.RequestParam;



@Controller
public class BookController {
	@Autowired
	private BookRepository BookRepository;

	
	@RequestMapping(value = "/booklist", method = RequestMethod.GET)
	public String Books(Model model) {

		model.addAttribute("Books", BookRepository.findAll());

		return "booklist";

	}

	@RequestMapping(value = "/add", method=RequestMethod.GET)
	public String addBook(Model model) {
		model.addAttribute("book", new Book());
		return "addBook";
	}
	
	@RequestMapping(value = "/save", method=RequestMethod.POST)
	public String saveBook(Book book) {
		BookRepository.save(book);
		return "redirect:booklist";
	}

	@RequestMapping(value = "/delete/{id}", method=RequestMethod.GET)
	public String deleteBook(@PathVariable("id") Long bookId, Model model) {
		BookRepository.deleteById(bookId);
		return "redirect:../booklist";
	}
	

}