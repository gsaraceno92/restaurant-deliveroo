package deliveroo.it.restourantsprint.repositories;

import org.springframework.data.repository.CrudRepository;

import deliveroo.it.restourantsprint.models.Food;
// This will be AUTO IMPLEMENTED by Spring into a Bean called userRepository
// CRUD refers Create, Read, Update, Delete

public interface FoodRepository extends CrudRepository<Food, Integer> {

}