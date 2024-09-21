package com.example.instagram.controller;

import com.example.instagram.model.Post;
import com.example.instagram.service.PostService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/posts")
public class PostController {

    @Autowired
    private PostService postService;

    @PostMapping("/create")
    public ResponseEntity<Post> createPost(@RequestBody Post post) {
        Post createdPost = postService.createPost(post);
        return ResponseEntity.ok(createdPost);
    }

    @GetMapping("/all")
    public ResponseEntity<List<Post>> getAllPosts() {
        List<Post> posts = postService.getAllPosts();
        return ResponseEntity.ok(posts);
    }


    @DeleteMapping("/delete/{postId}")
    public ResponseEntity<String> deletePost(@PathVariable Integer postId) {
        boolean isDeleted = postService.deletePost(postId);
        if (isDeleted) {
            return ResponseEntity.ok("Post deleted successfully");
        } else {
            return ResponseEntity.status(404).body("Post not found");
        }
    }


    @PutMapping("/edit/{postId}")
    public ResponseEntity<Post> editPost(@PathVariable Integer postId, @RequestBody Post updatedPost) {
        Post post = postService.updatePost(postId, updatedPost);
        if (post != null) {
            return ResponseEntity.ok(post);
        } else {
            return ResponseEntity.status(404).body(null);
        }
    }
}

