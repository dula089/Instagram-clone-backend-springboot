package com.example.instagram.repository;

import com.example.instagram.model.PostMedia;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface PostMediaRepository extends JpaRepository<PostMedia, Integer> {
    Optional<PostMedia> findByName(String name);
}

