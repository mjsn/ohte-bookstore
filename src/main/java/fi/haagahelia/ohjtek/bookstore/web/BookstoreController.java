package fi.haagahelia.ohjtek.bookstore.web;


import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;



@Controller
public class BookstoreController {

    @RequestMapping(value="/index", method=RequestMethod.GET)
    public String friends(Model model) {
        return "index";
    }


}