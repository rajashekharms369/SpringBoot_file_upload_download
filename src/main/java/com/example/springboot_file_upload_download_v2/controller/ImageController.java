package com.example.springboot_file_upload_download_v2.controller;

import com.example.springboot_file_upload_download_v2.service.ImageService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import java.io.IOException;

@RestController
//@RequestMapping("/image")
public class ImageController {

    @Autowired
    private ImageService imageService;

    @PostMapping("/save")
    public String saveImageOrFile(@RequestParam("file") MultipartFile file,
                                  @RequestParam("name") String name,
                                  @RequestParam("description") String description) throws IOException {
        return imageService.saveImage(file, name, description);
    }

    @GetMapping("/hello")
    public String sayHello() {
        return "Welcome!";
    }
}
