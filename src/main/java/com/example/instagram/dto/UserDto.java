package com.example.instagram.dto;


import lombok.Data;

@Data
public class UserDto {

    private Integer userId;
    private String full_name;
    private String userName;
    private String email;
    private String password;

}
