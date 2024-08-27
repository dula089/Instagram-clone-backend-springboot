package com.example.instagram.service;

import com.example.instagram.dto.UserGeneralDto;
import com.example.instagram.model.User;
import com.example.instagram.repository.UserRepository;
import lombok.AllArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import java.util.Optional;
@AllArgsConstructor
@Service
public class UserService {
    private final UserRepository userRepository;
    public ResponseEntity<UserGeneralDto> getUser() {
        UserGeneralDto userGeneral=new UserGeneralDto();
        Optional<User>optionalUser = userRepository.findById(2);
        if (optionalUser.isPresent()){
            User user =optionalUser.get();
            userGeneral.setUserId(user.getUserId());
            userGeneral.setUserName(user.getUserName());
            return ResponseEntity.ok(userGeneral);
        }else{
            return ResponseEntity.notFound().build();
        }
    }

}
