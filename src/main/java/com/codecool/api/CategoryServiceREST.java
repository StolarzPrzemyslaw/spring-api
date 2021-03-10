package com.codecool.api;

import com.codecool.model.Category;
import com.codecool.service.CategoryService;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class CategoryServiceREST {
    private final CategoryService categoryService;

    public CategoryServiceREST(CategoryService categoryService) {
        this.categoryService = categoryService;
    }

    @GetMapping("/api/categories")
    List<Category> all() {
        return categoryService.readAll();
    }

    @PostMapping("/api/categories")
    Category newEntity(@RequestBody Category newEntity) {
        return categoryService.create(newEntity);
    }

    @GetMapping("/api/categories/{id}")
    Category one(@PathVariable Long id) {
        return categoryService.read(id);
    }

    @PutMapping("/api/categories/{id}")
    Category replaceEntity(@RequestBody Category newEntity, @PathVariable Long id) {
        return categoryService.update(newEntity, id);
    }

    @DeleteMapping("/api/categories/{id}")
    void deleteEntity(@PathVariable Long id) {
        categoryService.delete(id);
    }
}
