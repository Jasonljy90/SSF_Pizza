package sg.edu.nus.iss.app.lovecalc.controller;

import java.io.IOException;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

import jakarta.servlet.http.HttpServletResponse;
import jakarta.validation.Valid;
import sg.edu.nus.iss.app.lovecalc.model.PizzaOrder;

@Controller
public class PizzaController {

    // @Autowired
    // private ContactsRedis ctcRedisSvc;

    // @GetMapping
    // public String calcCompatibility(@RequestParam(required=false, name="pizza") String pizza,
    //         @RequestParam(required=false, name="size") String size, @RequestParam(required=false, name="quantity") String quantity,
    //         Model model)
    //         throws IOException {
    //     model.addAttribute("pizza", pizza);
    //     model.addAttribute("size", size);
    //     model.addAttribute("quantity", quantity);
    //     return "orderdelivery";
    // }

    @GetMapping(path = "/pizza/orders") 
    public String orderForm(Model model){
        model.addAttribute("order", new PizzaOrder());
        return "index";
    }

    @PostMapping(path = "/pizza/orders", consumes = "application/x-www-form-urlencoded", produces = "text/html")
    public String processOrder(@Valid PizzaOrder pizzaOrder, BindingResult result, 
                Model model, HttpServletResponse response){
        if(result.hasErrors()){
            return "index";
        }
        // ctcRedisSvc.save(contact);
        // model.addAttribute( "contact", contact);
        model.addAttribute("pizza", pizzaOrder.getPizza());
        model.addAttribute("size", pizzaOrder.getSize());
        model.addAttribute("quantity", pizzaOrder.getQuantity());
        response.setStatus(HttpServletResponse.SC_CREATED);
        return "orderdelivery";
    }
    
    // @PostMapping("orderdelivery")
    // public String getAllListResult(Model model) throws IOException {
    //     // PizzaOrder[] mArr = lvSvc.getAllMatchMaking();
    //     // model.addAttribute("arr", mArr);
    //     return "list";
    // }
}
