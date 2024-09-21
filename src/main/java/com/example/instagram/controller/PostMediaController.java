package com.example.instagram.controller;

import com.example.instagram.model.PostMedia;
import com.example.instagram.service.PostMediaService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpHeaders;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import java.io.IOException;
import java.util.HashMap;
import java.util.Map;
import java.util.Optional;

@RestController
@RequestMapping("/image")
public class PostMediaController {

    @Autowired
    private PostMediaService postMediaService;

    @PostMapping
    public ResponseEntity<Map<String, Object>> uploadImage(@RequestParam("image") MultipartFile image) {
        try {
            PostMedia savedMedia = postMediaService.saveImage(image);

            Map<String, Object> responseBody = new HashMap<>();
            responseBody.put("message", "Image uploaded successfully");
            responseBody.put("name", savedMedia.getName());
            responseBody.put("type", savedMedia.getMediaType());
            responseBody.put("url", "/image/" + savedMedia.getName());

            return ResponseEntity.ok(responseBody);
        } catch (IOException e) {

            Map<String, Object> errorBody = new HashMap<>();
            errorBody.put("error", "Error uploading image");
            errorBody.put("message", e.getMessage());
            return ResponseEntity.status(500).body(errorBody);
        }
    }


    @GetMapping("/info/{name}")
    public ResponseEntity<PostMedia> getImageInfo(@PathVariable String name) {
        Optional<PostMedia> mediaOptional = postMediaService.getImageInfoByName(name);
        return mediaOptional.map(ResponseEntity::ok).orElseGet(() -> ResponseEntity.notFound().build());
    }


    @GetMapping("/{name}")
    public ResponseEntity<byte[]> getImage(@PathVariable String name) throws IOException {
        byte[] imageData = postMediaService.getImageByName(name);
        if (imageData != null) {
            return ResponseEntity.ok()
                    .contentType(MediaType.IMAGE_JPEG)
                    .header(HttpHeaders.CONTENT_DISPOSITION, "attachment; filename=\"" + name + "\"")
                    .body(imageData);
        }
        return ResponseEntity.notFound().build();
    }
}
