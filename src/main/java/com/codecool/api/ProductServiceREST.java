package com.codecool.api;

import com.codecool.exception.EntityNotFoundException;
import com.codecool.model.Product;
import com.codecool.repository.ProductRepository;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class ProductServiceREST {

    private final ProductRepository repository;

    public ProductServiceREST(ProductRepository repository) { this.repository = repository; }

    @GetMapping("/api/product")
    List<Product> all() {
        return repository.findAll();
    }

    @PostMapping("/api/product")
    Product newEntity(@RequestBody Product newEntity) {
        return repository.save(newEntity);
    }

    @GetMapping("/api/product/{id}")
    Product one(@PathVariable Long id) {
        return repository.findById(id).
                orElseThrow(() -> new EntityNotFoundException(Product.class, id));
    }

    @PutMapping("/api/product/{id}")
    Product replaceEntity(@RequestBody Product newEntity, @PathVariable Long id) {
        return repository.findById(id).
                map(entity -> {
                    entity.setName(newEntity.getName());
                    return repository.save(entity);
                }).
                orElseGet(() -> {
                    newEntity.setId(id);
                    return repository.save(newEntity);
                });
    }

    @DeleteMapping("/api/product/{id}")
    void deleteEntity(@PathVariable Long id) {
        repository.deleteById(id);
    }
}
