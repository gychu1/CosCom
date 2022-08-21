package com.gychu.coscom.controllers;

import com.gychu.coscom.models.Post;
import com.gychu.coscom.services.PostService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/post")
public class PostController {

    @Autowired
    PostService postService;

    @PostMapping
    private Post savePost(@RequestBody Post post) {
        return postService.savePost(post);
    }

    @GetMapping
    private List<Post> getAllPosts() {
        return postService.getAllPosts();
    }

    @GetMapping("/{id}")
    private Post getPostById (@PathVariable Long id) {
        return postService.getPostById(id);
    }

    @PutMapping
    private Post updatePost (@PathVariable Long id, @RequestBody Post post) {
        return postService.updatePost(id, post);
    }

    @DeleteMapping
    private Boolean deletePost (@PathVariable Long id) {
        return postService.deletePost(id);
    }
}
