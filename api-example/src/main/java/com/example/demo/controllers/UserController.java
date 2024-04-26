package com.example.demo.controllers;

import com.example.demo.entity.User;
import com.example.demo.repository.UserRepository;
import com.example.demo.services.UserService;
import lombok.AllArgsConstructor;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api")
@AllArgsConstructor
public class UserController {

    private final UserRepository repository;
    private final UserService userService;

    @GetMapping("/{name}")
    public User getUser(@PathVariable("name") String name){
        return repository.getUser(name);
    }

    @GetMapping("/users/{name}")
    public User getUsers(@PathVariable("name") String name){
        return userService.getUser(name);
    }

    @PostMapping("create")
    public User createUser(@RequestBody User user){
        return repository.createUser(user);
    }

}
