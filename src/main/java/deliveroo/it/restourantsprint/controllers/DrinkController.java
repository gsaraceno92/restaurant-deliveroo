package deliveroo.it.restourantsprint.controllers;

import java.util.Optional;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
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
    public ResponseEntity<Long> getDrink(@PathVariable Integer id) {
      Optional<Drink> drink = drinkRepository.findById(id);
      if (drink.isEmpty())
        return new ResponseEntity<>(HttpStatus.NOT_FOUND);
      return new ResponseEntity<>(HttpStatus.OK);
    }

    /**
     * Create drink.
     *
     * @param drink
     * @return the drink
     */
    @PostMapping("/drink")
    public Drink add(@Valid @RequestBody Drink drink) {
        return drinkRepository.save(drink);
    }

    /**
     * Create food.
     *
     * @param Food
     * @return the food
     */
    @DeleteMapping("/drinks/{id}")
    public ResponseEntity<Long> delete(@PathVariable Integer id) {
      Drink drink;
      Optional<Drink> optionaldrink = drinkRepository.findById(id);
      if (optionaldrink.isEmpty())
        new ResponseEntity<>(HttpStatus.NOT_FOUND);
      try {
        drink = optionaldrink.get();
        drinkRepository.delete(drink);
      } catch (Exception e) {
        return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
      }
      return new ResponseEntity<>(HttpStatus.NO_CONTENT);
    }
}