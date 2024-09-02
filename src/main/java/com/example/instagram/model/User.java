package com.example.instagram.model;

import jakarta.persistence.*;
import lombok.*;


import java.time.LocalDate;


@Setter
@Getter
@Data
@Entity
@AllArgsConstructor
@NoArgsConstructor
public class User {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "user_id")
    private Integer userId;

    private String full_name;

    @Column(nullable = false)
    private String userName;

    @Column(nullable = false)
    private String email;

    private String gender;

    private LocalDate dob;

    private String address;


    private String mobile_number;

    private String password;



}
