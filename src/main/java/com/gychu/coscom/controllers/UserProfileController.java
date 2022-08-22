package com.gychu.coscom.controllers;

import com.gychu.coscom.models.UserProfile;
import com.gychu.coscom.services.UserProfileService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;


@RestController
@RequestMapping("/userprofile")
public class UserProfileController {

    //dependency injection for UserService
    @Autowired
    UserProfileService userProfileService;

    @PostMapping
    private UserProfile submitUser(@RequestBody UserProfile userProfile) {
        return userProfileService.saveUser(userProfile); //returning the User, so you can see what got saved.
    }

    @GetMapping
    private List<UserProfile> getAllUsers() {
        return userProfileService.getAllUsers(); //returning the List of all Users.
    }

    @GetMapping ("/{username}")
    private UserProfile getUserByUsername(@PathVariable("username") String username) {
        return userProfileService.getUserByUsername(username); //returning User with username.
    }

    @PutMapping("/{username}")
    private UserProfile updateUser(String username, UserProfile userProfile) {
        return userProfileService.updateUser(username, userProfile);
    }

    @DeleteMapping("/{username}")
    private Boolean deleteUser(@PathVariable("username") String username) {
        return userProfileService.deleteUser(username);
    }
}
