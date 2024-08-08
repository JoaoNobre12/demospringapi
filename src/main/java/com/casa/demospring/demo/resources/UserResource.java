package com.casa.demospring.demo.resources;

import com.casa.demospring.demo.entities.User;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping(value = "/users")
public class UserResource {

    @GetMapping
    public ResponseEntity<User> findAll(){
        User user = new User(1L,"joao","joao@itau.com","11981290336","123456");

        return new ResponseEntity<>(user ,HttpStatus.OK);
    }
}
