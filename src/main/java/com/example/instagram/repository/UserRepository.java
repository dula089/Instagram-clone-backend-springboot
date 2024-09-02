package com.example.instagram.repository;


import com.example.instagram.model.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;


@Repository
public interface UserRepository extends JpaRepository<User,Integer> {
    boolean existsByEmail(String email);
    boolean existsByUserName(String userName);
    Optional<User> findByUserNameOrEmail(String userName, String Email);
    List<User>findAll();
}
