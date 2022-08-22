package com.gychu.coscom.controllers;

import com.gychu.coscom.models.Post;
import com.gychu.coscom.services.PostService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Objects;

@RestController
@RequestMapping("/post")
public class PostController {

    @Autowired
    PostService postService;

    @PostMapping
    private ResponseEntity<Post> savePost(@RequestBody Post post) {
        return new ResponseEntity<>(postService.savePost(post), HttpStatus.CREATED);
    }

    @GetMapping
    private ResponseEntity<List<Post>> getAllPosts() {
        return new ResponseEntity<>(postService.getAllPosts(), HttpStatus.OK);
    }

    @GetMapping("/{id}")
    private ResponseEntity<Object> getPostById (@PathVariable Long id) {
        try {
            return new ResponseEntity<>(postService.getPostById(id), HttpStatus.OK);
        } catch (IllegalArgumentException exception) {
            return new ResponseEntity<>(exception.getMessage(), HttpStatus.NOT_FOUND);
        }
    }

    @PutMapping("/{id}")
    private ResponseEntity<Object> updatePost (@PathVariable Long id, @RequestBody Post post) {
        try {
            return new ResponseEntity<>(postService.updatePost(id, post), HttpStatus.ACCEPTED);
        } catch (IllegalArgumentException exception) {
            return new ResponseEntity<>(exception.getMessage(), HttpStatus.NOT_FOUND);
        }
    }

    @DeleteMapping("/{id}")
    private ResponseEntity<Object> deletePost (@PathVariable Long id) {
        try {
            return new ResponseEntity<>(postService.deletePost(id), HttpStatus.NO_CONTENT);
        } catch (IllegalArgumentException exception) {
            return new ResponseEntity<>(exception.getMessage(), HttpStatus.NOT_FOUND);
        }
    }
}
