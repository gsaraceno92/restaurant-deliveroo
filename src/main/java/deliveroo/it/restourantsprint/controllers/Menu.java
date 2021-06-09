package deliveroo.it.restourantsprint.controllers;

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
    public Map<String, Object> getAll() {
      Map<String, Object> map = new HashMap<>();
      Iterable<Food> foods = foodRepository.findAll();
      for(Food food: foods) {
        map.put(food.getCategory(), food);
      }
      Iterable<Drink> drinks = drinkRepository.findAll();
      for (Drink drink : drinks) {
        map.put(drink.getCategory(), drink);
      }
      return map;
    }


}