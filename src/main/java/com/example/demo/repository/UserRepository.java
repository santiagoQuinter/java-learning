package com.example.demo.repository;

import com.example.demo.entity.User;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface UserRepository {
    User getUser(String name);

    List<User> getUsers();

    User createUser(User newUser);

    User editUser(String name, int age);

    String deleteUser(String name);
}
