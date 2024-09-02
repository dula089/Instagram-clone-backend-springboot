package com.example.instagram.controller;


import com.example.instagram.dto.LoginRequestDto;
import com.example.instagram.dto.UserDto;
import com.example.instagram.dto.UserGeneralDto;
import com.example.instagram.service.UserService;
import lombok.AllArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;


@RestController
@RequestMapping("/user")
@AllArgsConstructor
public class UserController {

    private UserService userService;

    @GetMapping("/list")
    public ResponseEntity<UserGeneralDto> getUser(@RequestParam Integer userId) {
        return userService.getUser(userId);
    }

    @GetMapping("/all")
    public ResponseEntity<List<UserGeneralDto>>getAllUsers(){
        return userService.getAllUsers();
    }
    @PostMapping("/signup")
    public ResponseEntity<String>signup(@RequestBody UserDto userDto){
        return userService.signup(userDto);
    }
    @PostMapping("/login")
    public ResponseEntity<String>login(@RequestBody LoginRequestDto loginRequestDto){
        return userService.login(loginRequestDto);
    }

}
