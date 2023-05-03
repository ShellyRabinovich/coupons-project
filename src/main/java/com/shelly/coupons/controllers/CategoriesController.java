package com.shelly.coupons.controllers;

import com.shelly.coupons.dto.CategoriesDTO;
import com.shelly.coupons.entities.Category;
import com.shelly.coupons.exceptions.ServerException;
import com.shelly.coupons.logic.CategoriesLogic;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/categories")
public class CategoriesController {

    private CategoriesLogic categoriesLogic;

    public CategoriesController(CategoriesLogic categoriesLogic) {
        this.categoriesLogic = categoriesLogic;
    }

    @PostMapping
    public void createCategory(@RequestBody Category category) throws ServerException {
        this.categoriesLogic.createCategory(category);
    }

    @PutMapping
    public void updateCategory(@RequestBody Category category) throws ServerException {
       this.categoriesLogic.updateCategory(category);
    }

    @DeleteMapping("{categoryId}")
    public void removeCategory(@PathVariable("categoryId") int categoryId) throws ServerException {
        this.categoriesLogic.deleteCategory(categoryId);
    }

    @GetMapping
    public List<CategoriesDTO> getAllCategories() throws ServerException {
        List<CategoriesDTO> categories = this.categoriesLogic.getAllCategories();
        return categories;
    }

    @GetMapping("{categoryId}")
    public Category getCategory(@PathVariable("categoryId") long categoryId) throws ServerException {
        Category category = this.categoriesLogic.getCategory(categoryId);
        return category;
    }
}

