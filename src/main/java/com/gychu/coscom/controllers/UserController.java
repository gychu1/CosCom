package com.gychu.coscom.controllers;

import com.gychu.coscom.models.User;
import com.gychu.coscom.services.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;


@RestController
@RequestMapping("/Users")
public class UserController {

    //dependency injection for UserService
    @Autowired
    UserService userService;

    @PostMapping
    private User submitUser(@RequestBody User user) {
        return userService.saveUser(user); //returning the User, so you can see what got saved.
    }

}
