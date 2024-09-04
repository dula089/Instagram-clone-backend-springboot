package com.example.instagram.service;

import com.example.instagram.dto.LoginRequestDto;
import com.example.instagram.dto.UserDto;
import com.example.instagram.dto.UserGeneralDto;
import com.example.instagram.model.User;
import com.example.instagram.repository.UserRepository;
import lombok.AllArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@AllArgsConstructor
@Service
public class UserService {
    private final UserRepository userRepository;
    private final BCryptPasswordEncoder passwordEncoder;
//    public ResponseEntity<UserGeneralDto> getUser(Integer userId) {
//        UserGeneralDto userGeneral=new UserGeneralDto();
//        Optional<User>optionalUser = userRepository.findById(userId);
//        if (optionalUser.isPresent()){
//            User user =optionalUser.get();
//            userGeneral.setUserId(user.getUserId());
//            userGeneral.setUserName(user.getUserName());
//            return ResponseEntity.ok(userGeneral);
//        }else{
//            return ResponseEntity.notFound().build();
//        }
//    }

    public ResponseEntity<String> signup(UserDto userDto) {
       if(userRepository.existsByEmail(userDto.getEmail())||userRepository.existsByUserName(userDto.getUserName())){
           return ResponseEntity.badRequest().body("User with given email or username already exists");
       }
       userDto.setPassword(passwordEncoder.encode(userDto.getPassword()));
       User user=new User();
       user.setFull_name(userDto.getFull_name());
       user.setUserName(userDto.getUserName());
       user.setEmail(userDto.getEmail());
       user.setPassword(userDto.getPassword());

       userRepository.save(user);
        return ResponseEntity.ok("User registered successfully");
    }

    public ResponseEntity<String> login(LoginRequestDto loginRequestDto) {
        Optional<User> optionalUser = userRepository.findByUserNameOrEmail(loginRequestDto.getUserNameOrEmail(), loginRequestDto.getUserNameOrEmail());
        if (optionalUser.isPresent()) {
            User user = optionalUser.get();
            if (passwordEncoder.matches(loginRequestDto.getPassword(), user.getPassword())) {
            return ResponseEntity.ok("Login Successful");
            } else {
            return ResponseEntity.status(401).body("Invalid credentials");
        }
    }else {
        return ResponseEntity.status(401).body("Invalid credentials");
        }
    }

    public ResponseEntity<List<UserDto>>getAllUsers(){
        List<User>users=userRepository.findAll();
        List<UserDto>userDtos=users.stream().map(user -> {
            UserDto dto=new UserDto();
            dto.setUserId(user.getUserId());
            dto.setUserName(user.getUserName());
            return dto;
        }).collect(Collectors.toList());
        return ResponseEntity.ok(userDtos);
    }

}
