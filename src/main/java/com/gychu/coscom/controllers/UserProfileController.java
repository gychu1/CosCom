package com.gychu.coscom.controllers;

import com.gychu.coscom.models.UserProfile;
import com.gychu.coscom.services.UserProfileService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;


@RestController
@RequestMapping("/userprofile")
public class UserProfileController {

    //dependency injection for UserService
    @Autowired
    UserProfileService userProfileService;

    @PostMapping
    private ResponseEntity<UserProfile> submitUser(@RequestBody UserProfile userProfile) {
        return new ResponseEntity<>(userProfileService.saveUser(userProfile), HttpStatus.CREATED); //returning the User, so you can see what got saved.
    }

    @GetMapping
    private ResponseEntity<List<UserProfile>> getAllUsers() {
        return new ResponseEntity<>(userProfileService.getAllUsers(), HttpStatus.OK); //returning the List of all Users.
    }

    @GetMapping ("/{username}")
    private ResponseEntity<UserProfile> getUserByUsername(@PathVariable("username") String username) {
        return new ResponseEntity<>(userProfileService.getUserByUsername(username), HttpStatus.OK); //returning User with username.
    }

    @PutMapping("/{username}")
    private ResponseEntity<UserProfile> updateUser(@PathVariable String username, @RequestBody UserProfile userProfile) {
        return new ResponseEntity<>(userProfileService.updateUser(username, userProfile), HttpStatus.OK);
    }

    @DeleteMapping("/{username}")
    private ResponseEntity<Boolean> deleteUser(@PathVariable("username") String username) {
        return new ResponseEntity<>(userProfileService.deleteUser(username), HttpStatus.NO_CONTENT);
    }
}
