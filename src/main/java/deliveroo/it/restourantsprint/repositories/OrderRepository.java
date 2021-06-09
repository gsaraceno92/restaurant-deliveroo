package deliveroo.it.restourantsprint.repositories;

import org.springframework.data.repository.CrudRepository;

import deliveroo.it.restourantsprint.models.Order;
// This will be AUTO IMPLEMENTED by Spring into a Bean called userRepository
// CRUD refers Create, Read, Update, Delete

public interface OrderRepository extends CrudRepository<Order, Integer> {

}