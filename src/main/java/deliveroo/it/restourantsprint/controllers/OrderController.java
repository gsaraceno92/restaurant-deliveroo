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

import deliveroo.it.restourantsprint.repositories.OrderRepository;
import deliveroo.it.restourantsprint.models.Order;

@RestController
@RequestMapping(path = "/deliveroo")
public class OrderController {
    @Autowired
    private OrderRepository orderRepository;

    @GetMapping("/orders")
    Iterable<Order> getAll() {
        return orderRepository.findAll();
    }

    @GetMapping("/orders/{id}")
    ResponseEntity<Long> getOrder(@PathVariable Integer id) {
        Optional<Order> order = orderRepository.findById(id);
        if (order.isEmpty()) 
          return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        return new ResponseEntity<>(HttpStatus.OK);
    }

    /**
     * Create order.
     *
     * @param Order
     * @return the order
     */
    @PostMapping("/order")
    public Order add(@Valid @RequestBody Order order) {
        return orderRepository.save(order);
    }

    /**
     * delete order.
     *
     * @param Order
     * @return the order
     */
    @DeleteMapping("/orders/{id}")
    public ResponseEntity<Long> delete(@PathVariable Integer id) {
      Order order;
      Optional<Order> optionalOrder = orderRepository.findById(id);
      if (optionalOrder.isEmpty()) 
        new ResponseEntity<>(HttpStatus.NOT_FOUND);
      try {
        order = optionalOrder.get();
        orderRepository.delete(order);
      } catch (Exception e) {
        return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
      }
      return new ResponseEntity<>(HttpStatus.NO_CONTENT);
    }
}
