package com.codecool.api;

import com.codecool.exception.EntityNotFoundException;
import com.codecool.model.Order;
import com.codecool.repository.OrderRepository;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class OrderServiceREST {

    private final OrderRepository repository;

    public OrderServiceREST(OrderRepository repository) {
        this.repository = repository;
    }

    @GetMapping("/api/orders")
    List<Order> all() {
        return repository.findAll();
    }

    @PostMapping("/api/orders")
    Order newEntity(@RequestBody Order newEntity) {
        return repository.save(newEntity);
    }

    @GetMapping("/api/orders/{id}")
    Order one(@PathVariable Long id) {
        return repository.findById(id).
                orElseThrow(() -> new EntityNotFoundException(Order.class, id));
    }

    @PutMapping("/api/orders/{id}")
    Order replaceEntity(@RequestBody Order newEntity, @PathVariable Long id) {
        return repository.findById(id).
                map(entity -> {
                    entity.setDate(newEntity.getDate());
                    return repository.save(entity);
                }).
                orElseGet(() -> {
                    newEntity.setId(id);
                    return repository.save(newEntity);
                });
    }

    @DeleteMapping("/api/orders/{id}")
    void deleteEntity(@PathVariable Long id) {
        repository.deleteById(id);
    }
}
