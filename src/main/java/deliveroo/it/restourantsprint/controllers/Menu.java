package deliveroo.it.restourantsprint.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;
import deliveroo.it.restourantsprint.models.Dish;

import deliveroo.it.restourantsprint.repositories.MenuRepository;

@RestController
@RequestMapping(path = "/deliveroo") // This means URL's start with /demo (after Application path)
public class Menu {

    @Autowired // This means to get the bean called userRepository
    // Which is auto-generated by Spring, we will use it to handle the data
    private MenuRepository menuRepository;

    @RequestMapping("/")
    String home() {
        return "Hello, World!";
    }

    @GetMapping("/menu")
    public Iterable<Dish> getAll() {
        // This returns a JSON or XML with the users
        return menuRepository.findAll();
    }

    @PostMapping(path = "/add") // Map ONLY POST Requests
    public @ResponseBody String addNewUser(@RequestParam String name, @RequestParam float price) {
        // @ResponseBody means the returned String is the response, not a view name
        // @RequestParam means it is a parameter from the GET or POST request

        Dish n = new Dish();
        n.setName(name);
        n.setPrice((float) price);
        menuRepository.save(n);
        return "Saved";
    }

}