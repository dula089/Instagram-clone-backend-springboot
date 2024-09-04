package com.example.instagram.service;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import com.example.instagram.dto.UserGeneralDto;
import com.example.instagram.model.User;
import com.example.instagram.repository.UserRepository;

import lombok.AllArgsConstructor;

@AllArgsConstructor
@Service
public class UserService {

    private final UserRepository userRepository;

    public ResponseEntity<UserGeneralDto> getUser(Integer userId) {
        UserGeneralDto userGeneral = new UserGeneralDto();
        Optional<User> optionalUser = userRepository.findById(userId);
        if (optionalUser.isPresent()) {
            User user = optionalUser.get();
            userGeneral.setUserId(user.getId());
            userGeneral.setUserName(user.getUsername());
            return ResponseEntity.ok(userGeneral);
        } else {
            return ResponseEntity.notFound().build();
        }
    }

    public ResponseEntity<List<UserGeneralDto>> getAllUsers() {
        List<User> users = userRepository.findAll();
        List<UserGeneralDto> userDtos = users.stream().map(user -> {
            UserGeneralDto dto = new UserGeneralDto();
            dto.setUserId(user.getId());
            dto.setUserName(user.getUsername());
            return dto;
        }).collect(Collectors.toList());
        return ResponseEntity.ok(userDtos);
    }

}
