package com.gychu.coscom.controllers;

import com.gychu.coscom.models.User;
import com.gychu.coscom.services.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;


@RestController
@RequestMapping("/user")
public class UserController {

    //dependency injection for UserService
    @Autowired
    UserService userService;

    @PostMapping
    private User submitUser(@RequestBody User user) {
        return userService.saveUser(user); //returning the User, so you can see what got saved.
    }

    @GetMapping
    private List<User> getAllUsers() {
        return userService.getAllUsers(); //returning the List of all Users.
    }

    @GetMapping ("/{username}")
    private User getUserByUsername(@PathVariable("username") String username) {
        return userService.getUserByUsername(username); //returning User with username.
    }

    @PutMapping("/{username}")
    private User updateUser(String username, User user) {
        return userService.updateUser(username, user);
    }

    @DeleteMapping("/{username}")
    private Boolean deleteUser(@PathVariable("username") String username) {
        return userService.deleteUser(username);
    }
}
