package deliveroo.it.restourantsprint.controllers;
import java.util.Optional;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.bind.annotation.RequestMapping;

import deliveroo.it.restourantsprint.repositories.FoodRepository;
import deliveroo.it.restourantsprint.models.Food;

@RestController
@RequestMapping(path = "/deliveroo")
public class FoodController {
    @Autowired
    private FoodRepository foodRepository;

    @GetMapping("/foods")
    Iterable<Food> getAll() {
        return foodRepository.findAll();
    }

    @GetMapping("/foods/{id}")
    Optional<Food> getFood(@PathVariable Integer id) {
        Optional<Food> food = foodRepository.findById(id);
        return food;
    }

    /**
     * Create food.
     *
     * @param Food
     * @return the food
     */
    @PostMapping("/food")
    public Food add(@Valid @RequestBody Food food) {
        return foodRepository.save(food);
    }
}
