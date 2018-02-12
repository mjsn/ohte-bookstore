package fi.haagahelia.ohjtek.bookstore.web;


import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import fi.haagahelia.ohjtek.bookstore.domain.Book;
import fi.haagahelia.ohjtek.bookstore.domain.BookRepository;



@Controller
public class BookstoreController {
	@Autowired
	private BookRepository repository;

    @RequestMapping(value="/books", method = RequestMethod.GET)
    public @ResponseBody List<Book> bookListRest() {	
        return (List<Book>) repository.findAll();
    }    

    @RequestMapping(value="/book/{id}", method = RequestMethod.GET)
    public @ResponseBody Book findBookRest(@PathVariable("id") Long bookId) {	
    	return repository.findOne(bookId);
    }       
	
    @RequestMapping(value= {"", "/index", "/index.html"}, method=RequestMethod.GET)
    public String frontpage(Model model) {
        return "index";
    }

    @RequestMapping(value="/booklist")
    public String bookList(Model model) {	
        model.addAttribute("books", repository.findAll());
        return "booklist";
    }

    @RequestMapping(value = "/add")
    public String addBook(Model model){
    	model.addAttribute("book", new Book());
        return "addbook";
    }

    @RequestMapping(value="/login")
    public String login() {	
        return "login";
    }	
    
    @RequestMapping(value = "/save", method = RequestMethod.POST)
    public String save(Book book){
        repository.save(book);
        return "redirect:booklist";
    }    

    @RequestMapping(value = "/delete/{id}", method = RequestMethod.GET)
    public String deleteBook(@PathVariable("id") Long bookId, Model model) {
    	repository.delete(bookId);
        return "redirect:../booklist";
    }     
}