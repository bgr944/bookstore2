package hh_sof03.bookstore2.web;

import java.util.ArrayList;
import java.util.List;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.beans.factory.annotation.Autowired;

import hh_sof03.bookstore2.domain.Category;
import hh_sof03.bookstore2.domain.CategoryRepository;
import org.springframework.web.bind.annotation.RequestParam;



@Controller
public class CategoryController {

    @Autowired
    private CategoryRepository cRepository;

    @RequestMapping(value = "/categorylist", method = RequestMethod.GET)
    public String Categories(Model model) {

        model.addAttribute("Categories", cRepository.findAll());

        return "categorylist";

    }

    @RequestMapping(value = "/createCategory", method=RequestMethod.GET)
    public String addCategory(Model model) {
        model.addAttribute("category", new Category());
        return "addCategory";
    }
    
    @RequestMapping(value = "/saveCategory", method=RequestMethod.POST)
	public String saveCategory(Category category) {
		cRepository.save(category);
		return "redirect:categorylist";
	}

	@RequestMapping(value = "/cancelCategory", method=RequestMethod.POST)
	public String cancelSave(Category category) {
		return "redirect:categorylist";
	}
}