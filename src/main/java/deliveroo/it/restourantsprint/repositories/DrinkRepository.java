package deliveroo.it.restourantsprint.repositories;

import org.springframework.data.repository.CrudRepository;

import deliveroo.it.restourantsprint.models.Drink;
public interface DrinkRepository extends CrudRepository<Drink, Integer> {

}