package com.gychu.coscom.controllers;

import com.gychu.coscom.models.Comment;
import com.gychu.coscom.services.CommentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/comment")
public class CommentController {

    @Autowired
    CommentService commentService;

    @PostMapping
    private ResponseEntity<Comment> saveComment(@RequestBody Comment comment) {
        return new ResponseEntity<>(commentService.saveComment(comment), HttpStatus.CREATED);
    }

    @GetMapping
    private ResponseEntity<List<Comment>> getAllComments() {
        return new ResponseEntity<>(commentService.getAllComments(), HttpStatus.OK);
    }

    @GetMapping("/{id}")
    private ResponseEntity<Comment> getCommentById (@PathVariable Long id) {
        return new ResponseEntity<>(commentService.getCommentById(id), HttpStatus.OK);
    }

    @PutMapping("/{id}")
    private ResponseEntity<Comment> updateComment (@PathVariable Long id, @RequestBody Comment comment) {
        return new ResponseEntity<>(commentService.updateComment(id, comment), HttpStatus.ACCEPTED);
    }

    @DeleteMapping("/{id}")
    private ResponseEntity<Boolean> deleteComment (@PathVariable Long id) {
        return new ResponseEntity<>(commentService.deleteComment(id), HttpStatus.NO_CONTENT);
    }
}
