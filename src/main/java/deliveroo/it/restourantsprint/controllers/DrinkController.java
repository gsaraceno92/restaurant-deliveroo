package deliveroo.it.restourantsprint.controllers;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import deliveroo.it.restourantsprint.models.Drink;
import deliveroo.it.restourantsprint.repositories.DrinkRepository;

@RestController
@RequestMapping(path = "/deliveroo") // This means URL's start with /demo (after Application path)
public class DrinkController {

    @Autowired // This means to get the bean called <resource>Repository
    private DrinkRepository drinkRepository;

    @GetMapping("/drinks")
    Iterable<Drink> getAll() {
        return drinkRepository.findAll();
    }

    @GetMapping("/drinks/{id}")
    Optional<Drink> getDrink(@PathVariable Integer id) {
        Optional<Drink> drink = drinkRepository.findById(id);
        return drink;
    }

}