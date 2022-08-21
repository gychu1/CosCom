package com.gychu.coscom.services;

import com.gychu.coscom.models.Comment;
import com.gychu.coscom.repositories.CommentRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class CommentService {

    @Autowired
    CommentRepository commentRepository;

    public Comment saveComment(Comment comment) {
        return commentRepository.save(comment);
    }

    public Comment getCommentById(Long id) {
        Optional<Comment> maybeComment = commentRepository.findById(id);
        if (maybeComment.isPresent()) {
            return maybeComment.get();
        } else {
            throw new IllegalArgumentException("Comment not found for ID" + id);
        }
    }

    public List<Comment> getAllComments() {
        return commentRepository.findAll();
    }

    public Comment updateComment (Long id, Comment comment) {
        Comment oldComment = getCommentById(id);

        oldComment.setText(comment.getText());

        commentRepository.save(oldComment);

        return oldComment;
    }

    public Boolean deleteComment(Long id) {
        Comment commentToDelete = getCommentById(id);
        commentRepository.delete(commentToDelete);
        return Boolean.TRUE;
    }

}
