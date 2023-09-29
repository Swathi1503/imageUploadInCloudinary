package com.cloudinaryexample.cloudinaryImageUploaddemo.service;

import com.cloudinary.Cloudinary;
import com.cloudinary.utils.ObjectUtils;
import com.cloudinaryexample.cloudinaryImageUploaddemo.entity.Image;
import com.cloudinaryexample.cloudinaryImageUploaddemo.repository.ImageRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.UUID;

@Service
public class ImageService {

    private final Cloudinary cloudinary;


    @Autowired
    private ImageRepository imageRepository;

    public ImageService() {
        cloudinary = new Cloudinary(ObjectUtils.asMap(
                "cloud_name", "daikmvdbw",
                "api_key", "166354169684961",
                "api_secret", "NMc-QSnNXPu1wkuZr3axz2qbAHQ"));
    }

//    public String uploadImage(MultipartFile file, String publicId) throws IOException {
//        try {
//            Map<?, ?> params = ObjectUtils.asMap(
//                    "public_id", publicId,
//                    "folder", "uploads"
//            );
//            Map<?, ?> uploadResult = cloudinary.uploader().upload(file.getBytes(), params);
//            String imageUrl = (String) uploadResult.get("secure_url");
//            return imageUrl;
//        } catch (IOException e) {
//            throw new IOException("Failed to upload image to Cloudinary", e);
//        }
//    }

    public List<String> uploadImages(List<MultipartFile> files) throws IOException {
        List<String> imageUrls = new ArrayList<>();
        for (MultipartFile file : files) {
            String publicId = generateUniquePublicId();
            try {
                Map<?, ?> params = ObjectUtils.asMap(
                        "public_id", publicId,
                        "folder", "uploads"
                );
                Map<?, ?> uploadResult = cloudinary.uploader().upload(file.getBytes(), params);
                String imageUrl = (String) uploadResult.get("secure_url");
                imageUrls.add(imageUrl);


            } catch (IOException e) {
                throw new IOException("Failed to upload image to Cloudinary", e);
            }
        }
        Image image = new Image();
        image.setImageURL(imageUrls.toString());
        imageRepository.save(image);
        return imageUrls;
    }

    private String generateUniquePublicId() {
        return "image_" + Math.random();
    }


}



