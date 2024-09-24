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

## Package Structure
```txt
└──src
    ├── main
    │   ├── java
    │   │   └── com.example.instagram
    │   │       ├── config
    │   │       │   ├──AppConfig
    │   │       │   ├──JwtAuthenticationFilter
    │   │       │   ├──SecurityConfiguration
    │   │       │   └──WebConfig
    │   │       ├── controller
    │   │       │   ├──AuthenticationController
    │   │       │   ├──PostController
    │   │       │   ├──PostLikeController
    │   │       │   ├──PostMediaController
    │   │       │   └──UserController
    │   │       ├── dto
    │   │       │   ├──LoginRequestDto
    │   │       │   ├──PostMediaRequest
    │   │       │   ├──UserDto
    │   │       │   └──UserGeneralDto
    │   │       ├── model
    │   │       │   ├──Comment
    │   │       │   ├──CommentLike
    │   │       │   ├──CommentReply
    │   │       │   ├──Follower
    │   │       │   ├──Messages
    │   │       │   ├──Post
    │   │       │   ├──PostLikes
    │   │       │   ├──PostMedia
    │   │       │   ├──PostTag
    │   │       │   ├──Share
    │   │       │   ├──Story
    │   │       │   └──User
    │   │       ├── repository
    │   │       │   ├──PostLikesRepository
    │   │       │   ├──PostMediaRepository
    │   │       │   ├──PostRepository
    │   │       │   └──UserRepository
    │   │       ├── responses
    │   │       │   └──LoginResponse
    │   │       ├── service
    │   │       │   ├──AuthenticationService
    │   │       │   ├──JwtService
    │   │       │   ├──PostLikesService
    │   │       │   ├──PostMediaService
    │   │       │   ├──PostService
    │   │       │   └──UserService
    │   │       └──Util   
    │   │           ├──ImageCompressionUtils
    │   │           └──Utilities
    │   └── resources
    │       ├── application.properties
    │       └── templates
    └── test
          └── java
              └── com.example.instagram
```



## RESTful API Endpoints

### User Endpoints

1. **Signup**: Register a new user.
    - **POST /auth/signup**
2. **Login**: Authenticate a user and generate a JWT.
    - **POST /auth/login**
3. **Get User by ID**: Retrieve details of a user by user ID.
    - **GET /user/list?userId={id}**
4. **Get All Users**: Fetch a list of all users.
    - **GET /user/all**
5. **Get Authenticated User**: Get details of the currently authenticated user.
    - **GET /user/me**

### Post Endpoints

1. **Create Post**: Create a new post.
    - **POST /posts/create**
2. **Get All Posts**: Fetch all posts.
    - **GET /posts/all**
3. **Edit Post**: Update a post by its ID.
    - **PUT /posts/edit/{postId}**
4. **Delete Post**: Delete a post by its ID.
    - **DELETE /posts/delete/{postId}**

### Post Likes Endpoints

1. **Like Post**: Like a post.
    - **POST /post-likes**
2. **Unlike Post**: Unlike a post.
    - **DELETE /post-likes?postId={postId}&id={id}**
3. **Get Likes by Post ID**: Retrieve all likes for a specific post.
    - **GET /post-likes/{postId}**

### Post Media Endpoints

1. **Upload Image**: Upload an image associated with a post.
    - **POST /image**
    - **Request Parameter**: `image` (Multipart file).
    - **Response**: Includes a message, image name, type, and access URL.
2. **Get Image Info by Name**: Get metadata about an image.
    - **GET /image/info/{name}**
3. **Get Image by Name**: Retrieve and download an image by its name.
    - **GET /image/{name}**
    - **Response**: Returns the image as a byte array.

## Entity Relationship Diagram


![ER drawio (1)](https://github.com/user-attachments/assets/3039d3b2-f397-4c3d-aba7-07e834b0c2e3)

