package com.example.instagram.model;

import jakarta.persistence.*;
import lombok.*;


import java.time.LocalDate;


@Data
@Entity
@AllArgsConstructor
@NoArgsConstructor
public class User {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer userId;
    private String full_name;
    private String userName;
    private String email;
    private String gender;
    private LocalDate dob;
    private String address;
    private String mobile_number;



}
