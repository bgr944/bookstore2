package hh_sof03.bookstore2.web;

import java.util.ArrayList;
import java.util.List;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.beans.factory.annotation.Autowired;

import hh_sof03.bookstore2.domain.Book;
import hh_sof03.bookstore2.domain.BookRepository;


@Controller
public class BookController {
	@Autowired
	private BookRepository BookRepository;

	
	@RequestMapping(value = "/booklist", method = RequestMethod.GET)
    public String Books(Model model) {

		model.addAttribute("Books", BookRepository.findAll());
		
		return "booklist";
		
    }
}