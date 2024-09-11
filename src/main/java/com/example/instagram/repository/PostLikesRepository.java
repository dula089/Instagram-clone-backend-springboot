package com.example.instagram.repository;

import com.example.instagram.model.PostLikes;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface PostLikesRepository extends JpaRepository<PostLikes,Integer> {
    List<PostLikes>findByPostId(Integer postId);
    void deleteByPostIdAndId(Integer postId,Integer id);
}
