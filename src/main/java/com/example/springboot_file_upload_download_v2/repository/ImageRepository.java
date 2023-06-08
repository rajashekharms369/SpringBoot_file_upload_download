package com.example.springboot_file_upload_download_v2.repository;

import com.example.springboot_file_upload_download_v2.entity.Image;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ImageRepository extends JpaRepository<Image, Long> {

}
