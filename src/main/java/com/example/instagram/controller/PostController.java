package com.example.instagram.controller;

import com.example.instagram.model.Post;
import com.example.instagram.service.PostService;
import lombok.AllArgsConstructor;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/post")
@AllArgsConstructor
public class PostController {
    private final PostService postService;

    @GetMapping("/getPost")
    public String getPost(){
        return "post";
    }

    @PostMapping("/create")
    public Post createPost(@RequestBody Post post){
        return postService.createPost(post);
    }
    @GetMapping("/getPosts")
    public List<Post>getAllPosts(){
        return postService.getAllPosts();
    }
}
