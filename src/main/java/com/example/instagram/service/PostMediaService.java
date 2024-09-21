package com.example.instagram.service;

import com.example.instagram.Util.ImageCompressionUtils;
import com.example.instagram.model.PostMedia;
import com.example.instagram.repository.PostMediaRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import java.io.IOException;
import java.util.Optional;

@Service
public class PostMediaService {

    @Autowired
    private PostMediaRepository postMediaRepository;


    public PostMedia saveImage(MultipartFile file) throws IOException {
        PostMedia media = new PostMedia();
        media.setName(file.getOriginalFilename());
        media.setMediaType(file.getContentType());
        media.setMediaData(ImageCompressionUtils.compressImage(file.getBytes()));
        return postMediaRepository.save(media);
    }


    public Optional<PostMedia> getImageInfoByName(String name) {
        return postMediaRepository.findByName(name);
    }


    public byte[] getImageByName(String name) throws IOException {
        Optional<PostMedia> mediaOptional = postMediaRepository.findByName(name);
        if (mediaOptional.isPresent()) {
            return ImageCompressionUtils.decompressImage(mediaOptional.get().getMediaData());
        }
        return null;
    }
}


