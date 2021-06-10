package deliveroo.it.restourantsprint.controllers;

import java.util.Optional;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
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
  ResponseEntity<Long> getFood(@PathVariable Integer id) {
    Optional<Food> food = foodRepository.findById(id);
    if (food.isEmpty())
      return new ResponseEntity<>(HttpStatus.NOT_FOUND);
    return new ResponseEntity<>(HttpStatus.OK);
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

  /**
   * delete food.
   *
   * @param Food
   * @return the food
   */
  @DeleteMapping("/foods/{id}")
  public ResponseEntity<Long> delete(@PathVariable Integer id) {
    Food food;
    Optional<Food> optionalFood = foodRepository.findById(id);
    if (optionalFood.isEmpty())
      new ResponseEntity<>(HttpStatus.NOT_FOUND);
    try {
      food = optionalFood.get();
      foodRepository.delete(food);
    } catch (Exception e) {
      return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
    }
    return new ResponseEntity<>(HttpStatus.NO_CONTENT);
  }
}
