package com.codecool.api;

import com.codecool.exception.EntityNotFoundException;
import com.codecool.model.ProductBasket;
import com.codecool.repository.ProductBasketRepository;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class ProductBascetServiceREST {

    private final ProductBasketRepository repository;

    public ProductBascetServiceREST(ProductBasketRepository repository) { this.repository = repository; }

    @GetMapping("/api/productBasket")
    List<ProductBasket> all() {
        return repository.findAll();
    }

    @PostMapping("/api/productBasket")
    ProductBasket newEntity(@RequestBody ProductBasket newEntity) {
        return repository.save(newEntity);
    }

    @GetMapping("/api/productBasket/{id}")
    ProductBasket one(@PathVariable Long id) {
        return repository.findById(id).
                orElseThrow(() -> new EntityNotFoundException(ProductBasket.class, id));
    }

    @PutMapping("/api/productBascet/{id}")
    ProductBasket replaceEntity(@RequestBody ProductBasket newEntity, @PathVariable Long id) {
        return repository.findById(id).
                map(entity -> {
                    entity.setAmount(newEntity.getAmount());
                    entity.setProduct(newEntity.getProduct());
                    entity.setOrder(newEntity.getOrder());
                    return repository.save(entity);
                }).
                orElseGet(() -> {
                    newEntity.setId(id);
                    return repository.save(newEntity);
                });
    }

    @DeleteMapping("/api/productBascet/{id}")
    void deleteEntity(@PathVariable Long id) {
        repository.deleteById(id);
    }
}
