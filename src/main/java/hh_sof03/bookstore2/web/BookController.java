package hh_sof03.bookstore2.web;

import java.util.ArrayList;
import java.util.List;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import hh_sof03.bookstore2.domain.Book;


@Controller
public class BookController {

	
	@RequestMapping(value = "/booklist", method = RequestMethod.GET)
    public String Books(Model model) {
		
		List<Book> Books = new ArrayList<Book>();

		model.addAttribute("Books", Books);
		
		return "booklist";
		
    }
}