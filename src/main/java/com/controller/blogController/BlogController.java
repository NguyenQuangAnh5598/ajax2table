package com.controller.blogController;

import com.model.Blog;
import com.model.Category;
import com.service.CategoryService.ICategoryService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.ModelAndView;
import com.service.blogService.IBlogService;

import java.util.List;
import java.util.Optional;

@Controller
@RequestMapping("/blog")
public class BlogController {
    @Autowired
    private IBlogService blogService;

    @Autowired
    private ICategoryService categoryService;

    @ModelAttribute("categoryList")
    public Iterable<Category> categoryList() {
        return categoryService.findAll();
    }


    @PostMapping("/create")
    public ResponseEntity<Blog> addNewBlog(@RequestBody Blog blog) {
        return new ResponseEntity<>(blogService.save(blog), HttpStatus.CREATED);
    }

    @DeleteMapping("/delete/{id}")
    public ResponseEntity<Blog> deleteBlog(@PathVariable Long id) {
        Optional<Blog> blog = blogService.findByID(id);
        if (!blog.isPresent()) {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
        blogService.remove(id);
        return new ResponseEntity<>(blog.get(), HttpStatus.NO_CONTENT);
    }

    @GetMapping("/home")
    public ModelAndView showList() {
        ModelAndView modelAndView = new ModelAndView("/blog/home");
        modelAndView.addObject("blogList",blogService.findAll());
        return modelAndView;
    }

    @GetMapping("/list")
    public ResponseEntity<Iterable<Blog>> list() {
        List<Blog> blogList = (List<Blog>) blogService.findAll();
        if (blogList.isEmpty()) {
   return new ResponseEntity<>(HttpStatus.NO_CONTENT);
        }
        return new ResponseEntity<>(blogList,HttpStatus.OK);
    }

    @PutMapping("/update/{id}")
    public ResponseEntity<Blog> updateBlog(@RequestBody Blog blog, @PathVariable Long id) {
        Optional<Blog> blogOptional = blogService.findByID(id);
        if (!blogOptional.isPresent()) {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
        blog.setId(blogOptional.get().getId());
        return new ResponseEntity<>(blogService.save(blog),HttpStatus.OK);
    }
}
