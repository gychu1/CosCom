package com.gychu.coscom.services;

import com.gychu.coscom.models.Post;
import com.gychu.coscom.repositories.PostRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class PostService {

    @Autowired
    PostRepository postRepository;

    public Post savePost(Post post) {
        return postRepository.save(post);
    }

    public Post getPostById(Long id) {
        Optional<Post> maybePost = postRepository.findById(id);
        if (maybePost.isPresent()) {
            return maybePost.get();
        } else {
            throw new IllegalArgumentException("Post not found for ID" + id);
        }
    }

    public List<Post> getAllPosts () {
        return postRepository.findAll();
    }

    public Post updatePost (Long id, Post post) {
        Post oldPost= getPostById(id);

        oldPost.setDescription(oldPost.getDescription());

        postRepository.save(oldPost);

        return oldPost;
    }

    public Boolean deletePost(Long id) {
        Post postToDelete = getPostById(id);
        postRepository.delete(postToDelete);
        return Boolean.TRUE;
    }
}
