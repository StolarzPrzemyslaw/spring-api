package com.codecool.api;

import com.codecool.model.Category;
import com.codecool.repository.CategoryRepository;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class CategoryServiceREST {
    private final CategoryRepository repository;

    public CategoryServiceREST(CategoryRepository repository) {
        this.repository = repository;
    }

    @GetMapping("/categories")
    List<Category> all() {
        return repository.findAll();
    }

    @PostMapping("/categories")
    Category newEntity(@RequestBody Category newEntity) {
        return repository.save(newEntity);
    }
}
