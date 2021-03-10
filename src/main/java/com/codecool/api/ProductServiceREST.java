package com.codecool.api;

import com.codecool.model.Product;
import com.codecool.service.ProductService;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class ProductServiceREST {
    private final ProductService productService;

    public ProductServiceREST(ProductService productService) {
        this.productService = productService;
    }

    @GetMapping("/api/product")
    List<Product> all() {
        return productService.readAll();
    }

    @PostMapping("/api/product")
    Product newEntity(@RequestBody Product newEntity) {
        return productService.create(newEntity);
    }

    @GetMapping("/api/product/{id}")
    Product one(@PathVariable Long id) {
        return productService.read(id);
    }

    @PutMapping("/api/product/{id}")
    Product replaceEntity(@RequestBody Product newEntity, @PathVariable Long id) {
        return productService.update(newEntity, id);
    }

    @DeleteMapping("/api/product/{id}")
    void deleteEntity(@PathVariable Long id) {
        productService.delete(id);
    }
}
