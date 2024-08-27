package com.example.instagram.service;

import com.example.instagram.repository.PostRepository;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;
@AllArgsConstructor
@Service
public class PostService {
    private final PostRepository postRepository;
}
