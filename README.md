# Instagram-clone-backend-springboot

## Overview

This project is an Instagram-like backend API built using Spring Boot 3.3.3. It provides authentication features with JWT for security, user management, and basic endpoints for interacting with the application.

## Features

- User authentication and authorization with JWT (JSON Web Token)
- User registration and login
- JWT token generation and validation
- CORS enabled for integration with frontend
- Secure endpoints with Spring Security
- CRUD operations on users
- REST API for user data retrieval


## Tech Stack

- **Spring Boot 3.3.3** 
- **JWT(JSON Web Tokens)** for Authentication
- **MySQL** as the Database
- **Maven** for Dependancy Management
- **Hibernate** for JPA(Java Persistence API)

## Prerequisites

- Java 21
- Maven
- MySQL
- Postman(or any other API testing tool)
  

## Dependencies Used

- **Spring Boot Starter Web**: Provides core Spring MVC and RESTful web service functionality.
- **Spring Boot Starter Data JPA**: Integrates Spring Data JPA with Spring Boot, allowing easy database interaction.
- **Spring Boot Starter Security**: Adds security features to the app, including authentication and authorization.
- **Spring Security Crypto**: Provides password encryption with BCrypt for securely hashing user passwords.
- **Spring Boot Starter Data REST**: Simplifies the development of REST APIs using Spring Data.
- **Javax Mail**: Provides functionality to send and receive emails within the application.
- **Javax Activation**: Helps manage MIME data types, useful for sending emails with attachments.
- **MySQL Connector**: JDBC driver for connecting to MySQL databases.
- **Lombok**: Reduces boilerplate code by automatically generating getters, setters, constructors, etc.
- **Spring Boot DevTools**: Enables hot-reloading for faster development iteration.
- **Thymeleaf**: A server-side Java template engine for web and email rendering.
- **Spring Boot Starter Test**: Provides testing dependencies like JUnit and Mockito for unit and integration testing.
- **Gson**: Library to convert Java objects into JSON and back.
- **Jsoup**: Library for parsing and manipulating HTML documents.
- **Commons IO**: Apache Commons IO utilities for working with file and stream operations.
- **ModelMapper**: Simplifies object mapping between different layers of the application.
- **Jackson Databind**: Provides functionality to convert Java objects to and from JSON.
- **JWT (Java JSON Web Token)**: Implements JWT for securing APIs via token-based authentication.
- **Spring Security Test**: Provides support for testing Spring Security features.

## RESTful API Endpoints
1. **User Registration**: POST /auth/signup
