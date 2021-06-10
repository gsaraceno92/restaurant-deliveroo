package deliveroo.it.restourantsprint.controllers;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import org.springframework.web.bind.annotation.RestController;

import deliveroo.it.restourantsprint.repositories.DrinkRepository;
import deliveroo.it.restourantsprint.repositories.FoodRepository;

import deliveroo.it.restourantsprint.models.Drink;
import deliveroo.it.restourantsprint.models.Food;

@RestController
@RequestMapping(path = "/deliveroo") // This means URL's start with /demo (after Application path)
public class Menu {

  @Autowired // This means to get the bean called <resource>Repository
  private DrinkRepository drinkRepository;
  @Autowired
  private FoodRepository foodRepository;

  @RequestMapping(value = "/original/menu", method = RequestMethod.GET, produces = { "application/json" })
  public Map<String, Iterable> getMenu() {
    Map<String, Iterable> menu = new HashMap<>();
    Iterable<Food> foods = foodRepository.findAll();
    Iterable<Drink> drinks = drinkRepository.findAll();
    menu.put("foods", foods);
    menu.put("drinks", drinks);
    return menu;
  }

  @RequestMapping(value = "/menu", method = RequestMethod.GET, produces = { "application/json" })
  public Map<String, ArrayList<Object>> getAll() {
    Map<String, ArrayList<Object>> map = new HashMap<>();
    Iterable<Food> foods = foodRepository.findAll();
    for (Food food : foods) {
      if (!map.containsKey(food.getCategory())) {
        map.put(food.getCategory(), new ArrayList<Object>());
      }
      ArrayList<Object> foodValues = map.get(food.getCategory());
      foodValues.add(food);
    }
    Iterable<Drink> drinks = drinkRepository.findAll();
    for (Drink drink : drinks) {
      if (!map.containsKey(drink.getCategory())) {
        map.put(drink.getCategory(), new ArrayList<Object>());
      }
      ArrayList<Object> drinkValues = map.get(drink.getCategory());
      drinkValues.add(drink);
    }
    return map;
  }

}