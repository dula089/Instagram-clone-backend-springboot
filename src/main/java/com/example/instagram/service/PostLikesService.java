package com.example.instagram.service;

import com.example.instagram.model.PostLikes;
import com.example.instagram.repository.PostLikesRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class PostLikesService {

    @Autowired
    private PostLikesRepository postLikesRepository;

    public PostLikes likePost(PostLikes postLike) {
        return postLikesRepository.save(postLike);
    }

    public void unlikePost(Integer postId, Integer userId) {
        postLikesRepository.deleteByPostIdAndId(postId, userId);
    }

    public List<PostLikes> getLikesByPostId(Integer postId) {
        return postLikesRepository.findByPostId(postId);
    }
}

