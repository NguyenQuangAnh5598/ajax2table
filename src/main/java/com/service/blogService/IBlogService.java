package com.service.blogService;

import com.model.Blog;

import java.util.Optional;

public interface IBlogService {
    Iterable<Blog> findAll();

    Optional<Blog> findByID(Long id);

    Blog save(Blog blog);

    void remove(Long id);
}
