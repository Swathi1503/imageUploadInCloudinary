package com.cloudinaryexample.cloudinaryImageUploaddemo.controller;

import com.cloudinaryexample.cloudinaryImageUploaddemo.service.ImageService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.UUID;

@RestController
public class ImageController {

    @Autowired
    ImageService imageService;

//    @PostMapping("/UploadProfilePic")
//    public ResponseEntity<?> uploadImage( @RequestParam("file") MultipartFile file) {
//        if (file.isEmpty()) {
//            return ResponseEntity.badRequest().body("No file uploaded.");
//        }
////        String publicId = "user_" + userId + "_profile_pic";
//        String publicId="profile_pic";
//        try {
//            String uploadResult = imageService.uploadImage(file,publicId);
//            return ResponseEntity.ok(uploadResult);
//        } catch (IOException ex) {
//            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body("Internal server error: " + ex.getMessage());
//        }
//    }

    //    @PostMapping("/upload")
//    public ResponseEntity<List<String>> uploadImages(
//            @RequestParam("files") List<MultipartFile> files)
//            List<String> publicIds="profile_pics";
//    throws IOException {
//        List<String> imageUrls = imageService.uploadImages(files, publicIds);
//        return ResponseEntity.ok(imageUrls);
//    }
    @PostMapping("/upload")
    public ResponseEntity<List<String>> uploadImages(
            @RequestParam("files") List<MultipartFile> files) throws IOException {
        List<String> imageUrls = imageService.uploadImages(files);
        return ResponseEntity.ok(imageUrls);
    }
}
