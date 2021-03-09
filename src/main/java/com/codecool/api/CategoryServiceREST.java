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

    @GetMapping("/categories/{id}")
    Category one(@PathVariable Long id) {
        return repository.findById(id).
                orElseThrow();
    }

    @PutMapping("/categories/{id}")
    Category replaceEntity(@RequestBody Category newEntity, @PathVariable Long id) {
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

    @DeleteMapping("/categories/{id}")
    void deleteEntity(@PathVariable Long id) {
        repository.deleteById(id);
    }
}
