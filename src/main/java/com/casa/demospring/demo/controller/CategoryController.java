package com.casa.demospring.demo.controller;

import com.casa.demospring.demo.entities.Category;
import com.casa.demospring.demo.services.CategoryService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping(value = "/categories")
public class CategoryController {

    CategoryService userService;

    @Autowired
    public CategoryController(CategoryService userService) {
        this.userService = userService;
    }

    @GetMapping
    public ResponseEntity<List<Category>> findAll(){
        List<Category> users = userService.findAll();

        return new ResponseEntity<>(users ,HttpStatus.OK);
    }

    @GetMapping(value = "/{id}")
    public ResponseEntity<Category> findById(@PathVariable Long id){
        Category user = userService.findById(id);
        return new ResponseEntity<>(user,HttpStatus.OK);
    }
}
