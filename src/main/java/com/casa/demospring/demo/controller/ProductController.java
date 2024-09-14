package com.casa.demospring.demo.controller;

import com.casa.demospring.demo.entities.Product;
import com.casa.demospring.demo.services.ProductService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping(value = "/products")
public class ProductController {

    ProductService userService;

    @Autowired
    public ProductController(ProductService userService) {
        this.userService = userService;
    }

    @GetMapping
    public ResponseEntity<List<Product>> findAll(){
        List<Product> users = userService.findAll();

        return new ResponseEntity<>(users ,HttpStatus.OK);
    }

    @GetMapping(value = "/{id}")
    public ResponseEntity<Product> findById(@PathVariable Long id){
        Product user = userService.findById(id);
        return new ResponseEntity<>(user,HttpStatus.OK);
    }
}
