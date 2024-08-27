package com.example.instagram.controller;


import com.example.instagram.dto.UserGeneralDto;
import com.example.instagram.service.UserService;
import lombok.AllArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;


@RestController
@RequestMapping("/user")
@AllArgsConstructor
public class UserController {

    private UserService userService;

    @GetMapping("/list")
    public ResponseEntity<UserGeneralDto> getUser(@RequestParam Integer userId) {
        return userService.getUser();
    }


}
