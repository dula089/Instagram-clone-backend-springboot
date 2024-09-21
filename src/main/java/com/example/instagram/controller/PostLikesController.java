package com.example.instagram.controller;

import com.example.instagram.model.PostLikes;
import com.example.instagram.service.PostLikesService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/post-likes")
public class PostLikesController {

    @Autowired
    private PostLikesService postLikesService;


    @PostMapping
    public ResponseEntity<PostLikes> likePost(@RequestBody PostLikes postLike) {
        PostLikes createdLike = postLikesService.likePost(postLike);
        return ResponseEntity.ok(createdLike);
    }


    @DeleteMapping
    public ResponseEntity<String> unlikePost(@RequestParam Integer postId, @RequestParam Integer id) {
        postLikesService.unlikePost(postId, id);
        return ResponseEntity.ok("Post unliked successfully.");
    }


    @GetMapping("/{postId}")
    public ResponseEntity<List<PostLikes>> getLikesByPostId(@PathVariable Integer postId) {
        List<PostLikes> likes = postLikesService.getLikesByPostId(postId);
        return ResponseEntity.ok(likes);
    }
}

