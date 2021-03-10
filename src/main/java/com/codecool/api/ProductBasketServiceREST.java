package com.codecool.api;

import com.codecool.model.ProductBasket;
import com.codecool.service.ProductBasketService;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class ProductBasketServiceREST {
    private final ProductBasketService productBasketService;

    public ProductBasketServiceREST(ProductBasketService productBasketService) {
        this.productBasketService = productBasketService;
    }

    @GetMapping("/api/productBasket")
    List<ProductBasket> all() {
        return productBasketService.readAll();
    }

    @PostMapping("/api/productBasket")
    ProductBasket newEntity(@RequestBody ProductBasket newEntity) {
        return productBasketService.create(newEntity);
    }

    @GetMapping("/api/productBasket/{id}")
    ProductBasket one(@PathVariable Long id) {
        return productBasketService.read(id);
    }

    @PutMapping("/api/productBasket/{id}")
    ProductBasket replaceEntity(@RequestBody ProductBasket newEntity, @PathVariable Long id) {
        return productBasketService.update(newEntity, id);
    }

    @DeleteMapping("/api/productBasket/{id}")
    void deleteEntity(@PathVariable Long id) {
        productBasketService.delete(id);
    }
}
