package com.gychu.coscom.controllers;

import com.gychu.coscom.models.UserProfile;
import com.gychu.coscom.services.UserProfileService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Objects;


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
    private ResponseEntity<Object> getUserByUsername(@PathVariable("username") String username) {
        try {
            return new ResponseEntity<>(userProfileService.getUserByUsername(username), HttpStatus.OK); //returning User with username.
        } catch (IllegalArgumentException exception) {
            return new ResponseEntity<>(exception.getMessage(), HttpStatus.NOT_FOUND);
        }
    }

    @PutMapping("/{username}")
    private ResponseEntity<Object> updateUser(@PathVariable String username, @RequestBody UserProfile userProfile) {
        try {
            return new ResponseEntity<>(userProfileService.updateUser(username, userProfile), HttpStatus.OK);
        } catch (IllegalArgumentException exception) {
            return new ResponseEntity<>(exception.getMessage(), HttpStatus.NOT_FOUND);
        }
    }

    @DeleteMapping("/{username}")
    private ResponseEntity<Object> deleteUser(@PathVariable("username") String username) {
        try {
            return new ResponseEntity<>(userProfileService.deleteUser(username), HttpStatus.NO_CONTENT);
        } catch (IllegalArgumentException exception) {
            return new ResponseEntity<>(exception.getMessage(), HttpStatus.NOT_FOUND);
        }
    }
}
