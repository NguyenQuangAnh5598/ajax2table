package com.service.CategoryService;

import com.model.Blog;
import com.model.Category;

import java.util.Optional;

public interface ICategoryService {
    Iterable<Category> findAll();

    Optional<Category> findByID(Long id);

    Category save(Category category);

    void remove(Long id);
}
