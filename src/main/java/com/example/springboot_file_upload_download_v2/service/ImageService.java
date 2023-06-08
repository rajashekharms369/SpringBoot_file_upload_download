package com.example.springboot_file_upload_download_v2.service;

import com.example.springboot_file_upload_download_v2.entity.Image;
import com.example.springboot_file_upload_download_v2.repository.ImageRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import java.io.IOException;

@Service
public class ImageService {
    @Autowired
    public ImageRepository imageRepo;

    public String saveImage(MultipartFile file, String name, String description) throws IOException {
        Image image = new Image();
        image.setName(name);
        image.setDescription(description);
        image.setImage(file.getBytes());
        imageRepo.save(image);
        return "Image saved successfully in the DB";
    }
}
