package com.example.demo.services;

import com.example.demo.entity.User;
import com.example.demo.repository.UserRepository;
import org.springframework.stereotype.Service;

import java.util.Arrays;
import java.util.List;

@Service
public class UserService implements UserRepository {

    @Override
    public User getUser(String name) {
        //voy a la base busco un usuario por el nombre
        //Devuelvo el usuario
        User user = new User(name, 23);
        return  user;
    }

    @Override
    public List<User> getUsers() {
        User user1 = new User("Santi", 29);
        User user2 = new User("pepe", 29);
        User user3 = new User("pedro", 29);
        User user4 = new User("Ana", 29);
        List<User> userList = Arrays.asList(user1, user2, user3, user4);
        return userList;

    }

    @Override
    public User createUser(User newUser) {
        //Se crear el usuario newUser en la base de datos
        User user = new User(newUser.getName(),newUser.getAge());
        return user;
    }

    @Override
    public User editUser(String name, int age) {
        //Busca un usuario en la base de datos por nombre
        //Edita los datos del usuario con la información de editUser
        // Guarda el usuario editado
        User user = new User(name, 20);
        user.setName(name);
        user.setAge(age);
        return user;
    }

    @Override
    public String deleteUser(String name) {
        return "Usuario eliminado exitosamente";
    }
}
