package com.example.instagram.controller;

import com.example.instagram.service.PostService;
import lombok.AllArgsConstructor;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/post")
@AllArgsConstructor
public class PostController {
    private PostService postService;
    @GetMapping("/getPost")
    public String getPost(){
        return "post";
    }
}
