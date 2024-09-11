package com.example.instagram.service;

import com.example.instagram.model.Post;
import com.example.instagram.repository.PostRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class PostService {

    @Autowired
    private PostRepository postRepository;

    public Post createPost(Post post) {
        return postRepository.save(post);
    }

    public List<Post> getAllPosts() {
        return postRepository.findAll();
    }

    // Implement deletePost method
    public boolean deletePost(Integer postId) {
        Optional<Post> post = postRepository.findById(postId);
        if (post.isPresent()) {
            postRepository.deleteById(postId);
            return true;
        }
        return false;
    }

    // Implement updatePost method
    public Post updatePost(Integer postId, Post updatedPost) {
        Optional<Post> existingPost = postRepository.findById(postId);
        if (existingPost.isPresent()) {
            Post post = existingPost.get();
            post.setDescription(updatedPost.getDescription());
            post.setLocation(updatedPost.getLocation());
            post.setFilterId(updatedPost.getFilterId());
            post.setPostDate(updatedPost.getPostDate());
            post.setPostTime(updatedPost.getPostTime());
            return postRepository.save(post);
        }
        return null;
    }
}
