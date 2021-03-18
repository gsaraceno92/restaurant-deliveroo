package deliveroo.it.restourantsprint.controllers;

import java.util.ArrayList;
import java.util.List;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
// import deliveroo.it.restourantsprint.models.Dish;

@RestController
public class Menu {

    @RequestMapping("/menu")
    public List<String> getAll() {
        List<String> list = new ArrayList<>();
        list.add("pasta");
        list.add("8.5");
        return list;
        // return Arrays.asList(Dish("pasta", 8.5), Dish("carne", 10.0));
    }

}